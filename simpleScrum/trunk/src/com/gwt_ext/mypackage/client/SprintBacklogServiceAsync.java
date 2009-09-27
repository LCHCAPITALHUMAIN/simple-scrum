package com.gwt_ext.mypackage.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt_ext.mypackage.client.model.SprintbacklogEntity;

import java.util.List;


public interface SprintBacklogServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
    void getBacklogItems(String sprint, int teamNo, AsyncCallback<List<SprintbacklogEntity>> myBacklogItemAsyncCallback);
}