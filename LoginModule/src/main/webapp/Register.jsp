<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserRegister</title>
</head>
<body>

<script> 
function validate()
{ 
     var fullname = document.form.fullname.value;
     var emailId = document.form.emailId.value;
     var username = document.form.username.value; 
     var password = document.form.password.value;
     var mobileNo= document.form.mobileNo.value;
     
     if (fullname==null || fullname=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (emailId==null || emailId=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (username==null || username=="")
     { 
     alert("Username can't be blank"); 
     return false; 
     }
     else if(password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     else if (mobileNo==null || mobileNo=="")
     { 
     alert("Mobile No can't be blank"); 
     return false;
     }
 } 
</script>
	<div align ="center">
	<h1>User Registration</h1>
		<form name="form" action="Register" method="post" onsubmit="return validate();">
			<table>
				<tr><td>Full Name :</td><td><input type="text" name="fullname"></td></tr>
				<tr><td>User Name :</td><td><input type="text" name="username"></td></tr>
				<tr><td>Password  :</td><td><input type="password" name="password"></td></tr>
				<tr><td>Mobile No :</td><td><input type="number" name="mobileno"></td></tr>
				<tr><td>Email Id :</td><td><input type="email" name="emailId"></td></tr>
				
				<tr><td><input type="submit" value="Register"></td>
				
				<td><a href="http://localhost:8080/HomeCare/index.jsp">Already Registered ?</a></td></tr>
				<tr><td><input type="reset" value="Reset"></input></td></tr>
				
			</table>
		</form>
	</div>
</body>
</html>