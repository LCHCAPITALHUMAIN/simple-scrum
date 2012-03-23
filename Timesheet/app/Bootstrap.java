import Utils.HolidayTypeUtil;
import org.apache.commons.lang.time.DateUtils;
import play.db.jpa.JPABase;
import play.test.*;
import play.jobs.*;
import models.*;

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
        HolidayTypeUtil.initIfReqiured();
    }

    private void resetTimeForAllHolidays() {
        List<PublicHoliday> publicHolidays = PublicHoliday.findAll();
        for (PublicHoliday publicHoliday : publicHolidays) {
            System.out.println("# Intitial date: " + publicHoliday.date);
            publicHoliday.date = DateUtils.setHours(publicHoliday.date, 0);
            publicHoliday.date = DateUtils.setMinutes(publicHoliday.date, 0);
            publicHoliday.date = DateUtils.setSeconds(publicHoliday.date, 0);
            publicHoliday.date = DateUtils.setMilliseconds(publicHoliday.date, 0);
            System.out.println("# Modi date: " + publicHoliday.date);

            publicHoliday.save();
        }

        List<Holiday> holidays = Holiday.findAll();
        for (Holiday holiday : holidays) {
            DateUtils.setHours(holiday.date, 0);
            DateUtils.setMinutes(holiday.date, 0);
            DateUtils.setSeconds(holiday.date, 0);
            DateUtils.setMilliseconds(holiday.date, 0);

            holiday.save();
        }
    }

}