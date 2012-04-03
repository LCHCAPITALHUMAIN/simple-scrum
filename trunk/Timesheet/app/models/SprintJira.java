package models;

import Utils.JiraDetail;
import Utils.JiraUtil;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 03/04/12
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class SprintJira extends Model {
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
            jiraDetail = new JiraDetail();
            //jiraDetail = JiraUtil.getJira(jiraNumber);
        }
        return jiraDetail;
    }

    public void setJiraDetail(JiraDetail jiraDetail) {
        this.jiraDetail = jiraDetail;
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
        //return sprintEstimate - getActual();
        return 0.0F;
    }

    private Float getActual() {
        Float cumulatedActual=0F;
        for (Actual actual : actuals) {
            cumulatedActual += actual.actual;
        }

        return cumulatedActual;
    }
}
