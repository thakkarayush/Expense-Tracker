<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sub Category</title>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	%>
	<form action="savesubcategory" method="post">
		Type of Category:<select name="categoryId">

			<c:forEach items="${category}" var="c">
				<option value="${c.categoryId}">${c.categoryName}</option>
			</c:forEach>
		</select> Sub Category Name:<input type="text" name="subCategoryName"><br>
		<br> <input type="hidden" name="userId"
			value="<%=user.getUserId()%>">
		<button type="submit">Add</button>
	</form>
</body>
</html>