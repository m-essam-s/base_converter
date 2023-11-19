/**
 * Decimal
 */
public class Decimal {
  public static String ToBinary(String Decimal) {
    if(Decimal.contains(".")){
      double num = Double.parseDouble(Decimal);
      String binary = "";
      int Integral = (int) num;
      double fractional = num - Integral;
      while (Integral > 0){
        int rem = Integral % 2;
        binary += ((char)(rem + '0'));
        Integral /= 2;
      }
      binary = reverse(binary);
      binary += ('.');
      int II = 20;
      while (II-- > 0){
        fractional *= 2;
        int fract_bit = (int) fractional;

        if (fract_bit == 1){
            fractional -= fract_bit;
            binary += (char)(1 + '0');
          }
        else{
            binary += (char)(0 + '0');
          }
      }
      return binary;
    }
    else{
      String STr="";
      String IntegerPart=Decimal;
      int num=Integer.valueOf(IntegerPart);
      int n;
      while(num>0){
        n=num%2; 
        num/=2;
        STr=STr.concat(Integer.toString(n));
      }
      String Binary= reverse(STr);
      return Binary;
    }
  }
  public static String ToOctal(String decimal) {
    String Binary = Decimal_To_Binary(Decimal);
    String Octal = Binary_To_Octal(Binary);
    return Octal;
  }
  public static String toHexadecimal(int decimal) {
    String Binary = Decimal_To_Binary(Decimal) ;
    String Hexadecimal = Binary_To_Hexadecimal(Binary);
    return Hexadecimal;
  }
  
}