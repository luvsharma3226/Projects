<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Welcome to JSP :
		<%=LocalDateTime.now()%>
	</h3>
	<h3>
		<a href="comments.jsp">Test Comments</a>
	</h3>
	<h3>
		<a href="login.jsp">Test Scriptlets </a>
	</h3>

	<h4>
		Session Id:
		<%=session.getId()%></h4>
	<h4>
		Session TimeOut:
		<%=session.getMaxInactiveInterval()%></h4>
</body>
</html>