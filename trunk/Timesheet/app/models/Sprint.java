package models;

import Utils.CalendarUtil;
import Utils.DateIterator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.omg.CORBA.FloatSeqHelper;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.transform.Result;
import java.text.DecimalFormat;
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
    public List<SprintJira> sprintJiras;
    @Transient
    private TreeMap<Date, String> sprintDays;
    @Transient
    private Date currentDay;
    private ArrayList<SprintJira> plannedSprintJiras;

    @Override
    public String toString() {
        return String.format("Sprint %s: (%s, %s)", sprintNumber, formatDate(startDate), formatDate(endDate));
    }

    public String getSprintName() {
        return String.format("Sprint %s", sprintNumber);
    }

    public double getRemaining() {
        double totalRemaining = 0;
        for (SprintJira sprintJira : getSprintJiras()) {
            totalRemaining += sprintJira.getRemaining();
        }
        return totalRemaining;
    }

    public Float getRemaining(Date day) {
        Float remainingOfTheDay = 0F;
        for (SprintJira sprintJira : getSprintJiras()) {
            remainingOfTheDay += sprintJira.getRemaining(day);
        }
        return remainingOfTheDay;
    }

    public Float getRemainingOnPlannedJiras(Date day) {
        Float remainingOfTheDay = 0F;
        for (SprintJira sprintJira : getPlannedSprintJiras()) {
            remainingOfTheDay += sprintJira.getRemaining(day);
        }
        return remainingOfTheDay;
    }

    public Date getCurrentDay() {
        if (currentDay == null) {
            Date today = CalendarUtil.resetTime(new Date());
            for (Date sprintDay : getSprintDays().keySet()) {
                if (DateUtils.isSameDay(sprintDay, today)) {
                    return sprintDay;
                }
                currentDay = sprintDay;
            }
        }
        return currentDay;
    }
    public Map<Date, String> getSprintDaysUntilCurrentDay() {
        Map<Date, String> filteredSprintDays = new TreeMap<Date, String>();
        for (Date sprintDay : getSprintDays().keySet()) {
            filteredSprintDays.put(sprintDay, getSprintDays().get(sprintDay));
            if (sprintDay.equals(getCurrentDay())) {
                return filteredSprintDays;
            }
        }
        throw new IllegalStateException(String.format("Current day[%s] is not found in the sprint day list [%s]", getCurrentDay(), getSprintDays()));
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


    public Map<Date, Float> calculateActuals(User user) {
        Map<Date, Float> actuals = new TreeMap<Date, Float>();

        for (Date sprintDay : getSprintDaysUntilCurrentDay().keySet()) {
            if (sprintDay.before(currentDay)) {
                actuals.put(sprintDay, calculateActual(user, sprintDay));
            }
        }
        return actuals;
    }

    private Float calculateActual(User user, Date date) {
        Float totalActual = 0F;
        for (SprintJira sprintJira : getSprintJiras()) {
            for (Actual actual : sprintJira.actuals) {
                if (actual.user.userName.equals(user.userName) && DateUtils.isSameDay(actual.date, date)) {
                    totalActual += actual.actual;
                    System.out.println("actual found for " + user.userName + " on " + sprintJira.jiraNumber + " of " + actual.actual);
                }
            }
        }
        return totalActual;
    }

    public String getMessageForDay(Date day, User user, Float totalActualsOfTheDay) {
        StringBuffer result = new StringBuffer();
        result.append("Total: ").append(totalActualsOfTheDay).append(" Day(s)");
        result.append("<br>");
        for (SprintJira sprintJira : getSprintJiras()) {
            if (sprintJira.getActual(user, day) != 0F) {
                result.append(sprintJira.jiraNumber).append(" - ").append(sprintJira.getActual(user)).append(" Day(s)").append("<br>");
            }
        }
        return result.toString();
    }

    public String getDataForBurnDownchart() {
        Float estimate = getEstimateOfPlannedJira();
        int numberOfDays = getNumberOfDays();
        Float caloriesPerDay = estimate / numberOfDays;
        System.out.println("caloriesPerDay" + caloriesPerDay);

        int dayIndex = 1;
        List<String> expectedRemainingChartPoints = new ArrayList<String>();
        List<String> actualRemainingChartPoints = new ArrayList<String>();
        expectedRemainingChartPoints.add(String.format("[%s,%s]", 0, estimate));
        actualRemainingChartPoints.add(String.format("[%s,%s]", 0, estimate));
        for (Date date : getSprintDays().keySet()) {
            estimate -= caloriesPerDay;
            expectedRemainingChartPoints.add(String.format("[%s,%s]", dayIndex, new DecimalFormat("##.##").format(estimate)));
            if (date.equals(getCurrentDay()) || date.before(getCurrentDay())) {
                actualRemainingChartPoints.add(String.format("[%s,%s]", dayIndex, new DecimalFormat("##.##").format(getRemainingOnPlannedJiras(date))));
            }
            dayIndex++;
        }
        System.out.println("expectedRemainingChartPoints" + expectedRemainingChartPoints);
        System.out.println("expectedRemainingChartPoints" + actualRemainingChartPoints);
        String chartPoints = String.format("[[%s],[%s]]", StringUtils.join(expectedRemainingChartPoints, ','), StringUtils.join(actualRemainingChartPoints, ','));
        return chartPoints;

    }

    private int getDayIndex(Date date) {
        int index = 0;

        for (Date date1 : getSprintDays().keySet()) {
            index++;
            if (DateUtils.isSameDay(date1, date)) {
                return index ;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid date passed to find the index. Date: %s, SprintDays", date, getSprintDays().keySet()));
    }

    public int getNumberOfDays() {
        return getSprintDays().size();
    }

    public Float getEstimateOfPlannedJira() {
        Float totalEstimate = 0F;
        for (SprintJira sprintJira : getPlannedSprintJiras()) {
            totalEstimate += sprintJira.sprintEstimate;
        }
        return totalEstimate;
    }

    public Float getEstimate() {
        Float totalEstimate = 0F;
        for (SprintJira sprintJira : getSprintJiras()) {
            if (!SprintJira.TRANSVERSAL.equals(sprintJira.jiraCategory.name)) {
                totalEstimate += sprintJira.sprintEstimate;
            }
        }
        return totalEstimate;
    }

    public List<SprintJira> getPlannedSprintJiras() {
        if (plannedSprintJiras == null) {
            plannedSprintJiras = new ArrayList<SprintJira>();
            for (SprintJira sprintJira : getSprintJiras()) {
                if (sprintJira.isPlanned()) {
                    plannedSprintJiras.add(sprintJira);
                }
            }
        }
        return plannedSprintJiras;
    }
    public List<SprintJira> getSprintJiras() {
        if (sprintJiras == null) {
            sprintJiras = SprintJira.find("sprint=?", this).fetch();
        }
        return sprintJiras;
    }
}
