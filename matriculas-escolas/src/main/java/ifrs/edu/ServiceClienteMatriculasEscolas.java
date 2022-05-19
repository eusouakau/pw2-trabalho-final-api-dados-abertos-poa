package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/service-cli")
public class ServiceClienteMatriculasEscolas {

    @Inject
    @RestClient
    ServiceDadosPoa serviceDadosPoa;
    
    @GET
    @Path("/matriculas-escolas/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public MatriculasEscolas getMatriculasEscolas(@PathParam("name") String name) {
        return serviceDadosPoa.getMatriculasEscolas(name);
    }
}