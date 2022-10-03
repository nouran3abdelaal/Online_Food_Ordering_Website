package net.javaguides.usermangement.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.usermangement.model.MenuItem;

/**
 * Servlet implementation class AddOrderItem
 */
@WebServlet("/JSPs/AddOrderItem")
public class AddOrderItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ArrayList<MenuItem> order =new ArrayList<MenuItem>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String itemList = request.getParameter("submitItem");
		String [] item= itemList.split(",");
		response.getWriter().append("Served at: ").append(item[0]);
		int count = Integer.parseInt(request.getParameter("count"));

		MenuItem item1 =new MenuItem(item[0],Double.parseDouble(item[1]),count);
		order.add(item1);
		request.setAttribute("order", order);
		request.setAttribute("submit", item[2]);
	//	request.setAttribute("orders", );
		RequestDispatcher rd = request.getRequestDispatcher("ViewRestaurants.jsp"); 
//		rd.forward(request, response);
		//request.setAttribute("password", "yes");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
