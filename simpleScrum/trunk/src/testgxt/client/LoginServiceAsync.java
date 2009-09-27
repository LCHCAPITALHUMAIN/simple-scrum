package testgxt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
  void tryLoginAs(String login, String password, AsyncCallback<Boolean> async);
}
