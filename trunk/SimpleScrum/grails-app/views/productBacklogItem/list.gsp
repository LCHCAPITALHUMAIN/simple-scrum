
<%@ page import="com.simplescrum.model.ProductBacklogItem" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>ProductBacklogItem List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New ProductBacklogItem</g:link></span>
        </div>
        <div class="body">
            <h1>ProductBacklogItem List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Custom Role</th>
                   	    
                   	        <th>Feature</th>
                   	    
                   	        <g:sortableColumn property="creationDate" title="Creation Date" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <g:sortableColumn property="estimatedPoints" title="Estimated Points" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${productBacklogItemInstanceList}" status="i" var="productBacklogItemInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${productBacklogItemInstance.id}">${fieldValue(bean:productBacklogItemInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:productBacklogItemInstance, field:'customRole')}</td>
                        
                            <td>${fieldValue(bean:productBacklogItemInstance, field:'feature')}</td>
                        
                            <td>${fieldValue(bean:productBacklogItemInstance, field:'creationDate')}</td>
                        
                            <td>${fieldValue(bean:productBacklogItemInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:productBacklogItemInstance, field:'estimatedPoints')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${productBacklogItemInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
