/**
 * 
 */
package fr.mcgivrer.samples.sample01.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.mcgivrer.samples.sample01.model.User;

/**
 * @author FDELORME
 * 
 */
public class Users {

	private Map<String, User> users = new HashMap<>();

	/**
	 * Initialize data.
	 */
	public Users() {
		users.put("1", new User("fdelorme", "Frédéric", "Delorme", "passwd",
				"frederic.delorme@mail.com"));
		users.put("2", new User("gscheibel", "Guillaume", "Scheibel", "passwd",
				"guillaume.scheibel@mail.com"));
		users.put("3", new User("akubler", "Arnaud", "Kubler", "passwd",
				"arnaud.kubler@mail.com"));
		users.put("4", new User("achristmann", "Alain", "Christmann", "passwd",
				"alain.christmann@mail.com"));
		users.put("5", new User("jlalisse", "Jérôme", "Lalisse", "passwd",
				"jerome.lalisse@mail.com"));
		users.put("6", new User("ogenser", "Olivier", "Genser", "passwd",
				"olivier.genser@mail.com"));
		users.put("7", new User("rfrigui", "Rassil", "Frigui", "passwd",
				"rassil.frigui@mail.com"));
	}

	/**
	 * retrieve a user on its <code>uid</code>.
	 * 
	 * @param uid
	 * @return
	 */
	public User findById(String uid) {
		return users.get(uid);
	}

	/**
	 * retrieve user on its <code>username</code>.
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		for (User user : users.values()) {

			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		list.addAll(users.values());
		return list;
	}

}
