<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Reservation System</title>
<link rel="stylesheet" href="css/LoginPage.css">
<script type="text/javascript" src="js/LoginPage.js"></script>
</head>
<body>
<div id="mainblock">
<div id="image">
<img alt="Bus Image" src="images/bus-reservation.jpg">
</div>
<div id="form">
Existing User!!!
<h1>Login</h1>
<form action="/home" onsubmit="return validateForm()" method="post">
<input type="email" id="email" name="email" placeholder="Email" required><br>
<input type="password" id="password" name="password" placeholder="Password" required><br>
<input type="checkbox" id="remember" name="remember">
<label for="vehicle1">Remember Me</label><br>
<input type="submit" id="submit" value="Log In"/>
<br><br><br><br>
<label for="signup">New User!!!</label><br>
<a id="signup" href="/signup">Create an account</a>
</form>
</div>
</div>


</body>
</html>