/**
 * 
 */
package fr.mcgivrer.samples.sample01.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author FDELORME
 * 
 */
@Path("/hello")
public class HelloWorldService {

	@Path("/hello")
	@GET
	public String hello() {

		String hello = "Hello";
		String world = "World";

		String helloWorld = hello + " " + world + " !";

		return helloWorld;
	}

	/**
	 * retrieve name of the user and send and Hello Message.
	 * 
	 * @return
	 */
	@Path("/hello/{username}")
	@GET
	public Response hello(@PathParam("username") String username) {
				
		return Response.ok("user " + username +" !").build();
	}
	
	/**
	 * retrieve name of the user and send and Hello Message.
	 * 
	 * @return
	 */
	@Path("/hello/{username}/{age}/{role}")
	@GET
	public Response hello(@PathParam("username") String username, @PathParam("age")int age, @PathParam("role")String role) {
				
		return Response.ok("user " + username + ":"+age+":"+role).build();
	}
}
