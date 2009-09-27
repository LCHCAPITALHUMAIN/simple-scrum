package easyscrum.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import easyscrum.client.EasyScrumService;

public class EasyScrumServiceImpl extends RemoteServiceServlet implements EasyScrumService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}