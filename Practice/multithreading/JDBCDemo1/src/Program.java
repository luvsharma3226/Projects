import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class Program {

	public static void main(String[] args) {
		//Step 1: Load and Register Driver
		Connection con = null;
		Statement stmt = null ;
		try {
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step 2: Establish connection using credentials
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "sunbeam", "Cdac@123");
			
			//Step 1: Create Statement
			 stmt = con.createStatement();
			
			//Step 1: Create and execute query
			String sql = "SELECT * from candidates";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Program.printRow(rs);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Step 5: Close resources
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

	private static void printRow(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String name = rs.getNString(2);
		String paarty = rs.getNString(3);
		int votes = rs.getInt(4);
		
		System.out.printf("%-5d%-10s%-10s%-4d\n",id, name, paarty, votes);
		
	}

}
