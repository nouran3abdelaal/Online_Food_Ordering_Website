<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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



button{
 width: 250px;
height: 90px;
font-size: 25px;
border-radius: 12px;
  text-align: center;
  border-color:  #C9E2E9;
  background-color:  #C9E2E9;
color:  #2F8CAB;
position:relative; 
top: -50px; 

  
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
.addrest{

}

</style>

<meta charset="UTF-8">
<title>Home</title>
</head>

<body>
<h1>Supplier Page</h1>
<br>
 <a href="logout"> 
      <button class="logOut" type="submit" value="Logout"  >Logout</button>  
     </a> 
          <br>
          <br>
<%!
//public static void log_out(int clicked,HttpServletRequest request){
	//if(clicked==1){
	//	 System.out.println("the value of logged in>>"+ request.getSession().getAttribute("loggedIN"));
		// request.getSession().setAttribute("loggedIN", false);
		 //System.out.println("the value of logged in>>"+ request.getSession().getAttribute("loggedIN"));

//	}
	//<!------ onclick=<% //clicked=1; log_out(clicked,request); 
	//}

%>
<%
int clicked=0;
%>

<%
if(request.getSession().getAttribute("loggedIN") !=null && !(boolean)request.getSession().getAttribute("loggedIN")){
	  request.getSession().setAttribute("messageLOG", "You have to login first.");
		response.sendRedirect("Login.jsp");
		clicked = 0;
}
%>
<a href="Profile.jsp">  
      <button type="submit" value="profile"> Profile</button>
     </a>
     
 <br>
          <br>     <a href="Edit.jsp">  
      <button type="submit" value="Edit"> Edit</button>
     </a>
     
          </a>
     
 <br>
          <br>     <a href="AddRest.jsp">  
      <button class="addRest" type="submit" value="Add Restaurant "> Add Restaurant / Menu Items</button>
     </a>
      <br>
          <br>     <a href="viewMenu.jsp">  
      <button class="addRest" type="submit" value="View Menu"> View Menu</button>
     </a>
     <!--  <br>
          <br>     <a href="AddRest.jsp">  
      <button class="addRest" type="submit" value="Add Restaurant "> Add Restaurant </button>
     </a>
      <br>
        <br>     <a href="AddMenu.jsp">  
      <button class="addRest" type="submit" value="Add Menu "> Add Menu </button>
     </a>
      <br>
          <br>     <a href="viewMenu.jsp">  
      <button class="addRest" type="submit" value="View Menu"> View Menu</button>
     </a>
      -->
     
</body>
</html>