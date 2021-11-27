package application.rest.v1;


import java.util.regex.Pattern;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("to-number")
public class Numberizer {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response toNumber(@QueryParam("value") String romanNumber) {
    	
    	ResponseBuilder responseBuilder = Response.noContent();
    	responseBuilder.header("Content-Type", "text/plain");
    	
    	if( romanNumber == null || romanNumber.length() == 0 ) {
    		return responseBuilder.status(400).entity("Bad Request").build();
    	}
    	
    	romanNumber = romanNumber.toUpperCase();
    	
    	if( !isValidRoman(romanNumber) ) {
    		return responseBuilder.status(400).entity("Bad Request").build();
    	}
    	
        int decimalNumber = 0;
        
        try {
            for (int i = 0; i < romanNumber.length(); i++){
                int romanChar = getValue(romanNumber.charAt(i));

                if (i + 1 < romanNumber.length()){
                    int romanNextChar = getValue(romanNumber.charAt(i + 1));
     
                   if (romanChar >= romanNextChar){
                        decimalNumber = decimalNumber + romanChar;
                    }
                    else{
                        decimalNumber = decimalNumber + romanNextChar - romanChar;
                        i++;
                    }
                }
                else {
                    decimalNumber = decimalNumber + romanChar;
                }
            }
            
        }catch(Exception e) {
        	return responseBuilder.status(400).entity("Bad Request").build();
        }
 
		return responseBuilder.status(200).entity(decimalNumber+"").build();
    }
    
    private boolean isValidRoman(String roman) {
    	
    	boolean isRoman = Pattern.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})", roman);  
    	if( isRoman ) return true;

    	return false;
    }
    

    private int getValue(char romanLiteral) throws Exception{
    	if (romanLiteral == 'I') return 1;
            
        if (romanLiteral == 'V') return 5;
            
        if (romanLiteral == 'X') return 10;
            
        if (romanLiteral == 'L') return 50;
            
        if (romanLiteral == 'C') return 100;
            
        if (romanLiteral == 'D') return 500;
            
        if (romanLiteral == 'M') return 1000;
            
        throw new Exception("Not a roman number");
    }
}
