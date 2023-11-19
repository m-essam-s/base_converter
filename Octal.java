/**
 * Octal
 */
public class Octal {

  public static int toDecimal(String Octal) {
    String Binary = Octal_To_Binary(Octal);
    String Decimal = Binary_To_Decimal(Binary);
    return Decimal;
  }

  public static String toBinary(String Octal) {
    int Binary;
    Binary = Octal.replaceAll("0", "000");
    Binary = Octal.replaceAll("1", "001");
    Binary = Octal.replaceAll("2", "010");
    Binary = Octal.replaceAll("3", "011");
    Binary = Octal.replaceAll("4", "100");
    Binary = Octal.replaceAll("5", "101");
    Binary = Octal.replaceAll("6", "110");
    Binary = Octal.replaceAll("7", "111");
    return Binary;
  }

  public static String toHexadecimal(String Octal) {
    String Binary = Octal_To_Binary(Octal);
    String Hexadecimal = Binary_To_Hexadecimal(Binary);
    return Hexadecimal;
  }
}