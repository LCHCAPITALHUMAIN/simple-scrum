
<%@ page import="com.simplescrum.model.TaskActual" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>TaskActual List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New TaskActual</g:link></span>
        </div>
        <div class="body">
            <h1>TaskActual List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Task</th>
                   	    
                   	        <th>User</th>
                   	    
                   	        <g:sortableColumn property="date" title="Date" />
                        
                   	        <g:sortableColumn property="actualPoints" title="Actual Points" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${taskActualInstanceList}" status="i" var="taskActualInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        

                            <td>${fieldValue(bean:taskActualInstance, field:'id')}-><g:link action="show" id="${taskActualInstance.id}">show</g:link>|<g:link action="edit" id="${taskActualInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:taskActualInstance, field:'task')}</td>
                        
                            <td>${fieldValue(bean:taskActualInstance, field:'user')}</td>
                        
                            <td>${fieldValue(bean:taskActualInstance, field:'date')}</td>
                        
                            <td>${fieldValue(bean:taskActualInstance, field:'actualPoints')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${taskActualInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
