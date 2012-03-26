package Utils.ldap;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.*;

/**
 * This LDAP Security provider can lookup/authenticate a user by their global directory id, their email, and in some cases,
 * their full name (depends on whether their full name is unique)
 * <p/>
 * JNDI provides connection pooling by default. Connection pool configuration is done via system properties
 * (ie System.setProperty(prop, value), or via -Dprop=value on the command line).
 * <p/>
 * <b>Connection pool configuration:</b>
 * <table><tr>
 * <td><b>System Property</b></td>                          <td><b>Default</b></td>
 * </tr><tr>
 * <td>com.sun.jndi.ldap.connect.pool.authentication</td>   <td>"none simple"</td>
 * </tr><tr>
 * <td>com.sun.jndi.ldap.connect.pool.debug</td>            <td></td>
 * </tr><tr>
 * <td>com.sun.jndi.ldap.connect.pool.initsize</td>         <td>1</td>
 * </tr><tr>
 * <td>com.sun.jndi.ldap.connect.pool.maxsize</td>          <td>no maximum size</td>
 * </tr><tr>
 * <td>com.sun.jndi.ldap.connect.pool.prefsize</td>         <td>no preferred size</td>
 * </tr><tr>
 * <td>com.sun.jndi.ldap.connect.pool.protocol</td>         <td>"plain"</td>
 * </tr><tr>
 * <td>com.sun.jndi.ldap.connect.pool.timeout</td>          <td>no timeout (milliseconds)</td>
 * </tr></table>
 * See for more details <a href="http://java.sun.com/products/jndi/tutorial/ldap/connect/config.html">http://java.sun.com/products/jndi/tutorial/ldap/connect/config.html</a>
 */
public class GroupDirectorySecurityProvider {

    private static final int MAX_RESULTS_LIMIT = 50;
    private static final String KEY_SEPARATOR = ": ";
    private static final String ROOT = "o=group";

    private final Hashtable ENV = new Hashtable();
    private final SearchControls SEARCH_CONTROLS = new SearchControls();

    public GroupDirectorySecurityProvider(String host, String port, String dn, String password) {
        this("ldap://" + host + ":" + port, dn, password);
    }

    public GroupDirectorySecurityProvider(String ldapUrl, String dn, String password) {
        ENV.put(Context.PROVIDER_URL, ldapUrl);
        ENV.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        // Enable connection pooling
        ENV.put("com.sun.jndi.ldap.connect.pool", "true");

        if (isNotEmpty(dn) && isNotEmpty(password)) {
            ENV.put(Context.SECURITY_PRINCIPAL, dn);
            ENV.put(Context.SECURITY_CREDENTIALS, password);
        }

        // limit the number of results, and number of elements (we are only interested in basic properties)
        SEARCH_CONTROLS.setSearchScope(SearchControls.SUBTREE_SCOPE);
        SEARCH_CONTROLS.setReturningAttributes(new String[]{"*"});
        SEARCH_CONTROLS.setCountLimit(MAX_RESULTS_LIMIT);
    }

    public UserDetails lookupUserById(long uid) throws UserNotFoundException, InvalidSearchException, ConnectionFailureException {
        return lookupUser("(uid=" + uid + ")", null);
    }

    public UserDetails lookupUserById(String uid) throws UserNotFoundException, InvalidSearchException, ConnectionFailureException {
        return lookupUser("(uid=" + uid + ")", null);
    }

    public UserDetails authenticateUserById(long uid, String password) throws UserNotFoundException, InvalidSearchException, AuthenticationFailureException, ConnectionFailureException {
        return authenticateUser("(uid=" + uid + ")", password);
    }

    public UserDetails authenticateUserById(String uid, String password) throws UserNotFoundException, InvalidSearchException, AuthenticationFailureException, ConnectionFailureException {
        return authenticateUser("(uid=" + uid + ")", password);
    }

    public UserDetails lookupUserByEmail(String email) throws UserNotFoundException, InvalidSearchException, ConnectionFailureException {
        return lookupUser("(mail=" + email + ")", null);
    }

    public UserDetails authenticateUserByEmail(String email, String password) throws UserNotFoundException, InvalidSearchException, AuthenticationFailureException, ConnectionFailureException {
        return authenticateUser("(mail=" + email + ")", password);
    }

    public UserDetails lookupUserByFullName(String name) throws UserNotFoundException, InvalidSearchException, ConnectionFailureException {
        return lookupUser("(cn=" + name + ")", null);
    }

    public UserDetails[] lookupUsers(String searchTerm) throws ConnectionFailureException {
        try {
            return this.lookupUsers(searchTerm, new InitialDirContext(ENV));
        } catch (NamingException e) {
            throw new RuntimeException("LDAP Operation failed. See cause for details", e);
        }
    }

    public UserDetails[] lookupUsers(String searchTerm, DirContext ctx) throws ConnectionFailureException {
        searchTerm = "*" + searchTerm + "*";
        List result = new ArrayList();

        try {
            findUsers(ctx, "(uid=" + searchTerm + ")", result);
            findUsers(ctx, "(cn=" + searchTerm + ")", result);
        } catch (CommunicationException e) {
            throw new ConnectionFailureException("Connection to directory failed.", e);
        } catch (NamingException e) {
            throw new RuntimeException("LDAP Operation failed. See cause for details", e);
        } finally {
            cleanup(ctx);
        }

        return (UserDetails[]) result.toArray(new UserDetails[result.size()]);
    }

    private void findUsers(DirContext ctx, String filter, List result) throws NamingException {
        NamingEnumeration namingEnumeration = ctx.search(ROOT, filter, SEARCH_CONTROLS);
        while (namingEnumeration.hasMoreElements()) {
            SearchResult searchResult = (SearchResult) namingEnumeration.next();
            UserDetails userDetails = createUserDetails(ctx, searchResult);
            addUserDetails(userDetails, result);
        }
    }

    private void addUserDetails(UserDetails userDetails, List result) {
        if (userDetails.getUid() != null) {
            for (Iterator i = result.iterator(); i.hasNext();) {
                UserDetails existingUserDetails = (UserDetails) i.next();
                if (existingUserDetails.equals(userDetails)) {
                    return;
                }
            }
            result.add(userDetails);
        }
    }

    public UserDetails authenticateUserByFullName(String name, String password) throws UserNotFoundException, InvalidSearchException, AuthenticationFailureException, ConnectionFailureException {
        return authenticateUser("(cn=" + name + ")", password);
    }

    private UserDetails lookupUser(String filter, String password) throws UserNotFoundException, InvalidSearchException, ConnectionFailureException {
        try {
            return lookupOrAuthenticateUser(filter, password);
        } catch (AuthenticationFailureException e) {
            throw new RuntimeException("Received unexpected AuthenticationFailureException when looking up a user");
        }
    }

    private UserDetails authenticateUser(String filter, String password) throws UserNotFoundException, InvalidSearchException, AuthenticationFailureException, ConnectionFailureException {
        if (password == null) {
            throw new AuthenticationFailureException("Password can not be null");
        }
        return lookupOrAuthenticateUser(filter, password);
    }

    private UserDetails lookupOrAuthenticateUser(String filter, String password) throws UserNotFoundException, InvalidSearchException, AuthenticationFailureException, ConnectionFailureException {

        DirContext ctx = null;
        try {
            // Create initial context (in JDK1.4 JNDI, connection comes from pool)
            ctx = new InitialDirContext(ENV);
            SearchResult searchResult = findUser(ctx, filter);

            if (password != null) {
                verifyPassword(searchResult.getName() + "," + ROOT, password);
            }

            return createUserDetails(ctx, searchResult);
        } catch (CommunicationException e) {
            throw new ConnectionFailureException("Connection to directory failed.", e);
        } catch (NamingException e) {
            throw new ConnectionFailureException("LDAP Operation failed. See cause for details", e);
        } finally {
            cleanup(ctx);
        }
    }

    private SearchResult findUser(DirContext ctx, String filter) throws NamingException, InvalidSearchException, UserNotFoundException {
        NamingEnumeration namingEnumeration = ctx.search(ROOT, filter, SEARCH_CONTROLS);

        if (!namingEnumeration.hasMore()) {
            throw new UserNotFoundException("User with details " + filter + " does not exist in the directory");
        }
        SearchResult searchresult = (SearchResult) namingEnumeration.next();

        ensureOnlyOneResult(namingEnumeration);
        return searchresult;
    }

    private void ensureOnlyOneResult(NamingEnumeration namingEnumeration) throws NamingException, InvalidSearchException {
        if (namingEnumeration.hasMore()) {
            // work out exactly how  many we have
            namingEnumeration.next();
            int i = 2;
            try {
                while (namingEnumeration.hasMore()) {
                    namingEnumeration.next();
                    i++;
                }
                throw new InvalidSearchException("Search criteria were not enough to return a unique user. Search criteria produced " + i + " results");
            } catch (SizeLimitExceededException e) {
                throw new InvalidSearchException("Search criteria were not enough to return a unique user. Search criteria produced at least " + MAX_RESULTS_LIMIT + " results (resultset is limited to " + MAX_RESULTS_LIMIT + " - there may well have been more)");
            }
        }
    }

    private void verifyPassword(String dn, String password) throws NamingException, AuthenticationFailureException {
        if (password.length() == 0) {
            throw new AuthenticationFailureException("Failed to authenticate user: Empty Password");
        }
        try {
            Hashtable env = new Hashtable(ENV);
            env.put(Context.SECURITY_PRINCIPAL, dn);
            env.put(Context.SECURITY_CREDENTIALS, password);
            new InitialDirContext(env).close();
        } catch (AuthenticationException e) {
            throw new AuthenticationFailureException("Failed to authenticate user", e);
        }
    }

    private Map getAttributes(DirContext ctx, String parentKey, Attributes atts) throws NamingException {
        Map map = new HashMap();
        NamingEnumeration ne = atts.getIDs();
        if (ne != null) {
            while (ne.hasMore()) {
                String key = (String) ne.next();
                Object o = atts.get(key).get();
                if (o != null && o instanceof String) {
                    String value = (String) o;
                    map.put(createKey(parentKey, key), extractValue(value));
                }
            }
        }
        return map;
    }

    private String createKey(String parentKey, String key) {
        return parentKey + ("".equals(parentKey) ? "" : "_") + key;
    }

    private String extractValue(String value) {
        if (value.indexOf(KEY_SEPARATOR) != -1) {
            return value.substring(value.indexOf(KEY_SEPARATOR) + 2);
        }
        return value;
    }

    private UserDetails createUserDetails(DirContext ctx, SearchResult searchResult) throws NamingException {
        Map map = getAttributes(ctx, "", searchResult.getAttributes());
        UserDetails details = new UserDetails();
        details.setUid((String) map.get("uid"));
        details.setFirstname((String) map.get("givenName"));
        details.setLastname((String) map.get("sn"));
        details.setEmail((String) map.get("mail"));
        return details;
    }

    private void cleanup(DirContext ctx) {
        if (ctx != null) {
            try {
                ctx.close();
            } catch (NamingException e) {
                System.out.println("Failed to close ldap connection : " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private boolean isNotEmpty(String str) {
        return (str != null) && (str.trim().length() != 0);
    }
}
