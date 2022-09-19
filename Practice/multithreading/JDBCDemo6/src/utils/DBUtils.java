package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils {

    
	public static Connection getConnection() throws Exception {

		FileInputStream inputStream = new FileInputStream("src/resources/Config.properties");

		Properties p = new Properties();
		p.load(inputStream);
		
		Class.forName(p.getProperty("DRIVER"));
		return DriverManager.getConnection(p.getProperty("URL"),p.getProperty("USER"), p.getProperty("PASSWORD"));
	}
}
