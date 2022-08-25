package com.LoginModule.ForgotPassword;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginModule.Register.Dao; 

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword") 
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String emailid = request.getParameter("emailid");
		
		boolean status = false;
		
		Dao dao = new Dao();
		dao.loadDriver();
		Connection con = dao.getConnection();
		PreparedStatement st ;

		HttpSession session = request.getSession();
		
//      ForgotPassword................
		
		try {
			st = con.prepareStatement("SELECT * FROM homecare.accountdetails where username = ? and emailid = ?");
			st.setString(1,	username);
			st.setString(2, emailid);
			ResultSet rs = st.executeQuery();
			status = rs.next();
			
			if(status) { 
				
				session.setAttribute("username", username);
				session.setAttribute("emailid", emailid);
				
					
				response.sendRedirect("Otp.jsp");
				
			}
			else {
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Check your credentials');");  
				out.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("ForgotPassword.jsp");
				rd.include(request, response);
			}
			
// Sending Otp to email id..........................		
			
			System.out.print("preparing to send....");
			
			int otp = 0;
			Random random =new Random();
			otp = random.nextInt(123456);
			 
			session.setAttribute("otp", otp);
			
			String message = "Dear Customer,\n"
							+ "\n"
							+ "\n"
							+ "With reference to your password generation request initiated through imap format and requested by you,the\n"
							+ "Otp for completing this request,is given below\n"
							+ "\n"
							+ "Otp for your HomeCare Account is : "+otp+"\n"
							+ "Submit your otp in the specified page to retrieve your password as you submit your otp\n"
							+ "in the otp page your password will be generated through another email that will be sent \n"
							+ "to you. \n"
							+ "If you did not attempt the request through Homecare forgotpassword that triggered this One Time Password,please\n"
							+ "contact through Contact page(technical support team) in Homecare portal and report this email to chandan9905244361@gmail.com\n"
							+ "\n"
							+ "\n"
							+ "Warning : Do not disclose any confidential information to anyone such as username, password, OTP etc to anyone.\n"
							+ "\n"
							+ "\n"
							+ "Yours Sincerely,\n"
							+ "HomeCare Team\n"
							+ ""
							+ ""
							+ ""
							+ ""
							+ ""
							+ "This is a system generated email. We request you not to reply this message\n";
			
			String subject = "HomeCare : Otp Confirmation";
			String to = emailid;
			String from = "chandan9905244361@gmail.com";
			
			Mailer.sendEmail(message, subject, to, from);
			
//Submitting Otp values in database.........................
			
			st = con.prepareStatement("insert into Homecare.otp (username, emailid, otp) "
				+ "values( ?, ?, ?);");
			st.setString(1, username);
			st.setString(2, emailid);
			st.setInt(3, otp);
			int result = st.executeUpdate();
			if(result > 0) 
				System.out.println("Database submission Successful..........");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		

		
	}
	
}



