<%@ page import="com.simplescrum.model.Product" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Show Product</title>
</head>
<body>
<div class="nav">
  <span class="menuButton"><g:link class="home">Home</g:link></span>
  <span class="menuButton"><g:link class="list" action="list">Products</g:link></span>
  <span class="menuButton"><g:link class="list" controller="productBacklogItem" action="list">Items</g:link></span>
  <span class="menuButton"><g:link class="create" controller="productBacklogItem" action="create" params="['product.id':productInstance?.id]">New Item</g:link></span>
  <span class="menuButton"><g:link class="create" controller="release" action="create" params="['product.id':productInstance?.id]">New Release</g:link></span>
  <span class="menuButton"><g:link class="create" controller="feature" action="create" params="['product.id':productInstance?.id]">New Feature</g:link></span>
  <span class="menuButton"><g:link class="list" controller="auditLog" action="query" params="['auditLogEvent.className':productInstance?.class.name,'auditLogEvent.persistedObjectId':productInstance?.id]">Audit Trail</g:link></span>
</div>
<div class="body">
  <h1>Show Product</h1>
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>
  <div class="dialog">
    <table>
      <tbody>

      <tr class="prop">
        <td valign="top" class="name">Name:</td>

        <td valign="top" class="value">${fieldValue(bean: productInstance, field: 'name')}</td>

      </tr>

      <tr class="prop">
        <td valign="top" class="name">Description:</td>

        <td valign="top" class="value">${fieldValue(bean: productInstance, field: 'description')}</td>

      </tr>

      <tr class="prop">
        <td valign="top" class="name">Start Date:</td>

        <td valign="top" class="value">${fieldValue(bean: productInstance, field: 'startDate')}</td>

      </tr>

      <tr class="prop">
        <td valign="top" class="name">Releases:</td>

        <td valign="top" style="text-align:left;" class="value">
          <ul>
            <g:each var="r" in="${productInstance.releases}">
              <li><g:link controller="release" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
            </g:each>
          </ul>
        </td>

      </tr>

      </tbody>
    </table>
  </div>
  <div class="buttons">
    <g:form>
      <input type="hidden" name="id" value="${productInstance?.id}"/>
      <span class="button"><g:actionSubmit class="edit" value="Edit"/></span>
    %{--<span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>--}%
    </g:form>
  </div>
</div>
</body>
</html>
