/**
 * Decimal
 */
public class Decimal {
  public static String ToBinary(String Decimal) {
    if (Decimal.contains(".")) {
      double num = Double.parseDouble(Decimal);
      String binary = "";
      int Integral = (int) num;
      double fractional = num - Integral;
      while (Integral > 0) {
        int rem = Integral % 2;
        binary += ((char) (rem + '0'));
        Integral /= 2;
      }
      binary = reverse(binary);
      binary += ('.');
      int II = 20;
      while (II-- > 0) {
        fractional *= 2;
        int fract_bit = (int) fractional;

        if (fract_bit == 1) {
          fractional -= fract_bit;
          binary += (char) (1 + '0');
        } else {
          binary += (char) (0 + '0');
        }
      }
      return binary;
    } else {
      String STr = "";
      String IntegerPart = Decimal;
      int num = Integer.valueOf(IntegerPart);
      int n;
      while (num > 0) {
        n = num % 2;
        num /= 2;
        STr = STr.concat(Integer.toString(n));
      }
      String Binary = reverse(STr);
      return Binary;
    }
  }

  public static String ToOctal(String decimal) {
    String binary = Decimal.ToBinary(decimal);
    String Octal = Binary.ToOctal(binary);
    return Octal;
  }

  public static String ToHexadecimal(String decimal) {
    String binary = Decimal.ToBinary(decimal);
    String Hexadecimal = Binary.ToHexadecimal(binary);
    return Hexadecimal;
  }

  private static String reverse(String STr) {
    String stR = "";
    String[] A = STr.split("");
    for (int i = STr.length() - 1; i >= 0; i--) {
      stR = stR.concat(A[i]);
    }
    return stR;
  }

}