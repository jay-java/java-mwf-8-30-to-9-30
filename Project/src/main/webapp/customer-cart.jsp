<%@page import="java.util.Random"%>
<%@page import="Dao.CartDao"%>
<%@page import="Model.Cart"%>
<%@page import="Dao.WishListDao"%>
<%@page import="Model.WishList"%>
<%@page import="Dao.ProductDao"%>
<%@page import="Model.Product"%>
<%@page import="java.util.List"%>
<%@page import="Model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
 	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000000);
 %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->

<!DOCTYPE html>
<html lang="zxx">

<head>
<title>Bootie Ecommerce Bootstrap Responsive Web Template | Home
	:: W3layouts</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Bootie Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta tag Keywords -->

<!-- Custom-Files -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!-- Style-CSS -->
<!-- font-awesome-icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome-icons -->
<!-- /Fonts -->
<link
	href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900"
	rel="stylesheet">
<!-- //Fonts -->

</head>

<body>
	<%
	Customer c = null;
	if (session.getAttribute("data") != null) {
		c = (Customer) session.getAttribute("data");
	} else {
		response.sendRedirect("seller-login.jsp");
	}
	%>
	<!-- mian-content -->
	<div class="main-banner" id="home">
		<!-- header -->
		<header class="header">
			<div class="container-fluid px-lg-5">
				<!-- nav -->
				<nav class="py-4">
					<div id="logo">
						<h1>
							<a href="index.html"><span class="fa fa-bold"
								aria-hidden="true"></span>ootie</a>
						</h1>
					</div>

					<label for="drop" class="toggle">Menu</label> <input
						type="checkbox" id="drop" />
					<ul class="menu mt-2">
						<li class="active"><a href="customer-home.jsp">Home</a></li>
						<li>
							<!-- First Tier Drop Down --> <label for="drop-2" class="toggle">Drop
								Down <span class="fa fa-angle-down" aria-hidden="true"></span>
						</label> <a href="#">Products <span class="fa fa-angle-down"
								aria-hidden="true"></span></a> <input type="checkbox" id="drop-2" />
							<ul>
								<li><a href="customer-cart.jsp">Cart</a></li>

								<%
								List<WishList> list1 = WishListDao.getWishListByCusId(c.getId());
								%>
								<li><a href="customer-wishlist.jsp">WishList (<%=list1.size()%>)
								</a></li>
							</ul>
						</li>
						<li>
							<!-- First Tier Drop Down --> <label for="drop-2" class="toggle">Drop
								Down <span class="fa fa-angle-down" aria-hidden="true"></span>
						</label> <a href="#"><%=c.getName()%> <span class="fa fa-angle-down"
								aria-hidden="true"></span></a> <input type="checkbox" id="drop-2" />
							<ul>
								<li><a href="customer-profile.jsp">Profile</a></li>
								<li><a href="customer-change-password.jsp">Change
										Password</a></li>
								<li><a href="customer-logout.jsp">Logout</a></li>
							</ul>
						</li>
					</ul>
				</nav>
				<!-- //nav -->
			</div>
		</header>
		<!-- //header -->
	</div>

	<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Product Name</th>
				<th scope="col">Product Price</th>
				<th scope="col">Product Quantity</th>
				<th scope="col">Total</th>
			</tr>
		</thead>
		<tbody>
		<%List<Cart> list = CartDao.getCartByCusId(c.getId()); %>
		<%int net_price = 0; %>
		<%for(Cart c1:list){ %>
				<%net_price = net_price + c1.getTotal(); %>
			<tr>
				<th scope="row"><%=c1.getPname() %></th>
				<td><%=c1.getPprice() %></td>
				<td>
					<form action="CartController" method="post">
						<input type="hidden" name="cid" value="<%=c1.getCid()%>">
						<input type="number" min="1" max="10" value="<%=c1.getPqty()%>" name="pqty" onchange="this.form.submit();">
					</form>
				</td>
				<td><%=c1.getTotal() %></td>
			</tr>
			<%} %>
			
		</tbody>
	</table>
		<form method="post" action="pgRedirect.jsp">
		<table border="1">
			<tbody>
				<tr>
					<th>S.No</th>
					<th>Label</th>
					<th>Value</th>
				</tr>
				<tr>
					<td>1</td>
					<td><label>ORDER_ID::*</label></td>
					<td><input id="ORDER_ID" tabindex="1" maxlength="20" size="20"
						name="ORDER_ID" autocomplete="off"
						value="ORDS_<%= randomInt %>">
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td><label>CUSTID ::*</label></td>
					<td><input id="CUST_ID" tabindex="2" maxlength="30" size="12" name="CUST_ID" autocomplete="off" value="CUST001"></td>
				</tr>
				<tr>
					<td>3</td>
					<td><label>INDUSTRY_TYPE_ID ::*</label></td>
					<td><input id="INDUSTRY_TYPE_ID" tabindex="4" maxlength="12" size="12" name="INDUSTRY_TYPE_ID" autocomplete="off" value="Retail"></td>
				</tr>
				<tr>
					<td>4</td>
					<td><label>Channel ::*</label></td>
					<td><input id="CHANNEL_ID" tabindex="4" maxlength="12"
						size="12" name="CHANNEL_ID" autocomplete="off" value="WEB">
					</td>
				</tr>
				<tr>
					<td>5</td>
					<td><label>txnAmount*</label></td>
					<td><input title="TXN_AMOUNT" tabindex="10"
						type="text" name="TXN_AMOUNT"
						value="<%=net_price%>">
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input value="CheckOut" type="submit"	onclick=""></td>
				</tr>
			</tbody>
		</table>
		* - Mandatory Fields
	</form>
	</div>


	<!-- footer -->
	<footer>
		<div class="container">
			<div class="row footer-top">
				<div class="col-lg-4 footer-grid_section_w3layouts">
					<h2 class="logo-2 mb-lg-4 mb-3">
						<a href="index.html"><span class="fa fa-bold"
							aria-hidden="true"></span>ootie</a>
					</h2>
					<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
						laboris nisi ut aliquip ex ea commodo consequat.</p>
					<h4 class="sub-con-fo ad-info my-4">Catch on Social</h4>
					<ul class="w3layouts_social_list list-unstyled">
						<li><a href="#" class="w3pvt_facebook"> <span
								class="fa fa-facebook-f"></span>
						</a></li>
						<li class="mx-2"><a href="#" class="w3pvt_twitter"> <span
								class="fa fa-twitter"></span>
						</a></li>
						<li><a href="#" class="w3pvt_dribble"> <span
								class="fa fa-dribbble"></span>
						</a></li>
						<li class="ml-2"><a href="#" class="w3pvt_google"> <span
								class="fa fa-google-plus"></span>
						</a></li>
					</ul>
				</div>
				<div class="col-lg-8 footer-right">
					<div class="w3layouts-news-letter">
						<h3 class="footer-title text-uppercase text-wh mb-lg-4 mb-3">Newsletter</h3>

						<p>By subscribing to our mailing list you will always get
							latest news and updates from us.</p>
						<form action="#" method="post" class="w3layouts-newsletter">
							<input type="email" name="Email"
								placeholder="Enter your email..." required="">
							<button class="btn1">
								<span class="fa fa-paper-plane-o" aria-hidden="true"></span>
							</button>

						</form>
					</div>
					<div class="row mt-lg-4 bottom-w3layouts-sec-nav mx-0">
						<div class="col-md-4 footer-grid_section_w3layouts">
							<h3 class="footer-title text-uppercase text-wh mb-lg-4 mb-3">Information</h3>
							<ul class="list-unstyled w3layouts-icons">
								<li><a href="index.html">Home</a></li>
								<li class="mt-3"><a href="about.html">About Us</a></li>
								<li class="mt-3"><a href="#">Gallery</a></li>
								<li class="mt-3"><a href="#">Services</a></li>
								<li class="mt-3"><a href="contact.html">Contact Us</a></li>
							</ul>
						</div>
						<div class="col-md-4 footer-grid_section_w3layouts">
							<!-- social icons -->
							<div class="agileinfo_social_icons">
								<h3 class="footer-title text-uppercase text-wh mb-lg-4 mb-3">Customer
									Service</h3>
								<ul class="list-unstyled w3layouts-icons">

									<li><a href="#">About Us</a></li>
									<li class="mt-3"><a href="#">Delivery & Returns</a></li>
									<li class="mt-3"><a href="#">Waranty</a></li>
									<li class="mt-3"><a href="#">Terms & Condition</a></li>
									<li class="mt-3"><a href="#">Privacy Plolicy</a></li>
								</ul>
							</div>
							<!-- social icons -->
						</div>
						<div class="col-md-4 footer-grid_section_w3layouts my-md-0 my-5">
							<h3 class="footer-title text-uppercase text-wh mb-lg-4 mb-3">Contact
								Info</h3>
							<div class="contact-info">
								<div class="footer-address-inf">
									<h4 class="ad-info mb-2">Phone</h4>
									<p>+121 098 8907 9987</p>
								</div>
								<div class="footer-address-inf my-4">
									<h4 class="ad-info mb-2">Email</h4>
									<p>
										<a href="mailto:info@example.com">info@example.com</a>
									</p>
								</div>
								<div class="footer-address-inf">
									<h4 class="ad-info mb-2">Location</h4>
									<p>Honey Avenue, New York City</p>
								</div>
							</div>
						</div>


					</div>
					<div class="cpy-right text-left row">
						<p class="col-md-10">
							© 2019 Bootie. All rights reserved | Design by <a
								href="http://w3layouts.com"> W3layouts.</a>
						</p>
						<!-- move top icon -->
						<a href="#home" class="move-top text-right col-md-2"><span
							class="fa fa-long-arrow-up" aria-hidden="true"></span></a>
						<!-- //move top icon -->
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- //footer -->

</body>

</html>
