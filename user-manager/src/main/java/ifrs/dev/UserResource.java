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

import org.eclipse.microprofile.faulttolerance.Timeout;
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
  @Timeout(10000)
  public Response getAllUsers() {
    try {
      return Response.status(Status.OK).entity(userService.getAllUsers()).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @GET
  @Path("/{name}")
  @Timeout(10000)
  public Response getUserByName(@PathParam("name") String name) {
    try {
      return Response.status(Status.OK).entity(userService.getUserByName(name)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @POST
  @Timeout(10000)
  public Response createUser(User user) {
    try {
      return Response.status(Status.CREATED).entity(userService.createUser(user)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @POST
  @Path("/login")
  @Timeout(10000)
  public Response login(User user) {
    try {
      return Response.status(Status.OK).entity(userService.login(user)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @PUT
  @Path("/atualizar/{id}")
  @Timeout(10000)
  public Response updateUser(@PathParam("id") Long id, User user) {
    try {
      return Response.status(Status.OK).entity(userService.updateUser(user)).build();
    } catch (Exception e) {
      return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
  }

  @DELETE
  @Path("/deletar/{id}")
  @Timeout(10000)
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
  @Timeout(10000)
  public JsonArray getAllSA() {
    return servidoresAtivosService.getAllSA();
  }

  @GET
  @Path("/servidores/total-servidores-ativos")
  @Timeout(10000)
  public String getTotalServidoresAtivos() {
     return servidoresAtivosService.getTotalServidoresAtivos();
  }
    

  @GET
  @Path("/servidores/origem/{origem}")
  @Timeout(10000)
  public JsonArray getByOrigin(@PathParam("origem") String origem) {
    return servidoresAtivosService.getByOrigin(origem);
  }


  @GET
  @Path("/servidores/total/{origem}")
  @Timeout(10000)
  public String getTotalServidoresAtivosByOrigin(@PathParam("origem") String origem) {
    return servidoresAtivosService.getTotalServidoresAtivosByOrigin(origem);
  }

  @GET
  @Path("/servidores/salarios")
  @Timeout(10000)
  public double getSMEDBasicWage() {
    return servidoresAtivosService.getSMEDBasicWage();
  }
  
  // CADASTROS ESCOLAS
  @GET
  @Path("/escolas/lista-todos-cadastros-escolas")
  @Timeout(10000)
  public JsonArray getAllCE() {
    return cadastroEscolasService.getAllCE();
  }

  @GET
  @Path("/escolas/codigo/{_codigo}")
  @Timeout(10000)
  public JsonObject getCEByCodigo(@PathParam("_codigo") Integer _codigo) {
    return cadastroEscolasService.getCEByCodigo(_codigo);
  }

  @GET
  @Path("/escolas/quantidade/")
  @Timeout(10000)
  public String getQuantidadeByDepAdm() {
    return cadastroEscolasService.getQuantidadeByDepAdm();
  }

  @GET
  @Path("/escolas/nome/{_name}")
  @Timeout(10000)
  public JsonArray findByName(@PathParam("_name") String _name) {
    return cadastroEscolasService.findByName(_name);
  }

  // MATRICULAS ESCOLAS
  @GET
  @Path("/matriculas/lista-matriculas-escolas")
  @Timeout(10000)
  public JsonObject getAllMatriculas(){
    return matriculasEscolasService.getAllMatriculas();
  }

  @GET
  @Path("/matriculas/listar-matriculas")
  @Timeout(10000)
  public JsonObject listarMatriculasEscolas(@QueryParam("fields") String codigo, @QueryParam("fields") String nome, @QueryParam("fields") String total) {
    return matriculasEscolasService.listarMatriculasEscolas(codigo, nome, total);
  }

  @GET
  @Path("/matriculas/total-matriculas")
  @Timeout(10000)
  public Integer totalMatriculadosEmMatriculasEscolas(@QueryParam("fields") String totais){
    return matriculasEscolasService.totalMatriculadosEmMatriculasEscolas(totais);
  }

  @GET
  @Path("/matriculas/filtrar-codigo-matriculas/{_codigo}")
  @Timeout(10000)
  public JsonObject pesquisarCodigoMatriculasEscolas(@PathParam("_codigo") Integer _codigo){
    return matriculasEscolasService.pesquisarCodigoMatriculasEscolas(_codigo);
  }

  @GET
  @Path("/matriculas/filtrar-nome-matriculas-escolas-objetos/{_nome}")
  @Timeout(10000)
  public JsonArray pesquisarNomeMatriculasEscolasObjetos( @PathParam("_nome") String _nome){
    return matriculasEscolasService.pesquisarNomeMatriculasEscolasObjetos(_nome);
  }

  @GET
  @Path("/matriculas/filtrar-nome-matriculas-escolas-nomes/{_nome}")
  @Timeout(10000)
  public ArrayList<String> pesquisarNomeMatriculasEscolasNomes( @PathParam("_nome") String _nome){
    return matriculasEscolasService.pesquisarNomeMatriculasEscolasNomes(_nome);
  }

}


  