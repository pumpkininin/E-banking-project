<%@ page import="java.util.Map" %>
<%@ page import="com.se2.ebanking.services.CustomerService" %>
<%@ page import="com.se2.ebanking.models.Customer" %>
<%@ page import="com.se2.ebanking.models.Role" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<div class = "navigation-bar" style="background-color: #64687d">
<nav class="navbar navbar-expand-lg navbar-light bg-secondary">
	<a class="nav-link text-light" href="<%= request.getContextPath() %>/customer/"><i class="fa fa-home" ></i> Home</a>


	<div class="collapse navbar-collapse" id="navbarNavLeft">
	    <ul class="navbar-nav" modelAttributes ="roles">
			<li class="nav-item">
				<a class="nav-link text-light" href="<%= request.getContextPath() %>/customer/transfer-form">Transfer</a>
			</li>
			<li class="nav-item">
		        <a class="nav-link text-light" href="<%= request.getContextPath() %>/customer/loan-form">Loan</a>
			</li>
			<li class="nav-item">
		        <a class="nav-link text-light" href="<%= request.getContextPath() %>/customer/balance">Balance</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-light" href="<%= request.getContextPath() %>/customer/deposit-form">Deposit</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-light" href="<%= request.getContextPath() %>/customer/saving-form">Saving</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-light" href="<%= request.getContextPath() %>/customer/withdraw-form">Withdraw</a>
			</li>
			<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item">
						<a class="nav-link text-light" href="<%= request.getContextPath() %>/admin/">[ADMIN]</a>
					</li>
			</security:authorize>
	    </ul>
  	</div>
	<div class ="collapse navbar-collapse" id="navbarNavRigt" style = "float:right; justify-content: flex-end" modelAttributes="customer">
		<ul class="navbar-nav" style = "float:right">
			<sec:authorize access="!isAuthenticated()">
				<li class="nav-item">
					<a class="nav-link text-light" href="<%= request.getContextPath() %>/login-form">Login</a>
				</li>
				<li class="nav-item">
					<a class="nav-link text-light" href="<%= request.getContextPath() %>/register">Register</a>
				</li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<div class="dropdown">
					<div class="dropdown">
						<button class="dropbtn btn-secondary" ><security:authentication property="name" /> </button>
						<div class="dropdown-content">
							<a href="#">Edit profile</a>
<%--							<a href="#">Link 2</a>--%>
							<a href="<%= request.getContextPath() %>/logout">Logout</a>
						</div>
					</div>
				</div>
			</sec:authorize>
		</ul>
	</div>
</nav>
</div>
<style>
    .dropbtn {

        color: white;
        padding: 16px;
        font-size: 16px;
        border: none;
        cursor: pointer;

    }

    /* The container <div> - needed to position the dropdown content */
    .dropdown {
        position: relative;
        display: inline-block;
    }

    /* Dropdown Content (Hidden by Default) */
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    /* Links inside the dropdown */
    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    /* Change color of dropdown links on hover */
    .dropdown-content a:hover {text-decoration: underline;}

    /* Show the dropdown menu on hover */
    .dropdown:hover .dropdown-content {
        display: block;
    }

    /* Change the background color of the dropdown button when the dropdown content is shown */
    .dropdown:hover .dropbtn {
        background-color: #3e8e41;
    }
    /* Style buttons */
    .btn {
        border: none; /* Remove borders */
        color: white; /* White text */
        padding: 12px 16px; /* Some padding */
        font-size: 16px; /* Set a font size */
        cursor: pointer; /* Mouse pointer on hover */
    }

    /* Darker background on mouse-over */
    .btn:hover {
        background-color: #64687d;
    }
	.nav-link:hover{
		text-decoration:underline;
	}
</style>

