package net.javaguides.usermangement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

//import com.mysql.jdbc.Connection;
import com.mysql.jdbc.*;

import connectionDB.connectionProvider;
import net.javaguides.usermangement.model.users;

public class usersDAO { //DAO= DATA ACCESS OBJECT
      //private connectionProvider connection = new connectionProvider();
      Connection conn = (Connection) connectionProvider.getCon();
      
	private static final String getClientByEmail = "SELECT *\r\n"
			+ "FROM users\r\n"
			+ "NATURAL JOIN client\r\n"
			+ "where email= ?";	
	private static final String getUserByEmail = "SELECT *\r\n"
			+ "FROM users\r\n"
			
			+ "where email= ?";	
	private static final String checkEmail = "select * from users where email=?";	

	private static final String insertUser = "insert into users ( name, phoneNumber, type,email,password) values(?,?,?,?,?)";	
	private static final String inserclient = "insert into client ( email,city,streetName,buildingNumber,departmentNumber) values(?,?,?,?,?)";	
//	UPDATE users  NATURAL JOIN client
//	SET 
//	    name = 'nouranUPDATED',
//        city="alex";  addSupplier_admin
	
	  public void addSupplier_admin(users user) throws SQLException {
		    try(
		    		java.sql.PreparedStatement preparedS = conn.prepareStatement(insertUser);
		    		//java.sql.PreparedStatement preparedS2 = conn.prepareStatement(inserclient);
		    		){
	    		System.out.println("inside the try");
	    		System.out.println(user.toString());

		    	preparedS.setString(1,user.getName());
	    		preparedS.setString(2, user.getPhoneNumber());
	    		
	    		preparedS.setInt(3, user.getType());
	    		
	    		preparedS.setString(4, user.getEmail());
	    		preparedS.setString(5, user.getPassword());
	    		
		    	System.out.println(preparedS.executeUpdate()+"hhhhhhhhhhhhhhhhh");
		    }
		    catch(Exception e) {
		    	System.out.print(e);
		    }
	   }
	  
	private static final String updateClient = "	UPDATE users NATURAL JOIN client\r\n"
			+ "	SET \r\n"
			+ "	    name = ?,\r\n"
			+ "	    phoneNumber = ?,\r\n"
			+ "	    password = ?,\r\n"
			+ "	    streetName = ?,\r\n"
		
			+ "	    buildingNumber = ?,\r\n"
			+ "        users.email=?,\r\n"
			+ "        client.email=?,\r\n"
			+ "        city=? where email=?"
;
	private static final String updateUser = "	UPDATE users \r\n"
			+ "	SET \r\n"
			+ "	    name = ?,\r\n"
			+ "	    phoneNumber = ?,\r\n"
			+ "	    password = ?,\r\n"
			
			+ "        users.email=?  where email=?"
			
			
;
   public void addUser(users user) throws SQLException {
	    try(
	    		java.sql.PreparedStatement preparedS = conn.prepareStatement(insertUser);
	    		java.sql.PreparedStatement preparedS2 = conn.prepareStatement(inserclient);
	    		){
    		System.out.println("inside the try");
    		System.out.println(user.toString());

	    	preparedS.setString(1,user.getName());
    		preparedS.setString(2, user.getPhoneNumber());
    		
    		preparedS.setInt(3, 1);
    		
    		preparedS.setString(4, user.getEmail());
    		preparedS.setString(5, user.getPassword());
    		
    		preparedS2.setString(1, user.getEmail());

    		preparedS2.setString(2, user.getCity());

    		preparedS2.setString(3, user.getStreetName());

    		preparedS2.setInt(4, user.getBuildingNumber());
    		preparedS2.setInt(5, user.getDepartmentNumber());
    		//preparedS2.executeUpdate();
    		//System.out.println(user.getPhoneNumber());
	    	System.out.println(preparedS.executeUpdate()+"hhhhhhhhhhhhhhhhh");
	    	System.out.println(preparedS2.executeUpdate()+"hhhhhhhhhhhhhhhhh2");
	    }
	    catch(Exception e) {
	    	System.out.print(e);
	    }
   }
   public void updateClient(users user, String old_email) throws SQLException {
	    try(
	    		java.sql.PreparedStatement preparedS = conn.prepareStatement(updateClient);
	    		java.sql.PreparedStatement preparedS2 = conn.prepareStatement(updateUser);

	    		){
   		System.out.println("inside the try");
   		System.out.println(user.toString());
            if(user.getType()==1) {
            	preparedS.setString(1,user.getName());
           		preparedS.setString(2, user.getPhoneNumber());
           		preparedS.setString(3, user.getPassword());
           		//preparedS.setInt(3, 1);
           		preparedS.setString(4, user.getStreetName());
           		preparedS.setInt(5, user.getBuildingNumber());

           		//preparedS.setString(4, user.getEmail());
           		
           		
           		preparedS.setString(6, user.getEmail());
           		preparedS.setString(7, user.getEmail());

           		preparedS.setString(8, user.getCity());
           		preparedS.setString(9,old_email);
    	    	System.out.println(preparedS.executeUpdate()+"hhhhhhhhhhhhhhhhh");

            }
            else {
            	preparedS2.setString(1,user.getName());
           		preparedS2.setString(2, user.getPhoneNumber());
           		preparedS2.setString(3, user.getPassword());
           		preparedS2.setString(4, user.getEmail());
           		preparedS2.setString(5, old_email);

    	    	System.out.println(preparedS2.executeUpdate()+"hhhhhhhhhhhhhhhhh");

            	
            }
	    	

//   		preparedS2.setInt(4, user.getBuildingNumber());
//   		preparedS2.setInt(5, user.getDepartmentNumber());
   		//preparedS2.executeUpdate();
   		//System.out.println(user.getPhoneNumber());
	    	//System.out.println(preparedS2.executeUpdate()+"hhhhhhhhhhhhhhhhh2");
	    }
	    catch(Exception e) {
	    	System.out.print(e);
	    }
  }
   public int checkEmail(users user) throws SQLException {
	   int i=0 ;
	    try(
	    		java.sql.PreparedStatement preparedS = conn.prepareStatement(checkEmail);
	    		){
   		System.out.print("inside the try");
   		preparedS.setString(1,user.getEmail());
	   
   		ResultSet result = preparedS.executeQuery();
	    	System.out.println("result;;;"+result);
	    	//i= 0;
	    	while(result.next()) {
	    	    i++;
	    	}
	    	return  i;
	    }
	    catch(Exception e) {
	    	System.out.print(e+"error");
	    }
		return i;
  }
   public users getUser (users user) throws SQLException {
	   try(
			   java.sql.PreparedStatement preparedS = conn.prepareStatement(getUserByEmail);
			   java.sql.PreparedStatement preparedS2 = conn.prepareStatement(getClientByEmail);

			   
			   ){
		   System.out.println("user inside iserDAO"+user.toString());

		   preparedS.setString(1, user.getEmail());
		   ResultSet rs = preparedS.executeQuery();
		   users user1;
		   rs.next();

		   if(rs.getInt("type")==1) {
			   preparedS2.setString(1, user.getEmail());
			   ResultSet rs1 = preparedS2.executeQuery();
			   rs1.next();
			   user1 = new users(rs1.getString("email"),rs1.getString("name"),rs1.getString("phoneNumber"),rs1.getInt("type"),rs1.getString("city"),rs1.getString("streetName"),rs1.getInt("buildingNumber"),rs1.getInt("departmentNumber"),rs1.getString("password"));

		   }
		   else {
		  // preparedS.setString(1, user.getEmail());
		   //ResultSet rs = preparedS.executeQuery();
//		   this.email = email;
//			this.name = name;
//			this.phoneNumber = phoneNumber;
//			this.password = password;
			//public users(String email, String name, String phoneNumber, int type, String password) {

		    user1 = new users(rs.getString("email"),rs.getString("name"),rs.getString("phoneNumber"),rs.getInt("type"),rs.getString("password"));
		  
		   }
		   System.out.println("user inside iserDAO"+user.toString());
		 //  return rs.getString("password");
		   return user1;
	   }
	   catch(Exception e) {
	    	System.out.print(e+"error");
	    }
	   return null;
   }
   
}
