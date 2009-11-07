
<%@ page import="com.simplescrum.model.CustomRole" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>CustomRole List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New CustomRole</g:link></span>
        </div>
        <div class="body">
            <h1>CustomRole List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <th>Expertise Level</th>
                   	    
                   	        <g:sortableColumn property="instances" title="Instances" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <g:sortableColumn property="satisficationCriteria" title="Satisfication Criteria" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${customRoleInstanceList}" status="i" var="customRoleInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        

                            <td>${fieldValue(bean:customRoleInstance, field:'id')}-><g:link action="show" id="${customRoleInstance.id}">show</g:link>|<g:link action="edit" id="${customRoleInstance.id}">edit</g:link></td>
                        
                            <td>${fieldValue(bean:customRoleInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:customRoleInstance, field:'expertiseLevel')}</td>
                        
                            <td>${fieldValue(bean:customRoleInstance, field:'instances')}</td>
                        
                            <td>${fieldValue(bean:customRoleInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:customRoleInstance, field:'satisficationCriteria')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${customRoleInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
