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

public class SprintBacklogIT extends TimesheetController{
    public static void saveRemaining(SprintJira jira, Date date,Float timeInDays) {
        if (jira.id == null) {
            System.out.println("Failed...missing jira ino");
            renderJSON(new JSONResult("Failed"));
        }
        Remaining remaining = new Remaining();
        remaining.remaining = timeInDays;
        remaining.date = date;
        remaining.save();

        jira.remainings.add(remaining);
        jira.save();

        System.out.println(String.format("Saved remaining: %s %s %s", remaining.date, remaining.remaining, jira.jiraNumber));
        renderJSON(new JSONResult(JSONResult.SUCCESS));
    }

    public static void saveActual(SprintJira jira, Date date, Float timeInDays) {
        if (jira.id == null) {
            System.out.println("Failed...missing jira ino");
            renderJSON(new JSONResult("Failed"));
        }
        User loggedUser = User.find("userName=?", connected()).first();
        Actual actual = jira.getActualObject(loggedUser, date);
        if (actual == null) {
            actual = new Actual();
            actual.user = loggedUser;
            actual.date = date;
            actual.actual = 0F;
        }
        actual.actual += timeInDays;
        if (actual.actual > 1F) {
            //renderJSONResult("Actuals cannot be more than 8 hours per day");
            renderJSON(new JSONResult("Actuals cannot be more than 8 hours per day"));
        }
        actual.save();

        jira.actuals.add(actual);
        jira.save();

        System.out.println(String.format("Saved actual: %s %s %s %s", actual.user.fullName, actual.date, actual.actual, jira.jiraNumber));
        renderJSON(new JSONResult(JSONResult.SUCCESS));
    }

    public static void show(Sprint selectedSprint, String selectedTeam) {
        List<Sprint> allSprints = Sprint.findAll();
        List<Sprint> sprints = new ArrayList<Sprint>();
        for (Sprint sprint : allSprints) {
            if (sprint.isFeatureSprint()) {
                sprints.add(sprint);
            }
        }
        if (selectedSprint.id == null) {
            selectedSprint = sprints.get(sprints.size()-1);
        }
        double totalRemainingInDays = selectedSprint.getRemaining();
        User loggedUser = User.find("userName=?", connected()).first();
        Map<Date, Float> acutalsOfLoggedUser = selectedSprint.calculateActuals(loggedUser);
        render(totalRemainingInDays, selectedTeam, selectedSprint, sprints, acutalsOfLoggedUser, loggedUser);
    }
}
