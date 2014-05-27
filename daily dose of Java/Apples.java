import javax.swing.JOptionPane;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Apples extends JFrame {

    private JLabel item1;

    public static void main(String[] args) {

	String firstNumber = JOptionPane.showInputDialog("Enter first number:");
	String secondNumber = JOptionPane.showInputDialog("Enter second number:");

	int num1 = Integer.parseInt(firstNumber);
	int num2 = Integer.parseInt(secondNumber);
	int sum = num1 + num2;

	JOptionPane.showMessageDialog(null, // defaults to centered
				      "The answer is: " + sum,
				      " the title ", 
				      JOptionPane.PLAIN_MESSAGE);
				

	Apples tuna = new Apples();
	tuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	tuna.setSize(275, 180);
	tuna.setVisible(true);

    }

    public Apples() {
	super("The title bar");
	setLayout( new FlowLayout());

	item1 = new JLabel("this is a sentence");
	item1.setToolTipText("This is going to show up when you hover over!");
	add(item1);

    }

}