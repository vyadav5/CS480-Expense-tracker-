<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

     <link rel="stylesheet" href="../style/styles.css">

  </head>
  
  <body>
  <h1>Login</h1>

<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/UserServletLogin'/>" method="post">
	<input type="hidden" name="method" value="login"/>
		Email：	<input type="email" name="email" required/><br/>
	Password：	<input type="password" name="password" required/><br/>
	<input type="submit" value="Login"/> <br><br>
	
	<button type="button" name="back" onclick="history.back()">back</button>
	
</form>
  </body>
</html>
