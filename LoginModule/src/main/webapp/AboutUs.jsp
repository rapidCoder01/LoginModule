<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		 
		<h3>About Us Page</h3>
			 
		<div align="center"> 		 	
		 	<form action="Logout">
		 		<input type="submit" value="Logout">
		 	</form>
		</div>
		
</body>
</html>