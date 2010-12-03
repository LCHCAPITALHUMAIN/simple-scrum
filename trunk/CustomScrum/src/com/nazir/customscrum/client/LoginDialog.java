package com.nazir.customscrum.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Nov 27, 2010
 * Time: 11:00:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginDialog {
    private static LoginDialog loginDialog;
    private DialogBox dialogBox;
    private Button btnLogin;
    private TextBox txtUserName;
    private PasswordTextBox txtPassword;
    private Label lblLoginMessage;

    private final LoginServiceAsync loginService = GWT.create(LoginService.class);

    public static LoginDialog getInstance() {
        if (loginDialog == null) {
            loginDialog = new LoginDialog();
        }
        return loginDialog;
    }
    private LoginDialog() {
        // Create the dialog box
        dialogBox = createDialogBox();
        dialogBox.setGlassEnabled(true);
        dialogBox.setAnimationEnabled(true);

        dialogBox.center();
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
        loginService.login(txtUserName.getText(), txtPassword.getText(), new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable throwable) {
                lblLoginMessage.setText("Login Failed. Technical Error, please contact system administrator.");
            }

            @Override
            public void onSuccess(Boolean result) {
                if (result) {
                    dialogBox.hide();
                } else {
                    lblLoginMessage.setText("Incorrect username or password.");
                }
            }
        });

    }
    private DialogBox createDialogBox() {
        // Create a dialog box and set the caption text
        final DialogBox dialogBox = new DialogBox();
        dialogBox.ensureDebugId("cwDialogBox");
        dialogBox.setText("Login");

        // Create a table to layout the content
        VerticalPanel dialogContents = new VerticalPanel();
        dialogContents.setSpacing(4);
        dialogBox.setWidget(dialogContents);

        btnLogin = createLoginButton();

        txtUserName = new TextBox();
        txtPassword = new PasswordTextBox();
        lblLoginMessage = new Label();

        // We can add style names to widgets
        btnLogin.addStyleName("sendButton");


        dialogContents.add(txtUserName);
        dialogContents.add(txtPassword);
        dialogContents.add(lblLoginMessage);

        // Focus the cursor on the name field when the app loads
        txtUserName.setFocus(true);
        txtUserName.selectAll();

        dialogContents.add(btnLogin);
        if (LocaleInfo.getCurrentLocale().isRTL()) {
            dialogContents.setCellHorizontalAlignment(
                    btnLogin, HasHorizontalAlignment.ALIGN_LEFT);

        } else {
            dialogContents.setCellHorizontalAlignment(
                    btnLogin, HasHorizontalAlignment.ALIGN_RIGHT);
        }

        // Return the dialog box
        return dialogBox;
    }


    public void show() {
        dialogBox.show();

    }
}
