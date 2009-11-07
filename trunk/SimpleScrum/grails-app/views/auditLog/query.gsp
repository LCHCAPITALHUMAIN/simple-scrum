
<%@ page import="com.simplescrum.model.AuditLog" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>AuditLogEvent List</title>
    </head>
    <body>
        <div class="nav">
          <span class="menuButton"><g:link class="home">Home</g:link></span>
        </div>
        <div class="body">
            <h1>AuditLogEvent List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                   	        <g:sortableColumn property="id" title="Id"  params="['auditLogEvent.actor':auditParams?.actor,'auditLogEvent.className':auditParams?.className]"/>

                   	        <g:sortableColumn property="actor" title="Actor" params="['auditLogEvent.actor':auditParams?.actor,'auditLogEvent.className':auditParams?.className]"/>

                   	        <g:sortableColumn property="className" title="Class Name" params="['auditLogEvent.actor':auditParams?.actor,'auditLogEvent.className':auditParams?.className]"/>

                   	        <g:sortableColumn property="persistedObjectId" title="Object Id" params="['auditLogEvent.actor':auditParams?.actor,'auditLogEvent.className':auditParams?.className]"/>

                   	        <g:sortableColumn property="eventName" title="Operation" params="['auditLogEvent.actor':auditParams?.actor,'auditLogEvent.className':auditParams?.className]"/>

                   	        <g:sortableColumn property="dateCreated" title="Date Created" params="['auditLogEvent.actor':auditParams?.actor,'auditLogEvent.className':auditParams?.className]" />

                   	        <g:sortableColumn property="lastUpdated" title="Last Updated" />

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${auditList}" status="i" var="varAuditLog">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                            <td><g:link action="show" id="${varAuditLog.id}">${varAuditLog.id?.encodeAsHTML()}</g:link></td>

                            <td>${varAuditLog.actor?.encodeAsHTML()}</td>

                            <td>${varAuditLog.simpleclassName()?.encodeAsHTML()}</td>

                            <td>${varAuditLog.persistedObjectId?.encodeAsHTML()}</td>

                            <td>${varAuditLog.eventName?.encodeAsHTML()}</td>

                            <td>${fieldValue(bean:varAuditLog, field:'dateCreated')}</td>

                            <td>${fieldValue(bean:varAuditLog, field:'lastUpdated')}</td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                %{--<g:paginate total="${auditList.size()}" />--}%
            </div>
        </div>
    </body>
</html>
