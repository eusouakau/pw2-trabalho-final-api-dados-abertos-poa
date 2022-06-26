package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import io.vertx.core.json.JsonObject;

@Path("/matriculas-escolas")
@Produces(MediaType.APPLICATION_JSON)
public class MatriculasEscolasResource {
    
    static String resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";
    //static boolean flag = false;

    @Inject
    @RestClient
    MatriculasEscolasService matriculasEscolasService;
    
    @GET
    @Path("/findById/{id}")
    public String getMatrEscById(@PathParam("id") String id){
        return matriculasEscolasService.findById(resource_id, "102");
    }

    @GET
    @Path("/all")
    public String getAllMatrEsc(){
        return matriculasEscolasService.getAll();
    }
    // public static void findById(ArrayList<MatriculaEscola> listaMatriculasEscolas) {
    //     //return matriculasEscolasService.findById(id);
    //     for (MatriculaEscola escolaId : listaMatriculasEscolas) {
    //         if (escolaId.getName().equals(name)) {
    //             JOptionPane.showMessageDialog(null, "Escola localizada: " + escolaId.toString());
    //             flag = true;
    //         }
    //     }
    //     if (!flag)
	// 			JOptionPane.showMessageDialog(null, "Escola inexistente!");
    // }
}