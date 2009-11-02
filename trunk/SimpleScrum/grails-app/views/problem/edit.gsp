
<%@ page import="com.simplescrum.model.Problem" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Problem</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Problem List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Problem</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Problem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${problemInstance}">
            <div class="errors">
                <g:renderErrors bean="${problemInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${problemInstance?.id}" />
                <input type="hidden" name="version" value="${problemInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="closedDate">Closed Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'closedDate','errors')}">
                                    <g:datePicker name="closedDate" value="${problemInstance?.closedDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="creationDate">Creation Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'creationDate','errors')}">
                                    <g:datePicker name="creationDate" value="${problemInstance?.creationDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="impact">Impact:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'impact','errors')}">
                                    <input type="text" id="impact" name="impact" value="${fieldValue(bean:problemInstance,field:'impact')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="modificationDate">Modification Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'modificationDate','errors')}">
                                    <g:datePicker name="modificationDate" value="${problemInstance?.modificationDate}" precision="minute" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:problemInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="poster">Poster:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'poster','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.User.list()}" name="poster.id" value="${problemInstance?.poster?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="product">Product:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'product','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Product.list()}" name="product.id" value="${problemInstance?.product?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="rank">Rank:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'rank','errors')}">
                                    <input type="text" id="rank" name="rank" value="${fieldValue(bean:problemInstance,field:'rank')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="solution">Solution:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'solution','errors')}">
                                    <input type="text" id="solution" name="solution" value="${fieldValue(bean:problemInstance,field:'solution')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="state">State:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'state','errors')}">
                                    <g:select  from="${com.simplescrum.model.ProblemStatus?.values()}" value="${problemInstance?.state}" name="state" ></g:select>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
