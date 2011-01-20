package com.nazir.customscrum.server;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.test.AbstractTransactionalSpringContextTests;
import com.nazir.customscrum.client.model.*;

import java.sql.Time;
import java.util.Set;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 11, 2010
 * Time: 8:52:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateImplTest extends AbstractTransactionalSpringContextTests {
    private SessionFactory sessionFactory;
    protected Session session;

    @Override
    protected void onSetUpInTransaction() throws Exception {
        super.onSetUpInTransaction();
        session = sessionFactory.openSession();
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"file:./war/WEB-INF/applicationContext.xml"};
    }

    public void testCreateData() {
        setComplete();
        
        Sprint sprint = new Sprint();
        sprint.description  = ("Sprint 1");
        sprint.number = (1);
        sprint.title = ("Sprint 1");
        sprint.setGlobalStandupTime(new Time(System.currentTimeMillis()));
        sprint.setTasks(createTasks());
        sprint.fromDate = new Date();
        sprint.toDate = new Date();
        session.saveOrUpdate(sprint);
        session.flush();
        session.close();
    }

    private Set<Task> createTasks() {
        return null;
    }

    private Set<SprintDay> createDays() {
        return null;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
