package ifrs.dev.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:3300/servidores-ativos")
public interface ServidoresAtivosService {
    
    //  @GET
    //  @Path("/servidores")
    //  @Produces(MediaType.APPLICATION_JSON)
    //  public List<Servidor> getAllServidores();

}
