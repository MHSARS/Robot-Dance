import swiftbot.SwiftBotAPI;

public class FillUnderlights {
    public static void fillUnderlights(String hexNumber) {
        // Create an instance of SwiftBotAPI
        SwiftBotAPI sb = new SwiftBotAPI();

        // Get the decimal result using the hexToDecimal method
        int decimalResult = decimalConversion.hexToDecimal(hexNumber);

        // Calculate red, green, and blue colors
        int red = decimalResult;
        int green = Math.min((decimalResult / 80) * 3, 255);
        int blue = red > green ? red : green; // Blue is the maximum of red and green

        // Array representing the color to light up [red, green, blue]
        int[] colourToLightUp = {red, green, blue};

        try {
            // Fill underlights with the calculated color
            sb.fillUnderlights(colourToLightUp);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void fillUnderlightsGreen() {
        // Implement filling underlights with green color
        System.out.println("Filling underlights with green color");
        // You may add code here to control the underlights
    }

    public static void fillUnderlightsBlue() {
        // Implement filling underlights with blue color
        System.out.println("Filling underlights with blue color");
        // You may add code here to control the underlights
    }
}
