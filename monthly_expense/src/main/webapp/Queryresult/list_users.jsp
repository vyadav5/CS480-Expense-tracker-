<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>All Users</title>
 
  <link rel="stylesheet" href="../jsps/style/styles.css">

</head>
<body>
	<h3 align="center"> All Users </h3>
	<table>
	<tr>
		<th>Name</th>
		<th>Email</th>
	</tr>
<c:forEach items="${UserList}" var="user">
	<tr>
		<td>${user.username }</td>
		<td>${user.email }</td>
	</tr>
</c:forEach>
</table>
	<button type="button" name="back" onclick="history.back()">back</button>

</body>
</html>