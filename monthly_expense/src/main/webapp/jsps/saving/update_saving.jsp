<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Saving</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

     <link rel="stylesheet" href="../style/styles.css">

  </head>
  
  <body>
  <h2>Update Saving</h2>

<p style="color: green; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/Saving/update'/>" method="post">
	<input type="hidden" name="method" value="saving"/>	
	<%
	String saving_id = request.getParameter("saving_id");
	String saving_name = request.getParameter("saving_name");
	String saving_amount = request.getParameter("saving_amount");
	%>
	  <input type="hidden" name="saving_id" value='<%=saving_id%>' /><br/>
	  Saving Name：	<input type="text" name="name" value='<%=saving_name%>' required/><br/>
	Saving Amount：	<input type="number" min="0" name="amount" value='<%=saving_amount%>'  required/><br/>
	<input type="submit" value="Update"/> <br> <br>
	
	<button type="button" name="back" onclick="history.back()">back</button>
</form>
  </body>
</html>
