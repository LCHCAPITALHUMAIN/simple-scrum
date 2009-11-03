
<%@ page import="com.simplescrum.model.Sprint" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Sprints</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Sprint</g:link></span>
        </div>
        <div class="body">
            <h1>Sprints</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="dailyWorkTime" title="Daily Work Time" />
                        
                   	        <g:sortableColumn property="endDate" title="End Date" />
                        
                   	        <g:sortableColumn property="estimatedVelocity" title="Estimated Velocity" />
                        
                   	        <g:sortableColumn property="goal" title="Goal" />
                        
                   	        <g:sortableColumn property="number" title="Number" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${sprintInstanceList}" status="i" var="sprintInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${sprintInstance.id}">${fieldValue(bean:sprintInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'dailyWorkTime')}</td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'endDate')}</td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'estimatedVelocity')}</td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'goal')}</td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'number')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${sprintInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
