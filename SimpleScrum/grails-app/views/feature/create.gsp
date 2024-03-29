
<%@ page import="com.simplescrum.model.Feature" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Feature</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Features</g:link></span>
        </div>
        <div class="body">
            <h1>Create Feature</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${featureInstance}">
            <div class="errors">
                <g:renderErrors bean="${featureInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:featureInstance,field:'description','errors')}">
                                    <textarea rows="5" cols="40" name="description">${fieldValue(bean:featureInstance, field:'description')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:featureInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:featureInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="product">Product:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:featureInstance,field:'product','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Product.list()}" name="product.id" value="${featureInstance?.product?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                    <span class="button"><g:link class="cancel" action="list">Cancel</g:link></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
