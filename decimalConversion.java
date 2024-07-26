public class decimalConversion {
    // Sub-Process: Convert Hexadecimal to Decimal
    public static int hexToDecimal(String hexNumber) {
        int decimalResult = 0;
        int power = 0;

        // Iterate through the hexadecimal digits in reverse order
        for (int i = hexNumber.length() - 1; i >= 0; i--) {
            char hexDigit = hexNumber.charAt(i);
            int digitValue;

            // Convert hexadecimal digit to decimal value
            if (Character.isDigit(hexDigit)) {
                digitValue = hexDigit - '0';
            } else {
                digitValue = hexDigit - 'A' + 10;
            }

            // Add the decimal value to the total
            decimalResult += digitValue * Math.pow(16, power);
            power++;
        }

        // Display the result
        System.out.println("Decimal equivalent of " + hexNumber + " is: " + decimalResult);

        return decimalResult;
       
    }
}
