package it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import application.impl.romantonumber.RomanToDecimalImpl;

public class TestRomanToDecimal {

    @Nested
    @DisplayName("Test invalid input data")
    class invalidInputTestor {
        @Test
        @DisplayName("Input is bad data. Output should be an Exception with Bad Request")
        public void testBadCases() {
            String[] badCases = {
                    "",
                    "ia",
                    "iiii",
                    "XIXIX",
                    "dMXi",
                    "MMDD",
                    "DXXC",
                    "0"
            };
            for (String badCase : badCases) {

                Exception thrown = assertThrows(
                        IllegalArgumentException.class,
                        () -> RomanToDecimalImpl.toNumber(badCase));

                assertTrue(thrown.getMessage().contains("Bad Request"));
            }
        }
    }

    @Nested
    @DisplayName("Test valid input data")
    class validInputTestor {

        @Test
        @DisplayName("Input is basic data. Output should appropriate decimal number")
        public void testBasicCases() throws Exception {
            String[][] basicCases = {
                    { "I", "1" },
                    { "ii", "2" },
                    { "IiI", "3" },
                    { "V", "5" },
                    { "X", "10" },
                    { "L", "50" },
                    { "C", "100" },
                    { "D", "500" },
                    { "M", "1000" }
            };
            for (String basicCase[] : basicCases) {
                assertEquals(basicCase[1], RomanToDecimalImpl.toNumber(basicCase[0]));
            }
        }

        @Test
        @DisplayName("Input is non basic data. Output should appropriate decimal number")
        public void testNonBasicCases() throws Exception {
            String[][] nonBasicCases = {
                    { "IV", "4" },
                    { "VI", "6" },
                    { "IX", "9" },
                    { "XI", "11" },
                    { "XIX", "19" },
                    { "XX", "20" },
                    { "LIV", "54" },
                    { "XC", "90" },
                    { "XCIX", "99" },
                    { "CXCIX", "199" },
                    { "CD", "400" },
                    { "CM", "900" },
                    { "CMXLIV", "944" },
                    { "MCD", "1400" },
                    { "mmdcccxcix", "2899" },
                    { "MMMCMXCIX", "3999" }
            };
            for (String nonBasicCase[] : nonBasicCases) {
                assertEquals(nonBasicCase[1], RomanToDecimalImpl.toNumber(nonBasicCase[0]));
            }
        }

    }
}
