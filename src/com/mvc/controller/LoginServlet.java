package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.User;
import com.mvc.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/mvcView/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		printWriter.println("finally inside login servlet");
	
		String userId = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		LoginService loginService = new LoginService();
		boolean result = loginService.authenticateUser(userId, pwd);
		 if(result){
			 User user =loginService.getUserDetails(userId);
			  //request.getSession().setAttribute("user",user);
			 //response.sendRedirect("../mvcView/success.jsp"); // browser will treat this is NEW Request
			 // We can do Redirects from one servlet to other using Request Dispatcher without behaving as new Request
			request.setAttribute("user", user);
			 RequestDispatcher requestDispatcher =  request.getRequestDispatcher("../mvcView/success.jsp");
			requestDispatcher.forward(request, response);
			return;
		}else{
			response.sendRedirect("../mvcView/login.jsp");
			return;
		}
		
		
	}

}
