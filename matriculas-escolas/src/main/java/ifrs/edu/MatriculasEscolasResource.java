package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/matriculas-escolas")
public class MatriculasEscolasResource {
    
    // @POST
    // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    // @Produces(MediaType.APPLICATION_JSON)
    // public MatriculaEscola setIdMatriculasEscolas(@FormParam("id") Integer id, String nome) {
    //     MatriculaEscola m = new MatriculaEscola();
    //     m.setId(id);
    //     m.setName(nome);
    //     return m;
    // }
    
    @Inject
    @RestClient
    MatriculasEscolasService matriculasEscolasService;
    
    @GET
    @Path("/findByCodigo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MatriculaEscola getCodigoMatriculasEscolas(@QueryParam("id") Integer id) {
        return matriculasEscolasService.findById(id);
    }
}