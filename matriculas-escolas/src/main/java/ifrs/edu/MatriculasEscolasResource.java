package ifrs.edu;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.swing.text.AttributeSet.CharacterAttribute;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/*
 * Define o path da url que será mostrada para o cliente
 */
@Path("/matriculas-escolas/datastore_search_Local")
@Produces(MediaType.APPLICATION_JSON)
public class MatriculasEscolasResource {
        /*
         * Fixa o Id da API matriculas-escolas
         */
        static String resource_id = "5b5bc272-6666-4d24-8ddd-138fea511809";
        /*
         * Cria um objeto Json
         * Documentação: https://stleary.github.io/JSON-java/org/json/JSONObject.html
         */
        JsonObject obj = new JsonObject();

        /*
         * Injeção de dependência em no bean MatriculasEscolasService
         */
        @Inject
        @RestClient
        MatriculasEscolasService matriculasEscolasService;

        /*
         * Prepara o método para trazer todos os totais das Matriculas das Escolas
         * Municipais de Porto Alegre
         */
        @GET
        @Path("/all")
        public JsonObject getAllMatriculas() {
                /*
                 * Limpa o objeto Json antes de trazer os novos objetos
                 */
                obj.clear();
                /*
                 * Traz só os valores dos dados dentro do objeto 'records'
                 */
                obj.put("matriculas-escolas-all",
                                matriculasEscolasService.getAll(resource_id).getJsonObject("result")
                                                .getValue("records"));
                /*
                 * Retorna o objeto Json com todos objetos da API de Matrículas Escolas somente
                 * dentro de "records"
                 */
                return obj;
        }

        /*
         * Lista as Matrículas Cadastradas nas Escolas Municipais de Porto Alegre
         */
        @GET
        @Path("/listar-matriculas")
        public JsonObject listarMatriculasEscolas(
                        @QueryParam("fields") String codigo,
                        @QueryParam("fields") String nome,
                        @QueryParam("fields") String total

        ) {
                codigo = "codigo";
                nome = "nome";
                total = "total";
                /*
                 * Limpa o objeto Json antes de trazer os novos objetos
                 */
                obj.clear();
                /*
                 * Traz o código, nome e total de matrículas das escolas em um objeto limpo
                 */
                obj.put("matriculas-escolas-listar",
                                matriculasEscolasService.getListarMatriculas(resource_id, codigo, nome, total)
                                                .getJsonObject("result").getValue("records"));
                /*
                 * Retorna o objeto Json com os objetos da API de Matrículas Escolas somente
                 * dentro de "records" e que contém os atributos: codigo, nome e total de
                 * matriculas por escola
                 */
                return obj;
        }

        /*
         * Como o Get e Path funcionam para o filters:
         * http://localhost:3333/matriculas-escolas/datastore_search_Local/filtrar-
         * atributo-matriculas?filters=%7B%22codigo%22%3A105%7D
         */
        @GET
        @Path("/filtrar-atributo-matriculas")
        public JsonObject pesquisarAtributoMatriculasEscolas(
                        /*
                         * Tentativa frustrada de filtrar por atributo - fica para história e registro
                         * 
                         * @QueryParam("filters") @PathParam("{\"codigo\": " + "{codigo}" + "}")
                         * Integer codigo
                         */
                        @QueryParam("filters") String filters) {
                /*
                 * Limpa o objeto Json antes de trazer os novos objetos
                 */
                obj.clear();
                /*
                 * Traz somente um objeto da API de Matrículas das Escolas em um objeto limpo
                 */
                obj.put("matriculas-escolas-filtro",
                                matriculasEscolasService.getAtributoMatriculasEscolas(resource_id, filters)
                                                .getJsonObject("result").getValue("records"));
                /*
                 * Retorna o objeto Json somente com um objeto da API de Matrículas Escolas,
                 * dentro de "records", utilizando o "filters", e que contêm todos os
                 * atributos do objeto filtrado: _id,
                 * data_extracao, codigo, nome, ei_creche_parcial, ei_creche_integral,
                 * ei_creche, ei_pre_parcial, ei_pre_integral,
                 * ei_pre, ef_ciclos_parcial, ef_ciclos_integral, ef_ciclos, ef_eja,
                 * ensino_medio, normal_magisterio, profissionalizante, total
                 */
                return obj;
        }

        @GET
        @Path("/total-matriculas")
        public Integer totalMatriculadosEmMatriculasEscolas(
                        @QueryParam("fields") String totais) {
                Integer totalMatriculas = 0;
                totais = "total";
                /*
                 * Limpa o objeto Json antes de trazer os novos objetos
                 */
                obj.clear();
                /*
                 * Traz o total de matrículas em um objeto limpo
                 */
                obj.put("matriculas-escolas-total",
                                matriculasEscolasService.getTotalMatriculas(resource_id, totais)
                                                .getJsonObject("result").getValue("records"));

                for (int i = 0; i < obj.getJsonArray("matriculas-escolas-total").size(); i++) {
                        Integer a = totalMatriculas;
                        Integer b = (Integer) obj.getJsonArray("matriculas-escolas-total").getJsonObject(i)
                                        .getValue("total");
                        totalMatriculas = a + b;
                }

                /*
                 * Retorna a soma do atributo: total de matriculas por escola
                 */
                return totalMatriculas;
        }

        /*
         * Como o Get e Path funcionam para o filters:
         * http://localhost:3333/matriculas-escolas/datastore_search_Local/filtrar-
         * atributo-matriculas?filters=%7B%22codigo%22%3A105%7D
         */
        @GET
        @Path("/filtrar-codigo-matriculas/{_codigo}")
        public JsonObject pesquisarCodigoMatriculasEscolas(
                        /*
                         * Tentativa frustrada de filtrar por atributo - fica para história e registro
                         * 
                         * @QueryParam("filters") @PathParam("{\"codigo\": " + "{codigo}" + "}")
                         * Integer codigo
                         */
                        @PathParam("_codigo") Integer _codigo) {
                /*
                 * Limpa o objeto Json antes de trazer os novos objetos
                 */
                obj.clear();
                /*
                 * Traz somente um objeto da API de Matrículas das Escolas em um objeto limpo
                 */
                obj.put("codigo", _codigo);

                
                String serializad = obj.toString();
                obj.clear();
                obj.put("matricula-escola",
                                matriculasEscolasService.getAtributoMatriculasEscolas(resource_id, serializad)
                                                .getJsonObject("result").getValue("records"));
                /*
                 * Retorna o objeto Json somente com um objeto da API de Matrículas Escolas,
                 * dentro de "records", utilizando o "filters", e que contêm todos os
                 * atributos do objeto filtrado: _id,
                 * data_extracao, codigo, nome, ei_creche_parcial, ei_creche_integral,
                 * ei_creche, ei_pre_parcial, ei_pre_integral,
                 * ei_pre, ef_ciclos_parcial, ef_ciclos_integral, ef_ciclos, ef_eja,
                 * ensino_medio, normal_magisterio, profissionalizante, total
                 */
                return obj;
        }
}