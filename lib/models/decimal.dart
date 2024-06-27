import 'package:base_converter/models/binary.dart';

class Decimal {
  static String toBinary(String decimal) {
    try {
      bool isNegative = decimal.startsWith("-");
      if (isNegative) {
        decimal = decimal.substring(1);
      }

      if (decimal.contains(".")) {
        double num = double.parse(decimal);
        int integral = num.toInt();
        double fractional = num - integral;

        StringBuffer binaryBuilder = StringBuffer();

        // Convert integral part to binary
        if (integral == 0) {
          binaryBuilder.write('0');
        } else {
          while (integral > 0) {
            int rem = integral % 2;
            binaryBuilder.write(rem);
            integral ~/= 2;
          }
          binaryBuilder = StringBuffer(
              binaryBuilder.toString().split('').reversed.join(''));
        }

        binaryBuilder.write('.');

        // Convert fractional part to binary
        int maxFractionBits = 20;
        while (maxFractionBits-- > 0) {
          fractional *= 2;
          int fractBit = fractional.toInt();
          if (fractBit == 1) {
            fractional -= fractBit;
            binaryBuilder.write('1');
          } else {
            binaryBuilder.write('0');
          }

          if (fractional == 0) {
            break;
          }
        }

        String binaryResult = binaryBuilder.toString();
        if (isNegative) {
          binaryResult = "-$binaryResult";
        }
        return binaryResult;
      } else {
        int num = int.parse(decimal);
        StringBuffer binaryBuilder = StringBuffer();

        // Convert integral part to binary
        if (num == 0) {
          binaryBuilder.write('0');
        } else {
          while (num > 0) {
            int rem = num % 2;
            binaryBuilder.write(rem);
            num ~/= 2;
          }
          binaryBuilder = StringBuffer(
              binaryBuilder.toString().split('').reversed.join(''));
        }

        String binaryResult = binaryBuilder.toString();
        if (isNegative) {
          binaryResult = "-$binaryResult";
        }
        return binaryResult;
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
