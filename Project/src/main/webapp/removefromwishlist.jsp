<%@page import="Dao.WishListDao"%>
<%@page import="Model.WishList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int id=  Integer.parseInt(request.getParameter("wid"));
WishListDao.removeFromWishlist(id);
response.sendRedirect("customer-wishlist.jsp");
%>
</body>
</html>