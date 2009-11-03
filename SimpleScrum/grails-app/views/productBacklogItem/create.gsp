
<%@ page import="com.simplescrum.model.ProductBacklogItem" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create ProductBacklogItem</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">ProductBacklogItems</g:link></span>
        </div>
        <div class="body">
            <h1>Create ProductBacklogItem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${productBacklogItemInstance}">
            <div class="errors">
                <g:renderErrors bean="${productBacklogItemInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="label">Label:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'label','errors')}">
                                    <input type="text" id="label" name="label" value="${fieldValue(bean:productBacklogItemInstance,field:'label')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:productBacklogItemInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="type">Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'type','errors')}">
                                    <g:select  from="${com.simplescrum.model.ProductBacklogItemType?.values()}" value="${productBacklogItemInstance?.type}" name="type" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="rank">Rank:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'rank','errors')}">
                                    <input type="text" id="rank" name="rank" value="${fieldValue(bean:productBacklogItemInstance,field:'rank')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="notes">Notes:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'notes','errors')}">
                                    <input type="text" id="notes" name="notes" value="${fieldValue(bean:productBacklogItemInstance,field:'notes')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="product">Product:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'product','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Product.list()}" name="product.id" value="${productBacklogItemInstance?.product?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="estimatedPoints">Estimated Points:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'estimatedPoints','errors')}">
                                    <input type="text" id="estimatedPoints" name="estimatedPoints" value="${fieldValue(bean:productBacklogItemInstance,field:'estimatedPoints')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="estimationDate">Estimation Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'estimationDate','errors')}">
                                    <g:datePicker name="estimationDate" value="${productBacklogItemInstance?.estimationDate}" precision="minute" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="customRole">Custom Role:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'customRole','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.CustomRole.list()}" name="customRole.id" value="${productBacklogItemInstance?.customRole?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="feature">Feature:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'feature','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Feature.list()}" name="feature.id" value="${productBacklogItemInstance?.feature?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="creationDate">Creation Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'creationDate','errors')}">
                                    <g:datePicker name="creationDate" value="${productBacklogItemInstance?.creationDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ownerUser">Owner User:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'ownerUser','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.User.list()}" name="ownerUser.id" value="${productBacklogItemInstance?.ownerUser?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="state">State:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'state','errors')}">
                                    <g:select  from="${com.simplescrum.model.ProductBacklogItemStatus?.values()}" value="${productBacklogItemInstance?.state}" name="state" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
