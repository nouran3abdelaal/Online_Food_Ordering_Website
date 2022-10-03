<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-color: linen;
  /*background-image: url('images/mountains.jpg');*/
    box-sizing: border-box;
  
}

h3 {
  color:  #A25F08;
  margin-left: 40px;
  font-size: 50px;
  font-weight: bold;
}
form{
 text-align: center;
}
/*.pass {
 width: 150px;
}
*/
label{
 width: 200px;
  padding: 12px 0px;
  box-sizing: border-box;
 /* background-color: red;*/
 font-weight: bold;
   font-size: 20px;
 
  color:  #A25F08;
 
 display: inline-block;  /*this makes the width fixed*/
}
input{
 width: 25%;
  padding: 12px 20px;  /*12 for top dpwn */
  margin: 8px 4px;
  box-sizing: border-box;
}

input:placeholder{
font-size: 25px;
}
::placeholder {
font-size: 17px;
}
option{
font-size: 17px;

}
option[value]{
font-size: 17px;

}

button{
 width: 100px;
height: 40px;
font-size: 25px;
border-radius: 12px;
  text-align: center;
   position: relative;
    color:  #A25F08;
  border-color:   #A25F08;
  background-color: white;
  left: 220px;

}
select{
width: 25%;
  padding: 12px 20px;  /*12 for top dpwn */
  margin: 8px 4px;
  box-sizing: border-box;

}


a{
color:blue;
font-size: 20px;
margin:5px;
 position: relative;
  down: 70px;
  left: 460px;
}


</style>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<form action="insert1" method="post">
<div>
<h3> Personal Information</h3>
<label for="email">Enter your email:</label>
<input type="email" id="email" placeholder="Enter your Email" name="email" required>
<br>
<br>
<label for="name">User Name </label>
<input  id="name" name="userName" placeholder="Enter your name" required/>
<br>
<br>

<label for="phone">Phone Number </label>
<input  type="tel" id="phone" name="phoneNumber" pattern="[0-9]{11}" placeholder="01xxxxxxxxx" required/>

<br>
<br>
<label for="pass">Password</label>
<input  type="password" id="pass" name="password" placeholder="Enter Your Password" required/>
<br>
<br>
<label for="passRepeated">Confirm Password </label>
<input  type="password" id="passRepeated" name="passwordPepeated" placeholder="Confirm Your Password" required/>

<br>
<br>
<label for="postion">Choose Your Position:</label>

<select name="position" id="position">
  <option value="Client">Client</option>
  <option value="Supplier">Supplier</option>
  <option value="Admin">Admin</option>
 
</select>
</div>

<button type="submit" value="Next" >Next</button>
<br>
<br>

<%
boolean con = false;
if(request.getAttribute("email")!=null){
	request.setAttribute("emaill", null);
	out.append("Email already exists!!"+"\n"+"Try another email");
	
}
 if(request.getAttribute("password")!=null){
	request.setAttribute("password", null);
	out.append("Passwords aren't identical !!"+"<br>"+"Try again"+
	"br"+
	request.getParameter("password")+"  "+"password"	);
}

%>


</form>
<script>
function myFunction() {
  alert("Hello! I am an alert box!");
}
</script>
<br>
<a href="logout">I already have an account</a>
</body>
</html>