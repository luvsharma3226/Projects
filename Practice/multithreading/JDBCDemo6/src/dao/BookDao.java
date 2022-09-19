package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pojo.Book;
import utils.DBUtils;

public class BookDao implements Closeable {

	Connection con = null;
	PreparedStatement stmtSelect;
	PreparedStatement stmtUpdate;
	PreparedStatement stmtDelete;
	PreparedStatement stmtInsert;

	public BookDao() throws Exception {
		con = DBUtils.getConnection();
		this.stmtSelect = this.con.prepareStatement("SELECT * FROM candidates");
		this.stmtDelete = this.con.prepareStatement("DELETE FROM candidates WHERE id=?");
		this.stmtInsert = this.con.prepareStatement("INSERT INTO candidates VALUES (?,?,?,?)");
		this.stmtUpdate = this.con.prepareStatement("UPDATE candidates SET party=? WHERE id=?");
	}

	public List<Book> getBooks() throws Exception {
		List<Book> books = new ArrayList<Book>();
		try (ResultSet rs = stmtSelect.executeQuery()) {
			while (rs.next())
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		return books;
	}

	public int delete(int candidateId) throws SQLException {
		this.stmtDelete.setInt(1, candidateId);
		return this.stmtDelete.executeUpdate();
	}

	public int update(int candidateId, String party) throws SQLException {
		stmtUpdate.setString(1, party);
		stmtUpdate.setInt(2, candidateId);
		return this.stmtUpdate.executeUpdate();
	}

	public int insert(Book book) throws SQLException {
		stmtInsert.setInt(1, book.getId());
		stmtInsert.setString(2, book.getCandidateName());
		stmtInsert.setString(3, book.getParty());
		stmtInsert.setInt(4, book.getVotes());
		return this.stmtInsert.executeUpdate();
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
