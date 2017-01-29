package com.vinodh.basicservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Creating Servlet mapping using web.xml(Deployment Descriptor) Google Chrome
 * -> Tomcat -> Request -> Servlet Mappings[web.xml] -> java -> response ->
 * tomcat -> Google Chrome
 * 
 * HTTP is stateless Protocol :: It wont let server or browser save the data
 * while sending the request, Session objects come into rescue to save the
 * Request info as Attributes
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Servlet Life Cycle Methods init(created only once) -> Service(based
	 * on requests) -> Destroy(Destroyed only once)
	 * Every servlet is THread not Objects
	 * 
	 * REQUEST :: 
	 * SESSION :: Accessible across servlets
	 * CONTEXT :: Accessible across Servlets ++ Users
	 * 
	 */

	/**
	 * HTTP.GET method to Servlet :: 1. To get data from the server i.e., SELECT
	 * query to go hit the Database and return something 2. Values will be
	 * passed to request as QUERY parameters 3. Every GET method will have same
	 * action without any confirmation from the Browser i.e, we can
	 * refresh/fetch SELECT query any number of times
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hello Servlet reading from WEB.XML !!!!");
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
//request		
		String userName = request.getParameter("user");
		printWriter.write("User name passed from the Get request is " + userName);
		
// Session ==> across single browser/user, multiple session per application based on user session
		HttpSession httpSession = request.getSession();
		if (userName != "" && userName != null) {
			httpSession.setAttribute("savedUserName", userName);
		}
		printWriter.write(" Saved User name from user session " + (String) httpSession.getAttribute("savedUserName"));
//Context ==> Across the application/ multiple browser, but one per context
		ServletContext servletContext = request.getServletContext();		
		if (userName != "" && userName != null) {
		servletContext.setAttribute("savedContextUserName", userName);	
		}
		printWriter.write("User name passed from the Get request is " + (String)servletContext.getAttribute("savedContextUserName"));
				
	}

	/***
	 * HTTP.POST method to Servlet 1 :: To post some data i.e., INSERT some data
	 * into Database 2. Parameters will be passed into POST body 3. Every POST
	 * method will have same action, but if repeat browser will ask for
	 * confirmation i.e., we cannot INSERT same data again and again
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("post method---->");
		String userName = req.getParameter("user");
		String fullName = req.getParameter("fullName");
		String pwd = req.getParameter("pwd");
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.write("User name passed from the post request is " + userName + "\n || Full Name--" + fullName
				+ "\n || YOUR pwd is :-)" + pwd);

		String profession = req.getParameter("prof");
		printWriter.write("|| Your Profession is " + profession);

		String age = req.getParameter("age");
		printWriter.write("|| Your are " + age);

		// To handle Multiple selections from the request Form
		String[] location = req.getParameterValues("location");
		for (String s : location) {
			printWriter.write("|| Your location is " + s);

		}

	}
}
