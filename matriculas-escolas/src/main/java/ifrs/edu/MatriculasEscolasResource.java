package ifrs.edu;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/matriculas-escolas")
@Singleton
public class MatriculasEscolasResource {
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public MatriculaEscola setIdMatriculasEscolas(@FormParam("id") Integer id, String nome) {
        MatriculaEscola m = new MatriculaEscola();
        m.setId(id);
        m.setName(nome);
        return m;
    }
}