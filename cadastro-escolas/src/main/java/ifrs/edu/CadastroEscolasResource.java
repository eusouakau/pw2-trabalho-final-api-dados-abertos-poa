package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.vertx.core.json.JsonObject;

@Path("/cadastro-escolas")
@Produces(MediaType.APPLICATION_JSON)
public class CadastroEscolasResource {

    static String resource_id = "5579bc8e-1e47-47ef-a06e-9f08da28dec8";

    @Inject
    @RestClient
    CadastroEscolasService cadastroEscolasService;

    @GET
    @Path("/findById/{id}")
    public JsonObject getCEById(@PathParam("id") String id) {
        return cadastroEscolasService.findById(resource_id, "101");
    }

    @GET
    @Path("/all")
    public JsonObject getAllCE() {
        return cadastroEscolasService.getAll(resource_id);
    }
}
