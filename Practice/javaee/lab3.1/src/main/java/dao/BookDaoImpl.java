package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import pojos.Book;

import static utils.DBUtils.fetchConnection;

public class BookDaoImpl implements IBookDao {
	private Connection cn;
	private PreparedStatement ps1, ps2, ps3;

	public BookDaoImpl() throws Exception {
		// get con
		cn = fetchConnection();

//		ps1 : for getting all categories
		ps1 = cn.prepareStatement("select distinct category from dac_books ");

//		ps2 : for getting all books by category
		ps2 = cn.prepareStatement("select * from dac_books where category=?");

//		ps3: for getting all details of book by Id
		ps3 = cn.prepareStatement("select * from dac_books where id=?");

		System.out.println("Book Dao Created....");

	}
	
	public void cleanUp() throws SQLException{
		if(ps1 != null)
			ps1.close();
		if(ps2 != null)
			ps2.close();
		if(ps3 != null)
			ps3.close();
		if(cn != null)
			cn.close();
		System.out.println("Book Dao Cleaned UP.....");
	}

	
	@Override
	public List<String> getAllCategories() throws Exception {
		ArrayList<String> categories = new ArrayList<>();
		try(ResultSet rs = ps1.executeQuery()){
			while(rs.next())
				categories.add(rs.getString(1));
		}
		return categories;
	}

	@Override
	public List<Book> getAllBookByCategory(String categoryName) throws Exception {
		ArrayList<Book> availableBooks = new ArrayList<>();
		ps2.setString(1, categoryName);
		try(ResultSet rs = ps2.executeQuery()){
			while(rs.next()) {
//				public Book(int bookId, String title, String author, String category, double price) {
				availableBooks.add(new Book(rs.getInt(1),rs.getString(2) , rs.getString(3), rs.getString(4), rs.getDouble(5)));
			}
		}
		return availableBooks;
	}

	@Override
	public Book getBookById(int bookId) throws Exception {
		
		ps3.setInt(1, bookId);
		try(ResultSet rs = ps3.executeQuery()){
			if(rs.next())
				return new Book(rs.getInt(1),rs.getString(2) , rs.getString(3), rs.getString(4), rs.getDouble(5));
		}
		return null;
	}

}
