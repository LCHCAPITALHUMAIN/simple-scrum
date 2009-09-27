package testgxt.client.model.scrum;

import junit.framework.TestCase;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;


public class SprintBacklogEntityTest extends TestCase {

  protected void setUp() throws Exception {
    super.setUp();
  }

  public void testFullRead() {
    ListableBeanFactory beans = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
    EntityManagerFactory entityManagerFactory = (EntityManagerFactory) beans.getBean("entityManagerFactory");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Query query = entityManager.createQuery("from testgxt.client.model.scrum.SprintBacklogEntity");
    List<SprintBacklogEntity> backlogEntities = query.getResultList();
    assertEquals(true, backlogEntities.size() >= 836);
  }

  public void testUpdateDetachedCopy() {
    ListableBeanFactory beans = new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
    EntityManagerFactory entityManagerFactory = (EntityManagerFactory) beans.getBean("entityManagerFactory");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    SprintBacklogEntity entry = entityManager.find(SprintBacklogEntity.class, 1L);
    entityManager.close();

    entry.setJphi("3.5");
    entry.setDhanya("1");
    entry.setDay10("4");

    entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    entry = entityManager.merge(entry);
    entityManager.getTransaction().commit();
    entityManager.close();
    assertEquals("3.5", entry.getJphi());
    assertEquals("1", entry.getDhanya());
    assertEquals("4", entry.getDay10());

    entityManager = entityManagerFactory.createEntityManager();
    SprintBacklogEntity actualEntry = entityManager.find(SprintBacklogEntity.class, 1L);
    entityManager.close();

    assertEquals(entry.getJphi(), actualEntry.getJphi());
    assertEquals(entry.getDhanya(), actualEntry.getDhanya());
    assertEquals(entry.getDay10(), actualEntry.getDay10());
  }

}