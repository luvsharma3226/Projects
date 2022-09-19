import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

import pojo.Book;
import utils.DBUtils;

public class Program {

	public static void main(String[] args) {
		try (Connection cn = DBUtils.getConnection(); Statement st = cn.createStatement();) {
			String sql = "SELECT * FROM candidates";
			ResultSet rs = st.executeQuery(sql);
			
			/*
			 * while(rs.next()) { Book book = new
			 * Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			 * System.out.println(book.toString()); }
			 */
			List<Book> bookList = new ArrayList<Book>();
			while(rs.next()) {
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				bookList.add(book);
			}
			for (Book book : bookList) {
				System.out.println(book);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

};

