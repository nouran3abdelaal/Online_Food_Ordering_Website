<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%@page  import="net.javaguides.usermangement.model.users" %>        <%@page  import="net.javaguides.usermangement.model.Restaurant" %>
                <%@page  import=" java.util.ArrayList" %>        <%@page  import="net.javaguides.usermangement.model.Menu" %>
                 <%@page  import="net.javaguides.usermangement.model.MenuItem" %>
         <%@page  import="net.javaguides.usermangement.model.Restaurant" %>
    <%@ page import="java.util.ArrayList" %>
          <%@page  import="net.javaguides.usermangement.dao.RestsDAO" %> 
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


form{
  text-align: center;
 
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
background-color:   #FE4902;
heigth: 180px;
position:relative; 
top: -50px; 
font-size: 75px;
color:  #FCF5EB;
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
  text-align: center;
  position:relative; 
bottom: 80px; 
	
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

table, th, td {
  border: 1px solid;
}

table{

 margin-left: auto;
  margin-right: auto;
  position: relative;
}
.item{
  margin-left: auto;
  margin-right: auto;
  font-size: 20px;
  background-color: #FE4902;
  color: #FCF5EB;
 
}
th{
width: 300px;
height :50px;
font-size: 25px;
background-color: #FE4902;
color: #FCF5EB;
}
td{
font-size: 20px;
height :30px;
text-align: center;
background-color: #FCF5EB;
color: #FE4902;

}

input{
 width: 25%;
  padding: 12px 20px;  /*12 for top dpwn */
  margin: 8px 4px;
  box-sizing: border-box;
 border-color: #FCF5EB;
}
input:focus{
 border-color:  #FE4902;
}

input:placeholder{
font-size: 25px;
}
::value {
font-size: 17px;
}

.myOrder{
position: fixed;
right: 10px;
top: 100px;
width:200px;
 background-color: #FE4902;
  color: #FCF5EB;

}
div{
position: relative;
}

</style>

<body>
<%
//users user = (users)request.getSession().getAttribute("USER");
//System.out.println("addrest.jsp>>"+user.toString());
ArrayList<Restaurant> restaurants = (ArrayList<Restaurant>) request.getSession().getAttribute("ALL");
System.out.println(restaurants.toString());
String submit; //restaurant name
ArrayList<MenuItem> order=new ArrayList<MenuItem>();
if(request.getParameter("submit")!=null){
	submit = request.getParameter("submit");
}
else{
	submit =(String) request.getAttribute("submit");
}
 
ArrayList<MenuItem> items= new ArrayList<MenuItem>();


if(request.getAttribute("order")!=null){
	 order = (ArrayList<MenuItem>)request.getAttribute("order");
	 System.out.println("submit"+order);

}
System.out.println("submit"+submit);

%>


	
	
<h1><%=submit %></h1>
	
	
	<a href="logout"> 
      <button class="logOut" type="submit" value="Logout" >Logout</button>  
     </a>
     
     <!--  
     <a href="Profile.jsp">  
      <button class= "home" type="submit" value="profile">Profile</button>
     </a>
     <br>
          <br>
     
    
     
     <a href="Edit.jsp">  
      <button class= "edit" type="submit" value="Edit"> Edit </button>  
     </a>
     --> 

  
     <a href="Home.jsp">  
   
      <button class="Home" type="submit" value="Home"> Home</button>
     </a>
     <div>
 <%
 if(order!=null && order.size()>0){
	
 %>
 <a herf="orderPage.jsp">
 <button class="myOrder" >View My Order</button>
 
 </a>
 <%} %>
<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Price</th>
       <th>Count</th>
      <th style="background-color: #FCF5EB"></th>
    </tr>
  </thead>
  
  <tbody>
  <% for(int i=0;i<restaurants.size();i++){
	  if(restaurants.get(i).getName().equals(submit)){
		  Menu menu = restaurants.get(i).getMenu();
           items =menu.getMenu(); 
           System.out.println("items"+items.toString());
	  }
	 
  }
  
	  %>
	  <%
	  for(int i=0;i<items.size();i++){
		  

	  %>
    <tr>
     <form action="AddOrderItem" method="get">  
      <td name="name" value= <%= items.get(i).getName() %> >
      <label  > <%= items.get(i).getName() %></label>
      </td>
       <td><%= items.get(i).getPrice() %></td>
      
       <td>
<input type="number"  min=0 name="count" value="0">
</td>
       <td >
          
     
     <button  type= "submit" class="item" name="submitItem" value= <%=items.get(i).getName()+","+items.get(i).getPrice()+","+submit %>>Select</button>
      </form>
      </td>
    </tr>
    <%} %>
   
</table>
</div>

</body>
</html>