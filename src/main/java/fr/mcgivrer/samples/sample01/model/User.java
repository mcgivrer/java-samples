/**
 * JavaEE platform Samples : Sample01
 * @copyright 2013
 * @author Frédéric Delorme<frederic.delorme@gmail.com>
 * @author Guillaume Scheibel<guillaume.scheibel@gmail.com>
 */
package fr.mcgivrer.samples.sample01.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author FDELORME
 * 
 */
@Entity
@Table(name = "WEBUSERS")
@NamedQueries({
		@NamedQuery(name = "findAll", query = "select u from User u"),
		@NamedQuery(name = "findByUsername", query = "select u from User u where u.username like :username"),
		@NamedQuery(name = "findByFirstname", query = "select u from User u where u.firstName like :firstname") })
public class User {

	@Id
	@Size(min = 3, max = 20, message = "username size must be between 3 and 20 characters")
	@NotNull(message = "username must be provided")
	public String username;

	@Size(min = 4, max = 40, message = "firstname can npot exceed 40 characters")
	private String firstName;

	@Size(min = 4, max = 50, message = "firstname can npot exceed 50 characters")
	private String lastName;

	@NotNull(message = "password must be provided and can not be null")
	private String password;

	private String email;

	public User() {

	}

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
