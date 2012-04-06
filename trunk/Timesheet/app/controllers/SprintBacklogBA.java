package controllers;

import models.*;
import play.mvc.With;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static controllers.Secure.Security.connected;

/**
 * Created by IntelliJ IDEA.
 * User: n_khan
 * Date: 21/03/12
 * Time: 10:03
 * To change this template use File | Settings | File Templates.
 */
@With(Secure.class)

public class SprintBacklogBA extends TimesheetController{
    public static void show(Sprint selectedSprint, String selectedTeam) {
        List<Sprint> sprints = Sprint.findAll();
        if (selectedSprint.id == null) {
            selectedSprint = sprints.get(sprints.size()-1);
        }
        double totalRemainingInDays = selectedSprint.getRemaining();
        User loggedUser = User.find("userName=?", connected()).first();
        Map<Date, Float> acutalsOfLoggedUser = selectedSprint.calculateActuals(loggedUser);
        render(totalRemainingInDays, selectedTeam, selectedSprint, sprints, acutalsOfLoggedUser, loggedUser);
    }
}
