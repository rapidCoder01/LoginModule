package com.LoginModule.Home;
//package com.HomeCare.Home;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@WebServlet("/Home")
//public class Home extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		
//		HttpSession session = request.getSession();
//		String u = session.getAttribute("username").toString();
//		
//		out.print("<div align=\"center\"><h3>Welcome to Home Care "+u+"</h3></div>");
//
//		
//		
//		
//		out.print("<div align=\"center\"><a href =\"./Logout\">Logout</a></div>");
//		
//	}
//
//}
