<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="display.jsp" method="post">
		<table style="background-color: cyan; margin: auto; border: 1">
			<tr>
				<td>Enter user Email</td>
				<td><input type="text" name="email" /></td>
			</tr>

			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="login" /></td>
			</tr>
		</table>
	</form>
	<h4>
		Session Id:
		<%=session.getId()%></h4>
</body>
</html>