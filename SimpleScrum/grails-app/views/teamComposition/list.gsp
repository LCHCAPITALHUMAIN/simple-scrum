
<%@ page import="com.simplescrum.model.TeamComposition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>TeamComposition List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New TeamComposition</g:link></span>
        </div>
        <div class="body">
            <h1>TeamComposition List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Team</th>
                   	    
                   	        <th>User</th>
                   	    
                   	        <th>Sprint</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${teamCompositionInstanceList}" status="i" var="teamCompositionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        

                            <td>${fieldValue(bean:teamCompositionInstance, field:'id')}-><g:link action="show" id="${teamCompositionInstance.id}">show</g:link>|<g:link action="edit" id="${teamCompositionInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:teamCompositionInstance, field:'team')}</td>
                        
                            <td>${fieldValue(bean:teamCompositionInstance, field:'user')}</td>
                        
                            <td>${fieldValue(bean:teamCompositionInstance, field:'sprint')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${teamCompositionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
