
<%@ page import="com.simplescrum.model.Problem" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Problem List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Problem</g:link></span>
        </div>
        <div class="body">
            <h1>Problem List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <g:sortableColumn property="impact" title="Impact" />
                        
                   	        <g:sortableColumn property="solution" title="Solution" />
                        
                   	        <g:sortableColumn property="creationDate" title="Creation Date" />
                        
                   	        <g:sortableColumn property="modificationDate" title="Modification Date" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${problemInstanceList}" status="i" var="problemInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        

                            <td>${fieldValue(bean:problemInstance, field:'id')}-><g:link action="show" id="${problemInstance.id}">show</g:link>|<g:link action="edit" id="${problemInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:problemInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:problemInstance, field:'impact')}</td>
                        
                            <td>${fieldValue(bean:problemInstance, field:'solution')}</td>
                        
                            <td>${fieldValue(bean:problemInstance, field:'creationDate')}</td>
                        
                            <td>${fieldValue(bean:problemInstance, field:'modificationDate')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${problemInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
