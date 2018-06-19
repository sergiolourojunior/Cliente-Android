package ifsul.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import ifsul.model.Doador;
import ifsul.model.DoadoresDAO;

@Path("/doadores")
public class DoadoresResource {
	
	@GET
	
	public String getDoadores() throws SQLException
	{
		String json = new Gson().toJson(new DoadoresDAO().getDoadores());
		String response = "{\"doadores\":"+json+"}";
		return response;
	}
	
	@POST
	public String save(Doador doadores) throws SQLException
	{
		if(new DoadoresDAO().save(doadores))
		{
			return "salvo";
		}return "erro";
	}
	
	@PUT
	public String savePut(Doador doadores) throws SQLException
	{
		if(new DoadoresDAO().save(doadores))
			{
				return "salvo";
			}return "erro";
	}
	
	@DELETE
	@Path("{id}")
	public String delete(@PathParam("id") Long id) throws SQLException
	{
		if(new DoadoresDAO().delete(id))
		{
			return "excluído";
		}return "erro";
		
	}
}
