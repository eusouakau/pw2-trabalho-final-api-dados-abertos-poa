package ifrs.edu;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/action")
@RegisterRestClient
public interface MatriculasEscolasService {
    
    @GET
    @Path("/datastore_search?resource_id=5b5bc272-6666-4d24-8ddd-138fea511809&")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MatriculasEscolas> findByName(@QueryParam("nome") String nome);
}
