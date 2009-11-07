
<%@ page import="com.simplescrum.model.RemainingEstimation" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create RemainingEstimation</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">RemainingEstimations</g:link></span>
        </div>
        <div class="body">
            <h1>Create RemainingEstimation</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${remainingEstimationInstance}">
            <div class="errors">
                <g:renderErrors bean="${remainingEstimationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="task">Task:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:remainingEstimationInstance,field:'task','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Task.list()}" name="task.id" value="${remainingEstimationInstance?.task?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remainingPoints">Remaining Points:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:remainingEstimationInstance,field:'remainingPoints','errors')}">
                                    <input type="text" id="remainingPoints" name="remainingPoints" value="${fieldValue(bean:remainingEstimationInstance,field:'remainingPoints')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="date">Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:remainingEstimationInstance,field:'date','errors')}">
                                    <g:datePicker name="date" value="${remainingEstimationInstance?.date}" precision="day" ></g:datePicker>
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
