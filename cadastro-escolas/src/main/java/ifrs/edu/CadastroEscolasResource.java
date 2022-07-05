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

  @GET
  @Path("getQuantidade/")
  public String getQuantidadeByDepAdm() {
    Integer totalMunicipal = 0;
    Integer totalPrivado = 0;

    for (int i = 0; i < getAllCE().size(); i++) {
      String tipo = getAllCE().getJsonObject(i).getValue("dep_administrativa").toString();
      if (tipo.equals("MUNICIPAL")) {
        totalMunicipal += 1;
      }
      if (tipo.equals("PRIVADO")) {
        totalPrivado += 1;
      }
    }
    String result = "Total Municipal: " + totalMunicipal.toString() + "\nTotal Privado: " + totalPrivado.toString();
    return result;
  }

  @GET
  @Path("findByName/{name}")
  public JsonArray findByName(@PathParam("name") String name) {
    JsonArray newArray = new JsonArray();

    for (int i = 0; i < getAllCE().size(); i++) {
      if (getAllCE().getJsonObject(i).getString("nome").contains(name)) {
        newArray.add(getAllCE().getJsonObject(i));
      }
    }

    return newArray;
  }
}