
<%@ page import="com.simplescrum.model.Release" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Release List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Release</g:link></span>
        </div>
        <div class="body">
            <h1>Release List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <g:sortableColumn property="goal" title="Goal" />
                        
                   	        <th>Type</th>
                   	    
                   	        <g:sortableColumn property="startDate" title="Start Date" />
                        
                   	        <g:sortableColumn property="publishDate" title="Publish Date" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${releaseInstanceList}" status="i" var="releaseInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        

                            <td>${fieldValue(bean:releaseInstance, field:'id')}-><g:link action="show" id="${releaseInstance.id}">show</g:link>|<g:link action="edit" id="${releaseInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'goal')}</td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'type')}</td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'startDate')}</td>
                        
                            <td>${fieldValue(bean:releaseInstance, field:'publishDate')}</td>
                        
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
