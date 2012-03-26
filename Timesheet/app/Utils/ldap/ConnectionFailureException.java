package Utils.ldap;

public class ConnectionFailureException extends Exception {

    public ConnectionFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
