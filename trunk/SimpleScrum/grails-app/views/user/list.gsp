
<%@ page import="com.simplescrum.model.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>User List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New User</g:link></span>
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
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="login" title="Login" />
                        
                   	        <g:sortableColumn property="password" title="Password" />
                        
                   	        <g:sortableColumn property="email" title="Email" />
                        
                   	        <g:sortableColumn property="userRealName" title="User Real Name" />
                        
                   	        <g:sortableColumn property="emailShow" title="Email Show" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean:userInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:userInstance, field:'login')}</td>
                        
                            <td>${fieldValue(bean:userInstance, field:'password')}</td>
                        
                            <td>${fieldValue(bean:userInstance, field:'email')}</td>
                        
                            <td>${fieldValue(bean:userInstance, field:'userRealName')}</td>
                        
                            <td>${fieldValue(bean:userInstance, field:'emailShow')}</td>
                        
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