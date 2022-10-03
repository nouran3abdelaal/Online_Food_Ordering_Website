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
input[value]{

font-size: 17px;

}
h1{
text-align : center;
background-color:   #C9E2E9;
heigth: 150px;
position:relative; 
top: -50px; 
font-size: 75px;
color:  #2F8CAB;
}

form{
  text-align: center;
position: relative; 
bottom: 90px; 
}

label{
 width: 200px;
 white-space: nowrap;
  padding: 12px 0px;
  box-sizing: border-box;
 /* background-color: red;*/
 font-weight: bold;
   font-size: 22px;
 
  color:  #A25F08;
  text-align: center;
 display: inline-block;  /*this makes the width fixed*/
 margin-right: 5px;
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
top: 5px; 
left: 400px;
font-size: 30px;

}
.cancel{
 width: 120px;
height: 40px;
background-color: white;
color:  #2F8CAB;
position: relative; 
bottom: 125px; 
left: 400px;
font-size: 30px;

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
::value {
font-size: 17px;
}

</style>


<meta charset="UTF-8">
<title>Edit Profile</title>
</head>
<body>
<%
if(request.getSession().getAttribute("loggedIN") !=null && !(boolean)request.getSession().getAttribute("loggedIN")){
	  request.getSession().setAttribute("messageLOG", "You have to login first.");
		response.sendRedirect("Login.jsp");
}
%>
<% users user =(users) request.getSession().getAttribute("USER");
//String email=(String)request.getSession().getAttribute("USER_Email");
%>
<h1> Edit Profile</h1>

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
     
<form action="EditProfile" method="post">
<label >Email:  </label>
<input type="text" name="email" value= <%= user.getEmail() %>>
<br>

<label >Name: </label>
<input type="text" name="userName" value= <%= user.getName() %> >

<br>
<label >Phone Number:</label>
<input type="text" name="phoneNumber" value= <%= user.getPhoneNumber() %> >

<br>

<label >Password:   </label>
<input type="text" name="Password"  value= <%= user.getPassword() %> >

<br>
<% if(user.getType()==1){

%>

        <label >City: </label>
<input type="text" name="city"  value=<%= user.getCity() %> >

<br>
<label >Street Name:   </label>
<input type="text" name="streetName"  value= <%= user.getStreetName() %> >

<br>
<label >Building Number:  </label>
<input type="text" name="buildingNumber"  value=<%= user.getBuildingNumber() %>>

<br>
<label >Department Number: </label>
<input type="text" name="departmentNumber"  value=  <%= user.getDepartmentNumber() %>>
<br>
        
  <%
  
  }
//else{
  %>
<!-- <p> else</p> -->
  <%
  
 // }
%>


<button class="edit" type="submit"> Done</button>

 
</form>
  <%
     if(user.getType()==1){
    	 
     
     %>
     <a href="Home.jsp">  
     <button class="cancel"
      type="submit" value="Cancel">Cancel</button>     </a>
     
     <% }
     else{
     %>
      <a href="supplierHome.jsp"> 
       <button class="cancel"
      type="submit" value="Cancel">Cancel</button>     </a>
     
      <%} %> 

</body>
</html>