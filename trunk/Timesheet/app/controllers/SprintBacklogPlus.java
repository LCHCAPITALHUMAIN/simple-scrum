package controllers;

import Utils.JiraDetail;
import models.SprintJira;
import models.Sprint;
import play.mvc.With;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 21/03/12
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)

public class SprintBacklogPlus extends TimesheetController{
//    public static void show(Sprint selectedSprint, String selectedTeam) {
//        List<String> columnHeaders = generateColumnHeader();
//        List<Sprint> sprints = Sprint.findAll();
//        if (selectedSprint.id == null) {
//            selectedSprint = sprints.get(sprints.size()-1);
//        }
//        List<SprintJira> sprintJiras = selectedSprint.sprintJiras;
////        if (StringUtils.isNotEmpty(selectedTeam)) {
////            jiraDetails = filterTeam(jiraDetails, selectedTeam);
////        }
//        double totalRemainingInDays = calcualteTotalRemaining(sprintJiras);
//        render(totalRemainingInDays, selectedTeam, selectedSprint, sprints, columnHeaders, sprintJiras);
//    }
//
//
//    private static double calcualteTotalRemaining(List<SprintJira> sprintJiraDetails) {
//        double totalRemaining = 0;
//        for (SprintJira sprintJiraDetail : sprintJiraDetails) {
//            totalRemaining += sprintJiraDetail.initialEstimate;
//        }
//        return totalRemaining;
//    }
//
//    //TODO: this method can be removed, instead apply filter in SQL query
//    private static List<JiraDetail> filterTeam(List<JiraDetail> jiraDetails, String teamName) {
//        List<JiraDetail> filterdTeam = new ArrayList<JiraDetail>();
//        for (JiraDetail jiraDetail : jiraDetails) {
//            if (teamName.equals(jiraDetail.team)) {
//                filterdTeam.add(jiraDetail);
//            }
//        }
//        return filterdTeam;
//    }
//
//    private static List<String> generateColumnHeader() {
//        List<String> columnHeader = new ArrayList<String>();
//        columnHeader.add("sprint");
//        columnHeader.add("category");
//        columnHeader.add("businessJira");
//        columnHeader.add("itJira");
//        columnHeader.add("description");
//        columnHeader.add("priority");
//        columnHeader.add("status");
//        columnHeader.add("assignee");
//        columnHeader.add("team");
//        columnHeader.add("estimate");
//        columnHeader.add("actual");
//        columnHeader.add("remaining");
//        return columnHeader;
//    }
//
}
