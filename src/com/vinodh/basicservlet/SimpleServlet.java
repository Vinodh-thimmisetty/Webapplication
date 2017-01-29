package com.vinodh.basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creating Servlet mapping using ANNOTAIONS
 * 
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "This is similar to a Java Class having main method, but instead of running the application in our local machine, we can deploy the application to external Server", urlPatterns = { "/SimpleServlet" })
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet from GET method!!!!");
	 	PrintWriter printWriter = response.getWriter();
					printWriter.println("<h3>Hello servlet Get MEthod !!!</h3>");
		
	}

}
