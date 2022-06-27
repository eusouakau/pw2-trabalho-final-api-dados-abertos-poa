package ifrs.dev.services;

// import javax.ws.rs.GET;
// import javax.ws.rs.Path;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8080/cadastro-escolas")
public interface CadastroEscolasService {

    // @GET
    // @Path("/escolas")
    // @Produces(MediaType.APPLICATION_JSON)
    //public List<Escola> getAllEscolas();

}
