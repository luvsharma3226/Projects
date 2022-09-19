package dao;

import java.sql.*;
import pojos.Voter;
import static utils.DBUtils.fetchConnection;

import pojos.Voter;

public class VoterDaoImpl implements IVoterDao {

	private Connection cn;
	private PreparedStatement pst1;

	@Override
	public Voter validateUser(String email, String password) throws Exception {
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rs = pst1.executeQuery()){
			if(rs.next()) {
				return new Voter(rs.getInt(1), rs.getString(2), email, password,rs.getString(6),rs.getBoolean(5));
			}
		}
		return null;
	}

	public VoterDaoImpl() throws Exception {
		// get conn
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from voters where email=? and password=?");
		System.out.println("Voter Dao created...");
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
		}
		if (cn != null)
			cn.close();
		System.out.println("VoterDao CleanUp Called....");
	}

}
