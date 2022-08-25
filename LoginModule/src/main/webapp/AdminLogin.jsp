<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>

	<script type="text/javascript">
	
	function validLogin(){
		if(document.form.Adminname.value == ""){
			alert ("Please enter your username");
			return false;
		}
		if(document.form.Adminpwd.value == ""){
			alert ("Please enter your password");
			return false;
		}
	}
	</script>
	<div align ="center">
	<h1>ADMIN LOGIN</h1>
		<form name="form" action="Admin" method="post" onsubmit="return validLogin();">
			<table>
				<tr><td>User name :</td><td><input type="text" name="Adminname"></td></tr>
				<tr><td>Password :</td><td><input type="password" name="Adminpwd"></td></tr>
				<tr><td><input type="submit" value="Admin Login"></td>
				<td><a href="http://localhost:8080/HomeCare/index.jsp">Back</a></td></tr>
			</table>
		</form>
	</div>
</body>
</html>