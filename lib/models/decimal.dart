import 'package:base_converter/models/binary.dart';

class Decimal {
  static String toBinary(String decimal) {
    try {
      if (decimal.contains(".")) {
        double num = double.parse(decimal);
        int integral = num.toInt();
        double fractional = num - integral;

        StringBuffer binaryBuilder = StringBuffer();

        // Convert integral part to binary
        StringBuffer integralPart = StringBuffer();
        while (integral > 0) {
          int rem = integral % 2;
          integralPart.write(rem);
          integral ~/= 2;
        }
        binaryBuilder.write(integralPart.toString().split('').reversed.join());

        binaryBuilder.write('.');

        // Convert fractional part to binary
        int precision = 64;
        while (precision-- > 0) {
          fractional *= 2;
          int fractBit = fractional.toInt();

          if (fractBit == 1) {
            fractional -= fractBit;
            binaryBuilder.write('1');
          } else {
            binaryBuilder.write('0');
          }
        }

        return binaryBuilder.toString();
      } else {
        String integerPart = decimal;
        int num = int.parse(integerPart);
        StringBuffer binaryBuilder = StringBuffer();

        // Convert integral part to binary
        while (num > 0) {
          int n = num % 2;
          binaryBuilder.write(n);
          num ~/= 2;
        }

        return binaryBuilder.toString().split('').reversed.join();
      }
    } on FormatException {
      return "Error: Invalid input. Please provide a valid decimal number.";
    } on Exception {
      return "Error: An unexpected error occurred.";
    }
  }

  static String toOctal(String decimal) {
    String binary = toBinary(decimal);
    String octal = Binary.toOctal(binary);
    return octal;
  }

  static String toHexadecimal(String decimal) {
    String binary = toBinary(decimal);
    String hexadecimal = Binary.toHexadecimal(binary);
    return hexadecimal;
  }
}
