/**
 * Binary
 */
public class Binary {

  public static int ToDecimal(String binary) {
    if (Binary.contains(".")) {
      String FractionPart = Binary.substring(Binary.indexOf('.') + 1);
      String IntegerPart = Binary.replace("." + FractionPart, "");
      int num1 = 0;
      char[] IntegeR = IntegerPart.toCharArray();
      int counter1 = 0;
      for (int i = IntegerPart.length() - 1; i >= 0; i--) {
        int a = (IntegeR[i] - '0');
        num1 += (a * Math.pow(2, counter1));
        counter1++;
      }
      String Dicemal1 = Integer.toString(num1);

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
      String IntegerPart = Binary;
      int num1 = 0;
      char[] IntegeR = IntegerPart.toCharArray();
      int counter1 = 0;
      for (int i = IntegerPart.length() - 1; i >= 0; i--) {
        int a = (IntegeR[i] - '0');
        num1 += (a * Math.pow(2, counter1));
        counter1++;
      }
      String Dicemal = Integer.toString(num1);
      return Dicemal;
    }
  }

  public static String ToOctal(String binary) {
    if (Binary.contains(".")) {
      String FractionsPart = Binary.substring(Binary.indexOf('.') + 1);
      String IntegerPart = Binary.replace("." + FractionsPart, "");
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

      int num1 = (Integer.parseInt(IntegerPart, 2));
      String Octal1 = Integer.toOctalString(num1);
      int num2 = (Integer.parseInt(FractionsPart, 2));
      String Octal2 = Integer.toOctalString(num2);

      while (Octal2.charAt(Octal2.length() - 1) == '0') {
        Octal2 = removeLastCharacter(Octal2);
      }

      String Octal = Octal1 + "." + Zeros + Octal2;
      return Octal;
    } else {
      String I;
      while (Binary.length() % 3 != 0) {
        I = "0" + Binary;
        Binary = I;
      }
      int num = (Integer.parseInt(Binary, 2));
      String Octal = Integer.toOctalString(num);
      return Octal;
    }
  }

  public static String ToHexadecimal(String binary) {
    if (Binary.contains(".")) {
      String FractionsPart = Binary.substring(Binary.indexOf('.') + 1);
      String IntegerPart = Binary.replace("." + FractionsPart, "");
      String I;
      while (IntegerPart.length() % 4 != 0) {
        I = "0" + IntegerPart;
        IntegerPart = I;
      }
      while (FractionsPart.length() % 4 != 0) {
        I = FractionsPart + "0";
        FractionsPart = I;
      }

      String Zeros = "";
      int i = 0;
      while (FractionsPart.substring(i, i + 4).equals("0000")) {
        Zeros = Zeros.concat("0");
        i += 4;
        if ((i + 4) > FractionsPart.length()) {
          break;
        }
      }
      int num1 = (Integer.parseInt(IntegerPart, 2));
      String Hex1 = Integer.toHexString(num1);
      int num2 = (Integer.parseInt(FractionsPart, 2));
      String Hex2 = Integer.toHexString(num2);

      while (Hex2.charAt(Hex2.length() - 1) == '0') {
        Hex2 = removeLastCharacter(Hex2);
      }

      String Hex = Hex1.toUpperCase() + "." + Zeros + Hex2.toUpperCase();
      return Hex;
    } else {
      String I;
      while (Binary.length() % 4 != 0) {
        I = "0" + Binary;
        Binary = I;
      }

      int num = (Integer.parseInt(Binary, 2));
      String Hex = Integer.toHexString(num).toUpperCase();
      return Hex;
    }
  }
}