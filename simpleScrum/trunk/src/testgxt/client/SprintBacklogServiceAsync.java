package testgxt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import testgxt.client.model.scrum.SprintBacklogEntity;

public interface SprintBacklogServiceAsync {
    void getBacklogItems(String sprint, int teamNo, AsyncCallback<List<SprintBacklogEntity>> myBacklogItemAsyncCallback);
    void setBacklogItems(SprintBacklogEntity item, AsyncCallback<List<SprintBacklogEntity>> myBacklogItemAsyncCallback);
}