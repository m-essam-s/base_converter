import 'dart:math' as math;
import 'package:base_converter/models/binary.dart';

class Hexadecimal {
  // Static map of hexadecimal values
  static const Map<String, int> hexaValues = {
    '0': 0,
    '1': 1,
    '2': 2,
    '3': 3,
    '4': 4,
    '5': 5,
    '6': 6,
    '7': 7,
    '8': 8,
    '9': 9,
    'A': 10,
    'B': 11,
    'C': 12,
    'D': 13,
    'E': 14,
    'F': 15,
  };

  // Convert hexadecimal to decimal
  static String toDecimal(String hexadecimal) {
    // Check for negative sign
    bool isNegative = hexadecimal.startsWith("-");
    if (isNegative) {
      hexadecimal = hexadecimal.substring(1);
    }

    int dotLocation = hexadecimal.indexOf('.');
    if (dotLocation == -1) {
      dotLocation =
          hexadecimal.length; // No dot, consider end of string as dot location
    }

    double decimal = 0.0;

    // Convert integer part
    for (int i = 0; i < dotLocation; i++) {
      decimal += hexaValues[hexadecimal[i].toUpperCase()]! *
          math.pow(16, dotLocation - i - 1);
    }

    // Convert fractional part
    for (int i = dotLocation + 1; i < hexadecimal.length; i++) {
      decimal += hexaValues[hexadecimal[i].toUpperCase()]! *
          math.pow(16, dotLocation - i);
    }

    // Handle negative result
    if (isNegative) {
      decimal = -decimal;
    }

    return decimal.toString();
  }

  static String toBinary(String hexadecimal) {
    String binary = "";
    for (int i = 0; i < hexadecimal.length; i++) {
      String hexDigit = hexadecimal[i];
      switch (hexDigit) {
        case '0':
          binary += "0000";
          break;
        case '1':
          binary += "0001";
          break;
        case '2':
          binary += "0010";
          break;
        case '3':
          binary += "0011";
          break;
        case '4':
          binary += "0100";
          break;
        case '5':
          binary += "0101";
          break;
        case '6':
          binary += "0110";
          break;
        case '7':
          binary += "0111";
          break;
        case '8':
          binary += "1000";
          break;
        case '9':
          binary += "1001";
          break;
        case 'A':
        case 'a':
          binary += "1010";
          break;
        case 'B':
        case 'b':
          binary += "1011";
          break;
        case 'C':
        case 'c':
          binary += "1100";
          break;
        case 'D':
        case 'd':
          binary += "1101";
          break;
        case 'E':
        case 'e':
          binary += "1110";
          break;
        case 'F':
        case 'f':
          binary += "1111";
          break;
        case '.':
          binary += ".";
          break;
        default:
          throw const FormatException("Invalid hexadecimal digit");
      }
    }
    return binary;
  }

  static String toOctal(String hexadecimal) {
    String binary = toBinary(hexadecimal);
    return Binary.toOctal(binary);
  }
}
