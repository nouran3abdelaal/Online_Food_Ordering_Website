<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        <%@page  import="net.javaguides.usermangement.model.users" %>        <%@page  import="net.javaguides.usermangement.model.Restaurant" %>
                <%@page  import=" java.util.ArrayList" %>        <%@page  import="net.javaguides.usermangement.model.Menu" %>
        
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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


h2{
color: #2F8CAB;
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
bottom: 120px; 
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
p{
background-color: #C9E2E9;
color: #FE4902;
text-align: center;
  margin: auto;
  padding: 40px 0;
font-size: 25px;
display: inline-block;
position: relative;
left: 40%;
 top: 150px;
width:300px;


}

</style>

<body>

<%
users user = (users)request.getSession().getAttribute("USER");
System.out.println("addrest.jsp>>"+user.toString());
Restaurant rest = (Restaurant)request.getSession().getAttribute("REST");
System.out.println("rest.jsp>>"+rest);

//Menu menu =rest.getMenu();
int additem=0;
%>

<%
if(request.getAttribute("unique")!= null && request.getAttribute("unique").equals("no")){
	
%>
<jsp:include page="nameAlreadyExistsWarning.jsp" />
<!-- 
<p>
Restaurant Name Already Exist! <br>
Try Another :)
</p>
 -->
<%} else{%>

<% if(request.getAttribute("add_item_button")==null && rest==null){

	%>
	<h1> Add Restaurant</h1>
	
	<% }
	else{
	
	%>
<h1><%=rest.getName() %></h1>
	
	<%} %>
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
     
<% if(request.getAttribute("add_item_button")==null && rest==null){
	//request.getAttribute("add_item_button")==null
	//System.out.println("addrest.jsp>>"+rest.getName());
	//System.out.println("addrest.jsp>>"+rest);

	%>

<form action="addRestName" method="post">
<div></div>
<label for=" name ">Enter The Restaurant Name:</label>
<input type="text" id="name" placeholder="Enter The Restaurant Name" name="name" required>
<button type="submit">Save</button>
<br>
<br>
</form>
<%}
else{
%>



<form action="addMenuItem" method="post">
<div>  
<h2>Adding Menu item</h2>
<label for=" itemName ">Enter The Item Name:</label>
<input type="text" id="itemName" placeholder="Enter The Item Name" name="itemName" required>
<br>
<br>
<label for=" itemPrice ">Enter The Item Price:</label>
<input type="number" step="any" id="itemPrice" placeholder="Enter The Item Price" name="itemPrice" required>

</div>
<br>
<br>
<button type="submit">Save</button>

</form>
<br>
<br>

<%

}
}
%>




</body>
</html>