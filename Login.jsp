<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="Login.css">
</head>
<body  >
  
  <div class = "hed">

</div>
<form action="Login" method="post">
  <div>
  <h2>Login Form</h2>
  <div class="container">
    <label for="uname"style="padding:10px;margin-left:3px;"><b>Username</b></label><br>
    <input type="text" placeholder="Enter Username" name="uname" required style="padding:10px;margin-left:3px;" autocomplete><br><br>
    
    <label for="psw"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="psw" required><br><br>
     <div>
     <span >create an account? <a href="Signup.jsp"style="color:white;" ><b >Sign up</b></a></span><br><br>
     </div>
     <div class = "sub">  
    <button type="submit" style="padding:10px;margin-left:90px;position:center; border-radius:5px; width:100px; background-color:rgba(0,0,0.5)">Login</button>
    <br><br>
    </div> 
  </div>
  </form>
</div>
</body>
</html>