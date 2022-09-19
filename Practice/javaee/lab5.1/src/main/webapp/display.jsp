<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diplay Page</title>
</head>
<body>
	<h4>
		Email :
		<%
	out.print(request.getParameter("email"));
	%>
	</h4>
	<h4>
		Password :
		<%
	out.print(request.getParameter("pass"));
	%>
	</h4>
	<h4>
		Session Id:
		<%=session.getId()%></h4>
</body>
</html>