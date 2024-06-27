import 'dart:math' as math;

class Binary {
  static String toDecimal(String binary) {
    if (binary.contains(".")) {
      String fractionPart = binary.substring(binary.indexOf('.') + 1);
      String integerPart = binary.replaceFirst(".$fractionPart", "");
      int num1 = 0;
      List<int> integerDigits = integerPart.split('').map(int.parse).toList();
      int counter1 = 0;
      for (int i = integerPart.length - 1; i >= 0; i--) {
        int a = integerDigits[i];
        num1 += (a * math.pow(2, counter1)).toInt();
        counter1++;
      }
      String decimal1 = num1.toString();

      double num2 = 0.0;
      List<int> fractionDigits = fractionPart.split('').map(int.parse).toList();
      int counter2 = -1;
      for (int i = 0; i < fractionPart.length; i++) {
        int a = fractionDigits[i];
        num2 += (a * math.pow(2, counter2));
        counter2--;
      }
      String decimal2 = num2.toString();
      String decimal = "$decimal1.${decimal2.substring(2)}";
      return decimal;
    } else {
      String integerPart = binary;
      int num1 = 0;
      List<int> integerDigits = integerPart.split('').map(int.parse).toList();
      int counter1 = 0;
      for (int i = integerPart.length - 1; i >= 0; i--) {
        int a = integerDigits[i];
        num1 += (a * math.pow(2, counter1)).toInt();
        counter1++;
      }
      String decimal = num1.toString();
      return decimal;
    }
  }

  static String toOctal(String binary) {
    if (binary.contains(".")) {
      String fractionsPart = binary.substring(binary.indexOf('.') + 1);
      String integerPart = binary.replaceFirst(".$fractionsPart", "");
      String i;
      while (integerPart.length % 3 != 0) {
        i = "0$integerPart";
        integerPart = i;
      }
      while (fractionsPart.length % 3 != 0) {
        i = "${fractionsPart}0";
        fractionsPart = i;
      }
      String zeros = "";
      int j = 0;
      while (fractionsPart.substring(j, j + 3) == "000") {
        zeros = "${zeros}0";
        j += 3;
        if ((j + 3) > fractionsPart.length) {
          break;
        }
      }

      int num1 = int.parse(integerPart, radix: 2);
      String octal1 = num1.toRadixString(8);
      int num2 = int.parse(fractionsPart, radix: 2);
      String octal2 = num2.toRadixString(8);

      while (octal2[octal2.length - 1] == '0') {
        octal2 = octal2.substring(0, octal2.length - 1);
      }

      String octal = "$octal1.$zeros$octal2";
      return octal;
    } else {
      String i;
      while (binary.length % 3 != 0) {
        i = "0$binary";
        binary = i;
      }
      int num = int.parse(binary, radix: 2);
      String octal = num.toRadixString(8);
      return octal;
    }
  }

  static String removeLastCharacter(String str) {
    if (str.isEmpty) {
      return str;
    }
    return str.substring(0, str.length - 1);
  }

  static String toHexadecimal(String binary) {
    bool isNegative = binary.startsWith("-");
    if (isNegative) {
      binary = binary.substring(1);
    }

    String fractionsPart = "";
    String integerPart = binary;

    if (binary.contains(".")) {
      fractionsPart = binary.substring(binary.indexOf('.') + 1);
      integerPart = binary.substring(0, binary.indexOf('.'));
    }

    // Pad IntegerPart to have a length multiple of 4
    integerPart = padToMultipleOfFour(integerPart);

    // Convert IntegerPart to hexadecimal
    String hex1 =
        int.parse(integerPart, radix: 2).toRadixString(16).toUpperCase();

    String hex2 = "";
    if (fractionsPart.isNotEmpty) {
      // Convert fractionsPart to decimal value first
      double fractionalDecimal = 0.0;
      for (int i = 0; i < fractionsPart.length; i++) {
        if (fractionsPart[i] == '1') {
          fractionalDecimal += 1 / math.pow(2, i + 1);
        }
      }

      // Convert decimal fraction to hexadecimal
      int fractionalInt;
      for (int i = 0; i < 10 && fractionalDecimal > 0; i++) {
        // Limit the conversion to 10 digits for precision
        fractionalDecimal *= 16;
        fractionalInt = fractionalDecimal.floor();
        hex2 += fractionalInt.toRadixString(16).toUpperCase();
        fractionalDecimal -= fractionalInt;
      }
    }

    // Remove trailing zeros from hex2
    hex2 = hex2.replaceAll(RegExp(r'0+$'), '');

    // Construct the final hexadecimal string
    String hex = hex2.isNotEmpty ? "$hex1.$hex2" : hex1;
    if (isNegative) {
      hex = "-$hex";
    }
    return hex;
  }

  // Helper method to pad a binary string to have a length multiple of 4
  static String padToMultipleOfFour(String binary) {
    while (binary.length % 4 != 0) {
      binary = "0$binary";
    }
    return binary;
  }
}
