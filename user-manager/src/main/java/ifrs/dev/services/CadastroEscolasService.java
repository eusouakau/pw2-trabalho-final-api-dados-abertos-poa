package ifrs.dev.services;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:3400/cadastro-escolas")
@Produces(MediaType.APPLICATION_JSON)
public interface CadastroEscolasService {

  @GET
  @Path("/lista-todos-cadastros-escolas")
  public JsonArray getAllCE();

  @GET
  @Path("/codigo/{_codigo}")
  public JsonObject getCEByCodigo(@PathParam("_codigo") Integer _codigo);

  @GET
  @Path("/quantidade")
  public String getQuantidadeByDepAdm();

  @GET
  @Path("/nome/{_name}")
  public JsonArray findByName(@PathParam("_name") String _name);

}
