<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>ACCOUNT REGISTRATION FORM</title>
    
    
    
    
        <link rel="stylesheet" href="<c:url value='/resources/css/style.css'/> ">

    
    
    
  </head>

  <body>

    <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<div class="wrapper">
  <h1>Register For An Account</h1>
  <p>To sign-up for a free basic account please provide us with some basic information using
  the contact form below. Please use valid credentials.</p>
  <form class="form" method="post" action="yourpage.html">
    <input type="text" class="name" placeholder="Name">
    <div>
      <p class="name-help">Please enter your first and last name.</p>
    </div>
    <input type="email" class="email" placeholder="Email">
     <div>
      <p class="email-help">Please enter your current email address.</p>
    </div>
    <input type="submit" class="submit" value="Register">
  </form>
</div>
<!--<p class="optimize">
  Optimized for Chrome & Firefox!
</p>-->
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="<c:url value='/resources/js/index.js'/> "></script>

    
    
    
  </body>
</html>
