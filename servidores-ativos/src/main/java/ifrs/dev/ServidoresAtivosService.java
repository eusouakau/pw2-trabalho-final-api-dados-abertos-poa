package ifrs.dev;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonArray;

@RegisterRestClient(baseUri = "https://raw.githubusercontent.com/eusouakau/dados-abertos-poa-json/master/servidores_ativos.json")
@Produces(MediaType.APPLICATION_JSON)
public interface ServidoresAtivosService {
  @GET
  public JsonArray getAll();
}
