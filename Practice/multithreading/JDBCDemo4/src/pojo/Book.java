package pojo;

public class Book {
	private int Id;
	private String candidateName;
	private String party;
	private int votes;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	@Override
	public String toString() {
		return String.format("%-5d%-15s%-10s%-10d" , Id , candidateName, party, votes);
	}
	public Book(int id, String candidateName, String party, int votes) {
		super();
		Id = id;
		this.candidateName = candidateName;
		this.party = party;
		this.votes = votes;
	}
	
}
