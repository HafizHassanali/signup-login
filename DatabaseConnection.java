package fyp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		   System.out.println("check database connection");
		   e.getMessage();
			e.printStackTrace();
		}  
		try {
			 con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/fileinfo","root","");
			
			System.out.println("connected Succefully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();e.getMessage();
			System.out.println("not to cennect with database");
		}  
	return con;
	}
}
