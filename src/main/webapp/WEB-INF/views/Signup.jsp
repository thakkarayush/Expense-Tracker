<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts_login/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css_login/style.css">
</head>
<body>

	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
						<s:form action="saveuser" method="post" modelAttribute="user">
							<div class="form-group">
								<label for="name">First Name:</label><br><br>
								<s:input path="firstName" />
								<s:errors path="firstName"></s:errors>
							</div>
							<div class="form-group">
								<label for="email">Last Name:</label><br><br>
								<s:input path="lastName" />
								<s:errors path="lastName"></s:errors>
							</div>
							<div class="form-group">
								<label for="pass">Email:</label><br><br>
								<s:input path="email" />
								<s:errors path="email"></s:errors>
							</div>
							<div class="form-group">
								<label for="re-pass">Password:</label><br><br>
								<s:password path="password" />
								<s:errors path="password"></s:errors>
							</div>
							<div class="form-group">
							
							<label >Gender:</label><br><br><br>
								
								<table>
									<tr><td>Male:</td><td><s:radiobutton path="gender" value="male" /></td></tr>
								<tr><td>Female:</td><td><s:radiobutton path="gender" value="female" /></td></tr>
								</table>
							</div>
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</s:form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images_login/signup-image.jpg" alt="sing up image">
						</figure>
						<a href="login" class="signup-image-link">I am already member</a>
					</div>
				</div>
			</div>
		</section>



	</div>

	<!-- JS -->
	<script src="vendor_login/jquery/jquery.min.js"></script>
	<script src="js_login/main.js"></script>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>