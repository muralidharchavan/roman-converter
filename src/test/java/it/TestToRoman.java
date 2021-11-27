package it;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;

import application.rest.v1.Romanizer;

public class TestToRoman {

    @Test
    public void test_0() throws Exception {
    	assertEquals("nulla", new Romanizer().toRoman("0").readEntity(String.class));
    }
    
    @Test
    public void testNoValue() throws Exception {
    	assertEquals(400, new Romanizer().toRoman("").getStatus());
    }
    
    @Test
    public void testNegative() throws Exception {
    	assertEquals(400, new Romanizer().toRoman("-1").getStatus());
    	assertEquals(400, new Romanizer().toRoman("-99").getStatus());
    }
    
    @Test
    public void testGreaterThan3999() throws Exception {
    	assertEquals(400, new Romanizer().toRoman("4000").getStatus());
    }
    
    @Test
    public void testFloat() throws Exception {
    	assertEquals(400, new Romanizer().toRoman("2.5").getStatus());
    }
    
    
    @Test
    public void test1() throws Exception {
    	assertEquals("I", new Romanizer().toRoman("1").readEntity(String.class));
    }
    
    @Test
    public void test2() throws Exception {
    	assertEquals("II", new Romanizer().toRoman("2").readEntity(String.class));
    } 
    
    @Test
    public void test3000() throws Exception {
    	assertEquals("MMM", new Romanizer().toRoman("3000").readEntity(String.class));
    }
    	
    @Test
    public void test3500() throws Exception {
    	assertEquals("MMMD", new Romanizer().toRoman("3500").readEntity(String.class));
    }

    @Test
    public void test3700() throws Exception {
    	assertEquals("MMMDCC", new Romanizer().toRoman("3700").readEntity(String.class));
    }

    @Test
    public void test3900() throws Exception {
    	assertEquals("MMMCM", new Romanizer().toRoman("3900").readEntity(String.class));
    }

    @Test
    public void test3999() throws Exception {
    	assertEquals("MMMCMXCIX", new Romanizer().toRoman("3999").readEntity(String.class));
    }

    @Test
    public void test3861() throws Exception {
    	assertEquals("MMMDCCCLXI", new Romanizer().toRoman("3861").readEntity(String.class));
    }
    
    @Test
    public void test9() throws Exception {
    	assertEquals("IX", new Romanizer().toRoman("9").readEntity(String.class));
    }

    @Test
    public void test19() throws Exception {
    	assertEquals("XIX", new Romanizer().toRoman("19").readEntity(String.class));
    }

    @Test
    public void test30() throws Exception {
    	assertEquals("XXX", new Romanizer().toRoman("30").readEntity(String.class));
    }
    
    @Test
    public void test49() throws Exception {
    	assertEquals("XLIX", new Romanizer().toRoman("49").readEntity(String.class));
    }
    
    @Test
    public void test46() throws Exception {
    	assertEquals("XLVI", new Romanizer().toRoman("46").readEntity(String.class));
    }

    @Test
    public void test79() throws Exception {
    	assertEquals("LXXIX", new Romanizer().toRoman("79").readEntity(String.class));
    	Response response = new Romanizer().toRoman("79");
    	String convertedData = response.readEntity(String.class);
    	assertEquals("LXXIX", convertedData);
    }

    @Test
    public void test0001() throws Exception {
    	assertEquals("I", new Romanizer().toRoman("0001").readEntity(String.class));
    }

    @Test
    public void test99() throws Exception {
    	assertEquals("XCIX", new Romanizer().toRoman("99").readEntity(String.class));
    }

    @Test
    public void test101() throws Exception {
    	assertEquals("CI", new Romanizer().toRoman("101").readEntity(String.class));
    }

    @Test
    public void test399() throws Exception {
    	assertEquals("CCCXCIX", new Romanizer().toRoman("399").readEntity(String.class));
    }

    @Test
    public void test400() throws Exception {
    	assertEquals("CD", new Romanizer().toRoman("400").readEntity(String.class));
    }

    @Test
    public void test900() throws Exception {
    	assertEquals("CM", new Romanizer().toRoman("900").readEntity(String.class));
    }

    @Test
    public void test956() throws Exception {
    	assertEquals("CMLVI", new Romanizer().toRoman("956").readEntity(String.class));
    }

    @Test
    public void test950() throws Exception {
    	assertEquals("CML", new Romanizer().toRoman("950").readEntity(String.class));
    }
    
    @Test
    public void test2899() throws Exception {
    	assertEquals("MMDCCCXCIX", new Romanizer().toRoman("2899").readEntity(String.class));
    }

    @Test
    public void test1000() throws Exception {
    	assertEquals("M", new Romanizer().toRoman("1000").readEntity(String.class));
    }
    
    @Test
    public void test1099() throws Exception {
    	assertEquals("MXCIX", new Romanizer().toRoman("1099").readEntity(String.class));
    }

    @Test
    public void test944() throws Exception {
    	assertEquals("CMXLIV", new Romanizer().toRoman("944").readEntity(String.class));
    }

    @Test
    public void test1001() throws Exception {
    	assertEquals("MI", new Romanizer().toRoman("1001").readEntity(String.class));
    }
    
    @Test
    public void test1400() throws Exception {
    	assertEquals("MCD", new Romanizer().toRoman("1400").readEntity(String.class));
    }


}
