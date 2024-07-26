public class octalConversion {
	// Sub-Process: Convert Hexadecimal to Octal
    public static String hexToOctal(String hexNumber) {
        StringBuilder octalResult = new StringBuilder();

        // Iterate through the hexadecimal digits in reverse order
        for (int i = hexNumber.length() - 1; i >= 0; i -= 3) {
            String hexChunk = hexNumber.substring(Math.max(0, i - 2), i + 1);
            int decimalResult = hexToDecimal(hexChunk); // Call hexToDecimal here
            String octalChunk = hexChunkToOctal(decimalResult);

            // Append the octal chunk to the result
            octalResult.insert(0, octalChunk);
        }
       
        // Display the result
        System.out.println("Decimal equivalent of " + hexNumber + " is: " + octalResult);

        return octalResult.toString();
    }

        // Sub-Process: Convert Hexadecimal Chunk to Octal
        public static String hexChunkToOctal(String hexChunk) {
            StringBuilder octalResult = new StringBuilder();

            // Call the sub-process to convert hexadecimal to decimal
            int decimalResult = hexToDecimal(hexChunk);

            // Handle the case where the decimal equivalent is 0 separately
            if (decimalResult == 0) {
                return "0";
            }

            // Perform the conversion
            while (decimalResult > 0) {
                // Append the remainder (which is the octal digit) to the result
                octalResult.insert(0, decimalResult % 8);

                // Divide the decimal number by 8
                decimalResult /= 8;
            }

            return octalResult.toString();
        }

        // Sub-Process: Convert Hexadecimal to Decimal
        public static int hexToDecimal(String hexNumber) {
            int decimalResult = 0;

            // Iterate through the hexadecimal digits in reverse order
            for (int i = hexNumber.length() - 1, power = 0; i >= 0; i--, power++) {
                char hexDigit = hexNumber.charAt(i);
                int digitValue;

                // Convert hexadecimal digit to decimal value
                if (Character.isDigit(hexDigit)) {
                    digitValue = hexDigit - '0';
                } else {
                    digitValue = Character.toUpperCase(hexDigit) - 'A' + 10;
                }

                // Add the decimal value to the total
                decimalResult += digitValue * (1 << (4 * power));
            }

            return decimalResult;
        }
    }