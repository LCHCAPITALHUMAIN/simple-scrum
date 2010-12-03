package com.nazir.customscrum.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Dec 3, 2010
 * Time: 7:28:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddTask {
    private Button btnSearch;
    private DialogBox dialogBox1;

    public AddTask(String title) {
        addTaskPopup(title);
    }

    private void addTaskPopup(String title) {
        // Create the dialog box
        // Create a dialog box and set the caption text
        dialogBox1 = new DialogBox();
        dialogBox1.ensureDebugId("cwDialogBox");
        dialogBox1.setText(title);

        // Create a table to layout the content
        VerticalPanel dialogContents = new VerticalPanel();
        dialogContents.setSpacing(4);
        dialogBox1.setWidget(dialogContents);

        // Add some text to the top of the dialog
        FlexTable details = new FlexTable();
        details.setHTML(0, 0, "<b>Search Jira</b>");
        details.setWidget(0, 1, new TextBox());
        btnSearch = new Button("Search");
        btnSearch.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                searchOnJira();
            }
        });
        details.setWidget(0, 2, btnSearch);

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

    private void searchOnJira() {
    }

}
