package com.nazir.customscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
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


    @Override
    public void onModuleLoad() {
        //LoginDialog.getInstance().show();
        RootPanel.get("mainContainer").add(onInitialize1());
    }

public Widget onInitialize1() {
    // Create a tab panel
    DecoratedTabPanel tabPanel = new DecoratedTabPanel();
    tabPanel.setWidth("100%");
    tabPanel.setAnimationEnabled(true);

    // Add a home tab
    tabPanel.add(new Alerts(), "Alerts");
    tabPanel.add(new SprintBacklog(), "Sprintbacklog");
    tabPanel.add(new DailyScrum(), "Daily scrum");

    // Add a tab with an image
    tabPanel.add(new WhiteBoard(), "White board");
    tabPanel.add(new SvnView(), "SVN View");
    tabPanel.add(new ReleaseView(), "Release View");
    tabPanel.add(new Holidays(), "Holidays");

    // Return the content
    tabPanel.selectTab(0);
    tabPanel.ensureDebugId("cwTabPanel");
    return tabPanel;
  }


}
