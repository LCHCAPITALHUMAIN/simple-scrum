
<%@ page import="com.simplescrum.model.Role" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Role</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Roles</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Role</g:link></span>
            <span class="menuButton"><g:link class="list" controller="auditLog" action="query" params="['auditLogEvent.className':roleInstance?.class.name,'auditLogEvent.persistedObjectId':roleInstance?.id]">Audit Trail</g:link></span>
        </div>
        <div class="body">
            <h1>Show Role</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Name:</td>
                            
                            <td valign="top" class="value">${roleInstance?.name?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:roleInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Product:</td>
                            
                            <td valign="top" class="value"><g:link controller="product" action="show" id="${roleInstance?.product?.id}">${roleInstance?.product?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Sprint:</td>
                            
                            <td valign="top" class="value"><g:link controller="sprint" action="show" id="${roleInstance?.sprint?.id}">${roleInstance?.sprint?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">User:</td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${roleInstance?.user?.id}">${roleInstance?.user?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${roleInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
