<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<% //<%@page  import="main.java.net.javaguides.usermangement.model.users"
  //  %>
    
    <%@page  import="net.javaguides.usermangement.model.users"
   %>
    
<!DOCTYPE html>
<html>
<head>
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
<form action="EditProfile" method="post">
<label >Email:  </label>
<input type="text" name="email" value= <%= user.getEmail() %>>
<br>
<br>

<label >Name: </label>
<input type="text" name="userName" value= <%= user.getName() %> >
<br>

<br>
<label >Phone Number:</label>
<input type="text" name="phoneNumber" value= <%= user.getPhoneNumber() %> >
<br>

<br>
<label >City: </label>
<input type="text" name="city"  value=<%= user.getCity() %> >
<br>

<br>
<label >Street Name:   </label>
<input type="text" name="streetName"  value= <%= user.getStreetName() %> >
<br>

<br>
<label >Password:   </label>
<input type="text" name="Password"  value= <%= user.getPassword() %> >
<br>
<label >Building Number:  </label>
<input type="text" name="buildingNumber"  value=<%= user.getBuildingNumber() %>>
<br>

<br>
<label >Department Number: </label>
<input type="text" name="departmentNumber"  value=  <%= user.getDepartmentNumber() %>>
<br>

<input type="submit">
<br>
<br>
</form>
  <a href="Home.jsp">  
      <input type="submit" value="Cancel"/>  
     </a>
<br>
<label ></label>
<br>
</body>
</html>