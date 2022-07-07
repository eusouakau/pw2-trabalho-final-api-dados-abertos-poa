package ifrs.dev.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@RegisterRestClient(baseUri = "http://localhost:3333/matriculas-escolas")
@Produces(MediaType.APPLICATION_JSON)
public interface MatriculasEscolasService {
    
    @GET
    @Path("/lista-matriculas-escolas")
    public JsonObject getAllMatriculas();

    @GET
    @Path("/listar-matriculas")
    public JsonObject listarMatriculasEscolas(@QueryParam("fields") String codigo, @QueryParam("fields") String nome, @QueryParam("fields") String total);

    @GET
    @Path("/total-matriculas")
    public Integer totalMatriculadosEmMatriculasEscolas(@QueryParam("fields") String totais);

    @GET
    @Path("/filtrar-codigo-matriculas/{_codigo}")
    public JsonObject pesquisarCodigoMatriculasEscolas(@PathParam("_codigo") Integer _codigo);

    @GET
    @Path("/filtrar-nome-matriculas-escolas-objetos/{_nome}")
    public JsonArray pesquisarNomeMatriculasEscolasObjetos( @PathParam("_nome") String _nome);

    @GET
    @Path("/filtrar-nome-matriculas-escolas-nomes/{_nome}")
    public ArrayList<String> pesquisarNomeMatriculasEscolasNomes( @PathParam("_nome") String _nome);
}
