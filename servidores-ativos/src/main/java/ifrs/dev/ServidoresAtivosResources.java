package ifrs.dev;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import ifrs.dev.models.Servidor;
import io.vertx.core.json.JsonObject;

@Path("/servidores-ativos")
public class ServidoresAtivosResources {

    @Inject
    @RestClient
    ServidoresAtivosService servidoresAtivosService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAll")
    public JsonObject getAllServidoresAtivos() {
        return servidoresAtivosService.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/origem")
    public List<Servidor> getOrigemServidoresAtivos(@QueryParam("origem") String origem) {

        return servidoresAtivosService.findByOrigem(origem);
    }
}
