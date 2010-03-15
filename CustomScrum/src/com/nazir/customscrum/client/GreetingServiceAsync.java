package com.nazir.customscrum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.nazir.customscrum.client.model.Sprint;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
  void greetServer(String input, AsyncCallback<Sprint> callback);
}
