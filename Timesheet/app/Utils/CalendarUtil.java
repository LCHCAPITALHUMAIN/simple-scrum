package Utils;

import models.Location;
import models.PublicHoliday;
import play.db.jpa.GenericModel;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: 2/16/12
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalendarUtil {
    public static Date createDate(int date, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        if (date != 0) {
            calendar.set(Calendar.DATE, date);
        }
        if (month != 0) {
            calendar.set(Calendar.MONTH, month);
        }
        if (year != 0) {
            calendar.set(Calendar.YEAR, year);
        }
        return calendar.getTime();
    }

    public static Date createDateWithLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public static int getMonth(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getYear(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        return calendar.get(Calendar.YEAR);
    }

    public static boolean isWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == 7 || calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            return true;
        }
        return false;
    }

    public static boolean isPublicHoliday(Date date, Location location) {
        if (PublicHoliday.find("date=? and location=?", date, location).first() != null) {
            System.out.println("####Public holiday found: " + date);
            return true;
        }
        return false;


    }
}
