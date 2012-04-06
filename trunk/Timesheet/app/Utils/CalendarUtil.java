package Utils;

import models.Location;
import models.PublicHoliday;
import org.apache.commons.lang.time.DateUtils;
import play.db.jpa.GenericModel;

import java.text.SimpleDateFormat;
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
            calendar.set(Calendar.MONTH, month - 1);
        }
        if (year != 0) {
            calendar.set(Calendar.YEAR, year);
        }
        return resetTime(calendar.getTime());
    }

    public static Date resetTime(Date date) {
        date = DateUtils.setHours(date, 0);
        date = DateUtils.setMinutes(date, 0);
        date = DateUtils.setSeconds(date, 0);
        date = DateUtils.setMilliseconds(date, 0);
        return date;
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

    public static PublicHoliday isPublicHoliday(Date date, Location location) {
        PublicHoliday publicHoliday = PublicHoliday.find("date=? and location=?", date, location).first();
        return publicHoliday;
    }

    public static Date createNextFriday(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        do {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        } while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY);

        return resetTime(calendar.getTime());
    }
    public static Date createLastMonday() {
        Calendar calendar = Calendar.getInstance();

        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        return resetTime(calendar.getTime());
    }

    public static String formatDate(Date date) {

        return new SimpleDateFormat("MM-dd-yyyy").format(date);
    }
}
