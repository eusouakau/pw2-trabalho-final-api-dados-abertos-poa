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

import ifrs.dev.models.User;
import ifrs.dev.services.UserService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    
    @Inject
    UserService userService;
    
    @GET
    public Response getAllUsers() {
        try{
            return Response.status(Status.OK).entity(userService.getAllUsers()).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") long id) {
        try{
            return Response.status(Status.OK).entity(userService.getUserById(id)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{name}")
    public Response getUserByName(@PathParam("name") String name) {
        try{
            return Response.status(Status.OK).entity(userService.getUserByName(name)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    
    @POST
    public Response createUser(User user) {
        try{
            return Response.status(Status.CREATED).entity(userService.createUser(user)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    public Response login(User user) {
        try{
            return Response.status(Status.OK).entity(userService.login(user)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizar/{id}")
    public Response updateUser(@PathParam("id") Long id, User user) {
        try{
            return Response.status(Status.OK).entity(userService.updateUser(user)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/deletar/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        try{
            return Response.status(Status.OK).entity(userService.deleteUser(id)).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
