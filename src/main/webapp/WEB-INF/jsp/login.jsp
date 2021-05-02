<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>
</head>
<body>
	<div class="page" style = "width:75%; margin: auto">
	<jsp:include page="slideshow.jsp"></jsp:include>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<main>
    <div class="py-5 text-center">
      <h2>Login</h2>
      <p class="lead">Please enter all required information below to finish the login step</p>
    </div>
      <div class="col-md-7 col-lg-8" style = "margin:auto !important; width:50%">
        <h4 class="mb-3">Required information</h4>
        <form class="needs-validation" action="/login-finish" method='POST'>
          <div class="row g-3">
            <div class="col-12">
              <label for="phoneNumber" class="form-label">Phone number</label>
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" >
              <div class="invalid-feedback">
                Please enter a valid phone number for authenticating.
              </div>
            </div>
			<div class="col-12">
              <label for="password" class="form-label">Password</label>
              <input type="password" class="form-control" id="password" name ="password"/>
            
            </div>
            </div>
          <hr class="my-4">
          <button class="w-100 btn btn-primary btn-lg" type="submit">Login</button>
			<br><br><br>
        </form>
      </div>
</main>
	</div>

	<jsp:include page="footer.jsp"/>
</body>
<style>
    div.page{
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    }
</style>
</html>