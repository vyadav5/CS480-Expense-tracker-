<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>View Savings</title>
 
  <link rel="stylesheet" href="../jsps/style/styles.css">

</head>
<body>
	<h2> View Savings </h2>
	<table>
	<tr>
		<th>Saving ID</th>
		<th>User email</th>
		<th>Saving Name</th>
		<th>Saving Amount</th>
		<th>Creation Date</th>
	</tr>
	<c:forEach items="${SavingList}" var="saving">
		<tr>
			<td>${saving.saving_id }</td>
			<td>${saving.email }</td>
			<td>${saving.saving_name }</td>
			<td>${saving.saving_amount }</td>
			<td>${saving.creation_date }</td>			
		</tr>
	</c:forEach>
	<button type="button" name="back" onclick="history.back()">back</button>
</table> 
</body>
</html>