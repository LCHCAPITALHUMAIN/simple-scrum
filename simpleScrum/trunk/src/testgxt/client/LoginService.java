package testgxt.client;

import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.core.client.GWT;

public interface LoginService extends RemoteService {
  Boolean tryLoginAs(String login, String password);

  public static class App {
    private static LoginServiceAsync ourInstance = null;

    public static synchronized LoginServiceAsync getInstance() {
      if (ourInstance == null) {
        ourInstance = (LoginServiceAsync) GWT.create(LoginService.class);
        ((ServiceDefTarget) ourInstance).setServiceEntryPoint(GWT.getModuleBaseURL() + "testgxt.TestGxt/LoginService");
      }
      return ourInstance;
    }
  }
}
