package ifrs.edu;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fasterxml.jackson.databind.util.JSONPObject;

import io.vertx.core.json.JsonObject;

@Path("/cadastro-escolas")
public class CadastroEscolasResource {

    @Inject
    @RestClient
    CadastroEscolasService cadastroEscolasService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    public List<CadastroEscolas> getCEById(@QueryParam("_id") Integer id) {
        return cadastroEscolasService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public JsonObject getAllCE() {
        return cadastroEscolasService.getAll();
    }
}
