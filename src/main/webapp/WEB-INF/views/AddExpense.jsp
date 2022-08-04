<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	%>
	<form action="addexpense" method="post">
		Category:<select name="category" id="id_category">
			
			<c:forEach items="${category}" var="c">
				<option value="${c.categoryId}">${c.categoryName}</option>
			</c:forEach>


		</select> <br><br>
		
		Sub Category:<select id="id_subcategory" name="subCategoryName">
		<option value="select">Select</option>
		</select><br><br>
		
		Date:<input type="date" name="date" /><br> <br>
		
		Time:<input type="time" name="time" /><br><br>
		
		Description:<input type="text" name="description" /><br><br>
		
		Amount:<input type="text" name="amount" /><br><br>
		
		Type of Payment:<select name="typeofpayment">
			<c:forEach items="${amountType}" var="i">
				<option value="${i.accountType} ${i.cardNo} ${i.upiId}">${i.accountType} ${i.cardNo} ${i.upiId}</option>
			</c:forEach>
		</select><br> <br>
		<input type="hidden" value="<%=user.getUserId()%>" name="userId" />
		<button>Add Expense</button>
	</form>
	<script>
	
		$(document).ready(function(){
			console.log("fun");
			$("#id_category").change(function(){
				console.log("id_category");
			var id = document.getElementById("id_category").value;
						let url = "http://localhost:9898/listSubCategoryById?categoryId="+id;	
						 	 
						$.get(url)
						.done(function(data){
							console.log("gj"+data);
							let subcategory = $("#id_subcategory");
							subcategory.empty() 
								for(let i=0;i<data.length;i++){ 
								if(data[i].categoryId == id){
									subcategory.append("<option value="+data[i].subCategoryName+">"+data[i].subCategoryName+"</option>");
								}
							}
							
						}).fail(function(){
							console.log("something went wrong"); 
						});
			})	
		})
		
		
	</script>
</body>
</html>