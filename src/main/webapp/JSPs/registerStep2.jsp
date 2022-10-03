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
<form action="insert2" method="post">
<div>
<h3> Address</h3>

<label for="city">City </label>
<input  id="city" name="city" placeholder="Enter your City" required/>
<br><br>

<label for="streetName">Street Name </label>
<input  id="streetName" name="streetName" placeholder="Enter your street Name" required/>

<br>
<br>

<label for="buildingNumber">Building Number </label>
<input  type="number" id="buildingNumber" name="buildingNumber" placeholder="Enter The building Number" required/>
<br><br>

<label for="departmentNumber">Department Number </label>
<input  type="number" id="departmentNumber" name="departmentNumber" placeholder="Enter The department Number" required/>
<br>
<br>
</div>
<button type="submit" >Submit</button>
<br>
<br>
<% boolean con = false;


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