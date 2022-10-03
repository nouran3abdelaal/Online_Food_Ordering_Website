package net.javaguides.usermangement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import net.javaguides.usermangement.dao.RestsDAO;
import net.javaguides.usermangement.dao.usersDAO;
import net.javaguides.usermangement.model.Restaurant;
import net.javaguides.usermangement.model.users;

/**
 * getAttribute() – Passing data from Server to JSP
 * getParameter() – Passing data from client to JSP|| to servlet
 * Servlet implementation class clientServlet
 * //the action will come with "/" at the beginning so I should add it here but not in the jsp
 */
@WebServlet("/")
public class clientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	usersDAO userDOO;
	RestsDAO restDAO;
	String name ;
	String email  ;
	String phone ;
	String city ;
	String streetName ;
	int buildingNumber ;


	int departmentNumber ;
	String password ;
     users user;
	int type =1;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public clientServlet() {
        super();
         userDOO = new usersDAO();
         restDAO = new RestsDAO();
        System.out.println("inservlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String action = request.getServletPath();
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter writer = response.getWriter();
//		writer.println("<h1> My profile</h1>");	
//	
//		System.out.println("do get");
		String action = request.getServletPath();
		System.out.println("action "+ action);
		try {
		switch (action) {
		case "/JSPs/insert1":{  //the action will come with "/" at the beginning so I should add it here but not in the jsp
			
				checkPass_email(request,response);
			
			break;}
		case "/JSPs/insert2":{
			
			insertNewClient(request,response);
			  request.getSession().setAttribute("USER", user);
		
		break;
		}
		
case "/login":{
			
			Login(request,response);
		
		break;
		}
case "/JSPs/logout":{
	request.getSession().removeAttribute("REST");
	( request.getSession()).invalidate();
	System.out.println("rest.servlet>>"+request.getSession().getAttribute("REST"));

	response.sendRedirect(response.encodeRedirectURL("../Login.jsp"));


break;
}
default:{
				//insertNewClient(request,response);
				System.out.println("default");

				
			break;
			}
		}
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error "+e);
			e.printStackTrace();
		}
	}

	private void Login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		try {
		email = request.getParameter("email");
		password = request.getParameter("pass");
		System.out.println("password= "+ password);

		users user= new users(email,password);
		
		int x= userDOO.checkEmail(user);
		System.out.println("x= "+x);
		RequestDispatcher rd;
		if(userDOO.checkEmail(user)==0) {
			 rd=request.getRequestDispatcher("Login.jsp"); 
//			rd.forward(request, response);
			request.setAttribute("email", "yes");
			
				rd.forward(request, response);
			
			
			
		}
		else  {
			 user = userDOO.getUser(user);
			 System.out.println("user inside client servlet>>"+user.toString());
			System.out.println("\n"+user.getPassword()+" if =t rue"+ request.getParameter("pass"));

			if(!request.getParameter("pass").equals(user.getPassword())) {
				 rd=request.getRequestDispatcher("Login.jsp"); 
//					rd.forward(request, response);
					request.setAttribute("pass", "yes");
					
					rd.forward(request, response);

			}
			else {
//				 rd=request.getRequestDispatcher("Home.jsp"); 
////					rd.forward(request, response);
//					//request.setAttribute("pass", "yes");
//					rd.forward(request, response);
				  request.getSession().setAttribute("USER", user);
				  Restaurant rest = restDAO.getRestaurant(user);
				  request.getSession().setAttribute("REST", rest);

					System.out.println("user in login method = "+user.toString());
					  request.getSession().setAttribute("loggedIN", true);
					  if(user.getType()==1) {
					//response.sendRedirect("Home.jsp");
						  
						  ArrayList<Restaurant> restaurants = restDAO.getAllRestaurant();
						  request.getSession().setAttribute("ALL", restaurants);

						response.sendRedirect(response.encodeRedirectURL("JSPs/Home.jsp"));
					  }

					  if(user.getType()==2) {
							//response.sendRedirect("supplierHome.jsp");
						  // adding here getting 
							response.sendRedirect(response.encodeRedirectURL("JSPs/supplierHome.jsp"));


					  }
					  if(user.getType()==3) {
							//response.sendRedirect("adminHome.jsp");
							response.sendRedirect(response.encodeRedirectURL("JSPs/adminHome.jsp"));

					  }
					/*
					 * https://stackoverflow.com/questions/63427366/how-can-i-edit-the-url-of-my-page-using-jsp-and-servlet
					 * https://www.javatpoint.com/sendRedirect()-method
					 */
			}
			System.out.println("if =t rue");
		}
		}
		 catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	protected void checkPass_email(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		 name = request.getParameter("userName");
		 email = request.getParameter("email");
		 phone = request.getParameter("phoneNumber");
		 password = request.getParameter("password");
		 type = (request.getParameter("position").equals("Client"))? 1: (request.getParameter("position").equals("Supplier"))?2:3;

//	public users(String email, String name, String phoneNumber, int type, String password) {

		 user = new users(email,name,phone,type,password);
		System.out.println( user.toString());
		int x= userDOO.checkEmail(user);
		System.out.println("x= "+x);
		RequestDispatcher rd = null;
		if(userDOO.checkEmail(user)>=1) {
			 rd=request.getRequestDispatcher("register.jsp"); 
//			rd.forward(request, response);
			request.setAttribute("email", "yes");
			rd.forward(request, response);
			
			//response.forward(request,response);
			
			//response.getWriter().append("email already exists");
		}
		else if(!request.getParameter("password").equals(request.getParameter("passwordPepeated"))) {
			rd=request.getRequestDispatcher("register.jsp"); 
//			rd.forward(request, response);
			request.setAttribute("password", "yes");
			rd.forward(request, response);
		}
		else {
			if(request.getParameter("position").equals("Client")) {
				System.out.println("requestgetParameter(position)equals(Client)");
				rd=request.getRequestDispatcher("registerStep2.jsp"); 
				rd.forward(request, response);
			}
//			else if(request.getParameter("position").equals("Supplier")) {
//				rd=request.getRequestDispatcher("supplierHome.jsp"); 
//			}
			else {
				insertNewSupplier_admin(request, response);
				//rd=request.getRequestDispatcher("Login.jsp"); 

			}
		
			System.out.println("inside the else");
			//userDOO.addUser(user);
			System.out.println(request.getParameter("userName"));

			

		}
		
		//System.out.println("after the method");

	}
	protected void insertNewSupplier_admin (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
//		String name = request.getParameter("userName");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phoneNumber");
		 name = request.getParameter("userName");
		 System.out.println("insertNewSupplier_admin>>"+request.getParameter("userName"));
		 
//		 email = request.getParameter("email");
//		 phone = request.getParameter("phoneNumber");
		 //password = request.getParameter("password");
//		 city = request.getParameter("city");
//		 streetName = request.getParameter("streetName");
		 //departmentNumber =  request.getParameter("departmentNumber");
		 
		//	System.out.println(Integer.parseInt(request.getParameter("departmentNumber")));

//		 departmentNumber =  Integer.parseInt(request.getParameter("departmentNumber"));
//
//		 buildingNumber = Integer.parseInt(request.getParameter("buildingNumber"));
//
//		 user.setBuildingNumber(buildingNumber);
//		 user.setCity(city);
//		 user.setDepartmentNumber(departmentNumber);
//		 user.setStreetName(streetName);
		 switch(request.getParameter("position")) {
		 case "Client":{
			 user.setType(1);
			 break;
		 }
		 case "Supplier":{
			 user.setType(2);
			 break;
		 }
		 case "Admin":{
			 user.setType(3);
			 break;
		 }
		 default:{
			 user.setType(0);
			 break;
		 }
			 
		 }
		// user.setType(1);
		 
		//String password = request.getParameter("password");

		//int type =1;
		//users user = new users(email,name,phone,type,city,streetName,buildingNumber,departmentNumber,password);
		System.out.println("before the method");
		
     	userDOO.addSupplier_admin(user);
		response.sendRedirect(response.encodeRedirectURL("../Login.jsp"));

//     	RequestDispatcher rd=request.getRequestDispatcher("../Login.jsp"); 
//     	rd.forward(request, response);
		

}
	
	protected void insertNewClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
//		String name = request.getParameter("userName");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phoneNumber");
		 name = request.getParameter("userName");
		 System.out.println(request.getParameter("userName"));
		 
//		 email = request.getParameter("email");
//		 phone = request.getParameter("phoneNumber");
		 //password = request.getParameter("password");
		 city = request.getParameter("city");
		 streetName = request.getParameter("streetName");
		 //departmentNumber =  request.getParameter("departmentNumber");
		 
			System.out.println(Integer.parseInt(request.getParameter("departmentNumber")));

		 departmentNumber =  Integer.parseInt(request.getParameter("departmentNumber"));

		 buildingNumber = Integer.parseInt(request.getParameter("buildingNumber"));

		 user.setBuildingNumber(buildingNumber);
		 user.setCity(city);
		 user.setDepartmentNumber(departmentNumber);
		 user.setStreetName(streetName);
		 
		// switch(user.getType()) {
		 
//		 case "Client":{
//			 user.setType(1);
//			 break;
//		 }
//		 case "Supplier":{
//			 user.setType(2);
//			 break;
//		 }
//		 case "Admin":{
//			 user.setType(3);
//			 break;
//		 }
//		 default:{
//			 user.setType(0);
//			 break;
//		 }
			 
		// }
		 
		// user.setType(1);
		 
		//String password = request.getParameter("password");

		//int type =1;
		//users user = new users(email,name,phone,type,city,streetName,buildingNumber,departmentNumber,password);
		System.out.println("before the method");
		
     	userDOO.addUser(user);
		response.sendRedirect(response.encodeRedirectURL("../Login.jsp"));
//    	RequestDispatcher rd=request.getRequestDispatcher("../Login.jsp"); 
//     	rd.forward(request, response);
		

}
}
