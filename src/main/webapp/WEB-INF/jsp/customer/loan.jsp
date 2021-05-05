<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="page" style = "width:70%; margin: auto">
		<jsp:include page="../slideshow.jsp"></jsp:include>
		<jsp:include page="../nav-bar.jsp"></jsp:include>
					<br><br>
					<div class="col-md-7 col-lg-8" style = "margin:auto !important; width:50%">

				          <hr class="my-4">
							<c:choose>
								<c:when test="${empty loanDetail}">
						<h4 class="mb-3">Enter required information</h4>

						<form class="needs-validation" novalidate action="/customer/loan-confirm-form" method="POST" >
							<div class="row g-3">
								<div class="col-12">
									<label for="money-loan" class="form-label">Amount of money</label>
									<input type="number" class="form-control" step = "100000" id="money-loan" name = "money-loan" placeholder="" value="" required>

								</div>
								<div class="col-12">
									<label for="duration" class="form-label">Duration (Months)</label>
									<input type="number" min ="3" step="1" name="duration" class="form-control" id="duration" required/>

									</div>
								</div>
							<br><br>
									<button class="w-100 btn btn-primary btn-lg" type="submit">Continue</button>
						</form>
								</c:when>
								<c:otherwise>

									<h5 style="color: red">Your previous loan has not been paid, so you cannot make any loan</h5>
									<br/>
								</c:otherwise>
							</c:choose>

						<br><br>
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