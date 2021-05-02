<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>

</head>
<body>
<div class="page" style = "width:70%; margin: auto">
	<jsp:include page="../slideshow.jsp"></jsp:include>
	<jsp:include page="../nav-bar.jsp"></jsp:include>
	<main>
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
			<h2>Confirm transfer</h2>
			<p class="lead">Below is all information of your transfer process. Make sure that all of them are correct.
				To finish this process please confirm your account in detail then enter your account's password.</p>
		</div>

		<div class="row g-3" style = "    margin: auto; width: revert; display: flex;justify-content: space-around;">
			<div class="col-md-5 col-lg-4 order-md-last">
				Copy
				<div class="card">
					<div class="card-header">
						Error
					</div>
					<div class="card-body">
						<h5 class="card-title">Your balance is not valid</h5>
						<p class="card-text">Your transfer amount is higher than your balance, please check your balance before make a transfer.</p>
						<a href="/balance" class="btn btn-primary">My balance</a>
					</div>
				</div>

			</div>
		</div>
	</main>
</div>
<jsp:include page="../footer.jsp"/>
</body>
<style>
    div.page{
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
</style>
</html>