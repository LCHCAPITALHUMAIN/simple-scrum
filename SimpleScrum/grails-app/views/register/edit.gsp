<head>
	<meta name="layout" content="main" />
	<title>Edit Profile</title>
</head>

<body>

	<div class="nav">
		<span class="menuButton"><a class='home' href="${createLinkTo(dir:'')}">Home</a></span>
	</div>

	<div class="body">
		<h1>Edit Profile</h1>
		<g:if test="${flash.message}">
		<div class="message">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${person}">
		<div class="errors">
			<g:renderErrors bean="${person}" as="list" />
		</div>
		</g:hasErrors>
        <g:if test="${person.photo}">
          <img src="<g:createLink controller='user' action='renderImage' id='${person?.id}'/>"/>
        </g:if>
		<g:form>
			<input type="hidden" name="id" value="${person.id}" />
			<input type="hidden" name="version" value="${person.version}" />
			<div class="dialog">
			<table>
				<tbody>
				<tr class='prop'>
					<td valign='top' class='name'><label for='login'>Login Name:</label></td>
					<td valign='top' class='value ${hasErrors(bean:person,field:'login','errors')}'>
						<input type="hidden" name='login' value="${person.login?.encodeAsHTML()}"/>
						<div style="margin:3px">${person.login?.encodeAsHTML()}</div>
					</td>
				</tr>

				<tr class='prop'>
					<td valign='top' class='name'><label for='userRealName'>Full Name:</label></td>
					<td valign='top' class='value ${hasErrors(bean:person,field:'userRealName','errors')}'>
						<input type="text" name='userRealName' value="${person.userRealName?.encodeAsHTML()}"/>
					</td>
				</tr>

				<tr class='prop'>
					<td valign='top' class='name'><label for='password'>Password:</label></td>
					<td valign='top' class='value ${hasErrors(bean:person,field:'password','errors')}'>
						<input type="password" name='password' value=""/>
					</td>
				</tr>

				<tr class='prop'>
					<td valign='top' class='name'><label for='enabled'>Confirm Password:</label></td>
					<td valign='top' class='value ${hasErrors(bean:person,field:'password','errors')}'>
						<input type="password" name='repassword' />
					</td>
				</tr>

				<tr class='prop'>
					<td valign='top' class='name'><label for='email'>Email:</label></td>
					<td valign='top' class='value ${hasErrors(bean:person,field:'email','errors')}'>
						<input type="text" name='email' value="${person.email?.encodeAsHTML()}"/>
					</td>
				</tr>

				<tr class='prop'>
					<td valign='top' class='name'><label for='emailShow'>Show Email:</label></td>
					<td valign='top' class='value ${hasErrors(bean:person,field:'emailShow','errors')}'>
						<g:checkBox name='emailShow' value="${person.emailShow}" ></g:checkBox>
					</td>
				</tr>

				</tbody>
			</table>
			</div>

			<div class="buttons">
				<span class="button"><g:actionSubmit class='save' value="Update" /></span>
                <span class="button"><g:link class="cancel" controller="user" action="show" id="${person?.id}">Cancel</g:link></span>
			</div>

		</g:form>
      <br/>
      <hr>
      <br/>
     <g:uploadForm action="updatePhoto">
        <input type="hidden" name="id" value="${person.id}"/>
        <input type="hidden" name="version" value="${person.version}"/>

        <div class="dialog">
          <table>
            <tbody>
            <tr class="prop">
              <td valign="top" class="name">
                <label for="photo">Change Photo:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: person, field: 'photo', 'errors')}">
                <input type="file" id="photo" name="photo"/>
              </td>
            </tr>
            </tbody>
          </table>
        </div>

        <div class="buttons">
          <span class="button"><g:actionSubmit class='save' value="Update Photo"/></span>
        </div>

      </g:uploadForm>

	</div>
</body>
