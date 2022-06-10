package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface MatriculasEscolasService {
    
    @GET
    @Path("/action/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&q={name}")
    @Produces(MediaType.APPLICATION_JSON)
    public MatriculaEscola findById(@PathParam("name") String name);

}
