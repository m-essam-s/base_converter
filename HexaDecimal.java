/**
 * HexaDecimal
 */
public class HexaDecimal {

  public static int ToDecimal(String Hexadecimal) {
    return Binary_To_Decimal(Hexadecimal_To_Binary(Hexadecimal));
  }

  public static String ToBinary(String Hexadecimal) {
    String Binary;
    Binary = Hexadecimal.replaceAll("0", "0000");
    Binary = Hexadecimal.replaceAll("1", "0001");
    Binary = Hexadecimal.replaceAll("2", "0010");
    Binary = Hexadecimal.replaceAll("3", "0011");
    Binary = Hexadecimal.replaceAll("4", "0100");
    Binary = Hexadecimal.replaceAll("5", "0101");
    Binary = Hexadecimal.replaceAll("6", "0110");
    Binary = Hexadecimal.replaceAll("7", "0111");
    Binary = Hexadecimal.replaceAll("8", "1000");
    Binary = Hexadecimal.replaceAll("9", "1001");
    Binary = Hexadecimal.replaceAll("A", "1010");
    Binary = Hexadecimal.replaceAll("B", "1011");
    Binary = Hexadecimal.replaceAll("C", "1100");
    Binary = Hexadecimal.replaceAll("D", "1101");
    Binary = Hexadecimal.replaceAll("E", "1110");
    Binary = Hexadecimal.replaceAll("F", "1111");
    return Binary;
  }

  public static String ToOctal(String Hexadecimal) {
    return Decimal.ToOctal(toDecimal(Hexadecimal));
  }
}