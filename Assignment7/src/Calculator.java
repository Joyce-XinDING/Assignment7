import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Implement a calculator and it's add, minus, multiply and divide operations.//
public class Calculator extends JFrame implements ActionListener {
	
	private class WindowCloser extends WindowAdapter{
    }
	//Create the numbers on the button
	int i=0;
	private final String [] str={"7", "8", "9", "+", "4", "5","6", "-", "1", "2", "3" ,"*", "0",".","/","="};
	
	//Build buttons
	JButton[] buttons = new JButton[str.length];
	//Build text fields
	JTextField text = new JTextField();
	
	public Calculator() {
		super("Calc2");
		JPanel panel1 = new JPanel(new GridLayout(4, 4));
		for(int i=0; i<16; i++){
			buttons[i] = new JButton(str[i]);
			panel1.add(buttons[i]);
		}
		
		JPanel panel2 = new JPanel(new BorderLayout());
		panel2.add("Center", text);
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel1, "Center");
		getContentPane().add(panel2, "North");
		
		//add listeners
		for(int i=0; i<16; i++){
			buttons[i].addActionListener(this);
			text.addActionListener(this);
			addWindowListener(new WindowCloser());
			setSize(300, 300);
			setVisible(true);
		}
	}
	//avoid the first number start with .
	boolean isFirstDigit = true;
	Object operator = "=";
    double number= 0.0;
    
	public void handleOperator(String key) {	       
		if (operator.equals("+"))
	           number += Double.valueOf(text.getText());
	       else if (operator.equals("-"))
	           number -= Double.valueOf(text.getText());
	       else if (operator.equals("*"))
	           number *= Double.valueOf(text.getText());
	       else if (operator.equals("/"))
	           number /= Double.valueOf(text.getText());
	       else if (operator.equals("="))
	           number = Double.valueOf(text.getText());
	       text.setText(String.valueOf(number));
	       operator = key;
	       isFirstDigit = true;
	    }
	
	 public void handleNumber(String key) {
	       if (isFirstDigit)
	           text.setText(key);
	       else if ((key.equals(".")) && (text.getText().indexOf(".") < 0))
	           text.setText(text.getText() + ".");
	       else if (!key.equals("."))
	           text.setText(text.getText() + key);
	       isFirstDigit = false;
	    }
	 
	 public void actionPerformed(ActionEvent e) {
	       String label = e.getActionCommand();
	       if ("0123456789.".indexOf(label) > 0)
	           handleNumber(label);
	       else
	           handleOperator(label);
	    }
	public static void main(String[] args) {
		new Calculator();

	}

}
