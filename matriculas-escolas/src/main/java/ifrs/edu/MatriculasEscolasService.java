package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface MatriculasEscolasService {
    
    // @POST
    // @Produces(MediaType.APPLICATION_JSON)
    // @Consumes(MediaType.MULTIPART_FORM_DATA)
    // @Path("resource_id=5b5bc272-6666-4d24-8ddd-138fea511809")
    // public MatriculaEscola findById(@PathParam("_id") Integer id);
    // public MatriculaEscola findByName(@PathParam("nome") String nome);
    //@Path("/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&filters={\"_id\":\"id\"}")
    @GET
    @Path("/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&fields")
    @Produces(MediaType.APPLICATION_JSON)
    public MatriculaEscola findById(@QueryParam("_id") Integer id);
    
}
