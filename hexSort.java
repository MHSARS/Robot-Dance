import java.util.Arrays;

public class hexSort {
    public static void main(String[] args) {
        // Get hex numbers from MainCode class
        String[] hexValues = MainCode.hexnums;

        // Call the sub-process to sort hexadecimal values
        hexSortAscending(hexValues);

        // Display the sorted hexadecimal values
        System.out.println("Sorted Hexadecimal Values (Ascending Order):");
        for (String hexValue : hexValues) {
            System.out.print(hexValue + " ");
        }
    }

    // Sub-Process: Sort Hexadecimal Values in Ascending Order (Bubble Sort)
    public static void hexSortAscending(String[] hexValues) {
        int n = hexValues.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare hex values using their decimal equivalents
                if (hexToDecimal(hexValues[j]) > hexToDecimal(hexValues[j + 1])) {
                    // Swap hex values if they are in the wrong order
                    String temp = hexValues[j];
                    hexValues[j] = hexValues[j + 1];
                    hexValues[j + 1] = temp;
                }
            }
        }
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
