package application.rest.v1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import application.impl.numbertoroman.DecimalToRomanImpl;

@Path("to-roman")
public class DecimalToRomanInterface {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response toRoman(@QueryParam("value") String value) {

        ResponseBuilder responseBuilder = Response.noContent();
        responseBuilder.header("Content-Type", "text/plain");

        DecimalToRomanImpl toRomanImpl = new DecimalToRomanImpl();
        String roman;
        try {
            roman = toRomanImpl.toRoman(value);
        } catch (Exception e) {
            return responseBuilder.status(400).entity(e.getMessage()).build();
        }
        return responseBuilder.status(200).entity(roman).build();
    }
}
