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
import net.javaguides.usermangement.model.MenuItem;
import net.javaguides.usermangement.model.Menu;



/**
 * getAttribute() – Passing data from Server to JSP
 * getParameter() – Passing data from client to JSP|| to servlet
 * Servlet implementation class clientServlet
 */
@WebServlet("/JSPs/addMenuItem")
public class RestaurantAddingItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestsDAO RestsDAO;
	String itemName ;
	String supplier_email  ;
	int rest_ID ;
	int menu_ID ;
	int item_ID ;
	double item_price ;
	 users user;
     Restaurant rest;
     MenuItem menuItem;
     Menu menu;
	
/*
 * private int ID;
	
	private String name ;
	private double price;
	private String email;
	private int restID;
	private int menuID;
 */
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantAddingItemsServlet() {
        super();
        RestsDAO = new RestsDAO();
        menuItem = new MenuItem();
        menu = new Menu();
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
        rest = (Restaurant)request.getSession().getAttribute("REST");

        request.getSession().setAttribute("USER", user);
		System.out.println("kkkkkkkk>"+user.toString());

		addRestItem(request, response);
	}


	private void addRestItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("trdtttt");
//		 RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
//		 requestDispatcher.forward(request, response);
		
		//response.sendRedirect(response.encodeRedirectURL("Home.jsp"));

		
		System.out.println(user.toString());
	itemName = request.getParameter("itemName");
	menuItem.setName(itemName);
		
		item_price = Double.parseDouble(request.getParameter("itemPrice"));
		menuItem.setPrice(item_price);
		//System.out.println("line 105"+rest_name);
		
		
		supplier_email = user.getEmail();
		rest.setEmail(supplier_email);
	//	request.setAttribute("add_item_button", "yes");
        request.getSession().setAttribute("REST", rest);
    	 ArrayList<MenuItem> menuTEMP = menu.getMenu(); // Create an ArrayList object
    	 menuTEMP.add(menuItem);
        menu.setMenu(menuTEMP);
        rest.setMenu(menu);
        
      
		//System.out.println(rest_name);
        int IDMenu = -1;
        int IDItem = -1;

		try {
			IDMenu = RestsDAO.addMenu(rest);
			 menu.setID(IDMenu);
			IDItem = RestsDAO.addMenuItem(rest);
			menuItem.setID(IDItem);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       
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
			  request.getSession().setAttribute("REST", rest);
		        request.getSession().setAttribute("MENU", menu);


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
