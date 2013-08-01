/**
 * 
 */
package fr.mcgivrer.samples.sample01.model;

/**
 * @author FDELORME
 * 
 */
public class User {

	public String username;

	private String firstName;

	private String lastName;

	private String password;

	private String email;

	public User(String username, String firstName, String lastName,
			String password, String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("User [").append(" username: ").append(username)
				.append(" ,firstname:").append(firstName).append(" ,lastname:")
				.append(lastName).toString();
	}

}
