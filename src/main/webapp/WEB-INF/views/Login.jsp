<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login Form</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts_login/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css_login/style.css">
</head>
<body>

	<div class="main">
		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images_login/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="signup" class="signup-image-link">Create an account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Login</h2>
						<s:form action="login" method="post" modelAttribute="login" class="register-form" id="login-form">
						
							<div class="form-group">
								<label for="your_name">Email</label><br><br>
								<s:input path="email" />
								<s:errors path="email"></s:errors>
							</div>
							<div class="form-group">
								<label for="your_pass">Password</label><br><br>
								<s:password path="password" />
								<s:errors path="password"></s:errors>
							</div>
							
							<div class="form-group form-button">
								
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Login" />
							</div>
						</s:form> 
						
					</div>
				</div>
			</div>
		</section>

	</div>

	<!-- JS -->
	<script src="vendor_login/jquery/jquery.min.js"></script>
	<script src="js_login/main.js"></script>
</body>

</html>