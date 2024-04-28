package numbersystemconverter;

/**
 * Octal
 */
public class Octal {

  public static String ToDecimal(String Octal) {
    String binary = ToBinary(Octal);
    String decimal = Binary.ToDecimal(binary);
    return decimal;
  }

  public static String ToBinary(String OctToBi) {
    OctToBi = OctToBi.replaceAll("0", "000");
    OctToBi = OctToBi.replaceAll("1", "001");
    OctToBi = OctToBi.replaceAll("2", "010");
    OctToBi = OctToBi.replaceAll("3", "011");
    OctToBi = OctToBi.replaceAll("4", "100");
    OctToBi = OctToBi.replaceAll("5", "101");
    OctToBi = OctToBi.replaceAll("6", "110");
    OctToBi = OctToBi.replaceAll("7", "111");
    return OctToBi;
  }

  public static String ToHexadecimal(String Octal) {
    String binary = ToBinary(Octal);
    String Hexadecimal = Binary.ToHexadecimal(binary);
    return Hexadecimal;
  }

}