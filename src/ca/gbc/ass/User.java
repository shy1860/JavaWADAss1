package ca.gbc.ass;

public class User {
	
	String id,firstname,lastname,email,password,role,address,createdTime;
	public User(String id, String firstname, String lastname, String email, String password, String role, String address,
			String createdTime) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.address = address;
		this.createdTime = createdTime;
	}
	@Override
	public String toString() {
		return "User [id = " + id + " , First Name = " + firstname + " , Last Name = " + lastname + " , email = " + email
				+ " , password = " + password + ", role = " + role + ", address = " + address + " , createdTime = " + createdTime
				+ " ]";
	}
	
	

}
