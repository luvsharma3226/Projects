package pojos;
//candidates -- id (int) PK , name , political party , votes
public class Candidate {
	private int id , votes;
	String name, politicalParty;
	
	public Candidate() {
		this.id = 0;
		this.votes = 0;
		this.name = "";
		this.politicalParty = "";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoliticalParty() {
		return politicalParty;
	}
	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}
	@Override
	public String toString() {
		return "\n id=" + id + ", votes=" + votes + ", name=" + name + ", politicalParty=" + politicalParty
				+ "]\n";
	}
	public Candidate(int id, int votes, String name, String politicalParty) {
		super();
		this.id = id;
		this.votes = votes;
		this.name = name;
		this.politicalParty = politicalParty;
	}
	
	
}
