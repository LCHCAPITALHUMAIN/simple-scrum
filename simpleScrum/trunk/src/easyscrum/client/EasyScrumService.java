package easyscrum.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;


public interface EasyScrumService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use EasyScrumService.App.getInstance () to access static instance of EasyScrumServiceAsync
     */
    public static class App {
        private static EasyScrumServiceAsync app = null;

        public static synchronized EasyScrumServiceAsync getInstance() {
            if (app == null) {
                app = (EasyScrumServiceAsync) GWT.create(EasyScrumService.class);
                ((ServiceDefTarget) app).setServiceEntryPoint(GWT.getModuleBaseURL() + "easyscrum.EasyScrum/EasyScrumService");
            }
            return app;
        }
    }
}
