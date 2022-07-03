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
  // a base de dados é muito grande e pode ocorrer uma demora para carregar todos os dados.
  @GET
  @Path("/")
  public JsonArray getAllSA() {
    return ServidoresAtivosService.getAll();
  }

  @GET
  @Path("/total-servidores-ativos")
  public String getTotalServidoresAtivos() {
    Integer total = 0;
    for (int i = 0; i < getAllSA().size(); i++) {
      total += 1;
    }
    return "Total de Servidores Ativos: " + total.toString();
  }
    

  @GET
  @Path("origem/{origem}")
  public JsonArray getByOrigin(@PathParam("origem") String origem) {
    JsonArray newArray = new JsonArray();
    JsonArray array = getAllSA();

    for (int i = 0; i < array.size(); i++) {
      if (array.getJsonObject(i).getValue("origem").toString().equalsIgnoreCase(origem)) {
        newArray.add(array.getJsonObject(i));
      }
    }


    return newArray;
  }
}