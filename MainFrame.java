import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainFrame extends JFrame implements ActionListener {
  TextFields inputField = new TextFields("Enter a number");
  TextFields outputField = new TextFields("Result");
  Labels inputSystemLabel = new Labels("Input System");
  Labels outputSystemLabel = new Labels("Output System");
  Labels inputNumberLabel = new Labels("Input Number");
  Labels outputNumberLabel = new Labels("Output Number");
  Buttons convertButton = new Buttons("Convert");
  Buttons clearButton = new Buttons("Clear");
  Buttons swapButton = new Buttons("Swap");
  ComboBoxes inputSystem = new ComboBoxes(new String[] { "Decimal", "Binary", "Octal", "Hexadecimal" });
  ComboBoxes outputSystem = new ComboBoxes(new String[] { "Decimal", "Binary", "Octal", "Hexadecimal" });

  public MainFrame() {
    setTitle("Number System Converter");
    setSize(400, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(new java.awt.Color(195, 195, 195));
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);
    setVisible(true);

    inputField.setLocation(20, 100);
    inputNumberLabel.setLocation(30, 50);
    outputNumberLabel.setLocation(30, 100);
    inputSystemLabel.setLocation(30, 50);
    outputSystem.setLocation(30, 100);
    inputSystem.setLocation(30, 150);
    outputSystem.setLocation(30, 200);
    convertButton.setLocation(10, 300);
    swapButton.setLocation(135, 300);
    clearButton.setLocation(260, 300);
    outputField.setLocation(20, 500);

    int horizontalGap = 10;
    int verticalGap = 20;

    inputNumberLabel.setLocation(horizontalGap, verticalGap);
    inputField.setLocation(horizontalGap, verticalGap + 50);

    outputNumberLabel.setLocation(horizontalGap, verticalGap + 100);
    outputField.setLocation(horizontalGap, verticalGap + 150);

    inputSystemLabel.setLocation(horizontalGap, verticalGap + 200);
    inputSystem.setLocation(horizontalGap, verticalGap + 250);

    outputSystem.setLocation(horizontalGap, verticalGap + 300);
    outputSystem.setLocation(horizontalGap, verticalGap + 350);

    convertButton.setLocation(horizontalGap, verticalGap + 400);
    swapButton.setLocation(horizontalGap + 125, verticalGap + 400);
    clearButton.setLocation(horizontalGap + 250, verticalGap + 400);

    add(inputField);
    add(inputNumberLabel);
    add(outputNumberLabel);
    add(inputSystemLabel);
    add(outputSystem);
    add(outputField);
    add(convertButton);
    add(clearButton);
    add(swapButton);
    add(inputSystem);
    add(outputSystem);

    convertButton.addActionListener(this);
    clearButton.addActionListener(this);

    inputField.addActionListener(this);
    outputField.addActionListener(this);
    inputSystem.addActionListener(this);
    outputSystem.addActionListener(this);

    inputField.setVisible(true);
    inputNumberLabel.setVisible(true);
    outputNumberLabel.setVisible(true);
    inputSystemLabel.setVisible(true);
    outputSystem.setVisible(true);
    outputField.setVisible(true);
    convertButton.setVisible(true);
    clearButton.setVisible(true);
    swapButton.setVisible(true);
    inputSystem.setVisible(true);
    outputSystem.setVisible(true);

    inputField.setEditable(true);
    outputField.setEditable(false);

    inputField.setHorizontalAlignment(JTextField.CENTER);
    outputField.setHorizontalAlignment(JTextField.CENTER);

    // inputField.requestFocus();

    // inputField.selectAll();

    // inputField.grabFocus();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == convertButton) {
      switch ((String) inputSystem.getSelectedItem()) {
        case "Decimal":
          switch ((String) outputSystem.getSelectedItem()) {
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
            default:
              outputField.setText("Please select a valid output system");
              break;
          }
          break;
        default:
          outputField.setText("Please select a valid input system");
          break;
      }
    } else if (e.getSource() == clearButton) {
      inputField.setText("");
      outputField.setText("");
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
    setSize(120, 40);
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
    setSize(350, 40);
    setBackground(new java.awt.Color(255, 255, 255));
  }
}

class Labels extends JLabel {
  public Labels(String string) {
    setText(string);
    setSize(120, 40);
    setBackground(new java.awt.Color(169, 169, 169));
  }
}