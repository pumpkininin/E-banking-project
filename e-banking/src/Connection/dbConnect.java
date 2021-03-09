package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {
	private static String url = "jdbc:mysql://localhost:3306/bankdb?useSSL=false";
	private static String username = "root";
	private static String password = "root";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}