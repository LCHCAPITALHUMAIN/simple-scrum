
<%@ page import="com.simplescrum.model.Feature" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Features</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Feature</g:link></span>
        </div>
        <div class="body">
            <h1>Features</h1>
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
                        
                   	        <th>Product</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${featureInstanceList}" status="i" var="featureInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${featureInstance.id}">${fieldValue(bean:featureInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:featureInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:featureInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:featureInstance, field:'product')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${featureInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
