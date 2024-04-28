package numbersystemconverter;

/**
 * Binary
 */
public class Binary {

  public static String ToDecimal(String binary) {
    if (binary.contains(".")) {
      String FractionPart = binary.substring(binary.indexOf('.') + 1);
      String IntegerPart = binary.replace("." + FractionPart, "");
      long num1 = 0;
      char[] IntegeR = IntegerPart.toCharArray();
      int counter1 = 0;
      for (int i = IntegerPart.length() - 1; i >= 0; i--) {
        int a = (IntegeR[i] - '0');
        num1 += (a * Math.pow(2, counter1));
        counter1++;
      }
      String Dicemal1 = Long.toString(num1);

      Double num2 = 0.0;
      char[] FractioN = FractionPart.toCharArray();
      int counter2 = -1;
      for (int i = 0; i < FractionPart.length(); i++) {
        int a = (FractioN[i] - '0');
        num2 += (a * Math.pow(2, counter2));
        counter2--;
      }
      String Dicemal2 = Double.toString(num2);
      String Dicemal = Dicemal1 + "." + Dicemal2.substring(2);
      return Dicemal;
    } else {
      String IntegerPart = binary;
      long num1 = 0;
      char[] IntegeR = IntegerPart.toCharArray();
      int counter1 = 0;
      for (int i = IntegerPart.length() - 1; i >= 0; i--) {
        int a = (IntegeR[i] - '0');
        num1 += (a * Math.pow(2, counter1));
        counter1++;
      }
      String Dicemal = Long.toString(num1);
      return Dicemal;
    }
  }

  public static String ToOctal(String binary) {
    if (binary.contains(".")) {
      String FractionsPart = binary.substring(binary.indexOf('.') + 1);
      String IntegerPart = binary.replace("." + FractionsPart, "");
      String I;
      while (IntegerPart.length() % 3 != 0) {
        I = "0" + IntegerPart;
        IntegerPart = I;
      }
      while (FractionsPart.length() % 3 != 0) {
        I = FractionsPart + "0";
        FractionsPart = I;
      }
      String Zeros = "";
      int i = 0;
      while (FractionsPart.substring(i, i + 3).equals("000")) {
        Zeros = Zeros.concat("0");
        i += 3;
        if ((i + 3) > FractionsPart.length()) {
          break;
        }
      }

      long num1 = Long.parseLong(IntegerPart, 2);
      String Octal1 = Long.toOctalString(num1);
      long num2 = Long.parseLong(FractionsPart, 2);
      String Octal2 = Long.toOctalString(num2);

      while (Octal2.charAt(Octal2.length() - 1) == '0') {
        Octal2 = removeLastCharacter(Octal2);
      }

      String Octal = Octal1 + "." + Zeros + Octal2;
      return Octal;
    } else {
      String I;
      while (binary.length() % 3 != 0) {
        I = "0" + binary;
        binary = I;
      }
      long num = Long.parseLong(binary, 2);
      String Octal = Long.toOctalString(num);
      return Octal;
    }
  }

  public static String removeLastCharacter(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    return str.substring(0, str.length() - 1);
  }

  // Helper method to remove the last character from a string

  public static String ToHexadecimal(String Binary) {
    if (Binary.contains(".")) {
      String FractionsPart = Binary.substring(Binary.indexOf('.') + 1);
      String IntegerPart = Binary.substring(0, Binary.indexOf('.'));

      // Pad IntegerPart and FractionsPart to have a length multiple of 4
      IntegerPart = padToMultipleOfFour(IntegerPart);
      FractionsPart = padToMultipleOfFour(FractionsPart);

      StringBuilder Zeros = new StringBuilder();

      // Add zeros to Zeros for every group of 4 zeros at the beginning of
      // FractionsPart
      int i = 0;
      while (i < FractionsPart.length() && FractionsPart.substring(i, i + 4).equals("0000")) {
        Zeros.append("0");
        i += 4;
      }

      // Convert IntegerPart and FractionsPart to hexadecimal
      String Hex1 = Long.toHexString(Long.parseLong(IntegerPart, 2)).toUpperCase();
      String Hex2 = Long.toHexString(Long.parseLong(FractionsPart, 2)).toUpperCase();

      // Remove trailing zeros from Hex2
      while (!Hex2.isEmpty() && Hex2.charAt(Hex2.length() - 1) == '0') {
        Hex2 = Hex2.substring(0, Hex2.length() - 1);
      }

      // Construct the final hexadecimal string
      return Hex1 + "." + Zeros.toString() + Hex2;
    } else {
      // Pad Binary to have a length multiple of 4
      Binary = padToMultipleOfFour(Binary);

      // Convert Binary to hexadecimal
      String Hex = Long.toHexString(Long.parseLong(Binary, 2)).toUpperCase();

      return Hex;
    }
  }

  // Helper method to pad a binary string to have a length multiple of 4
  private static String padToMultipleOfFour(String binary) {
    while (binary.length() % 4 != 0) {
      binary = "0" + binary;
    }
    return binary;
  }

}