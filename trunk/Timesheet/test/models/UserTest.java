package models;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 26/03/12
 * Time: 11:26
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {
    @Test
    public void testEquality() throws Exception {
        User userNazir1 = new User("nazir");
        User userNazir2 = new User("nazir");
        userNazir2.location = new Location();

        assertEquals(userNazir1, userNazir2);
    }
}
