
<%@ page import="com.simplescrum.model.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show User</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home" controller="user">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Users</g:link></span>
            <span class="menuButton"><g:link class="create" controller="register">Register New</g:link></span>
        </div>
        <div class="body">
            <h1>Show User</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                        <tr class="prop">
                            <td valign="top" class="name">User Real Name:</td>

                            <td valign="top" class="value">${fieldValue(bean:userInstance, field:'userRealName')}</td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Login:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userInstance, field:'login')}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Email:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:userInstance, field:'email')}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Roles:</td>

                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="r" in="${userInstance.roles}">
                                    <li><g:link controller="role" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>

                        </tr>                    

                        <tr class="prop">
                            <td valign="top" class="name">Actuals:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="a" in="${userInstance.actuals}">
                                    <li><g:link controller="taskActual" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        %{--<tr class="prop">--}%
                            %{--<td valign="top" class="name">Authorities:</td>--}%
                            %{----}%
                            %{--<td  valign="top" style="text-align:left;" class="value">--}%
                                %{--<ul>--}%
                                %{--<g:each var="a" in="${userInstance.authorities}">--}%
                                    %{--<li><g:link controller="accessRole" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>--}%
                                %{--</g:each>--}%
                                %{--</ul>--}%
                            %{--</td>--}%
                            %{----}%
                        %{--</tr>--}%

                        <tr class="prop">
                            <td valign="top" class="name">Problems:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="p" in="${userInstance.problems}">
                                    <li><g:link controller="problem" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Product Backlog Items:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="p" in="${userInstance.productBacklogItems}">
                                    <li><g:link controller="productBacklogItem" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    

                        <tr class="prop">
                            <td valign="top" class="name">Tasks Created:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="t" in="${userInstance.tasksCreated}">
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
                    <input type="hidden" name="id" value="${userInstance?.id}" />
                    <span class="button"><g:link class="edit" controller="register" action="edit" id="${userInstance?.id}">Edit Access Credentials</g:link></span>
                    <span class="button"><g:link class="create" controller="role" action="create" params="['user.id':userInstance?.id]">Assign Role</g:link></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
