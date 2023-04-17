<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UserController" method="post">
		<table>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>