package testgxt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import java.util.List;

import testgxt.client.model.scrum.SprintBacklogEntity;


public interface SprintBacklogService extends RemoteService {
    // Sample interface method of remote interface
    List<SprintBacklogEntity> getBacklogItems(String sprint, int teamNo);
    void setBacklogItems(SprintBacklogEntity items);

    /**
     * Utility/Convenience class.
     * Use EasyScrumService.App.getInstance () to access static instance of EasyScrumServiceAsync
     */
    public static class App {
        private static SprintBacklogServiceAsync app = null;

        public static synchronized SprintBacklogServiceAsync getInstance() {
            if (app == null) {
                app = (SprintBacklogServiceAsync) GWT.create(SprintBacklogService.class);
                ((ServiceDefTarget) app).setServiceEntryPoint(GWT.getModuleBaseURL() + "testgxt.TestGxt/SprintBacklogService");
            }
            return app;
        }
    }
}