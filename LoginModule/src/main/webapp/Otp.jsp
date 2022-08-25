<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>One time password</title>
</head>
<body>
 
	<script type="text/javascript">
	
	function validOtp(){
		if(document.form.otp.value == ""){
			alert ("Please enter your OTP");
			return false;
		}
		
	}
	</script>
 	
		<div align ="center">
	<h3>Retrieve password</h3>
				<h4>Check Email : OTP has been sent to your email id</h4>
	
		<form name="form" action="ValidateOtp" method="post" onsubmit="return validOtp();">
			<table>
				<tr><td>Enter OTP :</td><td><input type="text" name="otpvalue"></td></tr>
				<tr><td><input type="submit" value="submit" ></td></tr>
				
			</table>
		</form>
</div>	
</body>
</html>