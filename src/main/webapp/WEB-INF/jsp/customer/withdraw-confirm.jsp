<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Withdraw</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="page" style = "width:70%; margin: auto">
	<jsp:include page="../slideshow.jsp"></jsp:include>
	<jsp:include page="../nav-bar.jsp"></jsp:include>

	<div class="col-md-7 col-lg-8" style = "margin:auto !important; width:50%">
		<h4 class="mb-3">Enter required information</h4>
		<form class="needs-validation" modelAttribute="withdrawInfo" novalidate action="/customer/withdraw-finish" method="POST">
			<div class="row g-3">
				<div class="col-12">
					<label for="money-withdraw" class="form-label">Amount of money</label>
					<input type="number" class="form-control" step = "100000" id="money-withdraw" name = "money-withdraw" placeholder="" value="" required>
					<div style="color:red;">
						${withdrawInfo.get(2)}
					</div>
				</div>
				<div class="col-12">
					<label for="account-type" class="form-label">Account type</label>
					<input type="text" name="account-type" class="form-control" id="account-type" required value="${withdrawInfo.get(0)}"/>

				</div>
			</div>
			<br>
			<strong>Confirm your password to finish this step</strong>
			<div class="col-md-7 col-lg-8">
				<div class="col-12">
					<label for="password" class="form-label">Password</label>
					<input type="password" class="form-control" id="password" name="password" >
					<div style="color:red;">
						${withdrawInfo.get(1)}
					</div>
				</div>

				<br><br><br>


			</div>
			<hr class="my-4">
			<button class="w-100 btn btn-primary btn-lg" type="submit">Continue</button>
		</form>
	</div>

</div>
<jsp:include page="../footer.jsp"/>
</body>
<style>
    div.page{
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
</style>
</html>