package testgxt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import testgxt.client.LoginService;

public class loginServiceImpl extends RemoteServiceServlet implements LoginService {
  public Boolean tryLoginAs(String login, String password) {
    return true;
  }
}