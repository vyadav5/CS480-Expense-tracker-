<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">

	<style>
		a:link, a:visited {
		  background-color: #cc2353;
		  color: white;
		  padding: 8px 15px;
		  border-radius: 5px;		  
		  text-align: center;
		  text-decoration: none;
		}
		
		a:hover, a:active {
		  background-color: black;
		  color: white;
		}
	</style>
  </head>
  <body>
  
  <p style="color: green; font-weight: 900"> ${msg}</p> 
  	<div>	
  	
    <h2>Expenses</h2>
    	<a href="<c:url value='/jsps/expense/add_expense.jsp'/>" target="body">Add Expense</a> |
    	<a href="<c:url value='/Expense/findByID'/>" target="body">Manage Expenses</a> |   
        <a href="<c:url value='/jsps/expense/view_expense.jsp'/>" target="body">View Expenses</a><br><br>
    </div>
    <hr>
    <div>
    <h2>Savings</h2>
    	<a href="<c:url value='/jsps/saving/add_saving.jsp'/>" target="body">Add Saving</a> |
    	<a href="<c:url value='/Saving/findByID'/>" target="body">Manage Savings</a> | 
		<a href="<c:url value='/jsps/saving/view_saving.jsp'/>" target="body">View Savings</a><br><br>      
    </div>
     <hr>
    <div>
    <h2>Categories</h2>
    	<a href="<c:url value='/jsps/category/add_category.jsp'/>" target="body">Add Category</a> |
    	<a href="<c:url value='/Category/list'/>" target="body">Manage categories</a><br><br>
    </div>
    <hr>
   
    <h2>Other actions</h2>
   	<a href="<c:url value='/jsps/user/initialize.jsp'/>" target="_parent">Initialize Database</a> |
	<a href="<c:url value='/Expense/findAll'/>" target="body"> All Expenses</a> | 
	<a href="<c:url value='/Saving/findAll'/>" target="body">All savings</a>
   
    
  </body>
</html>
