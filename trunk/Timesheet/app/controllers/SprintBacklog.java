package controllers;

import Utils.JiraDetail;
import Utils.JiraUtil;
import models.Team;
import org.apache.commons.lang.StringUtils;
import play.data.validation.Required;
import play.mvc.Controller;

import javax.print.StreamPrintService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 21/03/12
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
public class SprintBacklog extends Controller{
    public static void show(Integer selectedSprint, String selectedTeam) {
        List<String> columnHeaders = generateColumnHeader();
        List<Integer> sprints = JiraUtil.getAllSprint();
        if (selectedSprint == null) {
            selectedSprint = sprints.get(sprints.size()-1);
        }
        List<JiraDetail> jiraDetails = JiraUtil.getJiras(selectedSprint, "BUSINESS_JIRA");
        if (StringUtils.isNotEmpty(selectedTeam)) {
            jiraDetails = filterTeam(jiraDetails, selectedTeam);
        }
        List<String> teams = generateTeamList();
        render(selectedTeam, teams, selectedSprint, sprints, columnHeaders, jiraDetails);
    }

    private static List<String> generateTeamList() {

        List<String> teams = new ArrayList<String>();
        teams.add("Team1");
        teams.add("Team2");
        return teams;
    }

    private static List<JiraDetail> filterTeam(List<JiraDetail> jiraDetails, String teamName) {
        List<JiraDetail> filterdTeam = new ArrayList<JiraDetail>();
        for (JiraDetail jiraDetail : jiraDetails) {
            if (teamName.equals(jiraDetail.team)) {
                filterdTeam.add(jiraDetail);
            }
        }
        return filterdTeam;
    }

    private static List<String> generateColumnHeader() {
        List<String> columnHeader = new ArrayList<String>();
        columnHeader.add("sprint");
        columnHeader.add("category");
        columnHeader.add("businessJira");
        columnHeader.add("itJira");
        columnHeader.add("description");
        columnHeader.add("priority");
        columnHeader.add("status");
        columnHeader.add("assignee");
        columnHeader.add("team");
        columnHeader.add("estimate");
        columnHeader.add("actual");
        columnHeader.add("remaining");
        return columnHeader;
    }

}
