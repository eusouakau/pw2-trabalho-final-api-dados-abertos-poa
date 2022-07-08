package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonArray;

@RegisterRestClient(baseUri = "https://raw.githubusercontent.com/eusouakau/dados-abertos-poa-json/master/cadastro_escolas.json")
@Produces(MediaType.APPLICATION_JSON)
public interface CadastroEscolasService {
  @GET
  public JsonArray getAll();
}
