
<%@ page import="com.simplescrum.model.Task" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Task</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Task List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Task</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Task</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${taskInstance}">
            <div class="errors">
                <g:renderErrors bean="${taskInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${taskInstance?.id}" />
                <input type="hidden" name="version" value="${taskInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
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
                                    <label for="elapsedTime">Elapsed Time:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'elapsedTime','errors')}">
                                    <input type="text" id="elapsedTime" name="elapsedTime" value="${fieldValue(bean:taskInstance,field:'elapsedTime')}" />
                                </td>
                            </tr> 
                        
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
                                    <label for="notes">Notes:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'notes','errors')}">
                                    <input type="text" id="notes" name="notes" value="${fieldValue(bean:taskInstance,field:'notes')}"/>
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
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remainingEstimations">Remaining Estimations:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'remainingEstimations','errors')}">
                                    
<ul>
<g:each var="r" in="${taskInstance?.remainingEstimations?}">
    <li><g:link controller="remainingEstimation" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="remainingEstimation" params="['task.id':taskInstance?.id]" action="create">Add RemainingEstimation</g:link>

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
                                    <label for="taskActuals">Task Actuals:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskInstance,field:'taskActuals','errors')}">
                                    
<ul>
<g:each var="t" in="${taskInstance?.taskActuals?}">
    <li><g:link controller="taskActual" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="taskActual" params="['task.id':taskInstance?.id]" action="create">Add TaskActual</g:link>

                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
