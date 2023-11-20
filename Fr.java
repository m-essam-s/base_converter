import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class Fr extends JFrame {
  public Fr() {
    // Create the number system converter panel
    JPanel BaseConverterPanel = new JPanel(new FlowLayout());
    
    // Create the number system calculator panel
    JPanel BaseCalculatorPanel = new JPanel(new FlowLayout());
    
    // Create a tabbed pane
    JTabbedPane tabbedPane = new JTabbedPane();
    
    // Add the number system converter panel to the first tab
    tabbedPane.addTab("Base Converter", BaseConverterPanel);
    
    // Add the number system calculator panel to the second tab
    tabbedPane.addTab("Base Calculator", BaseCalculatorPanel);
    
    // Set the tabbed pane as the content pane of the frame
    setContentPane(tabbedPane);
    
    // Create components for the number system converter panel
    JLabel converterLabel = new JLabel("Converter:");
    JTextField converterTextField = new JTextField(10);
    JButton converterButton = new JButton("Convert");
    
    // Add components to the number system converter panel
    BaseConverterPanel.add(converterLabel);
    BaseConverterPanel.add(converterTextField);
    BaseConverterPanel.add(converterButton);
    
    // Create components for the number system calculator panel
    JLabel calculatorLabel = new JLabel("Calculator:");
    JTextField calculatorTextField = new JTextField(10);
    JComboBox<String> calculatorDropdown = new JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"});
    JButton calculatorButton = new JButton("Calculate");
    
    // Add components to the number system calculator panel
    BaseCalculatorPanel.add(calculatorLabel);
    BaseCalculatorPanel.add(calculatorTextField);
    BaseCalculatorPanel.add(calculatorDropdown);
    BaseCalculatorPanel.add(calculatorButton);
    
    // Set the size of the frame
    setSize(400, 300);
    
    // Set the default close operation of the frame
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Set the visibility of the frame
    setVisible(true);
  }
  
  public static void main(String[] args) {
    new Fr();
  }
}
