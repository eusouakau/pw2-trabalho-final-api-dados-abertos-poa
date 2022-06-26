package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonObject;

//@RegisterRestClient(baseUri = "https://raw.githubusercontent.com/eusouakau/dados-abertos-poa-json/master/matriculas_escolas.json")
//@RegisterRestClient(baseUri = "https://dadosabertos.poa.br/api/3/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809")
//@Path("datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809")
@Path("/action")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
public interface MatriculasEscolasService {
    
    static String resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("datastore_search")
    public JsonObject datastore_search(
            @QueryParam("resource_id") String resource_id,
            @QueryParam("fields") String nome,
            @QueryParam("fields") String codigo
    // @QueryParam("filters") Integer codigo,
    // @PathParam("{\"codigo\":codigo}") Integer codigo
    // @QueryParam("filters={\"codigo\":\"{codigo}\"}") Integer codigo
    );

    // static String resource_id =
    // "datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809";
    // @GET
    // @Path("/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&q={name}")
    // public MatriculaEscola findById(@PathParam("name") String name);
    // @GET
    // //public String findById(
    // @Produces(MediaType.APPLICATION_JSON)
    // public JsonObject findById(
    // @QueryParam("resource_id") String resource_id,
    // @QueryParam("filter=[+_id]") String id
    // );

    @GET
    // @Path("datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809")
    // @Path("/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809")
    // public String getAll();
    public JsonObject getAll(
    // @QueryParam("resource_id") String resource_id
    );
}
