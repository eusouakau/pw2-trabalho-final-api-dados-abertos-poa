package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonObject;

/*
 * Caso a API caia novamente, utilizar o código abaixo que os dados estão mokados
 * @RegisterRestClient(baseUri = "https://raw.githubusercontent.com/eusouakau/dados-abertos-poa-json/master/matriculas_escolas.json") 
*/

@RegisterRestClient(baseUri = "https://dadosabertos.poa.br/api/3/action/datastore_search")
@Produces(MediaType.APPLICATION_JSON)
public interface MatriculasEscolasService {

        /*
         * Id da API de Matrículas Escolas
         * static String resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";
         */

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public JsonObject getAll(
                        @QueryParam("resource_id") String resource_id);

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public JsonObject getListarMatriculas(
                        @QueryParam("resource_id") String resource_id,
                        @QueryParam("fields") String codigo,
                        @QueryParam("fields") String nome,
                        @QueryParam("fields") String total);

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public JsonObject getAtributoMatriculasEscolas(
                        @QueryParam("resource_id") String resource_id,
                        @QueryParam("filters") String filters);

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public JsonObject getTotalMatriculas(
                        @QueryParam("resource_id") String resource_id,
                        @QueryParam("fields") String total);
}
