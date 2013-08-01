/**
 * 
 */
package fr.mcgivrer.samples.sample01.services.user;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.mcgivrer.samples.sample01.data.Users;
import fr.mcgivrer.samples.sample01.model.User;

/**
 * User Management Service.
 * 
 * @author FDELORME
 * 
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

	private Users users;

	public UserService() {
		users = new Users();
	}

	/**
	 * Retrieve a User entity based on its <code>username</code>
	 * 
	 * @param username
	 * @return User entity.
	 */
	@Path("/get/{username}")
	@GET
	public Response getUser(@PathParam("username") String username) {
		if (users.findByUsername(username) != null) {
			return Response.ok(users.findByUsername(username)).build();
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
	public Response authenticate(@PathParam("username") String username,
			@QueryParam("pwd") String password) {

		boolean isOk = users.findByUsername(username).getPassword()
				.equals(password);
		return Response.status(
				(isOk ? Response.Status.OK : Response.Status.UNAUTHORIZED))
				.build();

	}

	/**
	 * retrieve a specific user and return a filtered JSON response without
	 * password.
	 * 
	 * @param string
	 * @return
	 */
	@Path("/user/{uid}")
	@GET
	public Response getUserById(@PathParam("uid") String uid) {
		User user = users.findById(uid);
		if (user != null) {
			try {
				JSONObject json = extractUserAttributes(user);

				return Response.ok(json.toString()).build();

			} catch (JSONException e) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/**
	 * retrieve list of all users and serve theme as JSON array.
	 * 
	 * @return
	 */
	@Path("/user")
	@GET
	public Response findAllUsers() {
		List<User> listUsers = users.findAll();
		try {

			JSONArray list = new JSONArray();
			for (User user : listUsers) {
				list.put(extractUserAttributes(user));
			}
			return Response.ok(list.toString()).build();

		} catch (JSONException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/**
	 * Extract only some attributes from the <code>user</code> entity.
	 * 
	 * @param user
	 * @return
	 * @throws JSONException
	 */
	private JSONObject extractUserAttributes(User user) throws JSONException {
		JSONObject json = new JSONObject(user)
				.put("username", user.getUsername())
				.put("firstname", user.getFirstName())
				.put("lastname", user.getLastName())
				.put("email", user.getEmail());
		return json;
	}

}
