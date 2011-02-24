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
    private User productOwner;
    private User globalScrumMaster;

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
        createTestUser();

        Sprint sprint = new Sprint();
        sprint.description  = ("Sprint 1");
        sprint.number = (1);
        sprint.title = ("Sprint 1");
        sprint.setGlobalStandupTime(new Time(System.currentTimeMillis()));
        sprint.setTasks(createTasks());
        sprint.fromDate = new Date();
        sprint.toDate = new Date();
        sprint.productOwner = productOwner;
        sprint.globalScrumMaster = globalScrumMaster;
        setTeam(sprint);
        session.saveOrUpdate(sprint);
        session.flush();
        session.close();
    }

    private void createTestUser() {
        Profile crdsITProfile = new Profile();
        crdsITProfile.name = "CRDS_IT";
        session.saveOrUpdate(crdsITProfile);

        Profile maosITProfile = new Profile();
        maosITProfile.name = "MAOS_IT";
        session.saveOrUpdate(maosITProfile);

        Profile referentialSupport = new Profile();
        referentialSupport.name = "REFRENTIAL_SUPPORT";
        session.saveOrUpdate(referentialSupport);

        Profile crdsBA = new Profile();
        crdsBA.name = "CRDS_BA";
        session.saveOrUpdate(crdsBA);

        productOwner = new User();
        productOwner.userUid = "waltzp";
        productOwner.firstName = "Patterson";
        productOwner.lastName = "WALTZ";
        productOwner.emailAddress = "patterson.waltz@bnpparibas.com";
        productOwner.profile = crdsBA;
        session.saveOrUpdate(productOwner);


        globalScrumMaster = new User();
        globalScrumMaster.userUid = "khann";
        globalScrumMaster.firstName = "Nazir";
        globalScrumMaster.lastName = "KHAN";
        globalScrumMaster.emailAddress = "nazir.khan@bnpparibas.com";
        globalScrumMaster.profile = crdsITProfile;


        session.saveOrUpdate(globalScrumMaster);


    }

    public void testHoliday() throws Exception {
        Holiday holiday = new Holiday();
        holiday.key = new HolidayKey();
        holiday.key.date = new Date();
        holiday.key.user = productOwner;
        session.saveOrUpdate(holiday);
        session.flush();
        session.close();

    }

    public void testRetrieveData() throws Exception {
        Sprint sprint = (Sprint) session.get(Sprint.class, 1);
        assertEquals(0, sprint.teams.size());

    }

    private void setTeam(Sprint sprint) {
        Team team = new Team();
        team.estimatedFocusFactor = 23;
        team.name = "T1";
        sprint.teams.add(team);
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
