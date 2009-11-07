
<%@ page import="com.simplescrum.model.Team" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Team</title>
    </head>
    <body>
        <div class="nav">
             <span class="menuButton"><g:link class="home">Home</g:link></span>
            <span class="menuButton"><g:link class="list" action="list">Teams</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Team</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${teamInstance}">
            <div class="errors">
                <g:renderErrors bean="${teamInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${teamInstance?.id}" />
                <input type="hidden" name="version" value="${teamInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="label">Label:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamInstance,field:'label','errors')}">
                                    <input type="text" id="label" name="label" value="${fieldValue(bean:teamInstance,field:'label')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamInstance,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:teamInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="compositions">Compositions:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamInstance,field:'compositions','errors')}">
                                    
<ul>
<g:each var="c" in="${teamInstance?.compositions?}">
    <li><g:link controller="teamComposition" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="teamComposition" params="['team.id':teamInstance?.id]" action="create">Add TeamComposition</g:link>

                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:link class="cancel" action="show" id="${teamInstance?.id}">Cancel</g:link></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
