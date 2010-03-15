package com.nazir.customscrum.server.util;

import com.nazir.customscrum.client.model.Sprint;
import com.nazir.customscrum.client.model.Task;
import com.nazir.customscrum.server.HibernateImplTest;
import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Mar 14, 2010
 * Time: 4:59:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class PojoConverterTest extends HibernateImplTest {
    private PojoConverter pojoConverter = new PojoConverter();

    public void testSimplePojo() {
        Sprint sprint = new Sprint();
        sprint.setTitle("Test");

        Sprint convertedSprint = pojoConverter.convert(sprint);
        assertNotSame(sprint, convertedSprint);
        assertEquals(sprint.getTitle(), convertedSprint.getTitle());
    }

    public void testNestedPojo() {
        Sprint sprint = (Sprint) session.load(Sprint.class, 1);

        org.hibernate.Hibernate.initialize(sprint);
        
        Sprint convertedSprint = pojoConverter.convert(sprint);
        assertNotSame(sprint, convertedSprint);
        assertEquals(sprint.getTitle(), convertedSprint.getTitle());
        assertNotSame(sprint.getTasks(), convertedSprint.getTasks());
        assertEquals(sprint.getTasks().size(), convertedSprint.getTasks().size());
        //assertEquals("task1", convertedSprint.getTasks().iterator().next().getDescription());
    }

    public void testNestedPojo1() {
        Sprint sprint = new Sprint();
        sprint.setTitle("Test");
        Set<Task> tasks = new HashSet<Task>();
        Task task1 = new Task();
        task1.setDescription("task1");
        tasks.add(task1);
        sprint.setTasks(tasks);


        Sprint convertedSprint = pojoConverter.convert(sprint);
        assertNotSame(sprint, convertedSprint);
        assertEquals(sprint.getTitle(), convertedSprint.getTitle());
        assertEquals(sprint.getTasks().size(), convertedSprint.getTasks().size());
        assertNotSame(sprint.getTasks(), convertedSprint.getTasks());
        assertEquals("task1", convertedSprint.getTasks().iterator().next().getDescription());
    }
}
