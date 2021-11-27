package it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import application.rest.v1.Romanizer;

public class TestToRoman {

    @Test
    public void test_0() throws Exception {
    	Response response = new Romanizer().toRoman("0");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("nulla", convertedData);
    }
    
    @Test
    public void testNoValue() throws Exception {
    	Response response = new Romanizer().toRoman("");
    	assertEquals(400, response.getStatus());
    }

    
    @Test
    public void testNegative() throws Exception {
    	Response response = new Romanizer().toRoman("-1");
    	assertEquals(400, response.getStatus());
    	response = new Romanizer().toRoman("-99");
    	assertEquals(400, response.getStatus());
    }
    
    @Test
    public void testGreaterThan3999() throws Exception {
    	Response response = new Romanizer().toRoman("4000");
    	assertEquals(400, response.getStatus());
    }
    
    @Test
    public void testFloat() throws Exception {
    	Response response = new Romanizer().toRoman("2.5");
    	assertEquals(400, response.getStatus());
    }
    
    
    @Test
    public void test1() throws Exception {
    	Response response = new Romanizer().toRoman("1");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("I", convertedData);
    }
    
    @Test
    public void test2() throws Exception {
    	Response response = new Romanizer().toRoman("2");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("II", convertedData);
    } 
    
    @Test
    public void test3000() throws Exception {
    	Response response = new Romanizer().toRoman("3000");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MMM", convertedData);
    }
    	
    @Test
    public void test3500() throws Exception {
    	Response response = new Romanizer().toRoman("3500");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MMMD", convertedData);
    }

    @Test
    public void test3700() throws Exception {
    	Response response = new Romanizer().toRoman("3700");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MMMDCC", convertedData);
    }

    @Test
    public void test3900() throws Exception {
    	Response response = new Romanizer().toRoman("3900");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MMMCM", convertedData);
    }

    @Test
    public void test3999() throws Exception {
    	Response response = new Romanizer().toRoman("3999");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MMMCMXCIX", convertedData);
    }

    @Test
    public void test3861() throws Exception {
    	Response response = new Romanizer().toRoman("3861");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MMMDCCCLXI", convertedData);
    }
    
    @Test
    public void test9() throws Exception {
    	Response response = new Romanizer().toRoman("9");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("IX", convertedData);
    }

    @Test
    public void test19() throws Exception {
    	Response response = new Romanizer().toRoman("19");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("XIX", convertedData);
    }

    @Test
    public void test30() throws Exception {
    	Response response = new Romanizer().toRoman("30");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("XXX", convertedData);
    }
    
    @Test
    public void test49() throws Exception {
    	Response response = new Romanizer().toRoman("49");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("XLIX", convertedData);
    }
    
    @Test
    public void test46() throws Exception {
    	Response response = new Romanizer().toRoman("46");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("XLVI", convertedData);
    }

    @Test
    public void test79() throws Exception {
    	Response response = new Romanizer().toRoman("79");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("LXXIX", convertedData);
    }

    @Test
    public void test0001() throws Exception {
    	Response response = new Romanizer().toRoman("0001");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("I", convertedData);
    }

    @Test
    public void test99() throws Exception {
    	Response response = new Romanizer().toRoman("99");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("XCIX", convertedData);
    }

    @Test
    public void test101() throws Exception {
    	Response response = new Romanizer().toRoman("101");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("CI", convertedData);
    }

    @Test
    public void test399() throws Exception {
    	Response response = new Romanizer().toRoman("399");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("CCCXCIX", convertedData);
    }

    @Test
    public void test400() throws Exception {
    	Response response = new Romanizer().toRoman("400");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("CD", convertedData);
    }

    @Test
    public void test900() throws Exception {
    	Response response = new Romanizer().toRoman("900");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("CM", convertedData);
    }

    @Test
    public void test956() throws Exception {
    	Response response = new Romanizer().toRoman("956");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("CMLVI", convertedData);
    }

    @Test
    public void test950() throws Exception {
    	Response response = new Romanizer().toRoman("950");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("CML", convertedData);
    }
    
    @Test
    public void test2899() throws Exception {
    	Response response = new Romanizer().toRoman("2899");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MMDCCCXCIX", convertedData);
    }

    @Test
    public void test1000() throws Exception {
    	Response response = new Romanizer().toRoman("1000");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("M", convertedData);
    }
    
    @Test
    public void test1099() throws Exception {
    	Response response = new Romanizer().toRoman("1099");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MXCIX", convertedData);
    }

    @Test
    public void test944() throws Exception {
    	Response response = new Romanizer().toRoman("944");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("CMXLIV", convertedData);
    }

    @Test
    public void test1001() throws Exception {
    	Response response = new Romanizer().toRoman("1001");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MI", convertedData);
    }
    
    @Test
    public void test1400() throws Exception {
    	Response response = new Romanizer().toRoman("1400");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("MCD", convertedData);
    }


}
