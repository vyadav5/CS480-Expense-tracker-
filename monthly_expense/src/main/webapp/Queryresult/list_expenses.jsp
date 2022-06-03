<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Manage Expenses</title>

 <link rel="stylesheet" href="../jsps/style/styles.css">

</head>
<body>
	<h2> Manage Expenses </h2>
	<table >
	<tr>
		<th>Expense ID</th>
		<th>User email</th>
		<th>Expense Name</th>
		<th>Expense Amount</th>
		<th>Category</th>
		<th>Creation Date</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${ExpenseList}" var="expense">
		<tr>
			<td>${expense.expense_id }</td>
			<td>${expense.email }</td>
			<td>${expense.expense_name }</td>
			<td>${expense.expense_amount }</td>
			<td>${expense.category_name }</td>
			<td>${expense.creation_date }</td>
			<td>
				<form action="<c:url value='/jsps/expense/update_expense.jsp?expense_id=${expense.expense_id}&expense_name=${expense.expense_name}
				&expense_amount=${expense.expense_amount}&category_name=${expense.category_name}'/>" method="post">										
					<button style="background-color: gray; color: white">Update expense</button>
				</form>  			 
			</td>				
			<td>
				<form action="<c:url value='/Expense/delete'/>" method="post">
					<input type="hidden" name="expense_id" value="${expense.expense_id}" />
					<button style="background-color: red; color: white">Delete expense</button>
				</form>  			 
			</td>
		</tr>
	</c:forEach>
	<button type="button" name="back" onclick="history.back()">back</button>
</table> 
</body>
</html>