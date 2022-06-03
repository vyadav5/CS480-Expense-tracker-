<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Manage Savings</title>
 
  <link rel="stylesheet" href="../jsps/style/styles.css">
 
</head>
<body>
	<h2>Manage Savings</h2>
	<table>
	<tr>
		<th>Saving ID</th>
		<th>User email</th>
		<th>Saving Name</th>
		<th>Saving Amount</th>
		<th>Creation Date</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${SavingList}" var="saving">
		<tr>
			<td>${saving.saving_id }</td>
			<td>${saving.email }</td>
			<td>${saving.saving_name }</td>
			<td>${saving.saving_amount }</td>
			<td>${saving.creation_date }</td>		
			<td>
				<form action="<c:url value='/jsps/saving/update_saving.jsp?saving_id=${saving.saving_id}&saving_name=${saving.saving_name}
				&saving_amount=${saving.saving_amount}'/>" method="post">
					<button style="background-color: gray; color: white">Update saving</button>
				</form>  			 
			</td>
			<td>
				<form action="<c:url value='/Saving/delete'/>" method="post">
					<input type="hidden" name="saving_id" value="${saving.saving_id}" />
					<button style="background-color: red; color: white">Delete saving</button>
				</form>  			 
			</td>
		</tr>
	</c:forEach>
	
	<button type="button" name="back" onclick="history.back()">back</button>
	
</table> 
</body>
</html>