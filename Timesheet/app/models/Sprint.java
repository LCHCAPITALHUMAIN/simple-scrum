package models;

import Utils.CalendarUtil;
import Utils.DateIterator;
import org.apache.commons.lang.time.DateUtils;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.*;

import static Utils.CalendarUtil.formatDate;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 03/04/12
 * Time: 11:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Sprint extends Model {
    public int sprintNumber;
    public Date startDate;
    public Date endDate;
    @Transient
    public List<SprintJira> sprintJiras = new ArrayList<SprintJira>();
    @Transient
    private TreeMap<Date, String> sprintDays = null;

    @Override
    public String toString() {
        return String.format("Sprint %s: (%s, %s)", sprintNumber, formatDate(startDate), formatDate(endDate));
    }

    public String getSprintName() {
        return String.format("Sprint %s", sprintNumber);
    }

    public double calcualteTotalRemaining() {
        double totalRemaining = 0;
        for (SprintJira sprintJira : sprintJiras) {
            totalRemaining += sprintJira.getRemaining();
        }
        return totalRemaining;
    }


    public Map<Date, String> getSprintDays() {
        if (sprintDays == null) {
            sprintDays = new TreeMap<Date, String>();
            DateIterator dateIterator = new DateIterator(startDate, endDate);
            int i = 1;
            for (Date date : dateIterator) {
                if (!CalendarUtil.isWeekend(date)) {
                    sprintDays.put(date, "Day " + i++);
                }
            }
        }
        return sprintDays;
    }


    public Map<Date, Float> calculateActuals(Date currentDay, User user) {
        Map<Date, Float> actuals = new TreeMap<Date, Float>();

        for (Date sprintDay : getSprintDays().keySet()) {
            if (sprintDay.before(currentDay)) {
                actuals.put(sprintDay, calculateActual(user, sprintDay));
            }
        }
        return actuals;
    }

    private Float calculateActual(User user, Date date) {
        Float totalActual = 0F;
        for (SprintJira sprintJira : sprintJiras) {
            for (Actual actual : sprintJira.actuals) {
                if (actual.user.userName.equals(user.userName) && DateUtils.isSameDay(actual.date, date)) {
                    totalActual += actual.actual;
                    System.out.println("actual found for " + user.userName + " on " + sprintJira.jiraNumber + " of " + actual.actual);
                }
            }
        }
        return totalActual;
    }

}
