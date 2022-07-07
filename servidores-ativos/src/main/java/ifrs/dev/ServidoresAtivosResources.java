package ifrs.dev;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

@Path("/servidores-ativos")
@Produces(MediaType.APPLICATION_JSON)
public class ServidoresAtivosResources {
  JsonObject obj = new JsonObject();

  @Inject
  @RestClient
  ServidoresAtivosService ServidoresAtivosService;

  // a base de dados é muito grande e pode ocorrer uma demora para carregar todos
  // os dados.
  @GET
  @Path("/lista-todos-servidores-ativos")
  @Timeout(10000)
  public JsonArray getAllSA() {
    return ServidoresAtivosService.getAll();
  }

  @GET
  @Path("/total-servidores-ativos")
  @Timeout(10000)
  public String getTotalServidoresAtivos() {
    return "Total de Servidores Ativos: " + getAllSA().size();
  }

  @GET
  @Path("/origem/{origem}")
  @Timeout(10000)
  public JsonArray getByOrigin(@PathParam("origem") String origem) {
    JsonArray newArray = new JsonArray();
    JsonArray array = getAllSA();

    for (int i = 0; i < 1000; i++) {
      if (array.getJsonObject(i).getValue("origem").toString().equalsIgnoreCase(origem)) {
        newArray.add(array.getJsonObject(i));
      }
    }

    return newArray;
  }

  @GET
  @Path("/total/{origem}")
  @Timeout(10000)
  public String getTotalServidoresAtivosByOrigin(@PathParam("origem") String origem) {
    return "Total de Servidores Ativos da Origem: " + origem + ": " + getByOrigin(origem).size();
  }

  @GET
  @Path("/salarios")
  @Timeout(10000)
  public double getSMEDBasicWage() {
    JsonArray array = getByOrigin("SMED");
    Double total = 0.0;
    Double media = 0.0;

    for (int i = 0; i < 1000; i++) {
      if (array.getJsonObject(i).getDouble("remuneracao_basica") != 0) {
        total += array.getJsonObject(i).getDouble("remuneracao_basica");
      }

    }
    media = total / array.size();
    System.out.println(("Total em reais de salários pagos para servidores da SMED: R$" + total + "\n")
        + ("Média salarial de servidores da SMED: R$" + media));
    return total;
  }
}