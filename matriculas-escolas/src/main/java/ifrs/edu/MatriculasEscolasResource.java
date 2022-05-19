package ifrs.edu;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/matriculas-escolas")
public class MatriculasEscolasResource {

    @Inject
    @RestClient
    MatriculasEscolasService matriculasEscolasService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findByNameLocal")
    public List<MatriculasEscolas> getNomeMatriculasEscolas(@QueryParam("nome") String nome) {
        //System.out.println("teste");
        return matriculasEscolasService.findByName(nome);
    }
}