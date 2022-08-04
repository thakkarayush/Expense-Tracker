<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Expense</title>
</head>
<body>
	<h2>List Expenses</h2>
	<table border="1">
		<tr>
			<th>Category</th>
			<th>Sub Category</th>
			<th>Date</th>
			<th>Time</th>
			<th>Description</th>
			<th>Amount</th>
			<th>Type Of Payment</th>
		</tr>
		<c:forEach items="${expense}" var="e">
			<tr>
				<td>${e.category}</td>
				<td>${e.subCategoryName}</td>
				<td>${e.date}</td>
				<td>${e.time}</td>
				<td>${e.description}</td>
				<td>${e.amount}</td>
				<td>${e.typeofpayment}</td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>