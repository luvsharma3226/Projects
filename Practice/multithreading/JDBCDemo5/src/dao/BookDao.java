package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pojo.Book;
import utils.DBUtils;

public class BookDao implements Closeable{
	 
	Connection con = null;
	Statement stmt = null;
	public BookDao() throws Exception {
		 con = DBUtils.getConnection();
		 stmt = con.createStatement();
	}
	
	public List<Book> getBooks() throws Exception {
		String sql = "SELECT * from candidates";
		List<Book> books = new ArrayList<Book>();
		try(ResultSet rs = stmt.executeQuery(sql)) {
			while(rs.next())
				books.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
		}
		return books;
	}
	
	public int delete(int candidateId) throws SQLException {
		String sql = "DELETE FROM candidates WHERE id="+candidateId;
		return this.stmt.executeUpdate(sql);
	}
	
	public int update(int candidateId, String party) throws SQLException {
		String sql = "UPDATE candidates SET party="+party+"WHERE id="+candidateId;
		return this.stmt.executeUpdate(sql);
	}
	
	public int insert(Book book) throws SQLException {
		String sql = "INSERT INTO candidates VALUES ("+book.getId()+","+book.getCandidateName()+","+book.getParty()+","+book.getVotes()+")";
		return this.stmt.executeUpdate(sql);
	}
	
	@Override
	public void close() throws IOException {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
