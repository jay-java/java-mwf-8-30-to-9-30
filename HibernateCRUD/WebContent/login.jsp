<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg }
	<form action="LoginController" method="post">
		<table>
			<tr><td>Email : <input type="text" name="email"></td></tr>
			<tr><td>Password : <input type="text" name="password"></td></tr>
			<tr><td><input type="submit" name="action" value="login"></td></tr>
		</table>
	</form>
</body>
</html>