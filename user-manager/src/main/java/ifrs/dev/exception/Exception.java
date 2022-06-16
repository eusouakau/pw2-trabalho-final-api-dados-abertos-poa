package ifrs.dev.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class Exception extends WebApplicationException{


    public Exception(String message, Status status) {
        super(Response.status(status).entity(message).build());
    }

    public Exception(String message) {
        super(Response.status(Status.NOT_FOUND).entity(message).build());
    }   
    
}
