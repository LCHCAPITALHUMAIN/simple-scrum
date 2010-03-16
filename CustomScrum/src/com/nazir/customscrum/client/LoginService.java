package com.nazir.customscrum.client;

import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 16, 2010
 * Time: 9:58:42 PM
 * To change this template use File | Settings | File Templates.
 */
@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
    public Boolean login(String userName, String password);
}
