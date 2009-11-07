
<%@ page import="com.simplescrum.model.RemainingEstimation" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show RemainingEstimation</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">RemainingEstimations</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New RemainingEstimation</g:link></span>
            <span class="menuButton"><g:link class="list" controller="auditLog" action="query" params="['auditLogEvent.className':remainingEstimationInstance?.class.name,'auditLogEvent.persistedObjectId':remainingEstimationInstance?.id]">Audit Trail</g:link></span>
        </div>
        <div class="body">
            <h1>Show RemainingEstimation</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Task:</td>
                            
                            <td valign="top" class="value"><g:link controller="task" action="show" id="${remainingEstimationInstance?.task?.id}">${remainingEstimationInstance?.task?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Remaining Points:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:remainingEstimationInstance, field:'remainingPoints')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:remainingEstimationInstance, field:'date')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${remainingEstimationInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
