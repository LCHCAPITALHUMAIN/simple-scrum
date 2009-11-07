
<%@ page import="com.simplescrum.model.Release" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Release</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Releases</g:link></span>
        </div>
        <div class="body">
            <h1>Create Release</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${releaseInstance}">
            <div class="errors">
                <g:renderErrors bean="${releaseInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:releaseInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="goal">Goal:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'goal','errors')}">
                                    <input type="text" id="goal" name="goal" value="${fieldValue(bean:releaseInstance,field:'goal')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="type">Type:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'type','errors')}">
                                    <g:select  from="${com.simplescrum.model.ReleaseType?.values()}" value="${releaseInstance?.type}" name="type" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="startDate">Start Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'startDate','errors')}">
                                    <g:datePicker name="startDate" value="${releaseInstance?.startDate}" precision="day" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="publishDate">Publish Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'publishDate','errors')}">
                                    <g:datePicker name="publishDate" value="${releaseInstance?.publishDate}" precision="day" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="state">State:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'state','errors')}">
                                    <g:select  from="${com.simplescrum.model.ReleaseStatus?.values()}" value="${releaseInstance?.state}" name="state" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="releaseVelocity">Release Velocity:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'releaseVelocity','errors')}">
                                    <input type="text" id="releaseVelocity" name="releaseVelocity" value="${fieldValue(bean:releaseInstance,field:'releaseVelocity')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="estimatedSprintDuration">Estimated Sprint Duration:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'estimatedSprintDuration','errors')}">
                                    <input type="text" id="estimatedSprintDuration" name="estimatedSprintDuration" value="${fieldValue(bean:releaseInstance,field:'estimatedSprintDuration')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="defaultEstimatedVelocity">Default Estimated Velocity:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'defaultEstimatedVelocity','errors')}">
                                    <input type="text" id="defaultEstimatedVelocity" name="defaultEstimatedVelocity" value="${fieldValue(bean:releaseInstance,field:'defaultEstimatedVelocity')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="product">Product:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:releaseInstance,field:'product','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Product.list()}" name="product.id" value="${releaseInstance?.product?.id}" ></g:select>
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
