package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.vertx.core.json.JsonObject;

@Path("/cadastro-escolas")
@Produces(MediaType.APPLICATION_JSON)
public class CadastroEscolasResource {

  static String resource_id = "5579bc8e-1e47-47ef-a06e-9f08da28dec8";
  JsonObject obj = new JsonObject();

  @Inject
  @RestClient
  CadastroEscolasService cadastroEscolasService;

  @GET
  @Path("all")
  public JsonObject getAllCE() {
    obj.put("cadastroEscolas",
        cadastroEscolasService
            .getAll(resource_id)
            .getJsonObject("result")
            .getValue("records"));
    return obj;
  }

  @GET
  @Path("getCEByCodigo/{_codigo}")
  public JsonObject getCEByCodigo(@PathParam("_codigo") Integer _codigo) {
    obj.put("codigo", _codigo);
    String serialized = obj.toString();
    obj.clear();
    obj.put("cadastroEscolas",
        cadastroEscolasService
            .getCEByCodigo(resource_id, serialized)
            .getJsonObject("result")
            .getValue("records"));
    return obj;
  }

  @GET
  @Path("getCEByNome/{_nome}")
  public JsonObject getCEByNome(@PathParam("_nome") String _nome) {
    // WHERE nome LIKE 'AMIGO'
    // where nome like "amigo"
    // obj.put("nome", _nome);
    // String serialized = obj.toString();
    String serialized = "=" + _nome;
    obj.put("cadastroEscolas",
        cadastroEscolasService
            .getCEByNome(resource_id, serialized)
            .getJsonObject("result")
            .getValue("records"));
    return obj;
  }
}