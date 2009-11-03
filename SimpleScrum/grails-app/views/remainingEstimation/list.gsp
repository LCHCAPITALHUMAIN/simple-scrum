
<%@ page import="com.simplescrum.model.RemainingEstimation" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>RemainingEstimations</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New RemainingEstimation</g:link></span>
        </div>
        <div class="body">
            <h1>RemainingEstimations</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="date" title="Date" />
                        
                   	        <g:sortableColumn property="remainingPoints" title="Remaining Points" />
                        
                   	        <th>Task</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${remainingEstimationInstanceList}" status="i" var="remainingEstimationInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${remainingEstimationInstance.id}">${fieldValue(bean:remainingEstimationInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:remainingEstimationInstance, field:'date')}</td>
                        
                            <td>${fieldValue(bean:remainingEstimationInstance, field:'remainingPoints')}</td>
                        
                            <td>${fieldValue(bean:remainingEstimationInstance, field:'task')}</td>
                        
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
