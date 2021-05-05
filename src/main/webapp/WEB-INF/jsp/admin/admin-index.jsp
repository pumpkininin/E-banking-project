<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
	<meta name="generator" content="Hugo 0.80.0">

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>




	<!-- Bootstrap core CSS -->
	<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

	<style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
	</style>


	<!-- Custom styles for this template -->
	<link href="dashboard.css" rel="stylesheet">
</head>
<body>

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
	<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="/admin/">E-banking</a>
	<button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
	<ul class="navbar-nav px-3">
		<li class="nav-item text-nowrap">
			<a class="nav-link" href="/customer/">Customer view</a>
		</li>
	</ul>
	<ul class="navbar-nav px-3">
		<li class="nav-item text-nowrap">
			<a class="nav-link" href="/logout">Sign out</a>
		</li>
	</ul>
</header>

<div class="container-fluid">
	<div class="row">
		<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
			<div class="position-sticky pt-3">
				<ul class="nav flex-column">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="/admin/">
							<span data-feather="home"></span>
							Dashboard
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/admin/customer-account">
							<span data-feather="file"></span>
							Manage customer account
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/admin/transation-list">
							<span data-feather="shopping-cart"></span>
							Manage banking transaction logs
						</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="/admin/set-rate-form">
							<span data-feather="users"></span>
							Manage money saving & loan
						</a>
					</li>


				</ul>


			</div>
		</nav>

		<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
			<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
				<h1 class="h2">Dashboard</h1>
				<div class="btn-toolbar mb-2 mb-md-0">
<%--					<div class="btn-group me-2">--%>
<%--						<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>--%>
<%--						<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>--%>
<%--					</div>--%>
					<button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
						<span data-feather="calendar"></span>
						This week
					</button>
				</div>
			</div>


			<h2>Customer lists</h2>
			<form action="/admin/add-customer-form" method="get">
				<button class="btn  btn-success">+ Add new customer</button>
			</form>
			<div class="table-responsive">
				<table class="table table-striped table-sm">
					<thead>
					<tr>
						<th>Id</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Phone number</th>
						<th>DOB</th>
						<th>Address</th>
						<th>Email</th>
						<th></th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="customer" items="${customers}">
					<tr>
						<td><c:out value="${customer.customer_id}" /></td>
						<td><c:out value="${customer.customer_firstName}"/></td>
						<td><c:out value="${customer.customer_lastName}"/></td>
						<td><c:out value="${customer.customer_phone}" /></td>
						<td><c:out value="${customer.customer_dob}" /></td>
						<td><c:out value="${customer.customer_address}" /></td>
						<td><c:out value="${customer.customer_email}" /></td>
						<td><a href="/admin/edit-form?id=<c:out value='${customer.customer_id}' />">Edit</a>
							<a href="/admin/delete?id=<c:out value='${customer.customer_id}' />" onclick="return confirm('Are you sure to delete this customer?')">Delete</a></td>
					</tr>

					</c:forEach>
					</tbody>
				</table>
			</div>
		</main>
	</div>
</div>


<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
