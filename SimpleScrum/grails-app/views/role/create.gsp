<%@ page import="com.simplescrum.model.Role" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Create Role</title>
</head>
<body>
<div class="nav">
  <span class="menuButton"><g:link class="home">Home</g:link></span>
  <span class="menuButton"><g:link class="list" action="list">Roles</g:link></span>
</div>
<div class="body">
  <h1>Create Role</h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <g:hasErrors bean="${roleInstance}">
    <div class="errors">
      <g:renderErrors bean="${roleInstance}" as="list"/>
    </div>
  </g:hasErrors>
  <g:form action="save" method="post">
    <div class="dialog">
      <table>
        <tbody>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="name">Name:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: roleInstance, field: 'name', 'errors')}">
            <g:select optionKey="description" from="${com.simplescrum.model.RoleType?.values()}" value="${roleInstance?.name}" name="name"></g:select>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="description">Description:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: roleInstance, field: 'description', 'errors')}">
            <textarea rows="5" cols="40" name="description">${fieldValue(bean: roleInstance, field: 'description')}</textarea>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="product">Product:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: roleInstance, field: 'product', 'errors')}">
            <g:select optionKey="id" from="${com.simplescrum.model.Product.list()}" name="product.id" value="${roleInstance?.product?.id}"></g:select>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="sprint">Sprint:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: roleInstance, field: 'sprint', 'errors')}">
            <g:select optionKey="id" from="${com.simplescrum.model.Sprint.list()}" name="sprint.id" value="${roleInstance?.sprint?.id}" noSelection="['null':'']"></g:select>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name">
            <label for="user">User:</label>
          </td>
          <td valign="top" class="value ${hasErrors(bean: roleInstance, field: 'user', 'errors')}">
            <g:select optionKey="id" from="${com.simplescrum.model.User.list()}" name="user.id" value="${roleInstance?.user?.id}"></g:select>
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
