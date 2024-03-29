
<%@ page import="com.simplescrum.model.TaskActual" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show TaskActual</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">TaskActuals</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New TaskActual</g:link></span>
            <span class="menuButton"><g:link class="list" controller="auditLog" action="query" params="['auditLogEvent.className':taskActualInstance?.class.name,'auditLogEvent.persistedObjectId':taskActualInstance?.id]">Audit Trail</g:link></span>
        </div>
        <div class="body">
            <h1>Show TaskActual</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Task:</td>
                            
                            <td valign="top" class="value"><g:link controller="task" action="show" id="${taskActualInstance?.task?.id}">${taskActualInstance?.task?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">User:</td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${taskActualInstance?.user?.id}">${taskActualInstance?.user?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:taskActualInstance, field:'date')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Actual Points:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:taskActualInstance, field:'actualPoints')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${taskActualInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
