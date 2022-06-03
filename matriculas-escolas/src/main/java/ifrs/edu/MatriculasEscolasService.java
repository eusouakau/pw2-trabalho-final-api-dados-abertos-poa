package ifrs.edu;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/action/datastore_search?")
@RegisterRestClient
public interface MatriculasEscolasService {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("resource_id=5b5bc272-6666-4d24-8ddd-138fea511809")
    public MatriculaEscola findById(@PathParam("_id") Integer id);
    public MatriculaEscola findByName(@PathParam("nome") String nome);
}
