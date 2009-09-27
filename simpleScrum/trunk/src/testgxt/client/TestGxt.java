package testgxt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestGxt implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    // temp to speed up the dev
    // SprintGrid grid = new SprintGrid();
    SprintGrid grid = new SprintGrid();
    MainPanel mainPanel = new MainPanel();
    LoginPanel loginScreen = new LoginPanel(mainPanel, grid);
    mainPanel.setFirstContent(loginScreen);
    RootPanel.get("slot3").add(mainPanel);
    System.out.println("Main launched");
  }
}
