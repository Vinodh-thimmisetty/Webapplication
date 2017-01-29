<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page language="java" import="com.mvc.model.User"%>
<%@ page language="java" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	Login Successful
	<!-- Session scope 	 <% //User user1= (User)session.getAttribute("user"); %> <% // User user2= (User)request.getAttribute("user"); %>
	-->
	<!--  	User Name :: <% //user1.getUserName()	%>	-->
	<!--  JSTL way of accessing java objects -->
	<jsp:useBean id="user" class="com.mvc.model.User" scope="request">
		<jsp:setProperty property="pwd" name="user" param="pwd" />
		<jsp:setProperty property="userName" name="user" value="userName pwd" />
	</jsp:useBean>
	User Name from JSTL ::: <%= user.getUserName() %> <br>
	Value from jsp Property :: <jsp:getProperty property="userName" name="user"/><br>
	<!--  Request parameters from jsp:get property -->
	Password passed into the Request is :: <jsp:getProperty property="pwd" name="user" />
</body>
</html>