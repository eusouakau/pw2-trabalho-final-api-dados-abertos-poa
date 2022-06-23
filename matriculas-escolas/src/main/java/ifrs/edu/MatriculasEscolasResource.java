package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/matriculas-escolas")
public class MatriculasEscolasResource {
   
    //private static Integer _id = 5;
    static boolean flag = false;

    //private static String name;

    @Inject
    @RestClient
    MatriculasEscolasService matriculasEscolasService;
    
    @GET
    @Path("/findByEscolas/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getString(@PathParam("name") String name){
        return name;
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