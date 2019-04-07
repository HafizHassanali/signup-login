<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
	<title>Signup</title>
	<link rel="stylesheet" type="text/css" href="Signup.css">
	<link href='https://fonts.googleapis.com/css?family=Bonbon' rel='stylesheet'>
</head>
<body >
	<div id="id01">
	<a href="home.jsp">
        <img src="home.jpg" width="30px" height="30px"> </a>
		<div class="model">
			<form action="Signup" method="post" class="modal-content" >
				<div  style="margin-left: 10px"   >
					<h1  style="color:white;">Sign up</h1>
					<p class="Colour">Please fill in this form to create an account.</p>
					<hr>
					<label for=" Full Name"><b class="Colour"> Full Name</b></label>
					<input type="text" id="corner" name="Full Name" 
					maxlength="32" pattern="[A-Za-z0-9\s}{1,30}"  title="Max 25 characters" placeholder="Your Full Name" required="required">

					<label for=" Address"><b class="Colour"> Address</b></label>
					<input type="text" name="Address" maxlength="40"pattern="[A-Za-z0-9\s}{1,50}" placeholder="Address" title="street/city/zip" required="required">

					<label for=" Phone"><b class="Colour">Phone (format: +92XXXXXXXXXX)</b></label>
					<input type="text" name="Phone" placeholder="Phone" maxlength="13" pattern="^((\+92)|(0092))-{0,1}\d{3}-{0,1}\d{7}$|^\d{11}$|^\d{4}-\d{7}$" required="required">

					<label for=" email"><b class="Colour">Email</b></label>
					<input type="text" name="email"  placeholder="something@gmail.com"
					pattern="^.+@.+$" title="something@gmail.domain" required="required">
                    
                    <label for="username"><b class="Colour">User Name</b></label>
					<input type="text" name="uname"placeholder="Hassan_62"maxlength="10" pattern="[A-Za-z0-9\s]{1,15}" 
					 title="maximum 10 characters(e.g:Hassan-62" required="required">
					 
					
					<label for="Password"><b class="Colour">Password</b></label>
					<input type="password" name="psw" placeholder="must be 8 characters(e.g:Hafiz@62)" minlength="8" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" id="password" title="password cotain eight or more characters one number one uppercase and one lowercaseletter" onkeyu='check();' required="required">

					<label for="Repeat_password"><b class="Colour">Confirm Password</b>
					<span id="message"></span>
					</label>
					<input type="password" name="pws-repeat" placeholder="confirm_password"
					id="confirm_password" onkeyup='check();' required="required">
					<span id="message"></span>

					<label class="Colour">
						<input type="checkbox" checked="checked"  name="remember" style="margin-bottom:15px">Remember me
					</label>

					<p >By creating an account you agree to our <a href="#" style="color:#b5d786">Terms & Privacy</a>.</p>

					<div class="clearfix">
						<button type="button" class="cancelbtn" onclick="document.getElementById('id01').style.display='block'" >Cancel</button>
						<button type="submit" class="signupbtn">Sign up</button>
					</div>
				</div>	
			</form>
		</div>
	</div>

	<script >

		var check = function(){
			if (document.getElementById('password').value == document.getElementById('confirm_password').value){
				document.getElementById('message').style.color = 'green';
				document.getElementById('message').innerHTML = 'matching';
			}else{

				document.getElementById('message').style.color = 'red';
				document.getElementById('message').innerHTML = 'Not matching';
			}
		}
		
	</script>
</body>
</html>