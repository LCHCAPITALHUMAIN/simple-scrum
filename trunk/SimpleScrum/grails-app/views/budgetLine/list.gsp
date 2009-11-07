
<%@ page import="com.simplescrum.model.BudgetLine" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>BudgetLine List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New BudgetLine</g:link></span>
        </div>
        <div class="body">
            <h1>BudgetLine List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${budgetLineInstanceList}" status="i" var="budgetLineInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        

                            <td>${fieldValue(bean:budgetLineInstance, field:'id')}-><g:link action="show" id="${budgetLineInstance.id}">show</g:link>|<g:link action="edit" id="${budgetLineInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:budgetLineInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:budgetLineInstance, field:'description')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${budgetLineInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
