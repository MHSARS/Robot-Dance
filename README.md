This project involves a series of Java classes designed to interact with a SwiftBot API for controlling a robot and its associated features, such as underlights and movement. Below is a summary of the key components:

Main Features:
Hexadecimal Conversions:

Hex to Decimal: Converts hexadecimal numbers to decimal using the decimalConversion class.
Hex to Binary: Converts hexadecimal numbers to binary in the binaryConversion class.
Hex to Octal: Converts hexadecimal numbers to octal using the octalConversion class.
Robot Control:

Fill Underlights: The FillUnderlights class calculates RGB values from a hexadecimal input and uses the SwiftBot API to fill the robot's underlights.
Move Robot: The RobotMovement class calculates speed based on a hexadecimal input converted to octal and moves the robot using the SwiftBot API.
Spin Robot: The spinRobot method in the RobotMovement class provides functionality to spin the robot.
Image Processing:

The MainCode class captures QR code images, decodes them to extract hexadecimal values, and then processes these values by calling various conversion methods.
The robot's movement and underlight actions are determined based on these converted values.
Additional Functionality:

The MainCode class also handles taking photos, processing binary results to control the robot's underlights, and enabling buttons on the robot.
How It Works:
The MainCode class is the entry point. It captures a QR code image and decodes it into a hexadecimal string.
This string is passed through various conversion classes (decimalConversion, binaryConversion, octalConversion) to obtain decimal, binary, and octal equivalents.
Based on these values, the robot's movement and underlight colors are controlled through the FillUnderlights and RobotMovement classes.
The robot's actions are further customized by interpreting the binary result, which decides whether to fill underlights with green or blue, or to spin the robot.
This code is structured to allow easy interaction with the SwiftBot's hardware, providing a rich set of features for robotic control and color management based on hexadecimal inputs.
