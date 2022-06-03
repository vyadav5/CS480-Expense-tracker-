<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>View Expenses</title>
 
  <link rel="stylesheet" href="../jsps/style/styles.css">

</head>
<body>

	<h2> View Expenses </h2>
		
	<table>
	<tr>
		<th>Expense ID</th>
		<th>User email</th>
		<th>Expense Name</th>
		<th>Expense Amount</th>
		<th>Category</th>
		<th>Creation Date</th>
	</tr>
	<c:forEach items="${ExpenseList}" var="expense">
		<tr>
			<td>${expense.expense_id }</td>
			<td>${expense.email }</td>
			<td>${expense.expense_name }</td>
			<td>${expense.expense_amount }</td>
			<td>${expense.category_name }</td>
			<td>${expense.creation_date }</td>			
		</tr>
	</c:forEach>
	<button type="button" name="back" onclick="history.back()">back</button>
</table> 
</body>
</html>