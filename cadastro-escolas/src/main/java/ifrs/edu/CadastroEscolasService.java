package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import io.vertx.core.json.JsonObject;

@RegisterRestClient(baseUri = "https://dadosabertos.poa.br/api/3/action/datastore_search")
@Produces(MediaType.APPLICATION_JSON)
public interface CadastroEscolasService {
  // https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5579bc8e-1e47-47ef-a06e-9f08da28dec8&q=jones

  @GET
  public JsonObject getAll(@QueryParam("resource_id") String resource_id);

  @GET
  public JsonObject getCEByCodigo(
      @QueryParam("resource_id") String resource_id,
      @QueryParam("filters") String _codigo);

  @GET
  public JsonObject getCEByNome(
      @QueryParam("resource_id") String resource_id,
      @QueryParam("q") String _nome);

}
