/**
 * 
 */
package fr.mcgivrer.samples.sample01.test;

import static org.fest.assertions.Assertions.assertThat;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import fr.mcgivrer.samples.sample01.model.User;
import fr.mcgivrer.samples.sample01.services.user.UserService;

/**
 * Unit Tests for UserServices
 * 
 * @author FDELORME
 * 
 */
public class UserServiceTest {

	private UserService userService;

	@Before
	public void setUp() {
		userService = new UserService();
	}

	@Test
	public void testGetUserOK() {
		/**
		 * get an existing user
		 */
		Response userResp = userService.getUser("fdelorme");
		assertThat(userResp.getStatus()).isEqualTo(
				Response.Status.OK.getStatusCode());

		assertThat(((User) userResp.getEntity()).getFirstName()).isEqualTo(
				"Frédéric");
	}

	@Test
	public void testGetUserKO() {
		/**
		 * get an error 404.
		 */
		assertThat(userService.getUser("toto").getStatus()).isEqualTo(
				Response.Status.NOT_FOUND.getStatusCode());
	}

	@Test
	public void testAuthenticate() {

		/* verify existing user is authenticate */
		Response userExists = userService.authenticate("fdelorme", "passwd");
		assertThat(userExists.getStatus()).isEqualTo(
				Response.Status.OK.getStatusCode());

		/* verify that wrong password */
		userExists = userService.authenticate("fdelorme", "passwdfdsgfds");
		assertThat(userExists.getStatus()).isEqualTo(
				Response.Status.UNAUTHORIZED.getStatusCode());

	}

}
