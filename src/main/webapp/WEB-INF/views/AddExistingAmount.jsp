<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Amount</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	%>
	<form method="post" action="saveexistingamount">
		<label>Type :</label> 
		
		<select name="accountType" id="id_type">
		<option disabled="disabled" selected="selected">--Select type--</option>
			<c:forEach items="${amountType}" var="i">
			
				<option value="${i.accountType}">${i.accountType}</option>
			</c:forEach>
		</select>
		<br>
		<br>
		
		<div id="amount">
			<label>Amount :</label> <input type="text" name="amount"><br>
			<br>
		</div>

		<div id="cardno">
			<label>Card Number(Last 4 digit) :</label> 
			<select id="id_number" name="cardNo">
				<option value="select">Select</option>
			</select>
			<br>
			<br>
		</div>

		
		<input type="submit" name="setamount" /> <input type="hidden"
			name="userId" value="<%=user.getUserId()%>" />
	</form>
	<script type="text/javascript">
		document.addEventListener('DOMContentLoaded', function() {

			document.querySelector("#type").onchange = function() {

				if (this.value == 'creditcard' || this.value == 'debitcard' || this.value == "paytm") {
					document.querySelector("#cardno").style.display = 'block';
					document.querySelector("#amount").style.display = 'block';
				}
				if (this.value == "cash") {
					document.querySelector("#cardno").style.display = 'none';
					document.querySelector("#amount").style.display = 'block';
				}
				
			}
		})
	</script>
	<script>
	
		$(document).ready(function(){
			console.log("fun");
			$("#id_type").change(function(){
				console.log("id_type");
					var type = document.getElementById("id_type").value;
					 let url = "http://localhost:9898/listCardNumberById?amountType="+type;
						 /* let url = "http://ec2-52-204-157-26.compute-1.amazonaws.com:5432/listSubCategoryById?categoryId="+id;	  */
						$.get(url)
						.done(function(data){
							console.log("gj"+data);
							let cardno = $("#id_number");
							cardno.empty() 
								for(let i=0;i<data.length;i++){ 
								if(data[i].accountType == type){
									cardno.append("<option value="+data[i].cardNo+">"+data[i].cardNo+"</option>");
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