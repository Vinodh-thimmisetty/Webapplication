<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
  String name = request.getParameter("user"); // Request
	if (name != "" && name != null) {
		session.setAttribute("savedUserName", name);// Session
		application.setAttribute("applicationContextName", name); // application context
		pageContext.setAttribute("pageContextUserName", name);
		pageContext.findAttribute("savedUserName"); // find the scope in which attribute exits
		pageContext.setAttribute("jaffa", name, PageContext.APPLICATION_SCOPE);
	}%>
	User Name is
	<%= name  %><br> session User Name is
	<%= session.getAttribute("savedUserName") %><br>
	Application context User Name is
	<%=	application.getAttribute("applicationContextName")%>
<br>
pageContext context User Name is
	<%=	pageContext.getAttribute("pageContextUserName")%>


</body>
</html>