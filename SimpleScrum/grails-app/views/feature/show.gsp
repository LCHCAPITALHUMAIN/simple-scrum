
<%@ page import="com.simplescrum.model.Feature" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Feature</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Features</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Feature</g:link></span>
            <span class="menuButton"><g:link class="list" controller="auditLog" action="query" params="['auditLogEvent.className':featureInstance?.class.name,'auditLogEvent.persistedObjectId':featureInstance?.id]">Audit Trail</g:link></span>
        </div>
        <div class="body">
            <h1>Show Feature</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:featureInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:featureInstance, field:'name')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Product:</td>
                            
                            <td valign="top" class="value"><g:link controller="product" action="show" id="${featureInstance?.product?.id}">${featureInstance?.product?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${featureInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
