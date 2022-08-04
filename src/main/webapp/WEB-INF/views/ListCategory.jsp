<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Category</title>
</head>
<body>
	<h2>List Category</h2>
	<table border="1">
		<tr>
			<th>Category Name</th>

			<th>User ID</th>
		</tr>
		<c:forEach items="${category}" var="c">
			<tr>
				<td>${c.categoryName}</td>
				<td>${c.userId}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>