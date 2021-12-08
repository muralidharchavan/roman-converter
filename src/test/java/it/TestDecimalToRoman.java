package it;

import java.lang.IllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import application.impl.numbertoroman.DecimalToRomanImpl;

public class TestDecimalToRoman {

    @Nested
    @DisplayName("Test invalidInput")
    class invalidDataTestor {

        String[] badCases = {
                "",
                "-1",
                "4000",
                "2.5",
        };

        @Test
        @DisplayName("Input is bad data. Output should be an Exception with Bad Request")
        public void testBadCases() {

            for (String badCase : badCases) {
                Exception thrown = assertThrows(
                        IllegalArgumentException.class,
                        () -> DecimalToRomanImpl.decimalToRoman(badCase));
                assertTrue(thrown.getMessage().contains("Bad Request"));
            }
        }

        @Test
        @DisplayName("Input is zero. Output should be nulla")
        public void testZero() {
            Exception thrown = assertThrows(
                    IllegalArgumentException.class,
                    () -> DecimalToRomanImpl.decimalToRoman("0"));
            assertTrue(thrown.getMessage().contains("nulla"));
        }

    }

    @Nested
    @DisplayName("Test Success conditions")
    class SuccessTestor {

        String[][] testData = {
                { "1", "I" }, { "2", "II" }, { "3", "III" }, { "4", "IV" },
                { "5", "V" }, { "6", "VI" }, { "8", "VIII" }, { "9", "IX" },
                { "10", "X" }, { "30", "XXX" }, { "34", "XXXIV" }, { "39", "XXXIX" },
                { "40", "XL" }, { "49", "XLIX" }, { "50", "L" }, { "3500", "MMMD" },
                { "3700", "MMMDCC" }, { "3900", "MMMCM" }, { "3999", "MMMCMXCIX" },
                { "3861", "MMMDCCCLXI" }, { "0001", "I" }, { "99", "XCIX" },
                { "101", "CI" }, { "399", "CCCXCIX" }, { "400", "CD" },
                { "900", "CM" }, { "956", "CMLVI" }, { "950", "CML" },
                { "2899", "MMDCCCXCIX" }, { "1000", "M" }, { "1099", "MXCIX" },
                { "944", "CMXLIV" }, { "1001", "MI" }, { "1400", "MCD" }
        };

        @Test
        public void test_success_cases() {
            for (String[] test : testData) {
                assertEquals(test[1], DecimalToRomanImpl.decimalToRoman(test[0]));
            }
        }
    }
}
