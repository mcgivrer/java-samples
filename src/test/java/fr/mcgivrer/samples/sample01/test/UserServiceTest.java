/**
 * JavaEE platform Samples : Sample01
 * @copyright 2013
 * @author Frédéric Delorme<frederic.delorme@gmail.com>
 * @author Guillaume Scheibel<guillaume.scheibel@gmail.com>
 */
package fr.mcgivrer.samples.sample01.test;

import static org.fest.assertions.Assertions.assertThat;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

	@Inject
	private UserService userService;

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
	public void testGetJsonUserOK() throws JSONException {
		/**
		 * get an existing user
		 */
		Response userResp = userService.getUserById(1);

		assertThat(userResp.getStatus()).isEqualTo(
				Response.Status.OK.getStatusCode());

		JSONObject json = new JSONObject(userResp.getEntity().toString());
		assertThat(json.get("firstname")).isEqualTo("Frédéric");
	}

	@Test
	public void testGetJsonUserKO() {
		/**
		 * get an error 404.
		 */
		assertThat(userService.getUserById(12).getStatus()).isEqualTo(
				Response.Status.NOT_FOUND.getStatusCode());
	}

	@Test
	public void testgetAllUsers() throws JSONException {

		/*
		 * retrieve all users
		 */
		Response respList = userService.findAllUsers();

		assertThat(respList.getStatus()).isEqualTo(
				Response.Status.OK.getStatusCode());

		JSONArray json = new JSONArray(respList.getEntity().toString());

		assertThat(json.length()).isEqualTo(7);

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
