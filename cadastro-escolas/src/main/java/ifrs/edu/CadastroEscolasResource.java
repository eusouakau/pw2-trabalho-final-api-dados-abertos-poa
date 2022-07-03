package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@Path("/cadastro-escolas")
@Produces(MediaType.APPLICATION_JSON)
public class CadastroEscolasResource {
  JsonObject obj = new JsonObject();

  @Inject
  @RestClient
  CadastroEscolasService cadastroEscolasService;

  @GET
  @Path("all")
  public JsonArray getAllCE() {
    return cadastroEscolasService.getAll();
  }

  @GET
  @Path("getCEByCodigo/{_codigo}")
  public JsonObject getCEByCodigo(@PathParam("_codigo") Integer _codigo) {
    JsonObject newObj = new JsonObject();

    for (int i = 0; i < getAllCE().size(); i++) {
      if (getAllCE().getJsonObject(i).getValue("codigo").toString()
          .equalsIgnoreCase(_codigo.toString())) {
        return getAllCE().getJsonObject(i);
      }
    }
    return newObj;
  }
}