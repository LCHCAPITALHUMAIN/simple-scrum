import Utils.CalendarUtil;
import Utils.HolidayTypeUtil;
import org.apache.commons.lang.time.DateUtils;
import play.db.jpa.JPABase;
import play.test.*;
import play.jobs.*;
import models.*;

import java.util.Calendar;
import java.util.List;

@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
        // Load default data if the database is empty
        if(Team.count() == 0) {
            System.out.println("############ Loaded yml" + Team.count());
            Fixtures.loadModels("initial-data.yml");

            resetTimeForAllHolidays();
            System.out.println("############ Loaded yml END" + Team.count());

        }
    }

    private void resetTimeForAllHolidays() {
        List<PublicHoliday> publicHolidays = PublicHoliday.findAll();
        for (PublicHoliday publicHoliday : publicHolidays) {
            System.out.println("# Intitial date: " + publicHoliday.date);
            publicHoliday.date = CalendarUtil.resetTime(publicHoliday.date);
            System.out.println("# Modi date: " + publicHoliday.date);

            publicHoliday.save();
        }

        List<Holiday> holidays = Holiday.findAll();
        for (Holiday holiday : holidays) {
            holiday.date = CalendarUtil.resetTime(holiday.date);
            holiday.save();
        }
    }

}