import 'package:base_converter/models/binary.dart';

class Octal {
  static String toDecimal(String octal) {
    String binary = toBinary(octal);
    String decimal = Binary.toDecimal(binary);
    return decimal;
  }

  static String toBinary(String octToBi) {
    octToBi = octToBi.replaceAll("0", "000");
    octToBi = octToBi.replaceAll("1", "001");
    octToBi = octToBi.replaceAll("2", "010");
    octToBi = octToBi.replaceAll("3", "011");
    octToBi = octToBi.replaceAll("4", "100");
    octToBi = octToBi.replaceAll("5", "101");
    octToBi = octToBi.replaceAll("6", "110");
    octToBi = octToBi.replaceAll("7", "111");
    return octToBi;
  }

  static String toHexadecimal(String octal) {
    String binary = toBinary(octal);
    String hexadecimal = Binary.toHexadecimal(binary);
    return hexadecimal;
  }
}
