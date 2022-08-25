package com.LoginModule.Register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mobileno = request.getParameter("mobileno");
		String emailId = request.getParameter("emailId");
		
		Dao dao = new Dao();
		dao.loadDriver();
		Connection con = dao.getConnection();
		PreparedStatement st ;
		try {
			st = con.prepareStatement("insert into Homecare.accountDetails (fullname, username, password, mobileno, emailid) "
					+ "values( ?, ?, ?, ?, ?);");

			st.setString(1, fullname);
			st.setString(2, username);
			st.setString(3, password);
			st.setString(4, mobileno);
			st.setString(5, emailId);
			
			int rs = st.executeUpdate();
			
			if(rs > 0) {
					

				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Registration Successful');");  
				out.println("</script>");
				
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);

				}

			
		}catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
}
