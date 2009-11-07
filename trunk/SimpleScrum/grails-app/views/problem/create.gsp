
<%@ page import="com.simplescrum.model.Problem" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Problem</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Problems</g:link></span>
        </div>
        <div class="body">
            <h1>Create Problem</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${problemInstance}">
            <div class="errors">
                <g:renderErrors bean="${problemInstance}" as="list" />
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
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'name','errors')}">
                                    <input type="text" id="name" name="name" value="${fieldValue(bean:problemInstance,field:'name')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="impact">Impact:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'impact','errors')}">
                                    <textarea rows="5" cols="40" name="impact">${fieldValue(bean:problemInstance, field:'impact')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="solution">Solution:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'solution','errors')}">
                                    <textarea rows="5" cols="40" name="solution">${fieldValue(bean:problemInstance, field:'solution')}</textarea>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="creationDate">Creation Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'creationDate','errors')}">
                                    <g:datePicker name="creationDate" value="${problemInstance?.creationDate}" precision="day" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="modificationDate">Modification Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'modificationDate','errors')}">
                                    <g:datePicker name="modificationDate" value="${problemInstance?.modificationDate}" precision="day" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="closedDate">Closed Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:problemInstance,field:'closedDate','errors')}">
                                    <g:datePicker name="closedDate" value="${problemInstance?.closedDate}" precision="day" noSelection="['':'']"></g:datePicker>
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
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                    <span class="button"><g:link class="cancel" action="list">Cancel</g:link></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
