import 'dart:math' as math;

class Octal {
  static String toDecimal(String octal) {
    bool isNegative = octal.startsWith("-");
    if (isNegative) {
      octal = octal.substring(1);
    }

    List<String> parts = octal.split('.');
    BigInt integerPart = BigInt.parse(parts[0], radix: 8);
    double decimalPart = 0;

    if (parts.length > 1) {
      for (int i = 0; i < parts[1].length; i++) {
        decimalPart += int.parse(parts[1][i], radix: 8) * math.pow(8, -(i + 1));
      }
    }

    String result = (integerPart.toDouble() + decimalPart).toString();

    if (isNegative) {
      result = "-$result";
    }
    return result;
  }

  static String toBinary(String octal) {
    bool isNegative = octal.startsWith("-");
    if (isNegative) {
      octal = octal.substring(1);
    }

    List<String> parts = octal.split('.');
    BigInt integerPart = BigInt.parse(parts[0], radix: 8);
    String binaryPart = integerPart.toRadixString(2);

    String fractionalBinary = "";
    if (parts.length > 1) {
      double decimalPart = 0;
      for (int i = 0; i < parts[1].length; i++) {
        decimalPart += int.parse(parts[1][i], radix: 8) * math.pow(8, -(i + 1));
      }
      fractionalBinary = '.';
      for (int i = 0; i < 52 && decimalPart > 0; i++) {
        decimalPart *= 2;
        if (decimalPart >= 1) {
          fractionalBinary += '1';
          decimalPart -= 1;
        } else {
          fractionalBinary += '0';
        }
      }
    }

    String result = binaryPart + fractionalBinary;
    if (isNegative) {
      result = "-$result";
    }
    return result;
  }

  static String toHexadecimal(String octal) {
    bool isNegative = octal.startsWith("-");
    if (isNegative) {
      octal = octal.substring(1);
    }

    List<String> parts = octal.split('.');
    BigInt integerPart = BigInt.parse(parts[0], radix: 8);
    String hexPart = integerPart.toRadixString(16);

    String fractionalHex = "";
    if (parts.length > 1) {
      double decimalPart = 0;
      for (int i = 0; i < parts[1].length; i++) {
        decimalPart += int.parse(parts[1][i], radix: 8) * math.pow(8, -(i + 1));
      }
      fractionalHex = '.';
      for (int i = 0; i < 13 && decimalPart > 0; i++) {
        // Limiting to 13 digits to avoid excessive precision
        decimalPart *= 16;
        int digit = decimalPart.toInt();
        fractionalHex += digit.toRadixString(16);
        decimalPart -= digit;
      }
    }

    String result = hexPart + fractionalHex;
    if (isNegative) {
      result = "-$result";
    }
    return result.toUpperCase();
  }
}
