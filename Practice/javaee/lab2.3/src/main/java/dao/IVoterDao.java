package dao;

import pojos.Voter;

public interface IVoterDao {
	public Voter validateUser(String email, String password) throws Exception;
}
