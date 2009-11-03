<html>
<head>
  <title><g:layoutTitle default="Grails"/></title>
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}"/>
  <link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}"/>
  <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
  <g:layoutHead/>
  <g:javascript library="application"/>
</head>
<body>
<div id="spinner" class="spinner" style="display:none;">
  <img src="${resource(dir: 'images', file: 'spinner.gif')}" alt="Spinner"/>
</div>
<div id="wrapper">
  <div id="header">

    <g:isLoggedIn>
      <dl style="margin-right:10px;margin-top:10px;">
        <dt>User</dt>
        <dd><g:loggedInUserInfo field="userRealName">Guest</g:loggedInUserInfo> -  <g:link controller="logout" action="index">sign out</g:link>
      </dl>
    </g:isLoggedIn>
    <div id="logo">
      <h1 style="font-family:Georgia;"><a href="#">Simple Scrum</a></h1>
      <p style="float :right">Say good by to Crappy Excel ;)</p>

    </div>
    %{--TODO Dsiplay when supported--}%
    <div id="search" style="display:none">
      <form method="get" action="">
        <fieldset>
          <input id="search-text" type="text" name="s" value="Search" size="15"/>
          <input type="submit" id="search-submit" value="Search"/>
        </fieldset>
      </form>
    </div>
    <!-- end #search -->
  </div>
  <!-- end #header -->
  <div id="menu">
    <ul>
      <li><a href="../">Home</a></li>
      <li><g:link controller="product">Product BackLog</g:link></li>
      <li><g:link controller="release">Releases</g:link></li>
      <li><g:link controller="sprint">Sprints</g:link></li>
      <li><g:link controller="task">Tasks</g:link></li>
      <li><g:link controller="user">Users</g:link></li>
    </ul>
  </div>
  <div id="page">
    <div id="content">
      <g:layoutBody/>
    </div>
    <div id="sidebar">
    </div>
    <div style="clear: both;">&nbsp;</div>
  </div>
</div>
<div id="footer">
  <p>Copyright (c) 2009 CRDS Web Team. All rights reserved. Version <g:meta name="app.version"/>  on Grails <g:meta name="app.grails.version"/></p>
</div>
</body>

</html>

