<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page isELIgnored="false" %> 
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<h2><a href="about">About</a></h2>
<h2><a href="register">Register</a></h2>
<%-- <%String name = (String)request.getAttribute("name"); %>
<h3><%=name %></h3>

<%List<String> list = (List)request.getAttribute("list"); %>
<%out.print(list); %> --%>

<h2>${name }</h2>
<h2>${list }</h2>
<c:forEach items="${list }" var="s">
	<h1>${s }</h1>
</c:forEach>
</body>
</html>
