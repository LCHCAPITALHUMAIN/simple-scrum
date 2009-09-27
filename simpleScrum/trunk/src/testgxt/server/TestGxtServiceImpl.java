package testgxt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import testgxt.client.TestGxtService;

public class TestGxtServiceImpl extends RemoteServiceServlet implements TestGxtService {
  // Implementation of sample interface method
  public String getMessage(String msg) {
    return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
  }
}