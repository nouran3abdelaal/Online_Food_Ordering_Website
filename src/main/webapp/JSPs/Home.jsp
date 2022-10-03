<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page  import="net.javaguides.usermangement.model.Restaurant" %>
    <%@ page import="java.util.ArrayList" %>
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
.edit{
 width: 80px;
height: 30px;
background-color: white;
color:  #2F8CAB;
position:absolute; 
top:25px; 
left:115px;
font-size: 20px;

}

.restName{
 position: absolute;
  bottom: 25px;
  right: 5px;
  font-size: 20px;
  background-color: #FCF5EB;

}
div{
position: relative;
  width: 200px;
  height: 100px;
  border: 3px solid #FCF5EB;
  display: inline-block;
  margin :5px;
  padding: 5px;
  background-color:  #F4E6CC;
}

div p{
 font-size: 20px;
 font-weight: bold;
 color:  #A25F08;
  background-color:  #F4E6CC;
}

.home{
 width: 80px;
height: 30px;
background-color: white;
color:  #2F8CAB;
position:absolute; 
top:25px; 
left:15px;
font-size: 20px;

}
</style>
<meta charset="UTF-8">
<title>Home</title>
</head>

<body>
<h1>Home Page</h1>
<br>
 <a href="logout"> 
      <button class="logOut" type="submit" value="Logout"   >Logout</button>  
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
ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) request.getSession().getAttribute("ALL");
System.out.println(restaurants.toString());
%>

<%
if(request.getSession().getAttribute("loggedIN") !=null && !(boolean)request.getSession().getAttribute("loggedIN")){
	  request.getSession().setAttribute("messageLOG", "You have to login first.");
		response.sendRedirect("Login.jsp");
		clicked = 0;
}
%>

<a href="Profile.jsp">  
      <button class= "home" type="submit" value="profile">Profile</button>
     </a>
     <br>
          <br>
     
   <!-- 
     
     <a href="Edit.jsp">  
      <button class= "edit" type="submit" value="Edit"> Edit </button>  
     </a>
      --> 
     <%
     for(int i=0; i< restaurants.size();i++){
     
     %>
     <div>
      <form action="ViewRestaurants.jsp">  
     <p ><%=restaurants.get(i).getName() %></p>
     <button type= "submit" class="restName" name="submit" value= <%=restaurants.get(i).getName() %>>View Menu</button>
      </form>
     </div>
     <%} %>
</body>
</html>