import java.awt.event.*;
import javax.swing.*;

public class NSConverter {
    public static void main(String[] args) {
        new mainFrame();
    }
}

public class Code{
    public static String Decimal_To_Binary( String Decimal){
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


    public static String Decimal_To_Octal( String Decimal){
        String Binary = Decimal_To_Binary(Decimal);
        String Octal = Binary_To_Octal(Binary);
        return Octal;
    }


    public static String Decimal_To_Hexadecimal( String Decimal){
        String Binary = Decimal_To_Binary(Decimal) ;
        String Hexadecimal = Binary_To_Hexadecimal(Binary);
        return Hexadecimal;

    }

    public static String Binary_To_Decimal( String Binary){
        if(Binary.contains(".")){
            String FractionPart=Binary.substring(Binary.indexOf('.')+1) ;    
            String IntegerPart  =Binary.replace("."+FractionPart,"") ;
            int num1=0;
            char[] IntegeR=IntegerPart.toCharArray();
            int counter1=0;
            for (int i=IntegerPart.length()-1;i>=0;i--){
                int a = (IntegeR[i] - '0');
                num1+=(a*Math.pow(2, counter1));
                counter1++;
            }
            String Dicemal1 = Integer.toString(num1);
            
            Double num2=0.0;
            char[] FractioN=FractionPart.toCharArray();
            int counter2=-1;
            for (int i=0; i<FractionPart.length(); i++){
                int a = (FractioN[i] - '0');
                num2+=(a*Math.pow(2, counter2));
                counter2--;
            }
            String Dicemal2 = Double.toString(num2);
            String Dicemal = Dicemal1+"."+Dicemal2.substring(2);  
            return Dicemal;  
        }
        else{
            String IntegerPart = Binary;
            int num1=0;
            char[] IntegeR=IntegerPart.toCharArray();
            int counter1=0;
            for (int i=IntegerPart.length()-1;i>=0;i--){
                int a = (IntegeR[i] - '0');
                num1+=(a*Math.pow(2, counter1));
                counter1++;
            }
            String Dicemal = Integer.toString(num1);
            return Dicemal;
        }
    }

    public static String Binary_To_Octal( String Binary){
        if (Binary.contains(".")){
        String FractionsPart=Binary.substring(Binary.indexOf('.')+1) ;    
        String IntegerPart  =Binary.replace("."+FractionsPart,"") ;
        String I;
        while(IntegerPart.length() % 3!=0){
            I ="0"+IntegerPart;
            IntegerPart=I;
        }
        while(FractionsPart.length() % 3!=0){
            I =FractionsPart+"0";
            FractionsPart=I;
        }
        String Zeros="";
        int i=0;
        while(FractionsPart.substring(i, i+3).equals("000")  ){
            Zeros=Zeros.concat("0");
            i+=3;
        if ((i+3)>FractionsPart.length()){
            break;
            }
        }

        int num1 = (Integer.parseInt(IntegerPart, 2));
        String Octal1 = Integer.toOctalString(num1);
        int num2 = (Integer.parseInt(FractionsPart, 2));
        String Octal2 = Integer.toOctalString(num2);
        
        while(Octal2.charAt(Octal2.length() - 1)=='0'){
            Octal2=removeLastCharacter(Octal2);
        }
        
        String Octal=Octal1+"."+Zeros+Octal2;
        return Octal;
        }
        else{
            String I;
            while(Binary.length() % 3!=0){
                I ="0"+Binary;
                Binary=I;
            }
            int num = (Integer.parseInt(Binary, 2));
            String Octal = Integer.toOctalString(num);
            return Octal ;
        }
    }

    public static String Binary_To_Hexadecimal( String Binary){
        if (Binary.contains(".")){
        String FractionsPart=Binary.substring(Binary.indexOf('.')+1) ;    
        String IntegerPart  =Binary.replace("."+FractionsPart,"") ;
        String I;
        while(IntegerPart.length() % 4!=0){
            I ="0"+IntegerPart;
            IntegerPart=I;
        }
        while(FractionsPart.length() % 4!=0){
            I =FractionsPart+"0";
            FractionsPart=I;
        }
        
        String Zeros="";
        int i=0;
        while(FractionsPart.substring(i, i+4).equals("0000")  ){
            Zeros=Zeros.concat("0");
            i+=4;
            if ((i+4)>FractionsPart.length()){
                break;
            }
        }
        int num1 = (Integer.parseInt(IntegerPart, 2));
        String Hex1 = Integer.toHexString(num1);
        int num2 = (Integer.parseInt(FractionsPart, 2));
        String Hex2 = Integer.toHexString(num2);
        
        while(Hex2.charAt(Hex2.length() - 1)=='0'){
            Hex2=removeLastCharacter(Hex2);
        }
        
        String Hex=Hex1.toUpperCase()+"."+Zeros+Hex2.toUpperCase();
        return Hex;
        }
        else{
            String I;
            while(Binary.length() % 4!=0){
                I ="0"+Binary;
                Binary=I;
            }

            int num = (Integer.parseInt(Binary, 2));
            String Hex = Integer.toHexString(num).toUpperCase();
            return Hex ;
        }
    }

    public static String Octal_To_Decimal( String Octal){
        String Binary = Octal_To_Binary(Octal) ;
        String Decimal = Binary_To_Decimal(Binary);
        return Decimal;
    }

    public static String Octal_To_Binary( String OctalToBinary){
        OctalToBinary = OctalToBinary.replaceAll("0", "000");
        OctalToBinary = OctalToBinary.replaceAll("1", "001");
        OctalToBinary = OctalToBinary.replaceAll("2", "010");
        OctalToBinary = OctalToBinary.replaceAll("3", "011");
        OctalToBinary = OctalToBinary.replaceAll("4", "100");
        OctalToBinary = OctalToBinary.replaceAll("5", "101");
        OctalToBinary = OctalToBinary.replaceAll("6", "110");
        OctalToBinary = OctalToBinary.replaceAll("7", "111");
        return OctalToBinary;
    }

    public static String Octal_To_Hexadecimal( String Octal){
        String Binary = Octal_To_Binary(Octal) ;
        String Hexadecimal = Binary_To_Hexadecimal(Binary);
        return Hexadecimal;

    }

    public static String Hexadecimal_To_Decimal( String Hexadecimal){
        return Binary_To_Decimal(Hexadecimal_To_Binary(Hexadecimal));
    }

    public static String Hexadecimal_To_Binary( String HexToBinary){
            HexToBinary = HexToBinary.replaceAll("0", "0000");
            HexToBinary = HexToBinary.replaceAll("1", "0001");
            HexToBinary = HexToBinary.replaceAll("2", "0010");
            HexToBinary = HexToBinary.replaceAll("3", "0011");
            HexToBinary = HexToBinary.replaceAll("4", "0100");
            HexToBinary = HexToBinary.replaceAll("5", "0101");
            HexToBinary = HexToBinary.replaceAll("6", "0110");
            HexToBinary = HexToBinary.replaceAll("7", "0111");
            HexToBinary = HexToBinary.replaceAll("8", "1000");
            HexToBinary = HexToBinary.replaceAll("9", "1001");
            HexToBinary = HexToBinary.replaceAll("A", "1010");
            HexToBinary = HexToBinary.replaceAll("B", "1011");
            HexToBinary = HexToBinary.replaceAll("C", "1100");
            HexToBinary = HexToBinary.replaceAll("D", "1101");
            HexToBinary = HexToBinary.replaceAll("E", "1110");
            HexToBinary = HexToBinary.replaceAll("F", "1111");
            return HexToBinary;
    }

    public static String Hexadecimal_To_Octal( String Hexadecimal){
        String Binary = Hexadecimal_To_Binary(Hexadecimal);
        String Octal = Binary_To_Octal(Binary);
        return Octal;
    } 

    public static String removeLastCharacter(String str) {
        String result = null;
        if ((str != null) && (str.length() > 0)) {
           result = str.substring(0, str.length() - 1);
        }
        return result;
    }

    public static void choice(){
        System.out.print("\n1.  Decimal\n2.  Binary\n3.  Octal\n4.  HexaDecimal\n-->: ");
    }

    public static String choices(int n){
        String[] Arr={ "Decimal", "Binary", "Octal", "HexaDecimal"};
        return Arr[n-1];
    }

    static String reverse(String STr){
        String stR="";
        String[] A=STr.split("");
        for(int i=STr.length()-1; i>=0; i--){
            stR=stR.concat(A[i]);
        }
        return stR; 
    }


    @Override
    public String toString() {
        return "Code []";
    }
}
class mainFrame extends JFrame implements ActionListener {
    class Textfields extends JTextField{
        Textfields(String PlaceHolder){
            
            //customTextField.setPlaceholder(PlaceHolder);

            this.setSize(80, 20);
            this.setText(PlaceHolder);
        }
    }

    class Buttons extends JButton{
        Buttons(String string){
            this.setText(string);
            this.setSize(80, 20);
            this.setBackground(new java.awt.Color(169,169,169));

        }  
    }
    class comboBoxs extends JComboBox{
        comboBoxs(String[] Systems){
            this.setText(string);
            this.setSize(80, 20);
            this.setBackground(new java.awt.Color(169,169,169));

        }  
    }
    
    
    Buttons buttun_1 = new Buttons("");
    Buttons buttun_2 = new Buttons("");


    Textfields textField_1 = new Textfields("");
    Textfields textField_2 = new Textfields("");
    

    String[] Currencies={" ","Decimal","Binary", "Octal", "HexaDecimal"};
    
    JComboBox comboBox_1 = new JComboBox(Currencies);
    JComboBox comboBox_2 = new JComboBox(Currencies);

    mainFrame(){
        
        this.setTitle("Number System Converter | Home");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new java.awt.Color(195,195,195));
            
        buttun_1.setText("Convert");
        buttun_1.addActionListener(this);  
        buttun_1.setLocation(140,270);
        buttun_2.setText("Exit");
        buttun_2.setLocation(35,270);
        buttun_2.addActionListener(this);
        
        textField_1.setBounds(140,30, 160, 20);
        textField_2.setBounds(140,150, 160, 20);

        comboBox_1.setBounds(35, 30, 80, 20);
    
        comboBox_2.setBounds(35, 150, 80, 20); 
    
        this.add(buttun_1);
        this.add(buttun_2);
        this.add(textField_1);
        this.add(textField_2);
        this.add(comboBox_1);
        this.add(comboBox_2); 
        
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); 
        this.setLayout(null);  
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new Code ();
        if (e.getSource()==buttun_1) {
            switch ((String)comboBox_1.getSelectedItem()) {
                case "Decimal":
                    switch ((String)comboBox_2.getSelectedItem()) {
                        case "Binary":
                            textField_2.setText(Code.Decimal_To_Binary(textField_1.getText())); 
                            break;
                        case "Octal":
                            textField_2.setText(Code.Decimal_To_Octal(textField_1.getText())); 
                            break;
                        case "HexaDecimal":
                            textField_2.setText(Code.Decimal_To_Hexadecimal(textField_1.getText())); 
                            break;
                        default:
                        textField_2.setText("PLZ select ");
                            break;
                    }break;
                case "Binary":
                    switch ((String)comboBox_2.getSelectedItem()) {
                        case "Decimal":
                            textField_2.setText(Code.Binary_To_Decimal(textField_1.getText())); 
                            break;
                        case "Octal":
                            textField_2.setText(Code.Binary_To_Octal(textField_1.getText())); 
                            break;
                        case "HexaDecimal":
                            textField_2.setText(Code.Binary_To_Hexadecimal(textField_1.getText())); 
                            break;
                        default:
                        textField_2.setText("PLZ sele2222ct ");
                            break;
                    }break;
                case "Octal":
                    switch ((String)comboBox_2.getSelectedItem()) {
                        case "Decimal":
                            textField_2.setText(Code.Octal_To_Decimal(textField_1.getText())); 
                            break;
                        case "Binary":
                            textField_2.setText(Code.Octal_To_Binary(textField_1.getText())); 
                            break;
                        case "HexaDecimal":
                            textField_2.setText(Code.Octal_To_Hexadecimal(textField_1.getText())); 
                            break;
                        default:
                        textField_2.setText("PLZ select ");
                            break;
                    }break;
                case "HexaDecimal":
                    switch ((String)comboBox_2.getSelectedItem()) {
                        case "Decimal":
                            textField_2.setText(Code.Octal_To_Decimal(textField_1.getText())); 
                            break;
                        case "Binary":
                            textField_2.setText(Code.Octal_To_Binary(textField_1.getText())); 
                            break;
                        case "Octal":
                            textField_2.setText(Code.Octal_To_Hexadecimal(textField_1.getText())); 
                            break;
                        default:
                        textField_2.setText("PLZ select ");
                            break;  
                    }break;      
                default:
                    textField_2.setText("PLZ s5454elect ");
                    break;
            }
        }
        else if (e.getSource()==buttun_2) {
            System.exit(0);
        }
    }
}