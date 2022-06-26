package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonObject;

@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
public interface CadastroEscolasService {

    @GET
    public JsonObject findById(
            @QueryParam("resource_id") String resource_id,
            @QueryParam("filter=[+_id]") String id);

    @GET
    public JsonObject getAll(
            @QueryParam("resource_id") String resource_id);
}
