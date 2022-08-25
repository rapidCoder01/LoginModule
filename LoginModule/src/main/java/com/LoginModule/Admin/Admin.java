package com.LoginModule.Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginModule.AdminBean.AdminBean;
import com.LoginModule.AdminDao.AdminDao;


@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		AdminDao Admindao =new AdminDao();
    		
    		response.setContentType("text/html");
    		
    		String Adminname = request.getParameter("Adminname");
    		String Adminpwd = request.getParameter("Adminpwd");
    		AdminBean Adminbean = new AdminBean();
    		Adminbean.setAdminname(Adminname);
    		Adminbean.setAdminpwd(Adminpwd);
    		
    		if(Admindao.validate(Adminbean)) {
    			HttpSession session = request.getSession();
    			session.setAttribute("a", Adminname);
    			response.sendRedirect("Admin.jsp");
    		}
    		else {
    			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
    			rd.include(request, response);
    		}
    		
    	}
}
