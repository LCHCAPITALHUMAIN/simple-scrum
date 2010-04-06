<%@ page import="com.simplescrum.model.Sprint" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Edit Sprint</title>
</head>
<body>
<div class="nav">
  <span class="menuButton"><g:link class="home">Home</g:link></span>
  <span class="menuButton"><g:link class="list" action="list">Sprints</g:link></span>
</div>
<div class="body">
  <h1>Edit Sprint</h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <g:hasErrors bean="${sprintInstance}">
    <div class="errors">
      <g:renderErrors bean="${sprintInstance}" as="list"/>
    </div>
  </g:hasErrors>
  <g:form method="post">
    <input type="hidden" name="id" value="${sprintInstance?.id}"/>
    <input type="hidden" name="version" value="${sprintInstance?.version}"/>
    <div class="dialog">
      <table>
        <tbody>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="number">Number:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'number', 'errors')}">
            <input type="text" id="number" name="number" value="${fieldValue(bean: sprintInstance, field: 'number')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="goal">Goal:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'goal', 'errors')}">
            <input type="text" id="goal" name="goal" value="${fieldValue(bean: sprintInstance, field: 'goal')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="startDate">Start Date:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'startDate', 'errors')}">
            <g:datePicker name="startDate" value="${sprintInstance?.startDate}" precision="day"></g:datePicker>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="endDate">End Date:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'endDate', 'errors')}">
            <g:datePicker name="endDate" value="${sprintInstance?.endDate}" precision="day"></g:datePicker>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="velocity">Velocity:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'velocity', 'errors')}">
            <input type="text" id="velocity" name="velocity" value="${fieldValue(bean: sprintInstance, field: 'velocity')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="estimatedVelocity">Estimated Velocity:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'estimatedVelocity', 'errors')}">
            <input type="text" id="estimatedVelocity" name="estimatedVelocity" value="${fieldValue(bean: sprintInstance, field: 'estimatedVelocity')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="dailyWorkTime">Daily Work Time:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'dailyWorkTime', 'errors')}">
            <input type="text" id="dailyWorkTime" name="dailyWorkTime" value="${fieldValue(bean: sprintInstance, field: 'dailyWorkTime')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="productBacklogItems">Product Backlog Items:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'productBacklogItems', 'errors')}">
            <g:select name="productBacklogItems"
                    from="${com.simplescrum.model.ProductBacklogItem.list()}"
                    size="5" multiple="yes" optionKey="id"
                    value="${sprintInstance?.productBacklogItems}"/>

          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="release">Release:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'release', 'errors')}">
            <g:select optionKey="id" from="${com.simplescrum.model.Release.list()}" name="release.id" value="${sprintInstance?.release?.id}"></g:select>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="state">State:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: sprintInstance, field: 'state', 'errors')}">
            <g:select optionKey="description" from="${com.simplescrum.model.SprintStatus?.values()}" value="${sprintInstance?.state}" name="state"></g:select>
          </td>
        </tr>

        </tbody>
      </table>
    </div>
    <div class="buttons">
      <span class="button"><g:actionSubmit class="save" value="Update"/></span>
      <span class="button"><g:link class="cancel" action="show" id="${sprintInstance?.id}">Cancel</g:link></span>
    </div>
  </g:form>
</div>
</body>
</html>
