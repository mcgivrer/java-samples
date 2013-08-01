/**
 * JavaEE platform Samples : Sample01
 * @copyright 2013
 * @author Frédéric Delorme<frederic.delorme@gmail.com>
 * @author Guillaume Scheibel<guillaume.scheibel@gmail.com>
 */
package fr.mcgivrer.samples.sample01.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.mcgivrer.samples.sample01.model.User;

/**
 * @author FDELORME
 * 
 */
public class Users {

	@PersistenceContext(unitName = "samples")
	EntityManager em;

	private Map<String, User> users = new HashMap<>();

	/**
	 * Initialize data.
	 */
	public Users() {

		

	}

	/**
	 * retrieve a user on its <code>uid</code>.
	 * 
	 * @param uid
	 * @return
	 */
	public User findById(int uid) {
		return em.find(User.class, uid);
	}

	/**
	 * retrieve user on its <code>username</code>.
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {

		Query q = em.createNamedQuery("findByUsername");
		q.setParameter("username", username);
		return (User) q.getResultList().get(1);

	}

	/**
	 * retrieve user on its <code>firstname</code>.
	 * 
	 * @param username
	 * @return
	 */
	public User findByFirstname(String firstname) {

		Query q = em.createNamedQuery("findByFirstname");
		q.setParameter("firstname", firstname);
		return (User) q.getResultList().get(1);

	}

	/**
	 * Retrieve all users from database.
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		return em.createNamedQuery("findAll").getResultList();
	}

}
