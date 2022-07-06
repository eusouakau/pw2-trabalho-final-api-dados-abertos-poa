package ifrs.edu;

import java.util.ArrayList;
import javax.inject.Inject;
import javax.json.JsonException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Timeout;
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
         * Cria um objeto Json que será usado em cada método
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
         * de Porto Alegre
         */
        @GET
        @Path("/lista-matriculas-escolas")
        @Timeout(1000)
        public JsonObject getAllMatriculas() {
                try {
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
                } catch (JsonException jException) {
                        jException.getStackTrace();

                } catch (Exception e) {
                        e.getStackTrace();
                }
                return obj;
        }

        /*
         * Lista as Matrículas Cadastradas nas Escolas de Porto Alegre
         */
        @GET
        @Path("/listar-matriculas")
        @Timeout(1000)
        public JsonObject listarMatriculasEscolas(
                        @QueryParam("fields") String codigo,
                        @QueryParam("fields") String nome,
                        @QueryParam("fields") String total

        ) {
                try {
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
                } catch (JsonException jException) {
                        jException.getStackTrace();
                } catch (Exception e) {
                        e.getStackTrace();
                }
                return obj;
        }

        /*
         * Soma o total das Matrículas Cadastradas nas Escolas de Porto Alegre
         */
        @GET
        @Path("/total-matriculas")
        @Timeout(1000)
        public Integer totalMatriculadosEmMatriculasEscolas(
                        @QueryParam("fields") String totais) {
                Integer totalMatriculas = 0;
                try {
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
                } catch (JsonException jException) {
                        jException.getStackTrace();
                } catch (Exception e) {
                        e.getStackTrace();
                }
                return totalMatriculas;
        }

        /*
         * Como o Get e Path funcionavam para o filters:
         * http://localhost:3333/matriculas-escolas/datastore_search_Local/filtrar-
         * atributo-matriculas?filters=%7B%22codigo%22%3A105%7D
         */
        @GET
        @Path("/filtrar-codigo-matriculas/{_codigo}")
        @Timeout(1000)
        public JsonObject pesquisarCodigoMatriculasEscolas(
                        /*
                         * Tentativa frustrada de filtrar por atributo - fica para história e registro
                         * 
                         * @QueryParam("filters") @PathParam("{\"codigo\": " + "{codigo}" + "}")
                         * Integer codigo
                         */
                        @PathParam("_codigo") Integer _codigo) {
                try {
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
                } catch (JsonException jException) {
                        jException.getStackTrace();
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return obj;
        }

        /*
         * Como o Get e Path funcionavam para o filters:
         * http://localhost:3333/matriculas-escolas/datastore_search_Local/filtrar-
         * atributo-matriculas?filters=%7B%22codigo%22%3A105%7D
         */
        @GET
        @Path("/filtrar-nome-matriculas-escolas-objetos/{_nome}")
        @Timeout(17000)
        public JsonArray pesquisarNomeMatriculasEscolasObjetos(
                        @PathParam("_nome") String _nome) {
                JsonArray novoJsonArray = new JsonArray();
                try {
                        /*
                         * Limpa o objeto Json antes de trazer os novos objetos
                         */
                        obj.clear();

                        String serializad = obj.toString();
                        obj.clear();
                        /*
                         * Traz os resultados da API de matrículas-escolas em um array limpo
                         */
                        obj.put("matricula-escola-nome",
                                        matriculasEscolasService.getAtributoMatriculasEscolas(resource_id, serializad)
                                                        .getJsonObject("result").getValue("records"));
                        /*
                         * Percorre todo o JsonArray
                         */
                        for (int i = 0; i < obj.getJsonArray("matricula-escola-nome").size(); i++) {
                                /*
                                 * Cria uma variável para inserir o atribuito "nome" que está no Objeto do
                                 * JsonArray
                                 */
                                String valorNomeObjJson = (String) obj.getJsonArray("matricula-escola-nome")
                                                .getJsonObject(i).getValue("nome");

                                /*
                                 * Verifica se o atributo "nome" do Objeto do JsonArray contém a palavra
                                 * pesquisada passada como parâmetro: _nome
                                 */
                                if (valorNomeObjJson.contains(_nome.toUpperCase())) {
                                        /*
                                         * Adiciona em um JsonArray limpo o Objeto do Json localizado, caso o nome
                                         * corresponda ao parâmetro enviado
                                         */
                                        novoJsonArray.add(obj.getJsonArray("matricula-escola-nome")
                                                        .getJsonObject(i));
                                }
                                // if(!valorNomeObjJson.contains(_nome.toUpperCase())){
                                // novoJsonArray.add("O nome informado não existe.");
                                // }
                        }
                } catch (NullPointerException nullPointerExcecao) {
                        nullPointerExcecao.getStackTrace();
                } catch (JsonException jException) {
                        jException.getStackTrace();
                } catch (Exception e) {
                        e.printStackTrace();
                }
                /*
                 * Retorna o objeto JsonArray somente com o objeto da API de Matrículas Escolas,
                 * dentro de "records", utilizando o "filters", e que contêm todos os
                 * atributos do objeto filtrado: _id,
                 * data_extracao, codigo, nome, ei_creche_parcial, ei_creche_integral,
                 * ei_creche, ei_pre_parcial, ei_pre_integral,
                 * ei_pre, ef_ciclos_parcial, ef_ciclos_integral, ef_ciclos, ef_eja,
                 * ensino_medio, normal_magisterio, profissionalizante, total
                 */
                return novoJsonArray;
        }

        /*
         * Como o Get e Path funcionavam para o filters:
         * http://localhost:3333/matriculas-escolas/datastore_search_Local/filtrar-
         * atributo-matriculas?filters=%7B%22codigo%22%3A105%7D
         */
        @GET
        @Path("/filtrar-nome-matriculas-escolas-nomes/{_nome}")
        @Timeout(17000)
        public ArrayList<String> pesquisarNomeMatriculasEscolasNomes(
                        @PathParam("_nome") String _nome) {
                ArrayList<String> novoArrayList = new ArrayList<String>();
                try {
                        /*
                         * Limpa o objeto Json antes de trazer os novos objetos
                         */
                        obj.clear();
                        /*
                         * 
                         */
                        String serializad = obj.toString();
                        obj.clear();
                        /*
                         * Traz o resultado da API de matrículas-escolas em um objeto limpo
                         */
                        obj.put("matricula-escola-nome",
                                        matriculasEscolasService.getAtributoMatriculasEscolas(resource_id, serializad)
                                                        .getJsonObject("result").getValue("records"));
                        for (int i = 0; i < obj.getJsonArray("matricula-escola-nome").size(); i++) {
                                String valorNomeObjJson = (String) obj.getJsonArray("matricula-escola-nome")
                                                .getJsonObject(i).getValue("nome");
                                /*
                                 * Verifica se o _nome enviado contém na API de matriculas-escolas
                                 */
                                if (valorNomeObjJson.contains(_nome.toUpperCase())) {
                                        /* Adiciona no novo ArrayList só os nomes que contém a palavra pesquisada */
                                        novoArrayList.add(valorNomeObjJson);
                                }
                        }
                } catch (NullPointerException nullPointerExcecao) {
                        nullPointerExcecao.getStackTrace();
                } catch (JsonException jException) {
                        jException.getStackTrace();
                } catch (Exception e) {
                        e.printStackTrace();
                }
                /*
                 * Retorna o objeto JsonArray somente com o objeto da API de Matrículas Escolas
                 * pesquisado,
                 * dentro de "records", utilizando o "filters", e que contêm todos os
                 * atributos do objeto filtrado: _id,
                 * data_extracao, codigo, nome, ei_creche_parcial, ei_creche_integral,
                 * ei_creche, ei_pre_parcial, ei_pre_integral,
                 * ei_pre, ef_ciclos_parcial, ef_ciclos_integral, ef_ciclos, ef_eja,
                 * ensino_medio, normal_magisterio, profissionalizante, total
                 */
                return novoArrayList;
        }
}