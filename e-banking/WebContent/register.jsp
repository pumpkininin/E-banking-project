<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="js/registration.js" defer></script>
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
        <form class="needs-validation" novalidate>
          <div class="row g-3">
            <div class="col-sm-6">
              <label for="firstName" class="form-label">First name</label>
              <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>

            <div class="col-sm-6">
              <label for="lastName" class="form-label">Last name</label>
              <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>

            <div class="col-12">
              <label for="username" class="form-label">Email</label>
              <div class="input-group has-validation">
                
                <input type="text" class="form-control" id="username"  required>
              <div class="invalid-feedback">
                  Your username is required.
                </div>
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label">Phone number</label>
              <input type="email" class="form-control" id="email" ">
              <div class="invalid-feedback">
                Please enter a valid phone number for authenticating.
              </div>
            </div>

            

            
            <div class="col-md-5">
              <label for="country" class="form-label">Country</label><br>
              <select class="form-select" id="country" required>
                <option value="">Choose...</option>
                <option>Việt Nam </option>
              </select>
              <div class="invalid-feedback">
                Please select a valid country.
              </div>
            </div>

            <div class="col-md-4">
              <label for="state" class="form-label">Province/City</label>
              <select class="form-select" id="province" required>
                <option value="">Choose...</option>
                
              </select>
              <div class="invalid-feedback">
                Please provide a valid state.
              </div>
            </div>

            <div class="col-md-3">
              <label for="zip" class="form-label">Town</label>
              <input type="text" class="form-control" id="Town" placeholder="" required>
              
            </div>
            <div class="col-12">
              <label for="address" class="form-label">Address in detail</label>
              <input type="text" class="form-control" id="address" placeholder="1234 Main St" required>
              <div class="invalid-feedback">
                Please enter your address.
              </div>
            </div>
          </div>

          <hr class="my-4">
		<div class="row g-3">
           <div class="col-12">
              <label for="email" class="form-label">Date of birth</label><br>
				<input type = "date" class="datepicker" data-date-format="mm/dd/yyyy">             
				 
              </div>
              </div>

         

          <hr class="my-4">

          
          <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
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
</body>
</html>