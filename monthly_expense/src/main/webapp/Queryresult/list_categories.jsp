<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Manage Categories</title>
 
  <link rel="stylesheet" href="../jsps/style/styles.css">

</head>
<body>
	<h2> Manage Categories </h2>
	<table>
	<tr>
		<th>Category ID</th>
		<th>Category Name</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${CategoryList}" var="category">
		<tr>
			<td>${category.category_id }</td>
			<td>${category.category_name }</td>
			<td>
				<form action="<c:url value='/jsps/category/update_category.jsp?category_id=${category.category_id}&category_name=${category.category_name}' />" method="post">
					<button style="background-color: gray; color: white">Update category</button>
				</form>  			 
			</td>
			<td>
				<form action="<c:url value='/Category/delete'/>" method="post">
					<input type="hidden" name="category_id" value="${category.category_id}" />
					<button style="background-color: red; color: white">Delete category</button>
				</form>  			 
			</td>
		</tr>
	</c:forEach>
	
	<button type="button" name="back" onclick="history.back()">back</button>
</table> 
</body>
</html>