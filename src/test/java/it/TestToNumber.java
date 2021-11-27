package it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import application.rest.v1.Numberizer;

public class TestToNumber {

    @Test
    public void test_blank() throws Exception {
    	Response response = new Numberizer().toNumber("");
    	assertEquals(400, response.getStatus());
    }

    @Test
    public void test_literals() throws Exception {
    	assertEquals("1", new Numberizer().toNumber("i").readEntity(String.class));
    	assertEquals("1", new Numberizer().toNumber("I").readEntity(String.class));
    	assertEquals("2", new Numberizer().toNumber("ii").readEntity(String.class));
    	assertEquals("2", new Numberizer().toNumber("II").readEntity(String.class));
    	assertEquals("2", new Numberizer().toNumber("Ii").readEntity(String.class));
    	assertEquals("3", new Numberizer().toNumber("iii").readEntity(String.class));
    	assertEquals("3", new Numberizer().toNumber("III").readEntity(String.class));
    	assertEquals("4", new Numberizer().toNumber("IV").readEntity(String.class));
    	assertEquals("4", new Numberizer().toNumber("iv").readEntity(String.class));
    	assertEquals("5", new Numberizer().toNumber("v").readEntity(String.class));
    	assertEquals("5", new Numberizer().toNumber("V").readEntity(String.class));
    	assertEquals("10", new Numberizer().toNumber("X").readEntity(String.class));
    	assertEquals("10", new Numberizer().toNumber("x").readEntity(String.class));
    	assertEquals("50", new Numberizer().toNumber("L").readEntity(String.class));
    	assertEquals("50", new Numberizer().toNumber("l").readEntity(String.class));
    	assertEquals("100", new Numberizer().toNumber("c").readEntity(String.class));
    	assertEquals("500", new Numberizer().toNumber("d").readEntity(String.class));
    	assertEquals("1000", new Numberizer().toNumber("m").readEntity(String.class));
    }
    
    @Test
    public void test_nonRomanLiterals() throws Exception {
    	assertEquals(400, new Numberizer().toNumber("ia").getStatus());
    }

    @Test
    public void test_invalidRomanNumber1() throws Exception {
    	assertEquals(400, new Numberizer().toNumber("iiii").getStatus());
    }
 
    @Test
    public void test_invalidRomanNumber2() throws Exception {
    	assertEquals(400, new Numberizer().toNumber("XIXIX").getStatus());
    }

    @Test
    public void test_2899() throws Exception {
    	assertEquals("2899", new Numberizer().toNumber("MMDCCCXCIX").readEntity(String.class));
    }

    @Test
    public void test_2899_smallcase() throws Exception {
    	assertEquals("2899", new Numberizer().toNumber("mmdcccxcix").readEntity(String.class));
    }

    @Test
    public void test_944() throws Exception {
    	assertEquals("944", new Numberizer().toNumber("CMXLIV").readEntity(String.class));
    }

    @Test
    public void test_3999() throws Exception {
    	assertEquals("3999", new Numberizer().toNumber("MMMCMXCIX").readEntity(String.class));
    }

}
