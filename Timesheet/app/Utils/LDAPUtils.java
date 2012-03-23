package Utils;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 3/23/12
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class LDAPUtils {
    public static boolean authenticate(String userName, String password) {
        if (userName.startsWith("a")) {
            return false;
        }
        return true;
    }
}
