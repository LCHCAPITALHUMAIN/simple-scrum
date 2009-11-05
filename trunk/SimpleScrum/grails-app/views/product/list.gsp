
<%@ page import="com.simplescrum.model.Product" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Products</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home" controller="product">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New</g:link></span>
        </div>
        <div class="body">
            <h1>Products</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <g:sortableColumn property="startDate" title="Start Date" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${productInstanceList}" status="i" var="productInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${productInstance.id}">${fieldValue(bean:productInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:productInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:productInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:productInstance, field:'startDate')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${productInstanceTotal}" />
            </div>
        </div>
    </body>
</html>