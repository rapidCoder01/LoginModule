<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	
		<% 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
			if(session.getAttribute("username")==null){
				response.sendRedirect("index.jsp");
			}
		 %>
		 
		<div align="center"> 
		 	<h2>Welcome to HomeCare ${username}</h2>
		 	
		 	<form action="Logout">
		 		<input type="submit" value="Logout">
		 	</form>
		</div>
		<a href ="AboutUs.jsp">About Us</a>
		
</body>
</html>