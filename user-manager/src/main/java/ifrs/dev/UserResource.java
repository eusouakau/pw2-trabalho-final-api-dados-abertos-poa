package ifrs.dev;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import ifrs.dev.models.User;
import ifrs.dev.services.ServidoresAtivosService;
import ifrs.dev.services.UserService;
import io.vertx.core.json.JsonArray;
import ifrs.dev.services.CadastroEscolasService;
import ifrs.dev.services.MatriculasEscolasService;
import io.vertx.core.json.JsonObject;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

  @Inject
  UserService userService;

  @Inject
  @RestClient
  ServidoresAtivosService servidoresAtivosService;

  @Inject
  @RestClient
  CadastroEscolasService cadastroEscolasService;
  
  @Inject
  @RestClient
  MatriculasEscolasService matriculasEscolasService;


  @GET
  public Response getAllUsers() {
    try {
      return Response.status(Status.OK).entity(userService.getAllUsers()).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @GET
  @Path("/{name}")
  public Response getUserByName(@PathParam("name") String name) {
    try {
      return Response.status(Status.OK).entity(userService.getUserByName(name)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @POST
  public Response createUser(User user) {
    try {
      return Response.status(Status.CREATED).entity(userService.createUser(user)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @POST
  @Path("/login")
  public Response login(User user) {
    try {
      return Response.status(Status.OK).entity(userService.login(user)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @PUT
  @Path("/atualizar/{id}")
  public Response updateUser(@PathParam("id") Long id, User user) {
    try {
      return Response.status(Status.OK).entity(userService.updateUser(user)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @DELETE
  @Path("/deletar/{id}")
  public Response deleteUser(@PathParam("id") Long id) {
    try {
      return Response.status(Status.OK).entity(userService.deleteUser(id)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }

  }

  //  SERVIDORES ATIVOS
  @GET
  @Path("/servidores/lista-todos-servidores-ativos")
  public JsonArray getAllSA() {
    return servidoresAtivosService.getAllSA();
  }

  @GET
  @Path("/servidores/total-servidores-ativos")
  public String getTotalServidoresAtivos() {
     return servidoresAtivosService.getTotalServidoresAtivos();
  }
    

  @GET
  @Path("/servidores/origem/{origem}")
  public JsonArray getByOrigin(@PathParam("origem") String origem) {
    return servidoresAtivosService.getByOrigin(origem);
  }


  @GET
  @Path("/servidores/total/{origem}")
  public String getTotalServidoresAtivosByOrigin(@PathParam("origem") String origem) {
    return servidoresAtivosService.getTotalServidoresAtivosByOrigin(origem);
  }

  @GET
  @Path("/servidores/salarios")
  public double getSMEDBasicWage() {
    return servidoresAtivosService.getSMEDBasicWage();
  }
  
  // CADASTROS ESCOLAS
  @GET
  @Path("/escolas/lista-todos-cadastros-escolas")
  public JsonArray getAllCE() {
    return cadastroEscolasService.getAllCE();
  }

  @GET
  @Path("/escolas/codigo/{_codigo}")
  public JsonObject getCEByCodigo(@PathParam("_codigo") Integer _codigo) {
    return cadastroEscolasService.getCEByCodigo(_codigo);
  }

  @GET
  @Path("/escolas/quantidade/")
  public String getQuantidadeByDepAdm() {
    return cadastroEscolasService.getQuantidadeByDepAdm();
  }

  @GET
  @Path("/escolas/nome/{_name}")
  public JsonArray findByName(@PathParam("_name") String _name) {
    return cadastroEscolasService.findByName(_name);
  }

  // MATRICULAS ESCOLAS
  @GET
  @Path("/matriculas/lista-matriculas-escolas")
  public JsonObject getAllMatriculas(){
    return matriculasEscolasService.getAllMatriculas();
  }

  @GET
  @Path("/matriculas/listar-matriculas")
  public JsonObject listarMatriculasEscolas(@QueryParam("fields") String codigo, @QueryParam("fields") String nome, @QueryParam("fields") String total) {
    return matriculasEscolasService.listarMatriculasEscolas(codigo, nome, total);
  }

  @GET
  @Path("/matriculas/total-matriculas")
  public Integer totalMatriculadosEmMatriculasEscolas(@QueryParam("fields") String totais){
    return matriculasEscolasService.totalMatriculadosEmMatriculasEscolas(totais);
  }

  @GET
  @Path("/matriculas/filtrar-codigo-matriculas/{_codigo}")
  public JsonObject pesquisarCodigoMatriculasEscolas(@PathParam("_codigo") Integer _codigo){
    return matriculasEscolasService.pesquisarCodigoMatriculasEscolas(_codigo);
  }

  @GET
  @Path("/matriculas/filtrar-nome-matriculas-escolas-objetos/{_nome}")
  public JsonArray pesquisarNomeMatriculasEscolasObjetos( @PathParam("_nome") String _nome){
    return matriculasEscolasService.pesquisarNomeMatriculasEscolasObjetos(_nome);
  }

  @GET
  @Path("/matriculas/filtrar-nome-matriculas-escolas-nomes/{_nome}")
  public ArrayList<String> pesquisarNomeMatriculasEscolasNomes( @PathParam("_nome") String _nome){
    return matriculasEscolasService.pesquisarNomeMatriculasEscolasNomes(_nome);
  }

}


  