package controllers;

import Utils.CalendarUtil;
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
    public static void saveRemaining(SprintJira jira, Date date,Float timeInDays) {
        if (jira.id == null) {
            System.out.println("Failed...missing jira ino");
            renderJSONResult("Failed");
        }
        Remaining remaining = new Remaining();
        remaining.remaining = timeInDays;
        remaining.date = date;
        remaining.save();

        jira.remainings.add(remaining);
        jira.save();

        System.out.println(String.format("Saved remaining: %s %s %s", remaining.date, remaining.remaining, jira.jiraNumber));
        renderJSONSuccessResult();
    }

    public static void saveActual(SprintJira jira, Date date, Float timeInDays) {
        if (jira.id == null) {
            System.out.println("Failed...missing jira ino");
            renderJSONResult("Failed");
        }
        Actual actual = new Actual();
        actual.user = User.find("userName=?", connected()).first();
        actual.actual = timeInDays;
        actual.date = date;
        actual.save();

        jira.actuals.add(actual);
        jira.save();

        System.out.println(String.format("Saved actual: %s %s %s %s", actual.user.fullName, actual.date, actual.actual, jira.jiraNumber));
        renderJSONSuccessResult();
    }

    public static void show(Sprint selectedSprint, String selectedTeam) {
        List<Sprint> sprints = Sprint.findAll();
        if (selectedSprint.id == null) {
            selectedSprint = sprints.get(sprints.size()-1);
        }
        List<SprintJira> sprintJiras = SprintJira.find("sprint=?", selectedSprint).fetch();
        selectedSprint.sprintJiras = sprintJiras;

        double totalRemainingInDays = selectedSprint.getRemaining();
        Date currentDay = CalendarUtil.resetTime(new Date());

        User loggedUser = User.find("userName=?", connected()).first();
        Map<Date, Float> acutalsOfLoggedUser = selectedSprint.calculateActuals(currentDay, loggedUser);
        render(totalRemainingInDays, selectedTeam, selectedSprint, sprints, sprintJiras,  currentDay, acutalsOfLoggedUser, loggedUser);
    }
}
