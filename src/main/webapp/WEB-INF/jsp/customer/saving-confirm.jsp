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
	<main style = "width:80%">
<%--		<div class="py-5 text-center">--%>
<%--			<img class="d-block mx-auto mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">--%>
<%--			<h2>Confirm transfer</h2>--%>
<%--			<strong class="lead">Below is your saving information. Remember that you only get this interest rate if you saving enough duration. In cases that--%>
<%--				you draw sooner, we will use lower interest!</strong>--%>
<%--		</div>--%>
		<br><br>
		<form action = "/customer/saving-finish" method="post" modelAttributes="savingInfo">
			<div class="row g-3">
				<div class="col-md-5 col-lg-4 order-md-last">
					<h4 class="d-flex justify-content-between align-items-center mb-3">
						<span class="text-muted">Your saving information</span>
						<span class="badge bg-secondary rounded-pill">3</span>
					</h4>

					<ul class="list-group mb-3">
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<h6 class="my-0">Amount of money</h6>
								<input size = "10" class="text-muted money" required name = "money-saving" value="${savingInfo.get(0)}" readonly/>

							</div>
							<span class="text-muted"></span>
						</li>
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<h6 class="my-0">Duration</h6>
								<input size = "10" class="text-muted duration" required name = "duration" value="${savingInfo.get(1)}" readonly/>

							</div>
							<span class="text-muted"></span>
						</li>
						<li class="list-group-item d-flex justify-content-between lh-sm">
							<div>
								<h6 class="my-0">Rate</h6>
								<input size = "10" class="text-muted rate" required name = "rate" value="${savingInfo.get(2)}" readonly/>

							</div>
							<span class="text-muted"></span>
						</li>
					</ul>


				</div>
				<div class="col-md-7 col-lg-8">
					<div class="col-12">
						<label for="password" class="form-label">Password</label>
						<input type="password" class="form-control" id="password" name="password" >
						<div style="color:red;">
							${savingInfo.get(3)}
						</div>
					</div>

					<br><br><br>
					<div class="col-3" style="margin:auto">
						<button class="w-100 btn btn-primary btn-lg" type="submit">Finish</button>
					</div>

				</div>
			</div>


		</form>
		<br><br><br>
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