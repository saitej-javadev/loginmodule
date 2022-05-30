package com.saitej.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saitej.dao.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	//response.sendRedirect("welcome.jsp"), 	request.setAttribute("email", email); does not display values in jsp using El
	//rd= request.getRequestDispatcher("welcome.jsp");  request.setAttribute("email", email); display values in jsp using El
	
	private static final long serialVersionUID = 1L;
//	RequestDispatcher rd =null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
       
		 LoginDao loginDao = new LoginDao();
		 
		if (loginDao.check(email, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			
			//request.setAttribute("email", email);
			//request.setAttribute("password", password);
			System.out.println(email + " " + password);
			response.sendRedirect("welcome.jsp");
		//	rd= request.getRequestDispatcher("welcome.jsp");
		
			
			
		} else {
			//request.setAttribute("email", email);
			//request.setAttribute("password", password);
			//System.out.println(email + " " + password);
			response.sendRedirect("error.jsp");
		//	rd= request.getRequestDispatcher("error.jsp");;
		}
		
		//rd.forward(request, response);

	}

}
