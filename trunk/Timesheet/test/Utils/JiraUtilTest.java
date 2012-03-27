package Utils;

import org.junit.Test;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 27/03/12
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class JiraUtilTest {
    @Test
    public void testGetReleases() throws Exception {
        Set<String> res = JiraUtil.getReleases();
        for (String re : res) {
            System.out.println(re);
        }
    }
}
