<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
       <%@page  import="net.javaguides.usermangement.model.users" %>        <%@page  import="net.javaguides.usermangement.model.Restaurant" %>
                <%@page  import=" java.util.ArrayList" %>        <%@page  import="net.javaguides.usermangement.model.Menu" %>
                 <%@page  import="net.javaguides.usermangement.model.MenuItem" %>
        
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
background-color: #2F8CAB;
color: #FCF5EB;
}
td{
font-size: 20px;
height :30px;
text-align: center;
background-color: #FCF5EB;
color: #2F8CAB;


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

<body>
<%
users user = (users)request.getSession().getAttribute("USER");
System.out.println("addrest.jsp>>"+user.toString());
Restaurant rest = (Restaurant)request.getSession().getAttribute("REST");
RestsDAO restDAO = new RestsDAO();
Menu menu = new Menu();
menu.setMenu(restDAO.getMenuItems(rest));
rest.setMenu(menu);

int additem=0;
System.out.println(menu.getMenu().toString());
%>

	
	
	
<h1><%=rest.getName() %></h1>
	<h2> Menu</h2>
	
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
     

<table>
  <thead>
    <tr>
      <th>Name</th>
      <th>Price</th>
    </tr>
  </thead>
  
  <tbody>
  <% for(int i=0;i<menu.getMenu().size();i++){
	  
  MenuItem item = menu.getMenu().get(i);
  System.out.println(item.getName()+">>"+i);

	  %>
    <tr>
      <td><%= item.getName() %></td>
       <td><%= item.getPrice() %></td>
   
    </tr>
    <%} %>
   
</table>


</body>
</html>