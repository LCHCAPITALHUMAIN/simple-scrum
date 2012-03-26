package Utils;

import Utils.ldap.*;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 26/03/12
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
public class LdapAuthenticator {
    static public String host="directory.echonet";
    static public String port="389";
    static public String user="cn=user_beagle";
    static public String password="Spirit*6";
    static public GroupDirectorySecurityProvider authenticator;

    static public boolean authenticate(String id, String password) {
        try {
            getAuthenticator().authenticateUserById(id, password);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (InvalidSearchException e) {
            e.printStackTrace();
            return false;
        } catch (AuthenticationFailureException e) {
            e.printStackTrace();
            return false;
        } catch (ConnectionFailureException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static private synchronized GroupDirectorySecurityProvider getAuthenticator() {
        if (authenticator == null) {
            authenticator = new GroupDirectorySecurityProvider(host, port, user, password);
        }
        return authenticator;
    }
}
