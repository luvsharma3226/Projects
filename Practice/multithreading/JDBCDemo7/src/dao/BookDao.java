package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.CallableStatement;
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
	CallableStatement stmtSelect;
	CallableStatement stmtUpdate;
	CallableStatement stmtDelete;
	java.sql.CallableStatement stmtInsert;

	public BookDao() throws Exception {
		con = DBUtils.getConnection();
		this.stmtSelect =  this.con.prepareCall("{call sp_select_candidates()}");
		this.stmtDelete = this.con.prepareCall("{call sp_delete_candidate(?)}");
		this.stmtInsert = this.con.prepareCall("{call sp_insert_canidates(?,?,?,?)");
		this.stmtUpdate = this.con.prepareCall("{call sp_update_candidates(?,?)}");
	}

	public List<Book> getBooks() throws Exception {
		List<Book> books = new ArrayList<Book>();
		stmtSelect.execute();
		try (ResultSet rs = stmtSelect.getResultSet()) {
			while (rs.next())
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		return books;
	}

	public int delete(int candidateId) throws SQLException {
		this.stmtDelete.setInt(1, candidateId);
		this.stmtDelete.execute();
		return stmtDelete.getUpdateCount();
	}

	public int update(int candidateId, String party) throws SQLException {
		stmtUpdate.setString(1, party);
		stmtUpdate.setInt(2, candidateId);
		this.stmtUpdate.execute();
		return stmtUpdate.getUpdateCount();

	}

	public int insert(Book book) throws SQLException {
		stmtInsert.setInt(1, book.getId());
		stmtInsert.setString(2, book.getCandidateName());
		stmtInsert.setString(3, book.getParty());
		stmtInsert.setInt(4, book.getVotes());
		this.stmtInsert.execute();
		return stmtInsert.getUpdateCount();
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
