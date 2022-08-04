<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
<%UserBean user = (UserBean)session.getAttribute("user");%> 
<h2>Add Category</h2>
<form method="post" action="savecategory">
		<label>Add expense category :</label> 
		<input type="text" name="categoryName">
			
		
		<input type="hidden" name="userId" value="<%=user.getUserId()%>">
		<input type="button" name="Add">
		<br> <input type="submit" value="setcategory" />
		
	</form>
</body>
</html>