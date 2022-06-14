package ifrs.dev;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ifrs.dev.models.Servidor;
import ifrs.dev.ServidoresAtivosService;


@Path("/servidores-ativos")
public class ServidoresAtivosResources {

    @Inject
    ServidoresAtivosService servidoresAtivosService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/origem")
    public List<Servidor> getOrigemServidoresAtivos(@QueryParam("origem") String origem) {

        return servidoresAtivosService.findByOrigem(origem);
    }
}
