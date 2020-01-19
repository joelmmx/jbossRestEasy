package mx.ine.cartografia;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/library")
public class Library {
	@GET
	@Path("/books")
	public String getBooks() {
		System.out.println("Hola");
		return "Hola";
	}
}
