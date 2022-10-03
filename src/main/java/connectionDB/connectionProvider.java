package connectionDB;
import java.sql.*;

public class connectionProvider {
	
public static Connection getCon() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodApp?useSSL=false&allowPublicKeyRetrieval=true","nouranA","root1@N");
		
		//com.microsoft.sqlserver.jdbc.SQLServerDriver
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=foodAPP;integratedSecurity=true;");

		//Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=foodAPP;user=root;password=root;encrypt=true;trustServerCertificate=true;");
		//jdbc:sqlserver://localhost:1433;databaseName=EDS
		System.out.println("DONE");
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
