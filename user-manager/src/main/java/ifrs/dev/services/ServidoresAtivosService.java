package ifrs.dev.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonArray;

@RegisterRestClient(baseUri = "http://localhost:3300/servidores-ativos")
@Produces(MediaType.APPLICATION_JSON)
public interface ServidoresAtivosService {
    
  @GET
  @Path("/lista-todos-servidores-ativos")
  public JsonArray getAllSA();

  @GET
  @Path("/total-servidores-ativos")
  public String getTotalServidoresAtivos();

  @GET
  @Path("/origem/{origem}")
  public JsonArray getByOrigin(@PathParam("origem") String origem);

  @GET
  @Path("/total/{origem}")
  public String getTotalServidoresAtivosByOrigin(@PathParam("origem") String origem);

  @GET
  @Path("/salarios")
  public double getSMEDBasicWage();


}
