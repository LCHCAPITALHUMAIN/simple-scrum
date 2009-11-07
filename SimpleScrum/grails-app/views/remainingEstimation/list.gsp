
<%@ page import="com.simplescrum.model.RemainingEstimation" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>RemainingEstimation List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New RemainingEstimation</g:link></span>
        </div>
        <div class="body">
            <h1>RemainingEstimation List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Task</th>
                   	    
                   	        <g:sortableColumn property="remainingPoints" title="Remaining Points" />
                        
                   	        <g:sortableColumn property="date" title="Date" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${remainingEstimationInstanceList}" status="i" var="remainingEstimationInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        

                            <td>${fieldValue(bean:remainingEstimationInstance, field:'id')}-><g:link action="show" id="${remainingEstimationInstance.id}">show</g:link>|<g:link action="edit" id="${remainingEstimationInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:remainingEstimationInstance, field:'task')}</td>
                        
                            <td>${fieldValue(bean:remainingEstimationInstance, field:'remainingPoints')}</td>
                        
                            <td>${fieldValue(bean:remainingEstimationInstance, field:'date')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${remainingEstimationInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
