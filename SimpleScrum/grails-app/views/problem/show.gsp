
<%@ page import="com.simplescrum.model.Problem" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Problem</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Problems</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Problem</g:link></span>
        </div>
        <div class="body">
            <h1>Show Problem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:problemInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Closed Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:problemInstance, field:'closedDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Creation Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:problemInstance, field:'creationDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Impact:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:problemInstance, field:'impact')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Modification Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:problemInstance, field:'modificationDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:problemInstance, field:'name')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Poster:</td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${problemInstance?.poster?.id}">${problemInstance?.poster?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Product:</td>
                            
                            <td valign="top" class="value"><g:link controller="product" action="show" id="${problemInstance?.product?.id}">${problemInstance?.product?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Rank:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:problemInstance, field:'rank')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Solution:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:problemInstance, field:'solution')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">State:</td>
                            
                            <td valign="top" class="value">${problemInstance?.state?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${problemInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
