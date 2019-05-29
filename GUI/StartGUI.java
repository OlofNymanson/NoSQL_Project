package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
//import java.awt.event;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StartGUI extends JFrame  {
	private JLabel l1, l2, l3;
	JTextField tf1;
	JButton btn1;
	JPasswordField p1;

	StartGUI() {
		final JFrame frame = new JFrame("BEAVERCOFFEE");
		l1 = new JLabel("BEAVERCOFFEE");
		l1.setForeground(Color.RED);
		l1.setFont(new Font("Serif", Font.BOLD, 20));

		l2 = new JLabel("Username");
		l3 = new JLabel("Password");
		tf1 = new JTextField();
		p1 = new JPasswordField();
		btn1 = new JButton("Login");

		l1.setBounds(100, 30, 400, 30);
		l2.setBounds(80, 70, 200, 30);
		l3.setBounds(80, 110, 200, 30);
		tf1.setBounds(300, 70, 200, 30);
		p1.setBounds(300, 110, 200, 30);
		btn1.setBounds(150, 160, 100, 30);
		btn1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	if (tf1.getText().equals("abc") && p1.getText().equals("123")) {
		    		frame.setVisible(false);
		    		new EmployeeWindow();
		            System.out.println("HEJHEJ");  
		    	}
		    }  
		    });  

		frame.add(l1);
		frame.add(l2);
		frame.add(tf1);
		frame.add(l3);
		frame.add(p1);
		frame.add(btn1);
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		frame.setSize(600, 400);
		frame.setLayout(null);
		frame.setVisible(true);
	}

//	public void actionPerformed(ActionEvent ae) {
//		String uname = tf1.getText();
//		String pass = p1.getText();
//		System.out.println("KUK");
//		if (uname.equals("abc") && pass.equals("123")) {
//			System.out.println("LUL");
//			
////			Welcome wel = new Welcome();
////			wel.setVisible(true);
////			JLabel label = new JLabel("Welcome:" + uname);
////			wel.getContentPane().add(label);
//		} else {
//			JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
//		}
//	}

	

	public static void main(String[] args) {
		new StartGUI();
		//new EmployeeWindow();
	}

	
}