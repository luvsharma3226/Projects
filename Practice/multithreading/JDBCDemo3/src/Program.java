import java.sql.*;
import com.mysql.cj.jdbc.Driver;

import utils.DBUtils;

public class Program {

	public static void main(String[] args) {
		try (Connection cn = DBUtils.getConnection(); Statement stmt = cn.createStatement();) {
			String sql = "DELETE FROM candidates where id=6";
			
			int count = stmt.executeUpdate(sql);
			System.out.println(count+" rows Updated!!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main2(String[] args) {
		try (Connection cn = DBUtils.getConnection(); Statement stmt = cn.createStatement();) {
			String sql = "UPDATE candidates SET party='aap' WHERE id=6";	
			
			int count = stmt.executeUpdate(sql);
			System.out.println(count+" rows Updated!!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main1(String[] args) {
		try (Connection cn = DBUtils.getConnection(); Statement stmt = cn.createStatement();) {
			String sql = "INSERT INTO candidates VALUES (6,'luv', 'NA', 9 )";
			
			int count = stmt.executeUpdate(sql);
			System.out.println(count+" rows Updated!!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}