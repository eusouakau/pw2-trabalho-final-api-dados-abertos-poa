package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@RegisterRestClient(baseUri = "https://dadosabertos.poa.br/api/3/action/datastore_search")
@Produces(MediaType.APPLICATION_JSON)
public interface CadastroEscolasService {

  @GET
  public String getCEByCodigo(
    @QueryParam("resource_id") String resource_id,
    @QueryParam("filters") String _codigo);

  @GET
  public String getAll(@QueryParam("resource_id") String resource_id);
}
