package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:3333/serviceDadosPoa")
public interface ServiceDadosPoa {
    @GET
    @Path("/serviceDadosPoa/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public MatriculasEscolas getMatriculasEscolas(@PathParam("nome") String nome);
}
