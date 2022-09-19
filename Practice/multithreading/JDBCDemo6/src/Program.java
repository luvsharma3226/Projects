import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

import dao.BookDao;
import pojo.Book;
import utils.DBUtils;

public class Program {
	
	
	public static void main5(String[] args) {
		try (BookDao dao = new BookDao()) {
			int count = dao.delete(8);
			System.out.println(count + " row(s) affected.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main3(String[] args) {
		try (BookDao dao = new BookDao()) {
			int count = dao.update(9,"'RSS'");
			System.out.println(count + " row(s) affected.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main2(String[] args) {
		try (BookDao dao = new BookDao()) {
			Book book = new Book(10, "Suhail", "BJP", 34);
			int count = dao.insert(book);
			System.out.println(count + " row(s) affected.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			List<Book> bookList;
			BookDao dao = new BookDao();
			bookList = dao.getBooks();

			for (Book book : bookList) {
				System.out.println(book);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

};
