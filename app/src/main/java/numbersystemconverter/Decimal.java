package numbersystemconverter;

/**
 * Decimal
 */
public class Decimal {
  public static String ToBinary(String Decimal) {
    try {
        if (Decimal.contains(".")) {
            double num = Double.parseDouble(Decimal);
            long Integral = (long) num;
            double fractional = num - Integral;

            StringBuilder binaryBuilder = new StringBuilder();

            // Convert integral part to binary
            while (Integral > 0) {
                int rem = (int) Integral % 2;
                binaryBuilder.insert(0, rem);
                Integral /= 2;
            }
            binaryBuilder.append('.');

            // Convert fractional part to binary
            int II = 20;
            while (II-- > 0) {
                fractional *= 2;
                int fract_bit = (int) fractional;

                if (fract_bit == 1) {
                    fractional -= fract_bit;
                    binaryBuilder.append('1');
                } else {
                    binaryBuilder.append('0');
                }
            }

            return binaryBuilder.toString();
        } else {
            String IntegerPart = Decimal;
            long num = Long.valueOf(IntegerPart);
            StringBuilder binaryBuilder = new StringBuilder();

            // Convert integral part to binary
            while (num > 0) {
                int n = (int) (num % 2);
                binaryBuilder.insert(0, n);
                num /= 2;
            }

            return binaryBuilder.toString();
        }
    } catch (NumberFormatException e) {
        return "Error: Invalid input. Please provide a valid decimal number.";
    } catch (Exception e) {
        return "Error: An unexpected error occurred.";
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

}