
<%@ page import="com.simplescrum.model.Role" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Role List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Role</g:link></span>
        </div>
        <div class="body">
            <h1>Role List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Name</th>
                   	    
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <th>Product</th>
                   	    
                   	        <th>Sprint</th>
                   	    
                   	        <th>User</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${roleInstanceList}" status="i" var="roleInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        

                            <td>${fieldValue(bean:roleInstance, field:'id')}-><g:link action="show" id="${roleInstance.id}">show</g:link>|<g:link action="edit" id="${roleInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:roleInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:roleInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:roleInstance, field:'product')}</td>
                        
                            <td>${fieldValue(bean:roleInstance, field:'sprint')}</td>
                        
                            <td>${fieldValue(bean:roleInstance, field:'user')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${roleInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
