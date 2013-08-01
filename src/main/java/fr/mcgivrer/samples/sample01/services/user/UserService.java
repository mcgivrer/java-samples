/**
 * 
 */
package fr.mcgivrer.samples.sample01.services.user;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.mcgivrer.samples.sample01.model.User;

/**
 * User Management Service.
 * 
 * @author FDELORME
 * 
 */
@Path("/user")
public class UserService {

	Map<String, User> users = new HashMap<>();

	public UserService() {
		users.put("fdelorme", new User("fdelorme", "Frédéric", "Delorme",
				"passwd", "frederic.delorme@capgemini.com"));
	}

	/**
	 * Retrieve a User entity based on its <code>username</code>
	 * 
	 * @param username
	 * @return User entity.
	 */
	@Path("/get/{username}")
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("username") String username) {
		if (users.get(username) != null) {
			return Response.ok(users.get(username)).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/**
	 * Verify that <code>authenticate/username?pwd=password</code> matching an
	 * existing <code>User</code>.
	 * 
	 * @param username
	 * @param password
	 * @return 200 => OK
	 */
	@Path("/authenticate/{username}")
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response authenticate(@PathParam("username") String username,
			@QueryParam("pwd") String password) {

		boolean isOk = users.get(username).getPassword().equals(password);
		return Response.status(
				(isOk 
					? Response.Status.OK 
					: Response.Status.UNAUTHORIZED))
				.build();

	}
}
