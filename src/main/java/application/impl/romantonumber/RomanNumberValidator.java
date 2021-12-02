package application.impl.romantonumber;

public class RomanNumberValidator {
    public String validate(String romanNumber) {
        if (romanNumber == null) {
            throw new IllegalArgumentException("Bad Request");
        }
        if (romanNumber.isEmpty()) {
            throw new IllegalArgumentException("Bad Request");
        }
        romanNumber = romanNumber.toUpperCase();
        if (!romanNumber.matches("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) {
            throw new IllegalArgumentException("Bad Request");
        }
        return romanNumber;
    }
}
