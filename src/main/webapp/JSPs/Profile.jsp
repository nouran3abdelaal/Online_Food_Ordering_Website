<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<% //<%@page  import="main.java.net.javaguides.usermangement.model.users"
  //  %>
    
    <%@page  import="net.javaguides.usermangement.model.users"
   %>
    
<!DOCTYPE html>
<html>
<head>
<style>
*{
 background-color: linen;
}
h1{
text-align : center;
background-color:   #C9E2E9;
heigth: 180px;
position:relative; 
top: -50px; 
font-size: 75px;
color:  #2F8CAB;
}

div{
  text-align: center;
position: relative; 
bottom: 55px; 
}

label{
 width: 500px;
  padding: 12px 0px;
  box-sizing: border-box;
 /* background-color: red;*/
 font-weight: bold;
   font-size: 25px;
 
  color:  #A25F08;
  text-align: center;
 display: inline-block;  /*this makes the width fixed*/
}
h1{
text-align : center;
background-color:   #C9E2E9;
heigth: 180px;
position:relative; 
top: -50px; 
font-size: 75px;
color:  #2F8CAB;
}

button{
 width: 120px;
height: 50px;
font-size: 25px;
border-radius: 12px;
  text-align: center;
  border-color:  #C9E2E9;
  background-color:  #C9E2E9;
color:  #2F8CAB;
  
}
.logOut{
 width: 80px;
height: 30px;
background-color: white;
color:  #2F8CAB;
position:absolute; 
top:25px; 
right:15px;
font-size: 20px;

}

.logOut{
 width: 80px;
height: 30px;
background-color: white;
color:  #2F8CAB;
position:absolute; 
top:25px; 
right:15px;
font-size: 20px;

}

.Home{
 width: 80px;
height: 30px;
background-color: white;
color:  #2F8CAB;
position:absolute; 
top:25px; 
left:15px;
font-size: 20px;

}
.edit{
 width: 100px;
height: 40px;
background-color: white;
color:  #2F8CAB;
position: relative; 
down:25px; 
left: 200px;
font-size: 30px;

}

</style>

<meta charset="UTF-8">
<title>Profile</title>
</head>
<h1> Profile</h1>
<body>
<% users user =(users) request.getSession().getAttribute("USER");
//String email=(String)request.getSession().getAttribute("USER_Email");
%>
 <a href="logout"> 
      <button class="logOut" type="submit" value="Logout" >Logout</button>  
     </a> 
     <%
     if(user.getType()==1){
    	 
     
     %>
     <a href="Home.jsp">  
     <% }
     else{
     %>
      <a href="supplierHome.jsp"> 
      <%} %> 
      <button class="Home" type="submit" value="Home"> Home</button>
     </a>
     
<div>
<label >Email: <%= user.getEmail() %> </label>
<br>
<label >Name: <%= user.getName() %> </label>
<br>
<label >Phone Number: <%= user.getPhoneNumber() %> </label>
<br>
<label >Password: <%= user.getPassword() %> </label>
<br>
<% if(user.getType()==1){

%>

<label >City: <%= user.getCity() %> </label>
<br>
<label >Street Name: <%= user.getStreetName() %> </label>
<br>
<label >Building Number: <%= user.getBuildingNumber() %> </label>
<br>
<label >Department Number: <%= user.getDepartmentNumber() %> </label>
<br>
<br>
 
<%
}
%>
 <a href="Edit.jsp">  
      <button class="edit" type="submit" value="Edit">Edit</button>
     </a>
</div>

</body>
</html>