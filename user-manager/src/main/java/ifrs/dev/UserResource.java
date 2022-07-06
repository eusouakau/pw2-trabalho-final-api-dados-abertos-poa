package ifrs.dev;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import ifrs.dev.models.User;
import ifrs.dev.services.CadastroEscolasService;
import ifrs.dev.services.UserService;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

  @Inject
  @RestClient
  CadastroEscolasService cadastroEscolasService;

  @Inject
  UserService userService;

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

}
