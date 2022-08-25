package com.LoginModule.ForgotPassword;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginModule.Register.Dao;

/**
 * Servlet implementation class Otp 
 */
@WebServlet("/ValidateOtp")
public class ValidateOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString(); 
		String emailid = session.getAttribute("emailid" ).toString();
		int otp = (int) session.getAttribute("otp");
		
		
		int value = Integer.parseInt(request.getParameter("otpvalue"));
		boolean status = false;
 
		Dao dao = new Dao();
		dao.loadDriver();
		Connection con = dao.getConnection();
		PreparedStatement st ;
		
		if(value == otp) {
			
			// Sending password to email id..........................		
			
						System.out.println("preparing to send....");
						try {
							
							st = con.prepareStatement("select password from homecare.accountdetails where username =\""+username+"\";");
							ResultSet rs =st.executeQuery();
							status = rs.next();
							String output = rs.getString("password");
							if(status) { 
								
								String message =  "Dear Customer,\n"
										+ "\n"
										+ "\n"
										+ "With reference to your password generation request initiated through imap format and requested by you, is\n"
										+ "now completed the password for your account, is given below\n"
										+ "\n"
										+ "Password for your HomeCare Account username "+username+" is : "+output+"\n"
										+ ""
										+ "If you did not attempt the request through Homecare forgotpassword that triggered this email,please\n"
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
								String subject = "HomeCare : Generated Password";
								String to = emailid;
								String from = "chandan9905244361@gmail.com";
								
								Mailer.sendEmail(message, subject, to, from);

								out.println("<div align=\"center\"><h4>Check your mail :"
										+ " Password has been sent to your mail id</h4>");
								
								out.println("<a href = \"index.jsp\">Back to Login Page</a></div>");
								
							// Deleting Values from Otp table .........................
								
								
								try {
									st = con.prepareStatement("delete from homecare.otp where id > 0;");

									int result = st.executeUpdate();
									if(result > 0) 
										System.out.println("Deletion Successful");
									
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else {
								out.println("<script type=\"text/javascript\">");  
								out.println("alert('Wrong Otp');");  
								out.println("</script>");
							
							}
							
							
							
						} catch (SQLException e) {

							e.printStackTrace();
						}
												
		}
		
	}

}
