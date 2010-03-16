package com.nazir.customscrum.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.nazir.customscrum.client.LoginService;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 16, 2010
 * Time: 9:58:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
    @Override
    public Boolean login(String userName, String password) {
        if ("naz".equals(userName)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}