package numbersystemconverter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements ActionListener {
  TextFields inputField = new TextFields("");
  TextFields outputField = new TextFields("Result");
  Labels inputSystemLabel = new Labels("From System");
  Labels outputSystemLabel = new Labels("Output System");
  Labels inputNumberLabel = new Labels("Input Number");
  Labels outputNumberLabel = new Labels("Output Number");
  Buttons convertButton = new Buttons("Convert");
  Buttons resetButton = new Buttons("Reset");
  Buttons swapButton = new Buttons("Swap");
  ComboBoxes inputSystem = new ComboBoxes(new String[] { "Decimal", "Binary", "Octal", "Hexadecimal" });
  ComboBoxes outputSystem = new ComboBoxes(new String[] { "Decimal", "Binary", "Octal", "Hexadecimal" });

  public MainFrame() {
    setTitle("Number System Converter");
    setSize(400, 530);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(new java.awt.Color(195, 195, 195));
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);
    setVisible(true);



    inputNumberLabel.setLocation(30, 10);
    inputField.setLocation(30, 40);

    
    inputSystemLabel.setLocation(30, 80);
    inputSystem.setLocation(30, 110);


    outputSystemLabel.setLocation(30, 200);
    outputSystem.setLocation(30, 230);

    convertButton.setLocation(30, 350);
    swapButton.setLocation(140, 350);
    resetButton.setLocation(250, 350);

    outputNumberLabel.setLocation(30, 390);
    outputField.setLocation(30, 420);
    


    add(inputField);
    add(inputNumberLabel);
    add(outputNumberLabel);
    add(inputSystemLabel);
    add(outputSystem);
    add(outputField);
    add(convertButton);
    add(resetButton);
    add(swapButton);
    add(inputSystem);
    add(outputSystemLabel);

    convertButton.addActionListener(this);
    resetButton.addActionListener(this);
    inputField.addActionListener(this);
    outputField.addActionListener(this);
    inputSystem.addActionListener(this);
    outputSystem.addActionListener(this);
    swapButton.addActionListener(this);


    inputNumberLabel.setVisible(true);
    inputField.setVisible(true);
    inputSystemLabel.setVisible(true);
    inputSystem.setVisible(true);
    outputSystemLabel.setVisible(true);
    outputSystem.setVisible(true);
    convertButton.setVisible(true);
    swapButton.setVisible(true);
    resetButton.setVisible(true);
    outputNumberLabel.setVisible(true);
    outputField.setVisible(true);
    inputField.setEditable(true);
    outputField.setEditable(false);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == convertButton) {
      switch ((String) inputSystem.getSelectedItem()) {
        case "Decimal":
          switch ((String) outputSystem.getSelectedItem()) {
            case "Decimal":
              outputField.setText(inputField.getText());
              break;
            case "Binary":
              outputField.setText(Decimal.ToBinary(inputField.getText()));
              break;
            case "Octal":
              outputField.setText(Decimal.ToOctal(inputField.getText()));
              break;
            case "Hexadecimal":
              outputField.setText(Decimal.ToHexadecimal(inputField.getText()));
              break;
            default:
              outputField.setText("Please select a valid output system");
              break;
          }
          break;
        case "Binary":
          switch ((String) outputSystem.getSelectedItem()) {
            case "Decimal":
              outputField.setText(Binary.ToDecimal(inputField.getText()));
              break;
            case "Binary":
              outputField.setText(inputField.getText());
              break;
            case "Octal":
              outputField.setText(Binary.ToOctal(inputField.getText()));
              break;
            case "Hexadecimal":
              outputField.setText(Binary.ToHexadecimal(inputField.getText()));
              break;
            default:
              outputField.setText("Please select a valid output system");
              break;
          }
          break;
        case "Octal":
          switch ((String) outputSystem.getSelectedItem()) {
            case "Decimal":
              outputField.setText(Octal.ToDecimal(inputField.getText()));
              break;
            case "Binary":
              outputField.setText(Octal.ToBinary(inputField.getText()));
              break;
            case "Octal":
              outputField.setText(inputField.getText());
              break;
            case "Hexadecimal":
              outputField.setText(Octal.ToHexadecimal(inputField.getText()));
              break;
            default:
              outputField.setText("Please select a valid output system");
              break;
          }
          break;
        case "Hexadecimal":
          switch ((String) outputSystem.getSelectedItem()) {
            case "Decimal":
              outputField.setText(Octal.ToDecimal(inputField.getText()));
              break;
            case "Binary":
              outputField.setText(Octal.ToBinary(inputField.getText()));
              break;
            case "Octal":
              outputField.setText(Octal.ToHexadecimal(inputField.getText()));
              break;
            case "Hexadecimal":
              outputField.setText(inputField.getText());
              break;
            default:
              outputField.setText("Please select a valid output system");
              break;
          }
          break;
        default:
          outputField.setText("Please select a valid input system");
          break;
      }
    } else if (e.getSource() == resetButton) {
      inputField.setText("");
      inputSystem.setSelectedItem("Decimal");
      outputField.setText("");
      outputSystem.setSelectedItem("Decimal");
    } else if (e.getSource() == swapButton) {
      String temp = (String) inputSystem.getSelectedItem();
      inputSystem.setSelectedItem(outputSystem.getSelectedItem());
      outputSystem.setSelectedItem(temp);
    }
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
  }
}

class Buttons extends JButton {
  public Buttons(String string) {
    setText(string);
    setSize(100, 30);
    setBackground(new java.awt.Color(169, 169, 169));
  }
}

class ComboBoxes extends JComboBox<String> {
  public ComboBoxes(String[] Systems) {
    for (String system : Systems) {
      addItem(system);
    }
    setSelectedItem(Systems[0]); // Set the initial selected item to the first element of the Systems array
    setSize(320, 30);
    setBackground(new java.awt.Color(169, 169, 169));
  }
}

class TextFields extends JTextField {
  public TextFields(String string) {
    setText(string);
    setSize(320, 40);
    setBackground(new java.awt.Color(255, 255, 255));
    setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
    setFont(new java.awt.Font("Arial", 0, 15));
  }
}

class Labels extends JLabel {
  public Labels(String string) {
    setText(string);
    setSize(120, 40);
    setBackground(new java.awt.Color(169, 169, 169));
  }
}