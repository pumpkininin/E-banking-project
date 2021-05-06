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
	<title>Dashboard Template · Bootstrap v5.0</title>
	<script src = "js/registration.js" defer></script>
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
				<h1 class="h2">Add new customer</h1>

			</div>
			<form class="needs-validation" action="/admin/finish-add-customer" method="Post" >
				<div class="row g-3">
					<div class="col-sm-6">
						<label for="firstName" class="form-label">First name</label>
						<input type="text" class="form-control" id="firstName" name = "firstName" placeholder="" value="" required>
						<div class="invalid-feedback">
							Valid first name is required.
						</div>
					</div>

					<div class="col-sm-6">
						<label for="lastName" class="form-label">Last name</label>
						<input type="text" class="form-control" id="lastName" name = "lastName" placeholder="" value="" required>
						<div class="invalid-feedback">
							Valid last name is required.
						</div>
					</div>

					<div class="col-12">
						<label for="username" class="form-label">Email</label>
						<div class="input-group has-validation">

							<input type="text" class="form-control" id="username" name = "email"  required>
							<div class="invalid-feedback">
								Your username is required.
							</div>
						</div>
					</div>

					<div class="col-12">
						<label for="phoneNumber" class="form-label">Phone number</label>
						<input type="text" class="form-control" id="phoneNumber" name = "phoneNumber"  required>
						<div class="invalid-feedback">
							Please enter a valid phone number for authenticating.
						</div>
					</div>
					<div class="col-12">
						<label for="address" class="form-label">Address</label>
						<input type="text" class="form-control" id="address" name = "address"  required>
						<div class="invalid-feedback">
							Please enter a valid phone number for authenticating.
						</div>
					</div>


				</div>

				<hr class="my-4">
				<div class="row g-3">
					<div class="col-12">
						<label for="dob" class="form-label">Date of birth</label><br>
						<input type = "date" class="datepicker" id = "dob" name = "dob" data-date-format="mm/dd/yyyy">

					</div>
				</div>
				<div class="col-12">
					<label for="password" class="form-label">Password</label>
					<input type="text" class="form-control" id="password" name = "password"  required>
					<div class="invalid-feedback">
						Please enter a valid phone number for authenticating.
					</div>
				</div>


				<hr class="my-4">


				<button class="w-100 btn btn-primary btn-lg" type="submit">Add new customer</button>
				<br><br><br>
			</form>

		</main>
	</div>
</div>


<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
