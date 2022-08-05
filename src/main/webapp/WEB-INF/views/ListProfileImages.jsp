<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profiles</title>
</head>
<body>
<h2>Profile Images</h2>
	<table border="1">
		<tr>
			<td>Image</td>
		</tr>

		<c:forEach items="${profiles}" var="p">
			<tr>
				<td><img src="${p.profileUrl}" height="200px" width="200px"/></td>
				<td> <a href="deleteprofile?profileId=${p.profileId}">Delete</a>
					
				</td>
			</tr>
			
		</c:forEach>
	</table>
</body>
</html>