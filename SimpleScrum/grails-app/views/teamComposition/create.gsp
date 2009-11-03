
<%@ page import="com.simplescrum.model.TeamComposition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create TeamComposition</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">TeamCompositions</g:link></span>
        </div>
        <div class="body">
            <h1>Create TeamComposition</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${teamCompositionInstance}">
            <div class="errors">
                <g:renderErrors bean="${teamCompositionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="team">Team:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamCompositionInstance,field:'team','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Team.list()}" name="team.id" value="${teamCompositionInstance?.team?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user">User:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamCompositionInstance,field:'user','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.User.list()}" name="user.id" value="${teamCompositionInstance?.user?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sprint">Sprint:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamCompositionInstance,field:'sprint','errors')}">
                                    <g:select optionKey="id" from="${com.simplescrum.model.Sprint.list()}" name="sprint.id" value="${teamCompositionInstance?.sprint?.id}" ></g:select>
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
