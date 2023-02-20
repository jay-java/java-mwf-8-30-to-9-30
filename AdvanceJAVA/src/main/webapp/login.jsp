<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- <%Scripltes %> --%>

<%
String msg = (String)request.getAttribute("msg");
if(msg!=null){
	out.print(msg);
}
%>

<%
String msg1= (String)request.getAttribute("msg1");
if(msg1!=null){
	out.print(msg1);
}
%>
<%
String inc= (String)request.getAttribute("incoorect");
if(inc!=null){
	out.print(inc);
}
%>

<form action="UserController" method="post">
		<table>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>