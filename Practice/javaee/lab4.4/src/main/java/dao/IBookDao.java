package dao;

import java.util.List;
import pojos.Book;
public interface IBookDao {
	
// add a method to fetch all dist cat names from DB
	List<String> getAllCategories() throws Exception;
	
// add a method to fetch all books from a selected category : called by CategoryDetailsServlet
	List<Book> getAllBookByCategory(String categoryName) throws Exception;
	
// add a method to fetch actual book details selected by the user : called by ShowCartServlet n Checkout
	Book getBookById(int bookId) throws Exception;
	
	
	
}
