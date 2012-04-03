package models;

import Utils.JiraDetail;
import Utils.JiraUtil;
import org.hibernate.annotations.CollectionOfElements;
import play.data.validation.Required;
import play.data.validation.Unique;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public Float SprintEstimate;

    @Transient
    private JiraDetail jiraDetail;

    @ManyToOne
    @Unique(message = "This jira is already linked with the sprint.")
    public Sprint sprint;



//    @ManyToMany
//    public Map<Date, Float> remaining;

    @OneToMany
    public List<Actual> actuals = new ArrayList<Actual>();


    @Override
    public String toString() {
        return String.format("%s %s", sprint.getSprintName(), jiraNumber);
    }

    public JiraDetail getJiraDetail() {
        if (jiraDetail == null) {
            jiraDetail = JiraUtil.getJira(jiraNumber);
        }
        return jiraDetail;
    }

    public void setJiraDetail(JiraDetail jiraDetail) {
        this.jiraDetail = jiraDetail;
    }
}
