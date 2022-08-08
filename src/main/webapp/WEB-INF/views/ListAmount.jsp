<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Account Type</td>
			<td>Amount</td>
			<td>Card Number</td>
			
		</tr>	
	
	<c:forEach items="${amount}" var="i">
		<tr>
			<td>${i.accountType}</td>
			<td>${i.amount}</td>
			<td>${i.cardNo}</td>
			
		</tr>
	
	</c:forEach>
	</table>
	<c:forEach items="${balance}" var="b">
		
		Available balance:	${b.amount}
	
	</c:forEach>
</body>
</html>