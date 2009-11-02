
<%@ page import="com.simplescrum.model.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit User</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">User List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New User</g:link></span>
        </div>
        <div class="body">
            <h1>Edit User</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${userInstance}">
            <div class="errors">
                <g:renderErrors bean="${userInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${userInstance?.id}" />
                <input type="hidden" name="version" value="${userInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="login">Login:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'login','errors')}">
                                    <input type="text" maxlength="15" id="login" name="login" value="${fieldValue(bean:userInstance,field:'login')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password">Password:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'password','errors')}">
                                    <input type="text" id="password" name="password" value="${fieldValue(bean:userInstance,field:'password')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email">Email:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'email','errors')}">
                                    <input type="text" id="email" name="email" value="${fieldValue(bean:userInstance,field:'email')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="userRealName">User Real Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'userRealName','errors')}">
                                    <input type="text" id="userRealName" name="userRealName" value="${fieldValue(bean:userInstance,field:'userRealName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="actuals">Actuals:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'actuals','errors')}">
                                    
<ul>
<g:each var="a" in="${userInstance?.actuals?}">
    <li><g:link controller="taskActual" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="taskActual" params="['user.id':userInstance?.id]" action="create">Add TaskActual</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="authorities">Authorities:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'authorities','errors')}">
                                    
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="emailShow">Email Show:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'emailShow','errors')}">
                                    <g:checkBox name="emailShow" value="${userInstance?.emailShow}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="enabled">Enabled:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'enabled','errors')}">
                                    <g:checkBox name="enabled" value="${userInstance?.enabled}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="isActive">Is Active:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'isActive','errors')}">
                                    <g:checkBox name="isActive" value="${userInstance?.isActive}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="isAdmin">Is Admin:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'isAdmin','errors')}">
                                    <g:checkBox name="isAdmin" value="${userInstance?.isAdmin}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="problems">Problems:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'problems','errors')}">
                                    
<ul>
<g:each var="p" in="${userInstance?.problems?}">
    <li><g:link controller="problem" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="problem" params="['user.id':userInstance?.id]" action="create">Add Problem</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="productBacklogItems">Product Backlog Items:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'productBacklogItems','errors')}">
                                    
<ul>
<g:each var="p" in="${userInstance?.productBacklogItems?}">
    <li><g:link controller="productBacklogItem" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="productBacklogItem" params="['user.id':userInstance?.id]" action="create">Add ProductBacklogItem</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="roles">Roles:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'roles','errors')}">
                                    
<ul>
<g:each var="r" in="${userInstance?.roles?}">
    <li><g:link controller="role" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="role" params="['user.id':userInstance?.id]" action="create">Add Role</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tasksCreated">Tasks Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'tasksCreated','errors')}">
                                    
<ul>
<g:each var="t" in="${userInstance?.tasksCreated?}">
    <li><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="task" params="['user.id':userInstance?.id]" action="create">Add Task</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pass">Pass:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:userInstance,field:'pass','errors')}">
                                    <input type="text" name="pass" id="pass" value="${fieldValue(bean:userInstance,field:'pass')}" />
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
