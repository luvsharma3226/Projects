package utils;
import java.sql.*;

public class DBUtils {

	public static Connection fetchConnection(String drvr,String url ,String name,String pwd) throws ClassNotFoundException, SQLException {
		//load JDBC Driver
		Class.forName(drvr);
//		get conn from DVRManager
		return DriverManager.getConnection(url, name , pwd);
	}
	
}
