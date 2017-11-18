package org.javib51.jersey.embedded.resources;

import javax.ws.rs.;
import javax.ws.rs.core.MediaType;
import javax.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LogerFactory;

@Path("/hello")
public class Hello {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello World!";
	}
}
