package testgxt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by IntelliJ IDEA.
 * User: J_Hallot
 * Date: 13 juil. 2009
 * Time: 13:15:11
 * To change this template use File | Settings | File Templates.
 */
public interface TestGxtServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
