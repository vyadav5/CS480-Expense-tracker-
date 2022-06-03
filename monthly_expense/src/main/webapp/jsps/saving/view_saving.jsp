<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>View Savings</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

     <link rel="stylesheet" href="../style/styles.css">

  </head>
  
  <body>
  <h2>View Savings</h2>

<p style="color: green; font-weight: 900"> ${msg}</p>

<form action="<c:url value='/Saving/custom'/>" method="post">
	<input type="hidden" name="method" value="Add Saving"/>
	  By Date：	<input type="date" name="date" required />
	<input type="submit" value="Get savings"/> <br> <br>
</form>
<hr>
<form action="<c:url value='/Saving/custom'/>" method="post">
	<input type="hidden" name="method" value="Add Saving"/>
	  By Year：	<input type="number" min="2000" name="year" required/>
	<input type="submit" value="Get savings"/> <br> <br>
</form>
<hr>	
<form action="<c:url value='/Saving/custom'/>" method="post">
	<input type="hidden" name="method" value="Add Saving"/>
	  By Month：<input type="month" name="month" required/>
	<input type="submit" value="Get savings"/> <br> <br>	
</form>
	
	<button type="button" name="back" onclick="history.back()">back</button>

  </body>
</html>
