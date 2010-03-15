package com.nazir.customscrum.server;

import  junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.test.AbstractTransactionalSpringContextTests;
import com.nazir.customscrum.client.model.*;

import java.util.Set;
import java.util.HashSet;
import java.util.Date;
import java.io.File;

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
        sprint.setDescription("Sprint 1");
        sprint.setNumber(1);
        sprint.setTitle("Sprint 1");
        sprint.setAvailability(60);
        sprint.setUserStories(createUserStories());
        sprint.setDays(createDays());
        sprint.setGlobalStandupTime(new Date());
        sprint.setStatus(SprintStatus.NOT_STARTED);
        sprint.setTasks(createTasks());
        sprint.setFromDate(new Date());
        sprint.setToDate(new Date());
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

    private Set<UserStory> createUserStories() {
        Set<UserStory> result = new HashSet<UserStory>();
        return result;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
