package ifrs.dev.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonArray;

@RegisterRestClient(baseUri = "http://localhost:3300/servidores-ativos")
@Produces(MediaType.APPLICATION_JSON)
public interface ServidoresAtivosService {
    
  @GET
  public JsonArray getAll();

  @GET
  public JsonArray getByOrigin(@PathParam("origem") String origem);

  @GET
  public String getTotalServidoresAtivos();

  @GET
  public double getSMEDBasicWage();

  @GET
  public String getTotalServidoresAtivosByOrigin(@PathParam("origem") String origem);

}
