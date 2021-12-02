package application.rest.v1;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import application.impl.romantonumber.RomanToDecimalImpl;

@Path("to-number")
public class RomanToDecimalInterface {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response toNumber(@QueryParam("value") String romanNumber) {
    	
    	ResponseBuilder responseBuilder = Response.noContent();
    	responseBuilder.header("Content-Type", "text/plain");
    	
    	RomanToDecimalImpl romanToDecimal = new RomanToDecimalImpl();
    	
    	String decimal;
    	try {
    		decimal = romanToDecimal.toNumber(romanNumber);
    	}catch(Exception e) {
    		return responseBuilder.status(400).entity(e.getMessage()).build();
    	}
    	
    	return responseBuilder.status(200).entity(decimal).build();
    	
    }
    
}
