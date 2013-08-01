/**
 * 
 */
package fr.mcgivrer.samples.sample01.test;


import static org.fest.assertions.Assertions.assertThat;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import fr.mcgivrer.samples.sample01.services.HelloWorldService;

/**
 * @author FDELORME
 *
 */
public class HelloWorldServiceTest {


	private  HelloWorldService service ;
	
	@Before
	public void setp(){
		service = new HelloWorldService();
	}
	
	/**
	 * Test method for {@link fr.mcgivrer.samples.sample01.services.HelloWorldService#hello()}.
	 */
	@Test
	public void testHello() {
		assertThat(service.hello()).isEqualToIgnoringCase("Hello World !");
	}

	/**
	 * Test method for {@link fr.mcgivrer.samples.sample01.services.HelloWorldService#hello(java.lang.String)}.
	 */
	@Test
	public void testHelloString() {

		Response rb = service.hello("toto");
		
		assertThat(rb.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
		assertThat(rb.getEntity().toString()).isEqualToIgnoringCase("Hello toto !");
	}

}
