/**
 * HexaDecimal
 */
public class HexaDecimal {


  public static String ToDecimal(String Hexadecimal) {
    String binary = ToBinary(Hexadecimal);
    String decimal = Binary.ToDecimal(binary);
    return decimal;
  }

  public static String ToBinary(String HexToBi) {
    HexToBi = HexToBi.replaceAll("0", "0000");
    HexToBi = HexToBi.replaceAll("1", "0001");
    HexToBi = HexToBi.replaceAll("2", "0010");
    HexToBi = HexToBi.replaceAll("3", "0011");
    HexToBi = HexToBi.replaceAll("4", "0100");
    HexToBi = HexToBi.replaceAll("5", "0101");
    HexToBi = HexToBi.replaceAll("6", "0110");
    HexToBi = HexToBi.replaceAll("7", "0111");
    HexToBi = HexToBi.replaceAll("8", "1000");
    HexToBi = HexToBi.replaceAll("9", "1001");
    HexToBi = HexToBi.replaceAll("A", "1010");
    HexToBi = HexToBi.replaceAll("B", "1011");
    HexToBi = HexToBi.replaceAll("C", "1100"); 
    HexToBi = HexToBi.replaceAll("D", "1101");
    HexToBi = HexToBi.replaceAll("E", "1110");
    HexToBi = HexToBi.replaceAll("F", "1111");
    return HexToBi;
  }

  public static String ToOctal(String Hexadecimal) {
    String binary = ToBinary(Hexadecimal);
    String octal = Binary.ToOctal(binary);
    return octal;
  }

}