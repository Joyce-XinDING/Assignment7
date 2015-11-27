import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//Based on problem 1, create a button and text area on the same layout. 
//Each time you click the button, it will read a string from ArrayList in order and show it in the text area. 
//When number of clicks beyond the ArrayList, pop up an alert menu.

public class DisplayQ1 extends JFrame{
	private JButton myButton;
	private JTextArea myTextArea;
	
	private ArrayList<String> content;
	private int line;
	private JScrollPane scroll;
	
	public DisplayQ1(String string) throws FileNotFoundException, IOException{
		create();
		add();
		addListeners();
		display();
		content = new RevFile(string).readbyline();
		line=0;
		
	}
	private void create() {
		myButton = new JButton("Click me!");
		myTextArea = new JTextArea();
		
		scroll = new JScrollPane();
		scroll.setViewportView(myTextArea);
		
		
	}
	public void add(){
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("South", myButton);
		getContentPane().add("Center", scroll);
	}
	public void addListeners(){
		myButton.addActionListener(new onClick());
	}
	public void display(){
		setSize(600,300);
		setVisible(true);
	}
	class onClick implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(line==content.size()){
				JOptionPane.showMessageDialog(null, "Nothing to show!");
			} else {
				myTextArea.append(content.get(line++)+"\n");
			}
			
		}
	}
	public static void main(String[] args) throws IOException{
		new DisplayQ1("/Users/Joyce/Desktop/HW7TestFile.txt");
	}
	
}
