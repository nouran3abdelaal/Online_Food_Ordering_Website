package net.javaguides.usermangement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
 */
@WebServlet("/JSPs/addRestName")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestsDAO RestsDAO;
	String rest_name ;
	String supplier_email  ;
	int rest_ID ;
	int menu_ID ;
	int item_ID ;
	double item_price ;
	 users user;
     Restaurant rest;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantServlet() {
        super();
        RestsDAO = new RestsDAO();
        rest = new Restaurant();
        //System.out.println("inservlet");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println("actionR "+ action);
        user = (users) request.getSession().getAttribute("USER");
        request.getSession().setAttribute("USER", user);
		System.out.println("kkkkkkkk>"+user.toString());

		try {
		switch (action) {
		case "/JSPs/addRestName":{ //the action will come with "/" at the beginning so I should add it here but not in the jsp
			
			addRestName(request,response);
			
			break;}
		case "/JSPs/insert2":{
			
		//	insertNewClient(request,response);
			//  request.getSession().setAttribute("USER", user);
		
		break;
		}
		
case "/JSPs/login":{
			
		//	Login(request,response);
		
		break;
		}
default:{
				//insertNewClient(request,response);
				System.out.println("defaultR");

				
			break;
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error "+e);
			e.printStackTrace();
		}
	}


	private void addRestName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("trdtttt");
//		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
//		 requestDispatcher.forward(request, response);
		
		//response.sendRedirect(response.encodeRedirectURL("Home.jsp"));

		System.out.println(user.toString());
		rest_name = request.getParameter("name");
		rest.setName(rest_name);
		System.out.println("line 105"+rest_name);
		supplier_email = user.getEmail();
		rest.setEmail(supplier_email);

		try {
			int count = RestsDAO.restNameUnique(rest);
			System.out.println("count");
			if(count>0) {
				System.out.println("count");
				RequestDispatcher rd = null ;
			    //	response.sendRedirect("Home.jsp");
                      request.setAttribute("unique", "no");
					rd=request.getRequestDispatcher("AddRest.jsp"); 
					rd.forward(request, response);
					return;
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		request.setAttribute("add_item_button", "yes");
        request.getSession().setAttribute("REST", rest);

		System.out.println(rest_name);
		
        int ID = -1;
		try {
			ID = RestsDAO.addRestaurant(rest);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        rest.setID(ID);
		RequestDispatcher rd = null ;
    //	response.sendRedirect("Home.jsp");

		rd=request.getRequestDispatcher("AddRest.jsp"); 
		//	System.out.println("line 105"+rd);

			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			//System.out.println("line 105"+rd);

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

//	public users(String email, String name, String phoneNumber, int type, String password) {

		

}
