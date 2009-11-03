
<%@ page import="com.simplescrum.model.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Users</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home" controller="user">Home</g:link></span>
            <span class="menuButton"><g:link class="create" controller="register">Register New</g:link></span>
            <span class="menuButton"><g:link class="list" controller="team">Teams</g:link></span>
        </div>
        <div class="body">
            <h1>Users</h1>
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

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean:userInstance, field:'login')}</g:link></td>
                        
                            <td>${fieldValue(bean:userInstance, field:'userRealName')}</td>
                        
                            <td>${fieldValue(bean:userInstance, field:'roles')}</td>

                            <td>${fieldValue(bean:userInstance, field:'email')}</td>

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
