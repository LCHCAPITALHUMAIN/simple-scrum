package com.nazir.customscrum.client;

import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Nov 27, 2010
 * Time: 11:50:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReleaseView extends VerticalPanel {
    private ListBox dropDownRelease;
    private FlexTable tableSprintTask;

    public ReleaseView() {
        createReleaseDropDown();
        createSprintViewTable();

        this.add(createCriteria());
        this.add(createSprintDetailsPanel());
        this.add(tableSprintTask);

    }

    private Widget createCriteria() {
        return dropDownRelease;
    }

    private DecoratorPanel createSprintDetailsPanel() {
         // Create a table to layout the form options
            FlexTable layout = new FlexTable();
            layout.setCellSpacing(6);
            FlexTable.FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

            // Add a title to the form
            layout.setHTML(0, 0, "<b>Release Details</b>");
            cellFormatter.setColSpan(0, 0, 2);
            cellFormatter.setHorizontalAlignment(
                0, 0, HasHorizontalAlignment.ALIGN_CENTER);

            // Add some standard form options
            layout.setHTML(1, 0, "<b>Desc</b>");
            layout.setHTML(1, 1, "In this release we are expecting to deliver bulk upload");
            layout.setHTML(2, 0, "<b>Content freeze date: </b>");
            layout.setHTML(2, 1, "20 Jan 2011");
            layout.setHTML(3, 0, "<b>Code freeze date: </b>");
            layout.setHTML(3, 1, "20 Jan 2011");
            layout.setHTML(4, 0, "<b>Functional test start date: </b>");
            layout.setHTML(4, 1, "20 Jan 2011");
            layout.setHTML(5, 0, "<b>UAT start date:</b>");
            layout.setHTML(5, 1, "20 Jan 2011");
            layout.setHTML(6, 0, "<b>Sign-off date: </b>");
            layout.setHTML(6, 1, "20 Jan 2011");
            layout.setHTML(7, 0, "<b>Go-live date: </b>");
            layout.setHTML(7, 1, "20 Jan 2011");

            // Wrap the content in a DecoratorPanel
            DecoratorPanel decPanel = new DecoratorPanel();
            decPanel.setWidget(layout);
            return decPanel;

     }


    private void createReleaseDropDown() {
        dropDownRelease = new ListBox(false);
        dropDownRelease.addItem("Sept 2010 release");
        dropDownRelease.addItem("Dec 2010 release");
        dropDownRelease.addItem("Q1 2011 release");
    }

    private void createSprintViewTable() {
        // Create a Flex Table
        tableSprintTask = new FlexTable();
        tableSprintTask.setBorderWidth(1);
        tableSprintTask.addStyleName("cw-FlexTable");

        int i = 0;
        tableSprintTask.setHTML(0, i++, "<b>IT</b>");
        tableSprintTask.setHTML(0, i++, "<b>Reference</b>");
        tableSprintTask.setHTML(0, i++, "<b>Desc</b>");
        tableSprintTask.setHTML(0, i++, "<b>Initial estimation</b>");
        tableSprintTask.setHTML(0, i++, "<b>Sprint estimation</b>");
        tableSprintTask.setHTML(0, i++, "<b>Remaining</b>");
        tableSprintTask.setHTML(0, i++, "<b>Budget</b>");

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
        flexTable.setWidget(numRows, i++, new HTML("✔"));
        flexTable.setWidget(numRows, i++, new HTML("ENT-2225"));
        flexTable.setWidget(numRows, i++, new HTML("Technical improvements"));
        flexTable.setWidget(numRows, i++, new HTML("14"));
        flexTable.setWidget(numRows, i++, new HTML("2"));
        flexTable.setWidget(numRows, i++, new HTML("1"));
        flexTable.setWidget(numRows, i++, new HTML("Web Migration"));

        numRows = flexTable.getRowCount();
        i = 0;
        flexTable.setWidget(numRows, i++, new HTML("✗"));
        flexTable.setWidget(numRows, i++, new HTML("ENT-2342"));
        flexTable.setWidget(numRows, i++, new HTML("BCLI Migration"));
        flexTable.setWidget(numRows, i++, new HTML("14"));
        flexTable.setWidget(numRows, i++, new HTML("2"));
        flexTable.setWidget(numRows, i++, new HTML("1"));
        flexTable.setWidget(numRows, i++, new HTML("Web Migration"));
    }

}
