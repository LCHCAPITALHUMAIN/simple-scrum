package com.nazir.customscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.nazir.customscrum.client.model.Sprint;

import javax.persistence.Entity;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@Entity
public class Welcome implements EntryPoint {
    /**
     * The message displayed to the user when the server cannot be reached or
     * returns an error.
     */
    private static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again.";

    /**
     * Create a remote service proxy to talk to the server-side Greeting service.
     */
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
    private final LoginServiceAsync loginService = GWT.create(LoginService.class);
    private Button btnLogin;
    private TextBox txtUserName;
    private PasswordTextBox txtPassword;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        btnLogin = createLoginButton();

        txtUserName = new TextBox();
        txtPassword = new PasswordTextBox();

        // We can add style names to widgets
        btnLogin.addStyleName("sendButton");

        // Add the nameField and sendButton to the RootPanel
        // Use RootPanel.get() to get the entire body element
        RootPanel.get("userNameFieldContainer").add(txtUserName);
        RootPanel.get("passwordFieldContainer").add(txtPassword);
        RootPanel.get("loginButtonContainer").add(btnLogin);

        // Focus the cursor on the name field when the app loads
        txtUserName.setFocus(true);
        txtUserName.selectAll();

    }

    private Button createLoginButton() {
        final Button btnLogin = new Button("Login");
        btnLogin.addStyleName("sendButton");
        ClickHandler clickHandler = new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                login();
            }
        };
        btnLogin.addClickHandler(clickHandler);
        KeyUpHandler keyUpHandler = new KeyUpHandler() {
            @Override
            public void onKeyUp(KeyUpEvent keyUpEvent) {
                if (keyUpEvent.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    login();
                }

            }
        };
        btnLogin.addKeyUpHandler(keyUpHandler);
        return btnLogin;
    }

    private void login() {
        RootPanel.get().add(new Button("de"));

        loginService.login(txtUserName.getText(), txtPassword.getText(), new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable throwable) {
                RootPanel.get().add(new Button("not logged"));
            }

            @Override
            public void onSuccess(Boolean result) {
                if (result) {
                    RootPanel.get().add(new Button("logged"));
                } else {
                    RootPanel.get().add(new Button("not logged"));
                }
            }
        });

    }

    private FlexTable tt() {
        // Create a Flex Table
        final FlexTable flexTable = new FlexTable();
        FlexTable.FlexCellFormatter cellFormatter = flexTable.getFlexCellFormatter();
        flexTable.addStyleName("cw-FlexTable");
        flexTable.setWidth("32em");
        flexTable.setCellSpacing(5);
        flexTable.setCellPadding(3);

        // Add some text
        cellFormatter.setHorizontalAlignment(0, 1,
                HasHorizontalAlignment.ALIGN_LEFT);
        flexTable.setHTML(0, 0, "table detail");
        cellFormatter.setColSpan(0, 0, 2);

        // Add a button that will add more rows to the table
        Button addRowButton = new Button("Add",
                new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        addRow(flexTable);
                    }
                });
        addRowButton.addStyleName("sc-FixedWidthButton");

        Button removeRowButton = new Button("Remove",
                new ClickHandler() {
                    public void onClick(ClickEvent event) {
                        removeRow(flexTable);
                    }
                });
        removeRowButton.addStyleName("sc-FixedWidthButton");
        VerticalPanel buttonPanel = new VerticalPanel();
        buttonPanel.setStyleName("cw-FlexTable-buttonPanel");
        buttonPanel.add(addRowButton);
        buttonPanel.add(removeRowButton);
        flexTable.setWidget(0, 1, buttonPanel);
        cellFormatter.setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_TOP);

        // Add two rows to start
        addRow(flexTable);
        addRow(flexTable);

        // Return the panel
        flexTable.ensureDebugId("cwFlexTable");
        return flexTable;
    }

    /**
     * Add a row to the flex table.
     */
    private void addRow(FlexTable flexTable) {
//        int numRows = flexTable.getRowCount();
//        flexTable.setWidget(numRows, 0, new Image(Showcase.images.gwtLogo()));
//        flexTable.setWidget(numRows, 1, new Image(Showcase.images.gwtLogo()));
//        flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows + 1);
    }

    /**
     * Remove a row from the flex table.
     */
    private void removeRow(FlexTable flexTable) {
        int numRows = flexTable.getRowCount();
        if (numRows > 1) {
            flexTable.removeRow(numRows - 1);
            flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows - 1);
        }
    }

    public void onModuleLoad1() {
        Sprint sprint = new Sprint();
        sprint.setDescription("Desc");

        final Button sendButton = new Button(sprint.getDescription());
        final TextBox nameField = new TextBox();
        nameField.setText("GWT User");

        // We can add style names to widgets
        sendButton.addStyleName("sendButton");

        // Add the nameField and sendButton to the RootPanel
        // Use RootPanel.get() to get the entire body element
        RootPanel.get("nameFieldContainer").add(nameField);
        RootPanel.get("sendButtonContainer").add(sendButton);

        // Focus the cursor on the name field when the app loads
        nameField.setFocus(true);
        nameField.selectAll();

        // Create the popup dialog box
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("Remote Procedure Call");
        dialogBox.setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");
        final Label textToServerLabel = new Label();
        final HTML serverResponseLabel = new HTML();
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);

        // Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dialogBox.hide();
                sendButton.setEnabled(true);
                sendButton.setFocus(true);
            }
        });

        // Create a handler for the sendButton and nameField
        class MyHandler implements ClickHandler, KeyUpHandler {
            /**
             * Fired when the user clicks on the sendButton.
             */
            public void onClick(ClickEvent event) {
                sendNameToServer();
            }

            /**
             * Fired when the user types in the nameField.
             */
            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    sendNameToServer();
                }
            }

            /**
             * Send the name from the nameField to the server and wait for a response.
             */
            private void sendNameToServer() {
                sendButton.setEnabled(false);
                String textToServer = nameField.getText();
                textToServerLabel.setText(textToServer);
                serverResponseLabel.setText("");
                greetingService.greetServer(textToServer, new AsyncCallback<Sprint>() {
                    public void onFailure(Throwable caught) {
                        // Show the RPC error message to the user
                        dialogBox.setText("Remote Procedure Call - Failure");
                        serverResponseLabel.addStyleName("serverResponseLabelError");
                        serverResponseLabel.setHTML(SERVER_ERROR);
                        dialogBox.center();
                        closeButton.setFocus(true);
                    }

                    public void onSuccess(Sprint result) {
                        dialogBox.setText("Remote Procedure Call");
                        serverResponseLabel.removeStyleName("serverResponseLabelError");
                        serverResponseLabel.setHTML(result.getTitle() + result.getAvailability());
                        dialogBox.center();
                        closeButton.setFocus(true);
                    }
                });
            }
        }

        // Add a handler to send the name to the server
        MyHandler handler = new MyHandler();
        sendButton.addClickHandler(handler);
        nameField.addKeyUpHandler(handler);
    }

}
