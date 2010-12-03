package com.nazir.customscrum.client;

import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Dec 1, 2010
 * Time: 7:59:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Alerts extends VerticalPanel {
    public Alerts() {
        add(createAlertMessage("Missing actuals", new String[]{"You have 3.5 days misssing in Sprint 42",
                "You have 2.5 days misssing in Sprint 44 "}));
        add(createAlertMessage("Sprint setup", new String[]{"The focus factor for team 1 is 22, whereas only 20 days of planned task has been added into the sprint"}));
        add(createAlertMessage("Sprint setup", new String[]{"The focus factor for team 1 is 16, whereas 18 days of planned task has been added into the sprint"}));

    }

    private DecoratorPanel createAlertMessage(String title, String message[]) {
        // Create a table to layout the form options
        FlexTable table = new FlexTable();
        table.setCellSpacing(6);
        FlexTable.FlexCellFormatter cellFormatter = table.getFlexCellFormatter();

        // Add a title to the form
        table.setHTML(0, 0, "<b>" + title + "</b>");
        cellFormatter.setColSpan(0, 0, 2);
        cellFormatter.setHorizontalAlignment(
                0, 0, HasHorizontalAlignment.ALIGN_CENTER);

        String consolidatedMessage = "";
        for (String msg : message) {
            consolidatedMessage += msg + "<br>";
        }
        table.setHTML(1, 0, consolidatedMessage);

        // Wrap the content in a DecoratorPanel
        DecoratorPanel decPanel = new DecoratorPanel();
        decPanel.setWidth("100%");
        decPanel.setWidget(table);
        return decPanel;

    }
}
