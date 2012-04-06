package models;

import Utils.JiraDetail;
import Utils.JiraUtil;
import controllers.Actuals;
import org.apache.commons.lang.time.DateUtils;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 03/04/12
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class SprintJira extends Model {
    public static final String UNPLANNED = "Unplanned";
    public static final String PLANNED = "Planned";
    public static final String TRANSVERSAL = "Transversal";
    public String jiraNumber;

    @Required
    @ManyToOne
    public JiraCategory jiraCategory;

    @Required
    public Float sprintEstimate;

    @Transient
    private JiraDetail jiraDetail ;

    @ManyToOne
    @Unique(message = "This jira is already linked with the sprint.")
    public Sprint sprint;



    @OneToMany
    public List<Actual> actuals = new ArrayList<Actual>();

    @OneToMany
    public List<Remaining> remainings = new ArrayList<Remaining>();


    @Override
    public String toString() {
        return String.format("%s %s", sprint, jiraNumber);
        //return String.format("%s %s", sprint.getSprintName(), jiraNumber);
    }

    public JiraDetail getJiraDetail() {
        if (jiraDetail == null) {
//            jiraDetail = new JiraDetail();
            jiraDetail = JiraUtil.getJira(jiraNumber);
        }
        return jiraDetail;
    }

    public void setJiraDetail(JiraDetail jiraDetail) {
        this.jiraDetail = jiraDetail;
    }

    public Float getRemaining(Date date) {
        Float result = calculateRemaining();
        for (Remaining remaining : remainings) {
            if (!remaining.date.after(date)) {
                result = remaining.remaining;
            }
        }
        return result;
    }

    public Float getRemaining() {
        if (remainings.isEmpty()) {
            return calculateRemaining();
        }
        Float finalRemaining = remainings.get(0).remaining;
        Date finalRemainingDate = remainings.get(0).date;

        for (Remaining remaining : remainings) {
            if (remaining.date.after(finalRemainingDate)) {
                finalRemaining = remaining.remaining;
                finalRemainingDate = remaining.date;
            }
        }
        return finalRemaining;

    }

    private Float calculateRemaining() {
        return sprintEstimate - getActual();
    }

    public Actual getActualObject(User user, Date day) {
        for (Actual actual : actuals) {
            if (user.userName.equals(actual.user.userName) && DateUtils.isSameDay(day, actual.date)) {
                return actual;
            }
        }
        return null;

    }

    public Float getActual(User user, Date day) {
        Float userActual = 0F;
        for (Actual actual : actuals) {
            if (user.userName.equals(actual.user.userName) && DateUtils.isSameDay(day, actual.date)) {
                userActual += actual.actual;
            }
        }
        return userActual;
    }

    public Float getActual(User user) {
        Float userActual = 0F;
        for (Actual actual : actuals) {
            if (user.userName.equals(actual.user.userName)) {
                userActual += actual.actual;

            }
        }
        return userActual;
    }
    private Float getActual() {
        Float cumulatedActual=0F;
        for (Actual actual : actuals) {
            cumulatedActual += actual.actual;
        }

        return cumulatedActual;
    }

    public Map<User, Float> getConsolidatedActuals() {
        Map<User, Float> consolidatedActuals = new HashMap<User, Float>();
        for (Actual actual : actuals) {
            if (!consolidatedActuals.containsKey(actual.user)) {
                consolidatedActuals.put(actual.user, 0F);
            }
            consolidatedActuals.put(actual.user, consolidatedActuals.get(actual.user) + actual.actual);
        }
        return consolidatedActuals;
    }

    public String getCssClassForCategory() {
        if (UNPLANNED.equals(jiraCategory.name)) {
            return "label label-important";
        }else if (PLANNED.equals(jiraCategory.name)) {
            return "label label-info";
        }else if (TRANSVERSAL.equals(jiraCategory.name)) {
            return "label label-warning";
        }
        return "label";
    }

    public boolean isPlanned() {
        return PLANNED.equals(jiraCategory.name);
    }

}
