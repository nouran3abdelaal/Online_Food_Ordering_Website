package project;
import java.sql.*;

public class connectionProvider {
	
public static Connection getCon() {
	try {
		//Class.forName("com.mysql.jdbc.Driver");
		//jdbc:sqlserver://localhost:1433;databaseName=EDS
		//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodApp","nouranA","root1@N");
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=foodAPP");

		return con;
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
	
}
public static void main(String[] args) {
	System.out.println(getCon());
}
}
