<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "css/slide-show.css" type="text/css"/>
<script src = "js/slide-show.js" defer></script>
</head>
<body>
<div class="slideshow-container">

  <!-- Full-width images with number and caption text -->
  <div class="mySlides fade-slide">
    <div class="numbertext">1 / 3</div>
    <img src="images/banking1.jpg" alt="..." style="width:100%; height:320px">
    <!-- <div class="text">Caption Text</div> -->
  </div>

  <div class="mySlides fade-slide">
    <div class="numbertext">2 / 3</div>
    <img src="images/saving-bank.jpeg" style="width:100%; height:320px">
   <!--  <div class="text">Caption Two</div> -->
  </div>

  <div class="mySlides fade-slide">
    <div class="numbertext">3 / 3</div>
    <img src="images/smart-banking.jpg" style="width:100%; height:320px">
 <!--    <div class="text">Caption Three</div> -->
  </div>

  <!-- Next and previous buttons -->
  <a class="prev" onclick="prev()">&#10094;</a>
  <a class="next" onclick="next()">&#10095;</a>
</div>
<br>

<!-- The dots/circles -->
<div style="text-align:center">
  <span class="dot" onclick="currentSlide(1)"></span> 
  <span class="dot" onclick="currentSlide(2)"></span> 
  <span class="dot" onclick="currentSlide(3)"></span> 
</div>
</body>
</html>