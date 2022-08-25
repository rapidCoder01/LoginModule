<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<div align ="center">
	<% 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
			if(session.getAttribute("a")==null){
				response.sendRedirect("AdminLogin.jsp");
			}
		 %>
		 
		<div align="center"> 
		 	<h2>Welcome ${username}</h2>
		 	
		 	<form action="Logout">
		 		<input type="submit" value="Logout">
		 	</form>
		</div>
</div>
</body>
</html>