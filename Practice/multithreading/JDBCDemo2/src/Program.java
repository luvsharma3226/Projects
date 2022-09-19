import java.sql.*;
import com.mysql.cj.jdbc.Driver;

import utils.DBUtils;

public class Program {

	public static void main(String[] args) {

		// Step 1: Load and Register Driver
		try (Connection con = DBUtils.getConnection();
				Statement stmt = con.createStatement()) {

			String sql = "SELECT * from candidates";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Program.printRow(rs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printRow(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		String name = rs.getNString(2);
		String paarty = rs.getNString(3);
		int votes = rs.getInt(4);

		System.out.printf("%-5d%-10s%-10s%-4d\n", id, name, paarty, votes);

	}

}
