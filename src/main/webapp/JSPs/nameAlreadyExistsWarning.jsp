<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
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
.done {
 width: 120px;
height: 50px;
font-size: 25px;
border-radius: 12px;
  text-align: center;
  border-color:  #C9E2E9;
  background-color:  #C9E2E9;
color:  #2F8CAB;
  position: relative;
  top: 250px;
  left: 120px;
}

</style>
<body>
<div>
<p>
Restaurant Name Already Exist! <br>
Try Another :)
<br>

</p>

<a href="AddRest.jsp"> 
      <button class="done" type="submit" value="OK" >OK</button>  
     </a> 
     </div>
</body>
</html>