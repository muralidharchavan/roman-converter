package application.impl.romantonumber;

public class RomanToDecimalImpl {

    public String toNumber(String romanNumber) throws Exception {

        romanNumber = new RomanNumberValidator().validate(romanNumber);

        int decimalNumber = 0;

        for (int i = 0; i < romanNumber.length(); i++) {
            int romanChar = getValue(romanNumber.charAt(i));

            if (i + 1 < romanNumber.length()) {
                int romanNextChar = getValue(romanNumber.charAt(i + 1));

                if (romanChar >= romanNextChar) {
                    decimalNumber = decimalNumber + romanChar;
                } else {
                    decimalNumber = decimalNumber + romanNextChar - romanChar;
                    i++;
                }
            } else {
                decimalNumber = decimalNumber + romanChar;
            }
        }
        return decimalNumber + "";
    }

    private int getValue(char romanLiteral) throws Exception {
        if (romanLiteral == 'I')
            return 1;
        if (romanLiteral == 'V')
            return 5;
        if (romanLiteral == 'X')
            return 10;
        if (romanLiteral == 'L')
            return 50;
        if (romanLiteral == 'C')
            return 100;
        if (romanLiteral == 'D')
            return 500;
        if (romanLiteral == 'M')
            return 1000;

        throw new Exception("Not a roman number");
    }
}
