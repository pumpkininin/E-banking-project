<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous"><script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous" defer></script>
<script src = "js/registration.js" defer></script>
</head>
<body>
	<div class="page" style = "width:75%; margin: auto">
	<jsp:include page="slideshow.jsp"></jsp:include>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<div class="container">
  <main>
    <div class="py-5 text-center">
      <h2>Registration form</h2>
      <p class="lead">Please enter all required information below to finish the registration step</p>
    </div>

    
        
      </div>
      <div class="col-md-7 col-lg-8" style = "margin:auto !important">
        <h4 class="mb-3">Required information</h4>
        <form class="needs-validation" action="/register-confirm" method="Post" novalidate>
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

            

            
            <div class="col-md-5">
              <label for="country" class="form-label">Country</label><br>
              <select class="form-select" id="country" name = "country" required>
                <option value="">Choose...</option>
                <option>Viet Nam </option>
              </select>
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>

            <div class="col-md-4">
              <label for="province" class="form-label">Province/City</label>
              <select class="form-select" id="province" name = "province" required>
                <option value="">Choose...</option>
                
              </select>
              <div class="invalid-feedback">
                Please provide a valid state.
              </div>
            </div>

            <div class="col-md-3">
              <label for="Town" class="form-label">Town</label>
              <input type="text" class="form-control" id="Town"  name = "town" placeholder="" required>
              
            </div>

          </div>

          <hr class="my-4">
		<div class="row g-3">
           <div class="col-12">
              <label for="dob" class="form-label">Date of birth</label><br>
				<input type = "date" class="datepicker" id = "dob" name = "dob" data-date-format="mm/dd/yyyy">
				 
              </div>
              </div>

         

          <hr class="my-4">

          
          <button class="w-100 btn btn-primary btn-lg" type="submit">Register</button>
          <br><br><br>
        </form>
      </div>
    </div>
  </main>

  <footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017–2021 Company Name</p>
    <ul class="list-inline">
      <li class="list-inline-item"><a href="#">Privacy</a></li>
      <li class="list-inline-item"><a href="#">Terms</a></li>
      <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
  </footer>
</div>
</div>
    <jsp:include page="footer.jsp"/>
</body>
<style>
  div.page{
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  }
</style>
</html>