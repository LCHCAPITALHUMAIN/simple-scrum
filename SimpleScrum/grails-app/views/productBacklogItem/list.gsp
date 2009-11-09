<%@ page import="com.simplescrum.model.ProductBacklogItem" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>ProductBacklogItem List</title>
</head>
<body>
<div class="nav">
  <span class="menuButton"><g:link class="home">Home</g:link></span>
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

        <g:sortableColumn property="number" title="Number"/>

        <g:sortableColumn property="rank" title="Rank"/>

        <g:sortableColumn property="label" title="Label"/>

        <g:sortableColumn property="feature" title="Feature"/>

        <g:sortableColumn property="estimatedPoints" title="Estimation"/>

        <g:sortableColumn property="estimationType.id" title="Estim. Type"/>

        <g:sortableColumn property="estimationDate" title="Estim. Date"/>

      </tr>
      </thead>
      <tbody>
      <g:each in="${productBacklogItemInstanceList}" status="i" var="productBacklogItemInstance">
        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

          <td>${fieldValue(bean: productBacklogItemInstance, field: 'number')}-><g:link action="show" id="${productBacklogItemInstance.id}">show</g:link>|<g:link action="edit" id="${productBacklogItemInstance.id}">edit</g:link></td>

          <td>${fieldValue(bean: productBacklogItemInstance, field: 'rank')}</td>

          <td>${fieldValue(bean: productBacklogItemInstance, field: 'label')}</td>

          <td>${fieldValue(bean: productBacklogItemInstance, field: 'feature')}</td>

          <td>${fieldValue(bean: productBacklogItemInstance, field: 'estimatedPoints')}</td>

          <td>${fieldValue(bean: productBacklogItemInstance, field: 'estimationType.id')}</td>

          <td>${fieldValue(bean: productBacklogItemInstance, field: 'estimationDate')}</td>

        </tr>
      </g:each>
      </tbody>
    </table>
  </div>
  <div class="paginateButtons">
    <g:paginate total="${productBacklogItemInstanceTotal}"/>
  </div>
</div>
</body>
</html>
