package net.javaguides.usermangement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.*;

import connectionDB.connectionProvider;
import net.javaguides.usermangement.model.Menu;
import net.javaguides.usermangement.model.MenuItem;
import net.javaguides.usermangement.model.Restaurant;
import net.javaguides.usermangement.model.users;


public class RestsDAO { //DAO= DATA ACCESS OBJECT
      //private connectionProvider connection = new connectionProvider();
      Connection conn = (Connection) connectionProvider.getCon();
      /*
       * create table restaurant(
id int  not null auto_increment,
name varchar(200),
email varchar(255) not null ,
 PRIMARY KEY(id, email),  /* i have to make id written first*/
      /*
FOREIGN KEY (email) REFERENCES Restaurant(email)
);
       */
	private static final String insertRestaurant =
			 "  INSERT INTO restaurant (name, email) VALUES (?, ?);\r\n"
		
			//+ "COMMIT;"
			;	
	private static final String insertRestaurantMenu =
			 "  INSERT INTO menu (restID, email) VALUES (?, ?);\r\n"
		
			//+ "COMMIT;"
			;	
	
	
			/*
			 * create table menu (
id int  not null auto_increment,
email varchar(255) not null ,
restID int not null,
 PRIMARY KEY(id,restID, email),  /* i have to make id written first
FOREIGN KEY (email,restID) REFERENCES restaurant(email,id)
);
			 */
	
	private static final String insertRestaurantItem =
			 "  INSERT INTO menuItem (name,price, email,restID,menuID) VALUES (?, ?,?,?,?);\r\n"
		
			//+ "COMMIT;"
			;
	private static final String restaurantNameUnique =
			 "   select count(*) as count from restaurant where email=? and  name=?;" 
		
			//+ "COMMIT;"
			;
   

	/*
	 * create table menuItem(
id int  not null auto_increment,
name varchar(200),
price double,
email varchar(255) not null ,
restID int not null,
menuID int not null,
 PRIMARY KEY(id,restID,menuID, email),  /* i have to make id written first*//*
FOREIGN KEY (email,restID,menuID) REFERENCES menu(email,restID,id)
);
	 */
	
	private static final String insertRestaurantP2 =
			"  SELECT LAST_INSERT_ID();\r\n"
			//+ "COMMIT;"
			;	
			

	private static final String getMenuItems =
			"  select name,price from menuItem where restID=? "
			//+ "COMMIT;"
			;	
	
	private static final String getRestaurant =
			"  select id, name from restaurant where email=?"
			//+ "COMMIT;"
			;
	private static final String getAllRestaurant =
			"   select restaurant.email, restaurant.name as restN, menuItem.name as menuN, menuItem.price as price from restaurant  join menu join menuItem \r\n"
			+ "    where  menu.restID= restaurant.id and menuItem.restID=restaurant.id and menuItem.menuID=menu.id\r\n"
			+ "    ORDER BY\r\n"
			+ "	restaurant.email DESC"
			//+ "COMMIT;"
			;
	
	  public ArrayList<Restaurant> getAllRestaurant() throws SQLException {
		ArrayList<Restaurant>restaurants = new ArrayList<Restaurant>();
		    try(
		    		java.sql.PreparedStatement preparedS = conn.prepareStatement(getAllRestaurant);
		    	//	java.sql.PreparedStatement preparedS2 = conn.prepareStatement(insertRestaurantP2);
		    		){
//		    	 conn.setAutoCommit(false);
//	    		System.out.println("inside the try");
//	    		System.out.println(rest.toString());

		    	
	            ResultSet rs1 = preparedS.executeQuery();
	            while( rs1.next()) {
	            	String email= rs1.getString("email");
	            	if(restaurants.size()>0 && restaurants.get(restaurants.size()-1).getEmail().equals(email)) {
	            		Menu menu = restaurants.get(restaurants.size()-1).getMenu();
	            		MenuItem item = new MenuItem(rs1.getString("menuN"), rs1.getDouble("price"));
	            		menu.getMenu().add(item);
	            		menu.setMenu(menu.getMenu());
	            	}
	            	else {
	            		Restaurant r = new Restaurant();
	            		r.setEmail(email);
	            		r.setName(rs1.getString("restN"));
	            		Menu menu = new Menu();
	            		MenuItem item = new MenuItem(rs1.getString("menuN"), rs1.getDouble("price"));
	            		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
	            		list.add(item);
	            		menu.setMenu(list);
	            		r.setMenu(menu);
	            		restaurants.add(r);
	            		
	            	}
	            }
	           
	           // conn.commit();
	          //  return rs1.getInt("count");
	            		
	    		return restaurants;
	    		
	    	
		    	
		    }
		    catch(Exception e) {
		    	System.out.print(e);
		    }
			return null;
	   }
	  
	  public int restNameUnique(Restaurant rest) throws SQLException {
		    try(
		    		java.sql.PreparedStatement preparedS = conn.prepareStatement(restaurantNameUnique);
		    	//	java.sql.PreparedStatement preparedS2 = conn.prepareStatement(insertRestaurantP2);
		    		){
//		    	 conn.setAutoCommit(false);
//	    		System.out.println("inside the try");
//	    		System.out.println(rest.toString());

		    	preparedS.setString(1,rest.getEmail());
	    		preparedS.setString(2, rest.getName());
	    	//	preparedS.executeUpdate();
	            ResultSet rs1 = preparedS.executeQuery();
	            rs1.next();
	           // conn.commit();
	            return rs1.getInt("count");
	            		
	    		
	    		
	    	
		    //	System.out.println(preparedS.executeUpdate()+"hhhhhhhhhhhhhhhhh");
		    	
		    }
		    catch(Exception e) {
		    	System.out.print(e);
		    }
			return -1;
	   }
   public int addRestaurant(Restaurant rest) throws SQLException {
	    try(
	    		java.sql.PreparedStatement preparedS = conn.prepareStatement(insertRestaurant);
	    		java.sql.PreparedStatement preparedS2 = conn.prepareStatement(insertRestaurantP2);
	    		){
	    	 conn.setAutoCommit(false);
    		System.out.println("inside the try");
    		System.out.println(rest.toString());

	    	preparedS.setString(1,rest.getName());
    		preparedS.setString(2, rest.getEmail());
    		preparedS.executeUpdate();
            ResultSet rs2 = preparedS2.executeQuery();
            rs2.next();
            conn.commit();
            return rs2.getInt("LAST_INSERT_ID()");
            		
    		
    		
    	
	    //	System.out.println(preparedS.executeUpdate()+"hhhhhhhhhhhhhhhhh");
	    	
	    }
	    catch(Exception e) {
	    	System.out.print(e);
	    }
		return -1;
   }
   public int addMenu(Restaurant rest) throws SQLException {
	    try(
	    		java.sql.PreparedStatement preparedS = conn.prepareStatement(insertRestaurantMenu);
	    		java.sql.PreparedStatement preparedS2 = conn.prepareStatement(insertRestaurantP2);
	    		){
	    	 conn.setAutoCommit(false);
   		System.out.println("inside the try");
   		System.out.println(rest.toString());

	    	preparedS.setLong(1,rest.getID());
   		preparedS.setString(2, rest.getEmail());
   		preparedS.executeUpdate();
           ResultSet rs2 = preparedS2.executeQuery();
           rs2.next();
           conn.commit();
           return rs2.getInt("LAST_INSERT_ID()");
           		
   		
   		
   	
	    //	System.out.println(preparedS.executeUpdate()+"hhhhhhhhhhhhhhhhh");
	    	
	    }
	    catch(Exception e) {
	    	System.out.print(e);
	    }
		return -1;
  }
   
   public int addMenuItem(Restaurant rest) throws SQLException {
	    try(
	    		/*
	    		 * private static final String insertRestaurantItem =
			 "  INSERT INTO menuItem (name,price, email,restID,menuID) VALUES (?, ?,?,?,?);\r\n"
	
	    		 */
	    		java.sql.PreparedStatement preparedS = conn.prepareStatement(insertRestaurantItem);
	    		java.sql.PreparedStatement preparedS2 = conn.prepareStatement(insertRestaurantP2);
	    		){
	    	 conn.setAutoCommit(false);
  		System.out.println("inside the try");
  		System.out.println(rest.toString());
            MenuItem item = rest.getMenu().getMenu().get(( rest.getMenu().getMenu()).size() - 1);
	    	preparedS.setString(1,item.getName());
	    	preparedS.setDouble(2,item.getPrice());

  		preparedS.setString(3, rest.getEmail());
  		preparedS.setLong(4, rest.getID());
  		preparedS.setLong(5, rest.getMenu().getID());

  		preparedS.executeUpdate();
          ResultSet rs2 = preparedS2.executeQuery();
          rs2.next();
          conn.commit();
          return rs2.getInt("LAST_INSERT_ID()");
          		
  		
  		
  	
	    //	System.out.println(preparedS.executeUpdate()+"hhhhhhhhhhhhhhhhh");
	    	
	    }
	    catch(Exception e) {
	    	System.out.print(e);
	    }
		return -1;
 }
 /*
  * private static final String getMenuItems =
			"  select * from menuItem where restID=? and menuID=?"
			//+ "COMMIT;"
			;	
	
  */
   
   public Restaurant getRestaurant(users user) throws SQLException {
	  // ArrayList<String> restaurants = new ArrayList<String>(); 
	   Restaurant rest= null;
	    try(
	    		/*
	    		 * private static final String insertRestaurantItem =
			 "  INSERT INTO menuItem (name,price, email,restID,menuID) VALUES (?, ?,?,?,?);\r\n"
	
	    		 */
	    		java.sql.PreparedStatement preparedS = conn.prepareStatement(getRestaurant);
	    		//java.sql.PreparedStatement preparedS2 = conn.prepareStatement(insertRestaurantP2);
	    		){
	    	
	    	// conn.setAutoCommit(false);
//		System.out.println("inside the try");
//		System.out.println(rest.toString());
        //  MenuItem item = rest.getMenu().getMenu().get(( rest.getMenu().getMenu()).size() - 1);
	    	preparedS.setString(1,user.getEmail());
	    	//preparedS.setDouble(2,item.getMenuID());

		
        ResultSet result = preparedS.executeQuery();
       // rs1.next();
        while(result.next()) {
        	rest=new Restaurant(result.getInt("id"), result.getString("name"));
        	return rest;
        }
        
        
	    	
	    }
	    catch(Exception e) {
	    	System.out.print(e);
	    }
	    return null;
}
   
   /*
    * private static final String getMenuItems =
			"  select name,price from menuItem where restID=? and menuID=?"
			//+ "COMMIT;"
			;	
	
    */
   public ArrayList<MenuItem> getMenuItems(Restaurant rest) throws SQLException {
	   ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	    try(
	    		
	    		java.sql.PreparedStatement preparedS = conn.prepareStatement(getMenuItems);
	    		//java.sql.PreparedStatement preparedS2 = conn.prepareStatement(insertRestaurantP2);
	    		){
	    	// conn.setAutoCommit(false);
// 		System.out.println("inside the try");
// 		System.out.println(rest.toString());
	    	preparedS.setLong(1,rest.getID());
	    	//preparedS.setInt(2,rest.getMenu().getID());
	    	 ResultSet result = preparedS.executeQuery();
	    	
          
	    	

 		
        
        // rs1.next();
         
         while(result.next()) {
        	 MenuItem item = new MenuItem(result.getString("name"), result.getDouble("price"));
        	 menu.add(item);
	    	}
      
	    	
	    }
	    catch(Exception e) {
	    	System.out.print(e);
	    }
	    return menu;
}
   
   
}
