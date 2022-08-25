<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>

	<script type="text/javascript">
	
	function validLogin(){
		if(document.form.username.value == ""){
			alert ("Please enter your username");
			return false;
		}
		if(document.form.password.value == ""){
			alert ("Please enter your password");
			return false;
		}
	}
	
	
	</script>
	
	<div align ="center">
	<h1>LOGIN</h1>
		<form name="form" action="Login" method="post" onsubmit="return validLogin();">
			<table>
				<tr><td>Username :</td><td><input type="text" name="username"></td></tr>
				<tr><td>Password :</td><td><input type="password" name="password"></td></tr>
				<tr><td><input type="submit" value="Login" ></td>
				<td><a href = "ForgotPassword.jsp">Forgot password ?</a></td>
				<tr><td><a href = "AdminLogin.jsp">Admin</a></td>
				<td><a href = "Register.jsp">Register</a></td></tr>
			</table>
		</form>
</div>	

</body>
</html>