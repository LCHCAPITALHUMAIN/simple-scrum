
<%@ page import="com.simplescrum.model.Product" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Product</title>
    </head>
    <body>
        <div class="nav">
             <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Products</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Product</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${productInstance}">
            <div class="errors">
                <g:renderErrors bean="${productInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${productInstance?.id}" />
                <input type="hidden" name="version" value="${productInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:productInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productInstance,field:'description','errors')}">
                                    <textarea rows="5" cols="40" name="description">${fieldValue(bean:productInstance, field:'description')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="startDate">Start Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productInstance,field:'startDate','errors')}">
                                    <g:datePicker name="startDate" value="${productInstance?.startDate}" precision="day" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="items">Items:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productInstance,field:'items','errors')}">
                                    
                                  <ul>
                                  <g:each var="i" in="${productInstance?.items?}">
                                      <li><g:link controller="productBacklogItem" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></li>
                                  </g:each>
                                  </ul>
                                  <g:link controller="productBacklogItem" params="['product.id':productInstance?.id]" action="create">Add ProductBacklogItem</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="releases">Releases:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productInstance,field:'releases','errors')}">
                                    
                                  <ul>
                                  <g:each var="r" in="${productInstance?.releases?}">
                                      <li><g:link controller="release" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
                                  </g:each>
                                  </ul>
                                  <g:link controller="release" params="['product.id':productInstance?.id]" action="create">Add Release</g:link>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:link class="cancel" action="show" id="${productInstance?.id}">Cancel</g:link></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
