package Utils;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/18/12
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class CalendarUtilTest {
    @Test
    public void testIsWeekend() throws Exception {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date date = formatter.parse("18/02/2012");
        assertTrue(CalendarUtil.isWeekend(date));

        date = formatter.parse("19/02/2012");
        assertTrue(CalendarUtil.isWeekend(date));

        date = formatter.parse("20/02/2012");
        assertFalse(CalendarUtil.isWeekend(date));

        date = formatter.parse("21/02/2012");
        assertFalse(CalendarUtil.isWeekend(date));

        date = formatter.parse("22/02/2012");
        assertFalse(CalendarUtil.isWeekend(date));

        date = formatter.parse("23/02/2012");
        assertFalse(CalendarUtil.isWeekend(date));

        date = formatter.parse("24/02/2012");
        assertFalse(CalendarUtil.isWeekend(date));

    }
}
