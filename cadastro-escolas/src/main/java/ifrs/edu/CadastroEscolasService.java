package ifrs.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.fasterxml.jackson.databind.util.JSONPObject;

import io.vertx.core.json.JsonObject;

@RegisterRestClient
public interface CadastroEscolasService {
    /// action/datastore_search?resource_id=5579bc8e-1e47-47ef-a06e-9f08da28dec8&filters={\"_id\":\"id\"}
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    public List<CadastroEscolas> findById(@QueryParam("?&filters={\"_id\":\"id\"}") Integer id);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getAll();
}
