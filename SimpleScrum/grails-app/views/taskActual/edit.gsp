
<%@ page import="com.simplescrum.model.TaskActual" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit TaskActual</title>
    </head>
    <body>
        <div class="nav">
             <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">TaskActuals</g:link></span>
        </div>
        <div class="body">
            <h1>Edit TaskActual</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${taskActualInstance}">
            <div class="errors">
                <g:renderErrors bean="${taskActualInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${taskActualInstance?.id}" />
                <input type="hidden" name="version" value="${taskActualInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="task">Task:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskActualInstance,field:'task','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Task.list()}" name="task.id" value="${taskActualInstance?.task?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user">User:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskActualInstance,field:'user','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.User.list()}" name="user.id" value="${taskActualInstance?.user?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="date">Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskActualInstance,field:'date','errors')}">
                                    <g:datePicker name="date" value="${taskActualInstance?.date}" precision="day" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="actualPoints">Actual Points:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:taskActualInstance,field:'actualPoints','errors')}">
                                    <input type="text" id="actualPoints" name="actualPoints" value="${fieldValue(bean:taskActualInstance,field:'actualPoints')}" />
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:link class="cancel" action="show" id="${taskActualInstance?.id}">Cancel</g:link></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
