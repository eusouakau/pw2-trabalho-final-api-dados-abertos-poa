package ifrs.dev;

import java.util.Arrays;
import java.util.HashSet;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.Claims;

public class Jwt {

    @GET
    @Path("/jwt")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String generate(@Context SecurityContext ctx) {
        return Jwt.issuer("http://localhost:3006")
                .upn("")
                .groups(new HashSet<>(Arrays.asList("User")))
                .claim(Claims.full_name, "")
                .sign();
    }
    
}
