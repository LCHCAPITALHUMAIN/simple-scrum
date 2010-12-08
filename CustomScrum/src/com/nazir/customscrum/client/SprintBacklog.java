package com.nazir.customscrum.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Nov 27, 2010
 * Time: 11:50:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SprintBacklog extends VerticalPanel {
    private ListBox dropDownSprint;
    private ListBox dropDownTeam;
    private FlexTable tableSprintTask;
    private FlexTable tableLegends;

    public SprintBacklog() {
        this.setHorizontalAlignment(ALIGN_CENTER);
        createSprintDropDown();
        createTeamDropDown();
        createSprintViewTable();
        createLegendTable();

        HorizontalPanel sprintDetails = new HorizontalPanel();
        sprintDetails.setSpacing(30);
        sprintDetails.add(createCriteria());
        sprintDetails.add(createSprintDetailsPanel());

        tableSprintTask.getCellFormatter().getElement(0, 7).setClassName("errorInActual");
        tableSprintTask.getCellFormatter().getElement(0, 10).setClassName("errorInActual");
        TableUtils.highLightRow(tableSprintTask, 1, "plannedTask");
        TableUtils.highLightRow(tableSprintTask, 2, "plannedTask");
        TableUtils.highLightRow(tableSprintTask, 3, "unplannedTask");
        TableUtils.highLightRow(tableSprintTask, 4, "nextTask");

        this.add(sprintDetails);
        this.add(tableSprintTask);
        this.add(tableLegends);
        this.add(createOperationTable());
    }

    private HorizontalPanel createOperationTable() {
       HorizontalPanel panel = new HorizontalPanel();
        Button btnAddPlannedTask = new Button("Add unplanned task");
        btnAddPlannedTask.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                new AddTask("Add planned task");
            }
        });
        panel.add(btnAddPlannedTask);

        Button btnAddUnplannedTask = new Button("Add planned task");
        btnAddUnplannedTask.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                new AddTask("Add unplanned task");
            }
        });
        panel.add(btnAddUnplannedTask);
        return panel;
    }

    private void createLegendTable() {
        tableLegends = new FlexTable();
        int i = 0;
        tableLegends.setHTML(0, i, "&nbsp;&nbsp;&nbsp;");
        tableLegends.getCellFormatter().addStyleName(0,i++, "plannedTask");
        tableLegends.setHTML(0, i++, "Planned");

        tableLegends.setHTML(0, i, "&nbsp;&nbsp;&nbsp;");
        tableLegends.getCellFormatter().addStyleName(0,i++, "unplannedTask");
        tableLegends.setHTML(0, i++, "Unplanned");

        tableLegends.setHTML(0, i, "&nbsp;&nbsp;&nbsp;");
        tableLegends.getCellFormatter().addStyleName(0,i++, "nextTask");
        tableLegends.setHTML(0, i++, "Next");

        tableLegends.setHTML(0, i, "&nbsp;&nbsp;&nbsp;");
        tableLegends.getCellFormatter().addStyleName(0,i++, "errorInActual");
        tableLegends.setHTML(0, i++, "Error in actual");
    }


    private void actualDetails() {
        // Create the dialog box
        // Create a dialog box and set the caption text
        final DialogBox dialogBox1 = new DialogBox();
        dialogBox1.ensureDebugId("cwDialogBox");
        dialogBox1.setText("Actual details");

        // Create a table to layout the content
        VerticalPanel dialogContents = new VerticalPanel();
        dialogContents.setSpacing(4);
        dialogBox1.setWidget(dialogContents);

        // Add some text to the top of the dialog
        FlexTable details = new FlexTable();
        details.setHTML(0, 0, "<b>Developer</b>");
        details.setHTML(0, 1, "<b>Actual</b>");

        details.setHTML(1, 0, "Nazir");
        details.setHTML(1, 1, "3");

        details.setHTML(2, 0, "Yann");
        details.setHTML(2, 1, "2");

        dialogContents.add(details);
        dialogContents.setCellHorizontalAlignment(
                details, HasHorizontalAlignment.ALIGN_CENTER);

        // Add a close button at the bottom of the dialog
        Button closeButton = new Button(
                "Close", new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        dialogBox1.hide();
                    }
                });
        dialogContents.add(closeButton);
        if (LocaleInfo.getCurrentLocale().isRTL()) {
            dialogContents.setCellHorizontalAlignment(
                    closeButton, HasHorizontalAlignment.ALIGN_LEFT);

        } else {
            dialogContents.setCellHorizontalAlignment(
                    closeButton, HasHorizontalAlignment.ALIGN_RIGHT);
        }

        // Return the dialog box
        final DialogBox dialogBox = dialogBox1;
        dialogBox.setGlassEnabled(true);
        dialogBox.setAnimationEnabled(true);

        dialogBox.center();
        dialogBox.show();
    }


    private void remainingDetails() {
        // Create the dialog box
        // Create a dialog box and set the caption text
        final DialogBox dialogBox1 = new DialogBox();
        dialogBox1.ensureDebugId("cwDialogBox");
        dialogBox1.setText("Remaining details");

        // Create a table to layout the content
        VerticalPanel dialogContents = new VerticalPanel();
        dialogContents.setSpacing(4);
        dialogBox1.setWidget(dialogContents);

        // Add some text to the top of the dialog
        FlexTable details = new FlexTable();
        details.setHTML(0, 0, "<b>Sprint</b>");
        details.setHTML(0, 1, "<b>Estimation</b>");
        details.setHTML(0, 2, "<b>Remaining</b>");

        details.setHTML(1, 0, "Sprint 43");
        details.setHTML(1, 1, "30");
        details.setHTML(1, 2, "20");

        details.setHTML(2, 0, "Sprint 44");
        details.setHTML(2, 1, "20");
        details.setHTML(2, 2, "2");

        dialogContents.add(details);
        dialogContents.setCellHorizontalAlignment(
                details, HasHorizontalAlignment.ALIGN_CENTER);

        // Add a close button at the bottom of the dialog
        Button closeButton = new Button(
                "Close", new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        dialogBox1.hide();
                    }
                });
        dialogContents.add(closeButton);
        if (LocaleInfo.getCurrentLocale().isRTL()) {
            dialogContents.setCellHorizontalAlignment(
                    closeButton, HasHorizontalAlignment.ALIGN_LEFT);

        } else {
            dialogContents.setCellHorizontalAlignment(
                    closeButton, HasHorizontalAlignment.ALIGN_RIGHT);
        }

        // Return the dialog box
        final DialogBox dialogBox = dialogBox1;
        dialogBox.setGlassEnabled(true);
        dialogBox.setAnimationEnabled(true);

        dialogBox.center();
        dialogBox.show();
    }


    private Widget createCriteria() {
        VerticalPanel criterias = new VerticalPanel();
        criterias.add(dropDownSprint);
        criterias.add(dropDownTeam);
        return criterias;
    }

    private DecoratorPanel createSprintDetailsPanel() {
        // Create a table to layout the form options
        FlexTable layout = new FlexTable();
        layout.setCellSpacing(6);
        FlexTable.FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

        // Add a title to the form
        layout.setHTML(0, 0, "<b>Sprint Details</b>");
        cellFormatter.setColSpan(0, 0, 2);
        cellFormatter.setHorizontalAlignment(
                0, 0, HasHorizontalAlignment.ALIGN_CENTER);

        // Add some standard form options
        layout.setHTML(1, 0, "Date");
        layout.setHTML(1, 1, "<b> 30/11/2010 To 5/12/2010 </b>");
        layout.setHTML(2, 0, "Availability: ");
        layout.setHTML(2, 1, "<b> 44 days </b>");
        layout.setHTML(3, 0, "Estimated velocity: ");
        layout.setHTML(3, 1, "<b> 22 days </b>");

        // Wrap the content in a DecoratorPanel
        DecoratorPanel decPanel = new DecoratorPanel();
        decPanel.setWidget(layout);
        return decPanel;

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

    private void createSprintViewTable() {
        // Create a Flex Table
        tableSprintTask = new FlexTable();
        tableSprintTask.setBorderWidth(1);
        tableSprintTask.addStyleName("cw-FlexTable");

        int i = 0;
        tableSprintTask.setHTML(0, i++, "<b>Reference</b>");
        tableSprintTask.setHTML(0, i++, "<b>Desc</b>");
        tableSprintTask.setHTML(0, i++, "<b>Sprint Estimation</b>");
        tableSprintTask.setHTML(0, i++, "<b>Actual</b>");
        tableSprintTask.setHTML(0, i++, "<b>Remaining</b>");
        tableSprintTask.setHTML(0, i++, "<b>Budget</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 1</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 2</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 3</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 4</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 5</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 6</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 7</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 8</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 9</b>");
        tableSprintTask.setHTML(0, i++, "<b>Day 10</b>");

        addRow(tableSprintTask);
        addRow(tableSprintTask);

        tableSprintTask.ensureDebugId("cwFlexTable");
    }

    /**
     * Add a row to the flex table.
     */
    private void addRow(FlexTable flexTable) {
        int numRows = flexTable.getRowCount();
        int i;
        i = 0;
        //flexTable.setWidget(numRows, i++, new HTML("✔"));
        flexTable.setWidget(numRows, i++, new HTML("ENT-2225"));
        flexTable.setWidget(numRows, i++, new HTML("Technical improvements"));
        flexTable.setWidget(numRows, i++, new HTML("14 (details)"));
        flexTable.setWidget(numRows, i++, generateActual());
        flexTable.setWidget(numRows, i++, generateRemaining("3"));
        flexTable.setWidget(numRows, i++, new HTML("Web Migration"));
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());                                  
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());

        numRows = flexTable.getRowCount();
        i = 0;
        //flexTable.setWidget(numRows, i++, new HTML("✗"));
        flexTable.setWidget(numRows, i++, new HTML("ENT-2342"));
        flexTable.setWidget(numRows, i++, new HTML("Technical improvements"));
        flexTable.setWidget(numRows, i++, new HTML("2 (details)"));
        flexTable.setWidget(numRows, i++, generateActual());
        flexTable.setWidget(numRows, i++, generateRemaining("1"));
        flexTable.setWidget(numRows, i++, new HTML("Web Migration"));
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());

        numRows = flexTable.getRowCount();
        i = 0;
        //flexTable.setWidget(numRows, i++, new HTML("✗"));
        flexTable.setWidget(numRows, i++, new HTML("ENT-2342"));
        flexTable.setWidget(numRows, i++, new HTML("Technical improvements"));
        flexTable.setWidget(numRows, i++, new HTML("2 (details)"));
        flexTable.setWidget(numRows, i++, generateActual());
        flexTable.setWidget(numRows, i++, generateRemaining("4"));
        flexTable.setWidget(numRows, i++, new HTML("Web Migration"));
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
        flexTable.setWidget(numRows, i++, createActualDropDown());
    }

    private HorizontalPanel generateActual() {
        HorizontalPanel panel = new HorizontalPanel();
        panel.add(new HTML("15 &nbsp;"));
        Anchor link = new Anchor("(details)", false);
        link.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                actualDetails();
            }
        });
        panel.add(link);
        return panel;
    }

    private HorizontalPanel generateRemaining(String days) {
        HorizontalPanel panel = new HorizontalPanel();
        TextBox textBox = new TextBox();
        textBox.setText(days);
        textBox.setMaxLength(3);
        textBox.setVisibleLength(3);
        panel.add(textBox);
        Anchor link = new Anchor("(details)", false);
        link.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                remainingDetails();
            }
        });
        panel.add(link);
        return panel;
    }

    private Widget createActualDropDown() {
        ListBox actuals = new ListBox();
        actuals.addItem("1");
        actuals.addItem("2");
        actuals.addItem("3");
        actuals.addItem("4");
        actuals.addItem("5");
        actuals.addItem("6");
        actuals.addItem("7");
        actuals.addItem("8");
        return actuals;
    }

}
