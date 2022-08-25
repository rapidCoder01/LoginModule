package com.LoginModule.Login;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginModule.LoginBean.Loginbean;
import com.LoginModule.LoginDao.LoginDao;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDao loginDao = new com.LoginModule.LoginDao.LoginDao();
		
		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Loginbean loginbean = new com.LoginModule.LoginBean.Loginbean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);
		
		if (loginDao.validate(loginbean))
		{
//			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//			rd.forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("Home.jsp");
		}
		else 
		{
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.include(request, response);
//			request.sendRedirect("Error.jsp");
		}	
		}

}
