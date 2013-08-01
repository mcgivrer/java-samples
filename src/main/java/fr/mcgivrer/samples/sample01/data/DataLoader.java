/**
 * JavaEE platform Samples : Sample01
 * @copyright 2013
 * @author Frédéric Delorme<frederic.delorme@gmail.com>
 * @author Guillaume Scheibel<guillaume.scheibel@gmail.com>
 */
package fr.mcgivrer.samples.sample01.data;

import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mcgivrer.samples.sample01.model.User;

/**
 * @author FDELORME
 * 
 */
@Singleton
@Startup
public class DataLoader {

	@PersistenceContext
	private EntityManager em;

	private Map<String,User> users = new HashMap<>();
	

	@PostConstruct
	@TransactionAttribute(REQUIRES_NEW)	
	public void init() {
		int size = em.createQuery("SELECT u FROM User u").getResultList().size();

		if (size == 0) {
			users.put("1", new User("fdelorme", "Frédéric", "Delorme",
					"passwd", "frederic.delorme@mail.com"));
			users.put("2", new User("gscheibel", "Guillaume", "Scheibel",
					"passwd", "guillaume.scheibel@mail.com"));
			users.put("3", new User("akubler", "Arnaud", "Kubler", "passwd",
					"arnaud.kubler@mail.com"));
			users.put("4", new User("achristmann", "Alain", "Christmann",
					"passwd", "alain.christmann@mail.com"));
			users.put("5", new User("jlalisse", "Jérôme", "Lalisse", "passwd",
					"jerome.lalisse@mail.com"));
			users.put("6", new User("ogenser", "Olivier", "Genser", "passwd",
					"olivier.genser@mail.com"));
			users.put("7", new User("rfrigui", "Rassil", "Frigui", "passwd",
					"rassil.frigui@mail.com"));

			for (User user : users.values()) {
				em.persist(user);
			}

		}
	}

}
