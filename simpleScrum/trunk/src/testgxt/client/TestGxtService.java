package testgxt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;

public interface TestGxtService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use TestGxtService.App.getInstance () to access static instance of TestGxtServiceAsync
     */
    public static class App {
        private static TestGxtServiceAsync app = null;

        public static synchronized TestGxtServiceAsync getInstanceTestGXTService() {
          if (app == null) {
              app = (TestGxtServiceAsync) GWT.create(TestGxtService.class);
              ((ServiceDefTarget) app).setServiceEntryPoint(GWT.getModuleBaseURL() + "testgxt.TestGxt/TestGxtService");
          }
          return app;
        }
    }
}
