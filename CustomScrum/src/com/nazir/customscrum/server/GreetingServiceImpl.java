package com.nazir.customscrum.server;

import com.nazir.customscrum.client.GreetingService;
import com.nazir.customscrum.client.model.Sprint;
import com.nazir.customscrum.server.util.PojoConverter;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.WebApplicationContext;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {

  public Sprint greetServer(String input) {
      WebApplicationContext springContext =
            WebApplicationContextUtils.getWebApplicationContext(getServletContext());
      SessionFactory sessionFactory = (SessionFactory) springContext.getBean("sessionFactory");
      Session session = sessionFactory.getCurrentSession();
      System.out.println(session);
      Sprint sprint = (Sprint) session.get(Sprint.class, 1);
      System.out.println("1Success..............");
      return new PojoConverter().convert(sprint);
  }
}
