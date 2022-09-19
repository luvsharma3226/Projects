package pojos;
// id int || name varchar(20) || email varchar(20) || password varchar(20) || status boolean || role varchar(20)
//  id | name    | email             | password | status | role
public class Voter {
		private int id;
		private String name , email, password , role;
		private boolean status;
		
		public Voter() {
		
		}
//
		public Voter(int id, String name, String email, String password, String role, boolean status) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.role = role;
			this.status = status;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Voter [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
					+ role + ", status=" + status + "]";
		}
}
