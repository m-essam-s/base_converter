import 'package:base_converter/models/binary.dart';

class Hexadecimal {
  static String toDecimal(String hexadecimal) {
    String binary = toBinary(hexadecimal);
    String decimal = Binary.toDecimal(binary);
    return decimal;
  }

  static String toBinary(String hexToBi) {
    hexToBi = hexToBi.replaceAll("0", "0000");
    hexToBi = hexToBi.replaceAll("1", "0001");
    hexToBi = hexToBi.replaceAll("2", "0010");
    hexToBi = hexToBi.replaceAll("3", "0011");
    hexToBi = hexToBi.replaceAll("4", "0100");
    hexToBi = hexToBi.replaceAll("5", "0101");
    hexToBi = hexToBi.replaceAll("6", "0110");
    hexToBi = hexToBi.replaceAll("7", "0111");
    hexToBi = hexToBi.replaceAll("8", "1000");
    hexToBi = hexToBi.replaceAll("9", "1001");
    hexToBi = hexToBi.replaceAll("A", "1010");
    hexToBi = hexToBi.replaceAll("B", "1011");
    hexToBi = hexToBi.replaceAll("C", "1100");
    hexToBi = hexToBi.replaceAll("D", "1101");
    hexToBi = hexToBi.replaceAll("E", "1110");
    hexToBi = hexToBi.replaceAll("F", "1111");
    return hexToBi;
  }

  static String toOctal(String hexadecimal) {
    String binary = toBinary(hexadecimal);
    String octal = Binary.toOctal(binary);
    return octal;
  }
}
