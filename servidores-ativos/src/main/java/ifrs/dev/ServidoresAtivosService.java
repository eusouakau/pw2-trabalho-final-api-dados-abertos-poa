package ifrs.dev;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import ifrs.dev.models.Servidor;
import io.vertx.core.json.JsonObject;

@Path("/api")
@RegisterRestClient
public interface ServidoresAtivosService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getAll();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findByOrigem")
    public List<Servidor> findByOrigem(@QueryParam("origem") String origem);
}