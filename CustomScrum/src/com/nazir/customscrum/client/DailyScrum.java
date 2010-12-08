package com.nazir.customscrum.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Dec 1, 2010
 * Time: 7:59:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class DailyScrum extends VerticalPanel {
    private ListBox dropDownSprint;
    private ListBox dropDownTeam;

    public DailyScrum() {
        this.setHorizontalAlignment(ALIGN_CENTER);
        createSprintDropDown();
        createTeamDropDown();

        this.setSpacing(30);
        this.add(createCriteria());
        //sprintDetails.add(createSprintDetailsPanel());


    }

    private Widget createSprintDetailsPanel() {
        return null;
    }

    private void createSprintDropDown() {
        dropDownSprint = new ListBox(false);
        dropDownSprint.addItem("Sprint 1");
        dropDownSprint.addItem("Sprint 2");
        dropDownSprint.addItem("Sprint 3");
    }
    private void createTeamDropDown() {
        dropDownTeam = new ListBox(false);
        dropDownTeam.addItem("All");
        dropDownTeam.addItem("Team 1");
        dropDownTeam.addItem("Team 2");
        dropDownTeam.addItem("Team 3");
    }


    private Widget createCriteria() {
        VerticalPanel criterias = new VerticalPanel();
        criterias.add(dropDownSprint);
        criterias.add(dropDownTeam);
        return criterias;
    }
}
