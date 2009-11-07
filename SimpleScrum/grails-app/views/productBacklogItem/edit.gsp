
<%@ page import="com.simplescrum.model.ProductBacklogItem" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit ProductBacklogItem</title>
    </head>
    <body>
        <div class="nav">
             <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">ProductBacklogItems</g:link></span>
        </div>
        <div class="body">
            <h1>Edit ProductBacklogItem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${productBacklogItemInstance}">
            <div class="errors">
                <g:renderErrors bean="${productBacklogItemInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${productBacklogItemInstance?.id}" />
                <input type="hidden" name="version" value="${productBacklogItemInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
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
                                    <textarea rows="5" cols="40" name="description">${fieldValue(bean:productBacklogItemInstance, field:'description')}</textarea>
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
                                    <textarea rows="5" cols="40" name="notes">${fieldValue(bean:productBacklogItemInstance, field:'notes')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="howToTest">How To Test:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'howToTest','errors')}">
                                    <textarea rows="5" cols="40" name="howToTest">${fieldValue(bean:productBacklogItemInstance, field:'howToTest')}</textarea>
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
                                    <label for="estimationType">Estimation Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'estimationType','errors')}">
                                    <g:select  from="${com.simplescrum.model.EstimationType?.values()}" value="${productBacklogItemInstance?.estimationType}" name="estimationType" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="estimationDate">Estimation Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'estimationDate','errors')}">
                                    <g:datePicker name="estimationDate" value="${productBacklogItemInstance?.estimationDate}" precision="day" noSelection="['':'']"></g:datePicker>
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
                                    <label for="plannedRelease">Planned Release:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'plannedRelease','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Release.list()}" name="plannedRelease.id" value="${productBacklogItemInstance?.plannedRelease?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="budgetLine">Budget Line:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'budgetLine','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.BudgetLine.list()}" name="budgetLine.id" value="${productBacklogItemInstance?.budgetLine?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="creationDate">Creation Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'creationDate','errors')}">
                                    <g:datePicker name="creationDate" value="${productBacklogItemInstance?.creationDate}" precision="day" ></g:datePicker>
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
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="tasks">Tasks:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:productBacklogItemInstance,field:'tasks','errors')}">
                                    
                                    <ul>
                                    <g:each var="t" in="${productBacklogItemInstance?.tasks?}">
                                        <li><g:link controller="task" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
                                    </g:each>
                                    </ul>
                                    <g:link controller="task" params="['productBacklogItem.id':productBacklogItemInstance?.id]" action="create">Add Task</g:link>

                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:link class="cancel" action="show" id="${productBacklogItemInstance?.id}">Cancel</g:link></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
