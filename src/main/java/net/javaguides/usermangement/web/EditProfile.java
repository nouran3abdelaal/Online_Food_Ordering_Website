package net.javaguides.usermangement.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermangement.dao.usersDAO;
import net.javaguides.usermangement.model.users;

/**
 * Servlet implementation class EditProfile
 */
@WebServlet(description = "EditP", urlPatterns = { "/JSPs/EditProfile" })
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	usersDAO userDOO;
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
	users user_session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
        userDOO = new usersDAO();
       // users user_session ;
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String action = request.getServletPath();
			System.out.println("action "+ action);
			UpdateUser(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	
	protected void UpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
//		String name = request.getParameter("userName");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phoneNumber");
		 name = request.getParameter("userName");
		 System.out.println(request.getParameter("userName"));
		  user_session = (users) request.getSession().getAttribute("USER");
		 email = request.getParameter("email");
		 phone = request.getParameter("phoneNumber");
		 password = request.getParameter("Password");
		 user = new users(email,name,phone,user_session.getType(),password);
		 if(user_session.getType()==1) {
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
			 user.setType(1);
		     	//userDOO.updateClient(user,user_session.getEmail());

		 }
		
		

		
		 
		//String password = request.getParameter("password");

		//int type =1;
		//users user = new users(email,name,phone,type,city,streetName,buildingNumber,departmentNumber,password);
		System.out.println("before the method");
		// users user1 =(users) request.getSession().getAttribute("USER");

     	userDOO.updateClient(user,user_session.getEmail());
     	request.getSession().setAttribute("USER", user);
     	 if(user.getType()==1) {
				//response.sendRedirect("Home.jsp");
					response.sendRedirect(response.encodeRedirectURL("Home.jsp"));
				  }

				  if(user.getType()==2) {
						//response.sendRedirect("supplierHome.jsp");
					  // adding here getting 
						response.sendRedirect(response.encodeRedirectURL("supplierHome.jsp"));


				  }
				  if(user.getType()==3) {
						//response.sendRedirect("adminHome.jsp");
						response.sendRedirect(response.encodeRedirectURL("adminHome.jsp"));

				  }
     	//response.sendRedirect(response.encodeRedirectURL("Home.jsp"));
//     	RequestDispatcher rd=request.getRequestDispatcher("Login.jsp"); 
//     	rd.forward(request, response);
		

}

}
