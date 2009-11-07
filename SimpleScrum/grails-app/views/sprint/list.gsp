
<%@ page import="com.simplescrum.model.Sprint" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Sprint List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Sprint</g:link></span>
        </div>
        <div class="body">
            <h1>Sprint List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="number" title="Number" />
                        
                   	        <g:sortableColumn property="goal" title="Goal" />
                        
                            <g:sortableColumn property="state" title="State" />

                   	        <g:sortableColumn property="startDate" title="Start Date" />
                        
                   	        <g:sortableColumn property="endDate" title="End Date" />
                        
                            <g:sortableColumn property="estimatedVelocity" title="Estimated Velocity" />

                   	        <g:sortableColumn property="velocity" title="Velocity" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${sprintInstanceList}" status="i" var="sprintInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${fieldValue(bean:sprintInstance, field:'id')}-><g:link action="show" id="${sprintInstance.id}">show</g:link>|<g:link action="edit" id="${sprintInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'goal')}</td>

                            <td>${fieldValue(bean:sprintInstance, field:'state')}</td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'startDate')}</td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'endDate')}</td>
                        
                            <td>${fieldValue(bean:sprintInstance, field:'estimatedVelocity')}</td>

                            <td>${fieldValue(bean:sprintInstance, field:'velocity')}</td>
                        
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
