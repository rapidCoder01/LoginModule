<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>

<script type="text/javascript">

function resetPassword(){
	if(document.form.username.value == ""){
		alert ("Please enter your username");
		return false;
	}
	if(document.form.emailid.value == ""){
		alert ("Please enter your emailid");
		return false;
	}
	
}


</script>
	
		<div align ="center">
	<h3>Retrieve password</h3>
				<h4>Please Enter your correct credentials to retrieve password</h4>
		<form name="form" action="ForgotPassword" method="post" onsubmit="return resetPassword();">
			<table>
				<tr><td>Username :</td><td><input type="text" name="username"></td></tr>
				<tr><td>Email Id :</td><td><input type="email" name="emailid"></td></tr>
				<tr><td><input type="submit" value="Retrieve password" ></td>
				
			</table>
		</form>
</div>	
</body>
</html>