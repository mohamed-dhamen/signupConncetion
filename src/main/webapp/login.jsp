<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>

		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="from">
			<form action="Login" method="post">
			<label for="name" >nom:</label>
			<input type="text" name="prenom" id="name"/><br/>
			<label for="lname" >lastName:</label>
			<input type="text" name="nom" id="lname"/><br/>
			<label for="email" >email:</label>
			<input type="text" name="email" id="email"/><br/>
			<label for="pwd" >password</label>
			<input type="password" name="pwd" id="pwd"/><br/>  
			<input type="submit" value="sign-up" />
			</form>
		</div>
	
	</body>
</html>