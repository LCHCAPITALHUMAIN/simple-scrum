package controllers;

import Utils.CalendarUtil;
import Utils.DateIterator;
import Utils.JiraDetail;
import models.*;
import play.mvc.With;

import java.util.*;

import static controllers.Secure.Security.connected;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 21/03/12
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)

public class SprintBacklogPlus extends TimesheetController{
    public static void saveRemaining(SprintJira jira, Date date,Float timeInHours) {
        if (jira.id == null) {
            System.out.println("Failed...missing jira ino");
            renderJSONResult("Failed");
        }
        Remaining remaining = new Remaining();
        remaining.remaining = timeInHours;
        remaining.date = date;
        remaining.save();

        jira.remainings.add(remaining);
        jira.save();

        System.out.println(String.format("Saved actual: %s %s %s", remaining.date, remaining.remaining, jira.jiraNumber));
        renderJSONSuccessResult();
    }

    public static void saveActual(SprintJira jira, Date date, Float timeInHours) {
        if (jira.id == null) {
            System.out.println("Failed...missing jira ino");
            renderJSONResult("Failed");
        }
        Actual actual = new Actual();
        actual.user = User.find("userName=?", connected()).first();
        actual.actual = timeInHours;
        actual.date = date;
        actual.save();

        jira.actuals.add(actual);
        jira.save();

        System.out.println(String.format("Saved actual: %s %s %s %s", actual.user.fullName, actual.date, actual.actual, jira.jiraNumber));
        renderJSONSuccessResult();
    }

    public static void show(Sprint selectedSprint, String selectedTeam) {
        List<String> columnHeaders = generateColumnHeader();
        List<Sprint> sprints = Sprint.findAll();
        if (selectedSprint.id == null) {
            selectedSprint = sprints.get(sprints.size()-1);
        }
        List<SprintJira> sprintJiras = SprintJira.find("sprint=?", selectedSprint).fetch();
//        if (StringUtils.isNotEmpty(selectedTeam)) {
//            jiraDetails = filterTeam(jiraDetails, selectedTeam);
//        }
        double totalRemainingInDays = calcualteTotalRemaining(sprintJiras);
        Map<Date, String> sprintDays = generateSprintDays(selectedSprint);
        render(totalRemainingInDays, selectedTeam, selectedSprint, sprints, columnHeaders, sprintJiras, sprintDays);
    }

    private static Map<Date, String> generateSprintDays(Sprint sprint) {
        TreeMap<Date, String> sprintDays = new TreeMap<Date, String>();
        DateIterator dateIterator = new DateIterator(sprint.startDate, sprint.endDate);
        int i=1;
        for (Date date : dateIterator) {
            if (!CalendarUtil.isWeekend(date)) {
                sprintDays.put(date, "Day " + i++);
            }
        }
        return sprintDays;
    }


    private static double calcualteTotalRemaining(List<SprintJira> sprintJiraDetails) {
        double totalRemaining = 0;
        for (SprintJira sprintJira : sprintJiraDetails) {
            totalRemaining += sprintJira.getRemaining();
        }
        return totalRemaining;
    }

    //TODO: this method can be removed, instead apply filter in SQL query
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
