
<%@ page import="com.simplescrum.model.Task" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Task</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Tasks</g:link></span>
        </div>
        <div class="body">
            <h1>Create Task</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${taskInstance}">
            <div class="errors">
                <g:renderErrors bean="${taskInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="label">Label:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'label','errors')}">
                                    <input type="text" id="label" name="label" value="${fieldValue(bean:taskInstance,field:'label')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="state">State:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'state','errors')}">
                                    <g:select  from="${com.simplescrum.model.TaskStatus?.values()}" value="${taskInstance?.state}" name="state" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="type">Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'type','errors')}">
                                    <g:select  from="${com.simplescrum.model.TaskType?.values()}" value="${taskInstance?.type}" name="type" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="estimatedPoints">Estimated Points:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'estimatedPoints','errors')}">
                                    <input type="text" id="estimatedPoints" name="estimatedPoints" value="${fieldValue(bean:taskInstance,field:'estimatedPoints')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="issueTrackingId">Issue Tracking Id:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'issueTrackingId','errors')}">
                                    <input type="text" id="issueTrackingId" name="issueTrackingId" value="${fieldValue(bean:taskInstance,field:'issueTrackingId')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="team">Team:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'team','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Team.list()}" name="team.id" value="${taskInstance?.team?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sprint">Sprint:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'sprint','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Sprint.list()}" name="sprint.id" value="${taskInstance?.sprint?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="notes">Notes:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'notes','errors')}">
                                    <textarea rows="5" cols="40" name="notes">${fieldValue(bean:taskInstance, field:'notes')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="creator">Creator:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'creator','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.User.list()}" name="creator.id" value="${taskInstance?.creator?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="productBacklogItem">Product Backlog Item:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'productBacklogItem','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.ProductBacklogItem.list()}" name="productBacklogItem.id" value="${taskInstance?.productBacklogItem?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                    <span class="button"><g:link class="cancel" action="list">Cancel</g:link></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
