
<%@ page import="com.simplescrum.model.TeamComposition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show TeamComposition</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">TeamCompositions</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New TeamComposition</g:link></span>
            <span class="menuButton"><g:link class="list" controller="auditLog" action="query" params="['auditLogEvent.className':teamCompositionInstance?.class.name,'auditLogEvent.persistedObjectId':teamCompositionInstance?.id]">Audit Trail</g:link></span>
        </div>
        <div class="body">
            <h1>Show TeamComposition</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Team:</td>
                            
                            <td valign="top" class="value"><g:link controller="team" action="show" id="${teamCompositionInstance?.team?.id}">${teamCompositionInstance?.team?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">User:</td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${teamCompositionInstance?.user?.id}">${teamCompositionInstance?.user?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Sprint:</td>
                            
                            <td valign="top" class="value"><g:link controller="sprint" action="show" id="${teamCompositionInstance?.sprint?.id}">${teamCompositionInstance?.sprint?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${teamCompositionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
