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
    @Path("datastore_search_Local/all")
    public JsonObject getAllMA(
        @QueryParam("resource_id") String resource_id
    ) {
        resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";
        return matriculasEscolasService.getAll(resource_id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("datastore_search_Local/matriculas-por-escolas")
    public JsonObject listarMatriculasEscolas(
            @QueryParam("resource_id") String resource_id,
            @QueryParam("fields") String codigo,
            @QueryParam("fields") String nome,
            @QueryParam("fields") String total            
    // @QueryParam("filters") @PathParam("{\"codigo\": " + "{codigo}" + "}") Integer
    // codigo,
    ) {
        resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";
        codigo = "codigo";
        nome = "nome";
        total = "total";        
        // filters = "";
        return matriculasEscolasService.datastore_search(resource_id, codigo, nome, total);
    }

    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("datastore_search_Local/matriculas-por-escolas/filters")
    public JsonObject pesquisarCodigoMatriculasEscolas(
            @QueryParam("resource_id") String resource_id,            
            @QueryParam("filters") String filters
    // @QueryParam("filters") @PathParam("{\"codigo\": " + "{codigo}" + "}") Integer
    // codigo,
    ) {
        resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";       
        //filters = "filters";
        // filters = "";
        return matriculasEscolasService.datastore_search_pesquisar(resource_id, filters);
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