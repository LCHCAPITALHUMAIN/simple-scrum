package com.nazir.customscrum.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 16, 2010
 * Time: 9:58:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface LoginServiceAsync {
    void login(String userName, String password, AsyncCallback<Boolean> async);
}
