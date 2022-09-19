package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {

	private Connection cn;
	private PreparedStatement pst1;

	public CandidateDaoImpl() throws Exception {

		// get Con
		cn = fetchConnection();

		pst1 = cn.prepareStatement("select * from candidates");

		System.out.println("candidate Dao created...");
	}

	@Override
	public List<Candidate> listCandidates() throws Exception {

		ArrayList<Candidate> cList = new ArrayList<Candidate>();

		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				cList.add(new Candidate(rst.getInt(1), rst.getInt(4), rst.getString(2), rst.getString(3)));
			}

		}
		return cList;
	}
}
