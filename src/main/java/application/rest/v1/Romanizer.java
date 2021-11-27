package application.rest.v1;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("to-roman")
public class Romanizer {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response toRoman(@QueryParam("value") String value) {
    	
    	ResponseBuilder responseBuilder = Response.noContent();
    	responseBuilder.header("Content-Type", "text/plain");
    	
    	String roman = "";
    	int quotient = -1;
    	int remainder = -1;
    	
    	int number;
    	try {
        	number = Integer.parseInt(value);
    	}catch(NumberFormatException nfe) {
    		return responseBuilder.status(400).entity("Bad Request").build();
    	}
    	
    	if( number < 0 || number > 3999 ) {
    		return responseBuilder.status(400).entity("Bad Request").build();
    	}
    	if( number == 0 ) {
            return responseBuilder.status(200).entity("nulla").build();
    	}
    	
    	if( number == 1 ) {
            return responseBuilder.status(200).entity("I").build();
    	}

    	if( number == 2 ) {
            return responseBuilder.status(200).entity("II").build();
    	}
    	
    	if( number >= 1000 ) {
    		quotient = number / 1000;
    		remainder = number % 1000;
    		for( int i = 0; i < quotient; i++ ) {
    			roman = roman + "M";
    		}
    	}
    	
    	if( remainder == -1 ) {
    		remainder = number;
    	}
    	
    	if( remainder >= 900 ) {
    		roman = roman + "CM";
    		remainder = remainder - 900;
    	}else if( remainder >= 500 ) {
			roman = roman + "D";
			remainder = remainder - 500;
		}
    	
    	if( remainder >= 400 ) {
    		roman = roman + "CD";
    		remainder = remainder - 400;
		}else if( remainder >= 100 ) {
			quotient = remainder / 100;
			remainder = remainder % 100;
    		for( int i = 0; i < quotient; i++ ) {
    			roman = roman + "C";
    		}
		}
    	
    	if( remainder >= 90 ) {
    		roman = roman + "XC";
    		remainder = remainder - 90;
    	}else if( remainder >= 50 ) {
			quotient = remainder / 50;
			remainder = remainder % 50;
    		for( int i = 0; i < quotient; i++ ) {
    			roman = roman + "L";
    		}
		}
    	
    	if( remainder >= 40 ) {
    		roman = roman + "XL";
    		remainder = remainder - 40;
		}else if( remainder >= 10 ) {
			quotient = remainder / 10;
			remainder = remainder % 10;
    		for( int i = 0; i < quotient; i++ ) {
    			roman = roman + "X";
    		}
		}
    	
    	if( remainder == 9 ) { 
    		roman = roman + "IX";
			remainder = 0;
    	}else if( remainder >= 5 ) { 
    		roman = roman + "V";
    		remainder = remainder - 5;
    		for( int i = 0; i < remainder; i++ ) {
    			roman = roman + "I";
    		}
    		remainder = 0;
		}
    	
    	if( remainder == 4 ) { // 10s block
    		roman = roman + "IV";
			remainder = 0;
		}else{
    		for( int i = 0; i < remainder; i++ ) {
    			roman = roman + "I";
    		}
			remainder = 0;
		}
    	
		return responseBuilder.status(200).entity(roman).build();
    }
}
