<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg }
<table>
<tr>
<th>id</th>
<th>fname</th>
<th>lname</th>
<th>email</th>
<th>password</th>
</tr>
<tr>
<td>${u.uid }</td>
<td>${u.fname }</td>
<td>${u.lname }</td>
<td>${u.email }</td>
<td>${u.password }</td>
<td><a href="HomeController?action=editdata&uid=${u.uid }">Edit</a></td>
<td><a href="HomeController?action=deletedata&uid=${u.uid }">Delete</a></td>
</tr>
</table>
<br><br><br>
<c:if test="${u1.uid > 0}">
<form action="HomeController" method="post">
<table>
<tr><td><input type="hidden" name="uid" value=${u1.uid }></td></tr>
<tr><td>First name : </td><td><input type="text" name="fname" value="${u1.fname }"></td></tr>
<tr><td>last name : </td><td><input type="text" name="lname" value="${u1.lname }"></td></tr>
<tr><td>Email : </td><td><input type="text" name="email" value="${u1.email }"></td></tr>
<tr><td>password : </td><td><input type="text" name="password" value="${u1.password }"></td></tr>
<tr><td><input type="submit" value="update"></td></tr>
</table>
</form>
</c:if>
</body>
</html>