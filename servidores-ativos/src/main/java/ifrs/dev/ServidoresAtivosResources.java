package ifrs.dev;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@Path("/servidores-ativos")
@Produces(MediaType.APPLICATION_JSON)
public class ServidoresAtivosResources {
  JsonObject obj = new JsonObject();

  @Inject
  @RestClient
  ServidoresAtivosService ServidoresAtivosService;

  @GET
  @Path("all")
  public JsonArray getAllSA() {
    return ServidoresAtivosService.getAll();
  }

  @GET
  @Path("origem/{origem}")
  public JsonArray getByOrigin(@PathParam("origem") String origem) {
    JsonArray newArray = new JsonArray();

    for (int i = 0; i < getAllSA().size(); i++) {
      if (getAllSA().getJsonObject(i).getValue("origem").toString().equalsIgnoreCase(origem)) {
        newArray.add(getAllSA().getJsonObject(i));
      }
    }

    return newArray;
  }
}