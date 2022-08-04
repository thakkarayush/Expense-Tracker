<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Amount</title>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	%>
	<form method="post" action="saveexistingamount">
		<label>Question :</label> <select name="accountType" id="type">
			<option disabled="disabled" selected="selected">--Select
				type--</option>
			<option value="cash">Cash</option>
			<option value="paytm">Paytm</option>
			<option value="creditcard">Credit Card</option>
			<option value="debitcard">Debit Card</option>
		</select><br>
		<br>

		<div id="amount">
			<label>Amount :</label> <input type="text" name="amount"><br>
			<br>
		</div>

		<div id="cardno">
			<label>Card Number(Last 4 digit) :</label> <input type="text"
				name="cardNo"><br>
			<br>
		</div>

		<div id="upiid">
			<label>UPI ID :</label> <input type="text" name="upiId"><br>
			<br>
		</div>

		<input type="submit" name="setamount" /> <input type="hidden"
			name="userId" value="<%=user.getUserId()%>" />
	</form>
	<script type="text/javascript">
		document.addEventListener('DOMContentLoaded', function() {

			document.querySelector("#type").onchange = function() {

				if (this.value == 'creditcard' || this.value == 'debitcard') {
					document.querySelector("#upiid").style.display = 'none';
					document.querySelector("#cardno").style.display = 'block';
					document.querySelector("#amount").style.display = 'block';
				}
				if (this.value == "cash") {
					document.querySelector("#upiid").style.display = 'none';
					document.querySelector("#cardno").style.display = 'none';
					document.querySelector("#amount").style.display = 'block';
				}
				if (this.value == "paytm") {
					document.querySelector("#upiid").style.display = 'block';
					document.querySelector("#cardno").style.display = 'none';
					document.querySelector("#amount").style.display = 'block';
				}
			}
		})
	</script>
</body>
</html>