package utils;
import java.sql.*;

public class DBUtils {

	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		//load JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
//		get conn from DVRManager
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?useSSL=false", "sunbeam", "Cdac@123");
	}
	
}
