package dao;

import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {
	List<Candidate> listCandidates() throws Exception;
}
