<%@ page import="com.simplescrum.model.CustomRole" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Create CustomRole</title>
</head>
<body>
<div class="nav">
  <span class="menuButton"><g:link class="home">Home</g:link></span>
  <span class="menuButton"><g:link class="list" action="list">CustomRoles</g:link></span>
</div>
<div class="body">
  <h1>Create CustomRole</h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <g:hasErrors bean="${customRoleInstance}">
    <div class="errors">
      <g:renderErrors bean="${customRoleInstance}" as="list"/>
    </div>
  </g:hasErrors>
  <g:form action="save" method="post">
    <div class="dialog">
      <table>
        <tbody>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="description">Description:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: customRoleInstance, field: 'description', 'errors')}">
            <input type="text" id="description" name="description" value="${fieldValue(bean: customRoleInstance, field: 'description')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="expertiseLevel">Expertise Level:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: customRoleInstance, field: 'expertiseLevel', 'errors')}">
            <g:select optionKey="description" from="${com.simplescrum.model.ExpertnessLevel?.values()}" value="${customRoleInstance?.expertiseLevel}" name="expertiseLevel"></g:select>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="instances">Instances:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: customRoleInstance, field: 'instances', 'errors')}">
            <input type="text" id="instances" name="instances" value="${fieldValue(bean: customRoleInstance, field: 'instances')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="name">Name:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: customRoleInstance, field: 'name', 'errors')}">
            <input type="text" id="name" name="name" value="${fieldValue(bean: customRoleInstance, field: 'name')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="satisficationCriteria">Satisfication Criteria:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: customRoleInstance, field: 'satisficationCriteria', 'errors')}">
            <input type="text" id="satisficationCriteria" name="satisficationCriteria" value="${fieldValue(bean: customRoleInstance, field: 'satisficationCriteria')}"/>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="usageFrequency">Usage Frequency:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: customRoleInstance, field: 'usageFrequency', 'errors')}">
            <g:select optionKey="description" from="${com.simplescrum.model.UsageFrequency?.values()}" value="${customRoleInstance?.usageFrequency}" name="usageFrequency"></g:select>
          </td>
        </tr>

        </tbody>
      </table>
    </div>
    <div class="buttons">
      <span class="button"><input class="save" type="submit" value="Create"/></span>
      <span class="button"><g:link class="cancel" action="list">Cancel</g:link></span>
    </div>
  </g:form>
</div>
</body>
</html>
