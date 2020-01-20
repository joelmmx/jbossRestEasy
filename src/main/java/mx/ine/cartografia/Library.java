package mx.ine.cartografia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/library")
public class Library {
	@GET
	@Path("/books")
	public String getBooks() throws Exception{
		System.out.println("Hola");
		return "Hola: "+getDataSource();
	}
	
	private String getDataSource() throws Exception{
		// Obtain our environment naming context
		Context initCtx = new InitialContext();
		//Context envCtx = (Context) initCtx.lookup("java:comp/env");

		// Look up our data source
		DataSource ds = (DataSource)
		  initCtx.lookup("java:jboss/datasources/dce_geoloc09");

		// Allocate and use a connection from the pool
		Connection conn = ds.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM geoloc.colonia where id=3");
		rs.next();
		String result = rs.getString("NOMBRE");
		conn.close();
		return result;
	}
}
