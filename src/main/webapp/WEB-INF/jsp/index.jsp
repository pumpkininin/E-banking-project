<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html
		xmlns:th="http://www.thymeleaf.org"
		xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
		xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta charset="ISO-8859-1">
<title>E Banking System</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous" defer></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">


</head>
<body>
	<div modelAttributes="roles" class="page" style = "width:70%; margin: auto">
		<jsp:include page="slideshow.jsp"></jsp:include>
		<jsp:include page="nav-bar.jsp"><jsp:param name="role" value="${roles}"/></jsp:include>
		
		<div class="row" style="margin-top:50px">
			<div class="col">
				<div class="card" style="width: 18rem;height:30rem">
				  <img src="/images/loan.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Smart loan</h5>
				    <p class="card-text">Funding for buying your new house, construction, renovation or repair of your current one with attractive incentives, flexible lending.</p>
				    
				    <a href="#" class="btn btn-primary">Detail...</a>
				 </div>
				</div>
			</div>
				 <div class="col">
					<div class="card" style="width: 18rem;height:30rem">
					  <img src="/images/payment2.jpg" class="card-img-top" alt="...">
					  <div class="card-body">
					    <h5 class="card-title">Payment and Transfer</h5>
					    <p class="card-text">Delivering the best payment and currency management solutions for corporate customers</p>
					    <br>
					    <a href="#" class="btn btn-primary">Detail...</a>
				 	  </div>
				 	 </div>
				 </div>
			<div class="col">
				<div class="card" style="width: 18rem;height:30rem">
				  <img src="/images/deposit.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Deposits</h5>
				    <p class="card-text">Send your money to our system and enjoy your life with protection and our attractive incentives</p>
				    <br><br>
				    <a href="#" class="btn btn-primary">Detail...</a>
				 </div>
				 </div>
			</div>
			<div class="col">
				<div class="card" style="width: 18rem;height:30rem">
				  <img src="/images/deposit.jpg" class="card-img-top" alt="...">
				  <div class="card-body">
				    <h5 class="card-title">Deposits</h5>
				    <p class="card-text">Send your money to our system and enjoy your life with protection and our attractive incentives</p>
				    <br><br>
				    <a href="#" class="btn btn-primary">Detail...</a>
				 </div>
				 </div>
			</div>
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