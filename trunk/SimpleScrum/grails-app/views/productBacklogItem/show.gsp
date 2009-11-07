
<%@ page import="com.simplescrum.model.ProductBacklogItem" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show ProductBacklogItem</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">ProductBacklogItems</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New ProductBacklogItem</g:link></span>
            <span class="menuButton"><g:link class="list" controller="auditLog" action="query" params="['auditLogEvent.className':productBacklogItemInstance?.class.name,'auditLogEvent.persistedObjectId':productBacklogItemInstance?.id]">Audit Trail</g:link></span>
        </div>
        <div class="body">
            <h1>Show ProductBacklogItem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Product:</td>
                            
                            <td valign="top" class="value"><g:link controller="product" action="show" id="${productBacklogItemInstance?.product?.id}">${productBacklogItemInstance?.product?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Number:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'number')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Label:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'label')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Type:</td>
                            
                            <td valign="top" class="value">${productBacklogItemInstance?.type?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Rank:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'rank')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Notes:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'notes')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">How To Test:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'howToTest')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Estimated Points:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'estimatedPoints')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Estimation Type:</td>
                            
                            <td valign="top" class="value">${productBacklogItemInstance?.estimationType?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Estimation Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'estimationDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Custom Role:</td>
                            
                            <td valign="top" class="value"><g:link controller="customRole" action="show" id="${productBacklogItemInstance?.customRole?.id}">${productBacklogItemInstance?.customRole?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Feature:</td>
                            
                            <td valign="top" class="value"><g:link controller="feature" action="show" id="${productBacklogItemInstance?.feature?.id}">${productBacklogItemInstance?.feature?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Planned Release:</td>
                            
                            <td valign="top" class="value"><g:link controller="release" action="show" id="${productBacklogItemInstance?.plannedRelease?.id}">${productBacklogItemInstance?.plannedRelease?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Budget Line:</td>
                            
                            <td valign="top" class="value"><g:link controller="budgetLine" action="show" id="${productBacklogItemInstance?.budgetLine?.id}">${productBacklogItemInstance?.budgetLine?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Creation Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:productBacklogItemInstance, field:'creationDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Owner User:</td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${productBacklogItemInstance?.ownerUser?.id}">${productBacklogItemInstance?.ownerUser?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">State:</td>
                            
                            <td valign="top" class="value">${productBacklogItemInstance?.state?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Tasks:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="t" in="${productBacklogItemInstance.tasks}">
                                    <li><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${productBacklogItemInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
