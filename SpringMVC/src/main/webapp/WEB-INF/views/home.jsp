<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Contact</th>
				<th scope="col">Address</th>
				<th scope="col">Email</th>
				<th scope="col">Password</th>
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="u">
				<tr>
					<th scope="row">${u.id }</th>
					<td>${u.name }</td>
					<td>${u.contact }</td>
					<td>${u.address }</td>
					<td>${u.email }</td>
					<td>${u.password }</td>
					<td><a href="update/${u.id }">Edit</a></td>
					<td><a href="delete/${u.id }">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h1><a href="register">AddUser</a></h1>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>