<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
 public void jspInit(){
	String defaultInitParam = getServletConfig().getInitParameter("initParamJSP");
	ServletContext servletContext = getServletContext();
	servletContext.setAttribute("initParamJSP", defaultInitParam);
	
}

%>
 
 Default init params: <%= getServletConfig().getInitParameter("initParamJSP") %> <br><br>
 
 <!-- To run any INIT params before JSP_SERVICE is called , we need to override the init method -->

The value in the servlet context is: <%= getServletContext().getAttribute("initParamJSP") %>

</body>
</html>