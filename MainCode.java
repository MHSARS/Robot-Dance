import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import swiftbot.Button;
import swiftbot.FailedToRunRaspistillException;
import swiftbot.ImageSize;
import swiftbot.SwiftBotAPI;

public class MainCode {
    static int count = 0;

    public static void main(String[] args) {
        SwiftBotAPI sb = new SwiftBotAPI();
        BufferedImage img = sb.getQRImage();

        try {
            String hexNumber = sb.decodeQRImage(img);
            if (!hexNumber.isEmpty()) {
                System.out.println("Hexadecimal Number: " + hexNumber);

                // Call the hexToDecimal method from decimalConversion class
                int decimalResult = hexSort.hexToDecimal(hexNumber);

                // Call the hexToOctal method from octalConversion class
                String octalResult = octalConversion.hexToOctal(hexNumber);

                // Call the hexToBinary method from binaryConversion class
                String binaryResult = binaryConversion.hexToBinary(hexNumber);

                // Call FillUnderlights class to fill underlights
                FillUnderlights.fillUnderlights(hexNumber);

                // Move the robot and take photos
                moveRobotAndTakePhotos(hexNumber);

                // Process binary result
                processBinaryResult(binaryResult);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    static void moveRobotAndTakePhotos(String hexNumber) {
        RobotMovement.moveRobot(hexNumber);
        takePhotoAndIncrementCount();
    }

    static void takePhotoAndIncrementCount() {
        SwiftBotAPI sb = new SwiftBotAPI();
        try {
            BufferedImage img = sb.takeStill(ImageSize.SQUARE_144x144);
            ImageIO.write(img, "jpg", new File("/home/pi/Documents/testImage.jpg"));
            count++;
        } catch (IOException | FailedToRunRaspistillException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void processBinaryResult(String binaryResult) {
        SwiftBotAPI sb = new SwiftBotAPI();
        for (int i = binaryResult.length() - 1; i >= 0; i--) {
            if (binaryResult.charAt(i) == '1') {
                FillUnderlights.fillUnderlightsGreen();
            } else {
                FillUnderlights.fillUnderlightsBlue();
                // Spin the robot
                RobotMovement.spinRobot();
            }
        }
        // After finishing, disable underlights
        sb.disableUnderlights();
    }

    static void enableButtons() {
        SwiftBotAPI sb = new SwiftBotAPI();
        sb.enableButton(Button.X, () -> {
            System.out.println("Exiting...");
            System.exit(0);
        });
        sb.enableButton(Button.Y, () -> {
            System.out.println("Press Y to continue.");
        });
    }
}

