# Number System Converter

This `Java` project provides a simple number system converter with support for decimal, binary, octal, and hexadecimal conversions.

## Files

### 1. `Decimal.java`

This file contains the `Decimal` class, which provides methods to convert decimal numbers to binary, octal, and hexadecimal. It also handles conversion from binary to decimal.

### 2. `Binary.java`

The `Binary` class in this file includes methods for converting binary numbers to decimal, octal, and hexadecimal. It relies on the `Decimal` class for binary to decimal conversion.

### 3. `Octal.java`

The `Octal` class offers functionality to convert octal numbers to decimal, binary, and hexadecimal. It utilizes the `Binary` class for conversion.

### 4. `HexaDecimal.java`

In this file, the `HexaDecimal` class handles the conversion of hexadecimal numbers to decimal, binary, and octal. It relies on the `Binary` class for binary conversion.

### 5. `MainFrame.java`

The `MainFrame` class represents the main graphical user interface (GUI) of the Number System Converter. It includes text fields, labels, buttons, and combo boxes to facilitate input and output of number conversions. The class implements the ActionListener interface to handle button clicks.

  - `Buttons`, `ComboBoxes`, `TextFields`, `Labels`

These classes are utility classes extending the JButton, JComboBox, JTextField, and JLabel classes, respectively. They provide a consistent and reusable UI component design.

### 6. `Main.java`

The `Main` class contains the `main` method and serves as the entry point for the application. It creates an instance of the `MainFrame` class to launch the GUI.

## How to Use

1. Run the `Main.java` file to start the application.
2. Enter a number in the "Input Number" field.
3. Select the input and output number systems using the dropdown menus.
4. Click the "Convert" button to perform the conversion.
5. The result will be displayed in the "Result" field.
6. Use the "Clear" button to reset the input and output fields.

Feel free to explore and contribute to enhance the functionality or add support for additional number systems.

## Contributing

Contributions to this project are welcome! If you have ideas for improvements, bug fixes, or additional features, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License.
