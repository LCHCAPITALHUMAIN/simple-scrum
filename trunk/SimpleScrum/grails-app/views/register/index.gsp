<head>
	<meta name="layout" content="main" />
	<title>User Registration</title>
</head>

<body>

	<div class="nav">
		<span class="menuButton"><a class='home' href="${createLinkTo(dir:'')}">Home</a></span>
	</div>

	<div class="body">
		<h1>User Registration</h1>
		<g:if test="${flash.message}">
		<div class="message">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${person}">
		<div class="errors">
			<g:renderErrors bean="${person}" as="list" />
		</div>
		</g:hasErrors>

		<g:uploadForm action="save">
		<div class="dialog">
		<table>
		<tbody>

			<tr class='prop'>
				<td valign='top' class='name'><label for='login'>Login Name:</label></td>
				<td valign='top' class='value ${hasErrors(bean:person,field:'login','errors')}'>
					<input type="text" name='login' value="${person?.login?.encodeAsHTML()}"/>
				</td>
			</tr>

			<tr class='prop'>
				<td valign='top' class='name'><label for='userRealName'>Full Name:</label></td>
				<td valign='top' class='value ${hasErrors(bean:person,field:'userRealName','errors')}'>
					<input type="text" name='userRealName' value="${person?.userRealName?.encodeAsHTML()}"/>
				</td>
			</tr>

			<tr class='prop'>
				<td valign='top' class='name'><label for='password'>Password:</label></td>
				<td valign='top' class='value ${hasErrors(bean:person,field:'password','errors')}'>
					<input type="password" name='password' value="${person?.password?.encodeAsHTML()}"/>
				</td>
			</tr>

			<tr class='prop'>
				<td valign='top' class='name'><label for='enabled'>Confirm Password:</label></td>
				<td valign='top' class='value ${hasErrors(bean:person,field:'password','errors')}'>
					<input type="password" name='repassword' value="${person?.password?.encodeAsHTML()}"/>
				</td>
			</tr>

			<tr class='prop'>
				<td valign='top' class='name'><label for='email'>Email:</label></td>
				<td valign='top' class='value ${hasErrors(bean:person,field:'email','errors')}'>
					<input type="text" name='email' value="${person?.email?.encodeAsHTML()}"/>
				</td>
			</tr>

            <tr class="prop">
                <td valign="top" class="name">
                    <label for="photo">Photo:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean:person,field:'photo','errors')}">
                    <input type="file" id="photo" name="photo" />
                </td>
            </tr>

			%{--<tr class='prop'>--}%
				%{--<td valign='bottom' class='name'><label for='code'>Enter Code: </label></td>--}%
				%{--<td valign='top' class='name'>--}%
					%{--<input type="text" name="captcha" size="8"/>--}%
					%{--<img src="${createLink(controller:'captcha', action:'index')}" align="absmiddle"/>--}%
				%{--</td>--}%
			%{--</tr>--}%

		</tbody>
		</table>
		</div>

		<div class="buttons">
			<span class="formButton">
				<input class='save' type="submit" value="Create"></input>
			</span>
		</div>

		</g:uploadForm>
	</div>
</body>
