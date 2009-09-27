package com.gwt_ext.mypackage.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.gwt_ext.mypackage.client.model.SprintbacklogEntity;

import java.util.List;


public interface SprintBacklogService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);
    List<SprintbacklogEntity> getBacklogItems(String sprint, int teamNo);

    /**
     * Utility/Convenience class.
     * Use EasyScrumService.App.getInstance () to access static instance of EasyScrumServiceAsync
     */
    public static class App {
        private static SprintBacklogServiceAsync app = null;

        public static synchronized SprintBacklogServiceAsync getInstance() {
            if (app == null) {
                app = (SprintBacklogServiceAsync) GWT.create(SprintBacklogService.class);
                ((ServiceDefTarget) app).setServiceEntryPoint(GWT.getModuleBaseURL() + "com.gwt_ext.mypackage.HelloWorld/SprintBacklogService");
            }
            return app;
        }
    }
}