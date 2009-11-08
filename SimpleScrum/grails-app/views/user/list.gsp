
<%@ page import="com.simplescrum.model.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>User List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home" controller="user">Home</g:link></span>
            <span class="menuButton"><g:link class="create" controller="register">Register New</g:link></span>
            <span class="menuButton"><g:link class="list" controller="team">Teams</g:link></span>
            <span class="menuButton"><g:link class="list" controller="role">Roles</g:link></span>
        </div>
        <div class="body">
            <h1>User List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="login" title="Login" />

                   	        <g:sortableColumn property="userRealName" title="Real Name" />

                   	        <g:sortableColumn property="roles" title="Scrum Roles" />

                   	        <g:sortableColumn property="email" title="Email" />
                        
                   	        <th>Photo</th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${fieldValue(bean:userInstance, field:'login')}-><g:link action="show" id="${userInstance.id}">show</g:link>|<g:link controller="register" action="edit" id="${userInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:userInstance, field:'userRealName')}</td>
                        
                            <td>${fieldValue(bean:userInstance, field:'roles')}</td>

                            <td>${fieldValue(bean:userInstance, field:'email')}</td>
                        
                            <td>
                              <g:if test="${userInstance.photo}">
                                <img src="<g:createLink controller='user' action='renderImage' id='${userInstance?.id}'/>"/>
                              </g:if>
                            </td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${userInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
