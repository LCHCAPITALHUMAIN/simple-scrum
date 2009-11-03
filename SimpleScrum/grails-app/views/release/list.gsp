
<%@ page import="com.simplescrum.model.Release" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Releases</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Release</g:link></span>
        </div>
        <div class="body">
            <h1>Releases</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="defaultEstimatedVelocity" title="Default Estimated Velocity" />
                        
                   	        <g:sortableColumn property="estimatedSprintDuration" title="Estimated Sprint Duration" />
                        
                   	        <g:sortableColumn property="goal" title="Goal" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <th>Product</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${releaseInstanceList}" status="i" var="releaseInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${releaseInstance.id}">${fieldValue(bean:releaseInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'defaultEstimatedVelocity')}</td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'estimatedSprintDuration')}</td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'goal')}</td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'product')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${releaseInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
