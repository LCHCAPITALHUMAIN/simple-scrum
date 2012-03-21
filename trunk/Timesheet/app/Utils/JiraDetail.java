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
    public String itJira;
    public String description;
    public String priority;
    public String status;
    public String assignee;
    public String team;
    public int estimate;
    public int actual;
    public int remaining;

    public String getCssColor() {
        if (status.equals("1-To be estimated")) {
            return "label label-important";
        }else if (status.equals("3-To be developed")) {
            return "label label-info";
        }else if (status.equals("4-Dev in progress")) {
            return "label label-warning";
        }else if (status.equals("5-To be Tested")) {
            return "label label-inverse";
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
