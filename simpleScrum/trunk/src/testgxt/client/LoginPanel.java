package testgxt.client;


import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.EventType;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;

public class LoginPanel extends LayoutContainer {

  private final MainPanel mainPanel;
  private final SprintGrid grid;

  public LoginPanel(MainPanel mainPanel, SprintGrid grid) {
    this.mainPanel = mainPanel;
    this.grid = grid;
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    Label loginLbl = new Label("Login: ");
    loginLbl.setWidth("150");
    add(loginLbl);
    final TextField login = new TextField();
    login.setWidth(150);
    add(login);
    Label passwordLbl = new Label("Password: ");
    passwordLbl.setWidth("150");
    add(passwordLbl);
    final PasswordTextBox password = new PasswordTextBox();
    password.setWidth("150");
    add(password);
    Button loginButton = new Button("LoginService");
    final LoginPanel loginPanel = this;
    loginButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        LoginService.App.getInstance().tryLoginAs(login.getValue().toString(),
            password.getValue(),
            new MyAsyncCallback(mainPanel,loginPanel,grid));
      }
    });
    add(loginButton);

  }

  private static class MyAsyncCallback<Boolean> implements AsyncCallback<Boolean> {
    private MainPanel mainPanel;
    private LoginPanel loginPanel;
    private SprintGrid grid;

    private MyAsyncCallback(MainPanel mainPanel, LoginPanel loginPanel, SprintGrid grid) {
      this.mainPanel = mainPanel;
      this.loginPanel = loginPanel;
      this.grid = grid;
    }

    public void onFailure(Throwable caught) {

    }
    public void onSuccess(Boolean result) {
      if(result!=null) {
        mainPanel.getContentPanel().remove(loginPanel);
        mainPanel.getContentPanel().add(grid);
        System.out.println("login panel replaced by grid one");
        mainPanel.repaint();
        System.out.println("main panel repainted");
      }
    }
  }
}