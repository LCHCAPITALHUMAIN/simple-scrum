package Utils;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 21/03/12
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
public class JiraDetail {
    public int sprint;
    public String category;
    public String businessJira;
    public String parentBusinessJira;
    public String itJira;
    public String parentITJira;
    public String description;
    public String priority;
    public String status;
    public String assignee;
    public String team;
    public int estimate;
    public int actual;
    public int remaining;

    public String getCssClassByStatus() {
        if ("1-To be estimated".equals(status)) {
            return "label label-important";
        }else if ("3-To be developed".equals(status)) {
            return "label label-info";
        }else if ("4-Dev in progress".equals(status)) {
            return "label label-warning";
        }else if ("5-To be Tested".equals(status)) {
            return "label label-inverse";
        }
        return "label";
    }

    public String getCssClassByCategory() {
        if ("Unplanned".equals(category)) {
            return "label label-important";
        }else if ("Planned".equals(category)) {
            return "label label-info";
        }else if ("Transversal".equals(category)) {
            return "label label-warning";
        }
        return "label";
    }

    @Override
    public String toString() {
        return "JiraDetail{" +
                "sprint=" + sprint +
                ", category='" + category + '\'' +
                ", businessJira='" + businessJira + '\'' +
                ", itJira='" + itJira + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", assignee='" + assignee + '\'' +
                ", team='" + team + '\'' +
                ", estimate=" + estimate +
                ", actual=" + actual +
                ", remaining=" + remaining +
                '}';
    }
}
