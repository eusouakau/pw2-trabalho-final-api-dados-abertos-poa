package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import io.vertx.core.json.JsonObject;

@RegisterRestClient(baseUri = "https://raw.githubusercontent.com/eusouakau/dados-abertos-poa-json/master/matriculas_escolas.json")
//@RegisterRestClient(baseUri = "https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809")
@Produces(MediaType.APPLICATION_JSON)
public interface MatriculasEscolasService {
    
    //@GET
    //@Path("/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&q={name}")
    //public MatriculaEscola findById(@PathParam("name") String name);
    @GET
    public String findById(
        @QueryParam("resource_id") String resource_id,
        @QueryParam("filter=[+_id]") String id
    );

    @GET
    public String getAll();
}
