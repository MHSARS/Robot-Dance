import swiftbot.SwiftBotAPI;

public class RobotMovement {
    public static void moveRobot(String hexNumber) {
        try {
            // Call hexToOctal method from octalConversion class to get octal result
            String octalResult = octalConversion.hexToOctal(hexNumber);
            int octalValue = Integer.parseInt(octalResult); // Parse octal result to integer

            // Calculate speed based on octal result
            int speed;
            if (octalValue < 50) {
                speed = Math.min(octalValue + 50, 100); // Ensure speed does not exceed 100
            } else {
                speed = Math.min(octalValue, 100); // Ensure speed does not exceed 100
            }

            // Move the robot with calculated speed
            SwiftBotAPI sb = new SwiftBotAPI();
            sb.move(speed, speed, 1000);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    
    public static void spinRobot() {
        // Implement spinning the robot
        System.out.println("Spinning the robot");
        // You may add code here to control the robot's spinning motion
    }
}
