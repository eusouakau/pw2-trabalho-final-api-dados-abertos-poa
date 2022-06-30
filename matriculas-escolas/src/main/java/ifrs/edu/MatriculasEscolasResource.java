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

    static String resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";

    JsonObject obj = new JsonObject();

    @Inject
    @RestClient
    MatriculasEscolasService matriculasEscolasService;

    // Traz todos os totais de Matriculas das Escolas Municipais de Porto Alegre
    @GET
    @Path("datastore_search_Local/all")
    public JsonObject getAllMatriculas() {
        // Traz só os dados dentro do objeto 'records'
        obj.put("matriculas-escolas-all",
                matriculasEscolasService.getAll(resource_id).getJsonObject("result").getValue("records"));
        return obj;
    }

    // static boolean flag = false;
    // @GET
    // @Path("datastore_search_Local/{nome}")
    // public JsonObject getByNomeMatriculaEscola(
    //     @PathParam("nome") String nome
    // ){
        
    //     JsonObject obj2 = getAllMatriculas();
    //     for(JsonObject matricula : obj2.getJsonObject("nome").getString("nome"))
    //     if(obj2.containsKey(nome)){
    //         flag = true;
    //         obj2.getString("nome");
    //     }
    //     if(!flag){
    //         flag = false;
    //         System.out.println("Escola inexistente.");
    //     }
    //     //getAllMatriculas().getValue("matriculas-escolas-all").forEach(JsonObject matricula -> matricula.getValue("nome"));
    //     return ;
    // }

    // Lista as Matrículas Cadastradas nas Escolas Municipais de Porto Alegre
    @GET
    @Path("datastore_search_Local/listar-matriculas")
    public JsonObject listarMatriculasEscolas(
            @QueryParam("fields") String codigo,
            @QueryParam("fields") String nome,
            @QueryParam("fields") String total

    ) {
        codigo = "codigo";
        nome = "nome";
        total = "total";
        // Traz o código, nome e total de matrículas das escolas em um objeto limpo
        obj.put("matriculas-escolas-listar",
                matriculasEscolasService.getListarMatriculas(resource_id, codigo, nome, total)
                        .getJsonObject("result").getValue("records"));
        return obj;
    }

    // Filtrar Escolas - passa por GET o atributo desejado e o valor dele e retorna
    // somente um objeto
    // Ex:
    // "_id": 1,
    // "data_extracao": "2022-06-01T01:40:22",
    // "codigo": 101,
    // "nome": "EMEI JP CANTINHO AMIGO ",
    // "ei_creche_parcial": 0,
    // "ei_creche_integral": 0,
    // "ei_creche": 0,
    // "ei_pre_parcial": 77,
    // "ei_pre_integral": 0,
    // "ei_pre": 77,
    // "ef_ciclos_parcial": 0,
    // "ef_ciclos_integral": 0,
    // "ef_ciclos": 0,
    // "ef_eja": 0,
    // "ensino_medio": 0,
    // "normal_magisterio": 0,
    // "profissionalizante": 0,
    // "total": 77
    // Como o Get funciona:
    // http://localhost:3333/matriculas-escolas/datastore_search_Local/filtrar-atributo-matriculas?filters=%7B%22codigo%22%3A105%7D
    @GET
    @Path("datastore_search_Local/filtrar-atributo-matriculas")
    public JsonObject pesquisarAtributoMatriculasEscolas(
            @QueryParam("filters") String filters
            // Tentativa frustrada de filtrar por atributo - fica para história e registro
            // @QueryParam("filters") @PathParam("{\"codigo\": " + "{codigo}" + "}") Integer
            // codigo,
    ) {
        obj.put("matriculas-escolas-filtro", matriculasEscolasService.getAtributoMatriculasEscolas(resource_id, filters)
                .getJsonObject("result").getValue("records"));
        return obj;
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