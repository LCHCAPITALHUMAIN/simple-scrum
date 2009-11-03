
<%@ page import="com.simplescrum.model.Task" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Tasks</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Task</g:link></span>
        </div>
        <div class="body">
            <h1>Tasks</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="label" title="Label" />
                        
                   	        <th>State</th>
                   	    
                   	        <th>Type</th>
                   	    
                   	        <th>Team</th>
                   	    
                   	        <th>Sprint</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${taskInstanceList}" status="i" var="taskInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${taskInstance.id}">${fieldValue(bean:taskInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:taskInstance, field:'label')}</td>
                        
                            <td>${fieldValue(bean:taskInstance, field:'state')}</td>
                        
                            <td>${fieldValue(bean:taskInstance, field:'type')}</td>
                        
                            <td>${fieldValue(bean:taskInstance, field:'team')}</td>
                        
                            <td>${fieldValue(bean:taskInstance, field:'sprint')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${taskInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
