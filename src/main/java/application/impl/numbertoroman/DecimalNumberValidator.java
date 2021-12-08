package application.impl.numbertoroman;

public class DecimalNumberValidator {

    public static String validate(String value) {
        int valueInt = checkForInteger(value);
        checkForZero(valueInt);
        checkForRange(valueInt);
        return valueInt + "";
    }

    public static int checkForInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Bad Request");
        }
    }

    private static void checkForZero(int value) {
        if (value == 0) {
            throw new IllegalArgumentException("nulla");
        }
    }

    public static void checkForRange(int valueInt) {
        if (valueInt < 1 || valueInt > 3999) {
            throw new IllegalArgumentException("Bad Request");
        }
    }

}
