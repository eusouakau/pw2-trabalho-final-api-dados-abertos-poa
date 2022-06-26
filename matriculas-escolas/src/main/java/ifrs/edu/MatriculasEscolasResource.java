package ifrs.edu;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import io.vertx.core.json.JsonObject;

@Path("/matriculas-escolas")
@Produces(MediaType.APPLICATION_JSON)
public class MatriculasEscolasResource {

    // static String resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";

    @Inject
    @RestClient
    MatriculasEscolasService matriculasEscolasService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("datastore_search_Local/nomes")
    public JsonObject listarNomesMatriculasEscolas(
            @QueryParam("resource_id") String resource_id,
            @QueryParam("fields") String nome,
            @QueryParam("fields") String codigo
    // @QueryParam("filters") @PathParam("{\"codigo\": " + "{codigo}" + "}") Integer
    // codigo,
    ) {
        resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";
        nome = "nome";
        codigo = "codigo";
        // filters = "";
        return matriculasEscolasService.datastore_search(resource_id, nome, codigo);
    }

    @GET
    @Path("/all")
    public JsonObject getAllMA() {
        return matriculasEscolasService.getAll();
    }

    // static boolean flag = false;
    // @GET
    // @Path("/all")
    // public JsonObject getAllMatrEsc(){
    // return matriculasEscolasService.getAll(resource_id);
    // }
    // public static void findById(ArrayList<MatriculaEscola>
    // listaMatriculasEscolas) {
    // //return matriculasEscolasService.findById(id);
    // for (MatriculaEscola escolaId : listaMatriculasEscolas) {
    // if (escolaId.getName().equals(name)) {
    // JOptionPane.showMessageDialog(null, "Escola localizada: " +
    // escolaId.toString());
    // flag = true;
    // }
    // }
    // if (!flag)
    // JOptionPane.showMessageDialog(null, "Escola inexistente!");
    // }
}