public class binaryConversion {
    // Sub-Process: Convert Hexadecimal to Binary
    public static String hexToBinary(String hexNumber) {
        StringBuilder binaryResult = new StringBuilder();

        // Iterate through the hexadecimal digits
        for (int i = 0; i < hexNumber.length(); i++) {
            char hexDigit = hexNumber.charAt(i);
            String binaryChunk = decimalToBinary(hexDigitToDecimal(hexDigit));

            // Append the binary chunk to the result
            binaryResult.append(binaryChunk);
        }
        
        // Display the result
        System.out.println("Binary equivalent of " + hexNumber + " is: " + binaryResult);

        return binaryResult.toString();
    }

    // Sub-Process: Convert Hexadecimal Digit to Decimal
    public static int hexDigitToDecimal(char hexDigit) {
        if (Character.isDigit(hexDigit)) {
            return hexDigit - '0';
        } else {
            return Character.toUpperCase(hexDigit) - 'A' + 10;
        }
    }

    // Sub-Process: Convert Decimal to Binary
    public static String decimalToBinary(int decimalNumber) {
        StringBuilder binaryResult = new StringBuilder();

        // Handle the case where the input is 0 separately
        if (decimalNumber == 0) {
            return "0000";
        }

        // Perform the conversion
        while (decimalNumber > 0) {
            // Append the remainder (which is the binary digit) to the result
            binaryResult.insert(0, decimalNumber % 2);

            // Divide the decimal number by 2
            decimalNumber /= 2;
        }

        // Pad with leading zeros to ensure a 4-bit representation
        while (binaryResult.length() < 4) {
            binaryResult.insert(0, "0");
        }

        return binaryResult.toString();
    }
}
