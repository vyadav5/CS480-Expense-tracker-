<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

	<style type="text/css">
		body {
			background: #32a856; 
		}
		a:link, a:visited {
		  background-color: #38363d;
		  color: white;
		  padding: 8px 15px;
		  text-align: center;
		  text-decoration: none;
		}
		
		a:hover, a:active {
		  background-color: green;
		  color: white;
		}
	</style>
  </head>
  
  <body>
  
<h1 style="text-align: center;">Expense & Saving Tracker</h1>
<div style="font-size: 15pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> 
		</c:when>
		<c:otherwise>
			<b> Hello, ${sessionScope.session_user.username} </b> </br>
			${totalExpense} </br>
			${totalSaving}
 		</c:otherwise>
	</c:choose>

</div>
  </body>
</html>
