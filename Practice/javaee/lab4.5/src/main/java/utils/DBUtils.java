package utils;

import java.sql.*;

public class DBUtils {

	private static Connection cn;

	public static void createSingletonDBConn(String drvr, String url, String name, String pwd)
			throws SQLException, ClassNotFoundException {
		Class.forName(drvr);
		cn = DriverManager.getConnection(url, name, pwd);
	}

	public static Connection fetchConnection() {
		return cn;
	}

	public static void cleanUp() throws SQLException {
		if (cn != null)
			cn.close();
	}
}
