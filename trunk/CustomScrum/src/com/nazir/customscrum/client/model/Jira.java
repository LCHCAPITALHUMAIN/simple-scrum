package com.nazir.customscrum.client.model;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: nazir
 * Date: Nov 27, 2010
 * Time: 12:22:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Jira {
   String id;
    String desc;
    String creator;
    String assignee;
    float estimate;
    Set<Jira> subJiras;
    Set<Jira> linkedJiras;
    String status;


}
