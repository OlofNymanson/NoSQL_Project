package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

import controller.Controller;


public class GUI extends JFrame{
	
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private Controller controller = new Controller();
	
	public GUI() {
		final JFrame frame = new JFrame("BEAVERCOFFEE");
		frame.setSize(600, 400);
		frame.setLayout(new GridLayout(0,1));
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		JLabel beaver = new JLabel("BEAVERCOFFEE");
		JButton addMemberBtn = new JButton("Add member");
		JButton employeeBtn = new JButton("Add employee");
		JButton locationBtn = new JButton("Add location");
		JButton addEmployerBtn = new JButton("Add employer");
		JButton findEmployerBtn = new JButton("Find employer");
		JButton findEmployeeBtn = new JButton("Find employee");
		JButton findLocationBtn = new JButton("Find location");
		JButton findMemberBtn = new JButton("Find member");
		JButton addIngredientBtn = new JButton("Add ingredient");
		JButton findIngredientBtn = new JButton("Find ingredient");
		JButton commentBtn = new JButton("Make a comment");
		JButton makeOrderBtn = new JButton("Make an order");
		
		
		makeOrderBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	frame.setVisible(false);
		    	makeOrder();
		    }  
		    }); 
		
		commentBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	frame.setVisible(false);
		    	makeComment();
		    }  
		    }); 
		
		findMemberBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String id = JOptionPane.showInputDialog("Enter a member's ID");
		    }  
		    });
		
		findLocationBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String id = JOptionPane.showInputDialog("Enter a location's ID");
		    }  
		    });
		
		findEmployeeBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String id = JOptionPane.showInputDialog("Enter a employee's ID");
		    }  
		    });
		
		findEmployerBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String id = JOptionPane.showInputDialog("Enter a employer's ID");
		    }  
		    });
		
		findIngredientBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String name = JOptionPane.showInputDialog("Enter a ingredient's name");
		    }  
		    });
		
		employeeBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	frame.setVisible(false);
		    	addEmployee();
		    }  
		    }); 
		
		addEmployerBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	frame.setVisible(false);
		    	addEmployer();
		    }  
		    }); 
		
		addMemberBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	frame.setVisible(false);
		    	addMember();
		    }  
		    }); 
		
		locationBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	frame.setVisible(false);
		    	addLocation();
		    }  
		    }); 
		
		addIngredientBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	frame.setVisible(false);
		    	addIngredient();
		    }  
		    }); 
		
		//frame.add(beaver);
		frame.add(makeOrderBtn);
		frame.add(addMemberBtn);
		frame.add(findMemberBtn);
		frame.add(employeeBtn);
		frame.add(findEmployeeBtn);
		frame.add(locationBtn);
		frame.add(findLocationBtn);
		frame.add(addEmployerBtn);
		frame.add(findEmployerBtn);
		frame.add(addIngredientBtn);
		frame.add(findIngredientBtn);
		frame.add(commentBtn);
		frame.setVisible(true);
		//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void makeOrder() {
		final JFrame locationFrame = new JFrame("Make an order");
		JButton addBtn = new JButton("Make order");
		JButton backBtn = new JButton("Back");
		JLabel lblId = new JLabel("Order ID:");
		JLabel lblEmpId = new JLabel("Employee ID:");
		JLabel lblLocId = new JLabel("Location ID:");
		JLabel lblMemId = new JLabel("Member ID");
		JTextField tfId = new JTextField();
		JTextField tfEmpId = new JTextField();
		JTextField tfLocId = new JTextField();
		JTextField tfMemId = new JTextField();
		locationFrame.dispatchEvent(new WindowEvent(locationFrame, WindowEvent.WINDOW_CLOSING));
		locationFrame.setLocation(dim.width/2-locationFrame.getSize().width/2, dim.height/2-locationFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	//add to db
		    		locationFrame.setVisible(false);
		    		new GUI();
		    }  
		    });  
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
	    		locationFrame.setVisible(false);
	    		new GUI();
	    }  
	    });  
		
		locationFrame.setLayout(new GridLayout(8,2));
		locationFrame.add(lblId);
		locationFrame.add(tfId);
		locationFrame.add(lblEmpId);
		locationFrame.add(tfEmpId);
		locationFrame.add(lblLocId);
		locationFrame.add(tfLocId);
		locationFrame.add(lblMemId);
		locationFrame.add(tfMemId);
		locationFrame.add(addBtn);
		locationFrame.add(backBtn);
		
		locationFrame.setSize(400, 300);
		locationFrame.setVisible(true);
	}
	
	private void addIngredient() {
		final JFrame ingredientFrame = new JFrame("Add Ingredient");
		JButton addBtn = new JButton("Add Ingredient");
		JButton backBtn = new JButton("Back");
		JLabel lblName = new JLabel("Ingredient name:");
		JLabel lblPrice = new JLabel("Price:");
		JTextField tfName = new JTextField();
		JTextField tfPrice = new JTextField();
		ingredientFrame.dispatchEvent(new WindowEvent(ingredientFrame, WindowEvent.WINDOW_CLOSING));
		ingredientFrame.setLocation(dim.width/2-ingredientFrame.getSize().width/2, dim.height/2-ingredientFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	//add to db
		    		ingredientFrame.setVisible(false);
		    		new GUI();
		    }  
		    });  
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
	    		ingredientFrame.setVisible(false);
	    		new GUI();
	    }  
	    });  
		
		ingredientFrame.setLayout(new GridLayout(4,2));
		ingredientFrame.add(lblName);
		ingredientFrame.add(tfName);
		ingredientFrame.add(lblPrice);
		ingredientFrame.add(tfPrice);
		ingredientFrame.add(addBtn);
		ingredientFrame.add(backBtn);
		
		ingredientFrame.setSize(400, 300);
		ingredientFrame.setVisible(true);
	}
		
		
		
	private void makeComment() {
		final JFrame commentFrame = new JFrame("Make Comment");
		JButton addBtn = new JButton("Add Comment");
		JButton backBtn = new JButton("Back");
		JLabel lblId = new JLabel("Employee id:");
		JLabel lblEmployer = new JLabel("Comment by:");
		JTextField tfId = new JTextField();
		JTextField tfBy = new JTextField();
		final JTextArea comment = new JTextArea("Comment here");
		commentFrame.dispatchEvent(new WindowEvent(commentFrame, WindowEvent.WINDOW_CLOSING));
		commentFrame.setLocation(dim.width/2-commentFrame.getSize().width/2, dim.height/2-commentFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String text = comment.getText();
		    	if(text.length() > 300) {
		    		JOptionPane.showMessageDialog(null, "Comment cannot be longer than 300 chars");
		    	}
		    	else {
		    	//add to db
		    		commentFrame.setVisible(false);
		    		new GUI();
		    	}
		    }  
		    });  
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
	    		commentFrame.setVisible(false);
	    		new GUI();
	    }  
	    });  
		
		commentFrame.setLayout(new GridLayout(4,2));
		commentFrame.add(lblId);
		commentFrame.add(tfId);
		commentFrame.add(lblEmployer);
		commentFrame.add(tfBy);
		commentFrame.add(comment);
		commentFrame.add(addBtn);
		commentFrame.add(backBtn);
		
		commentFrame.setSize(400, 300);
		commentFrame.setVisible(true);
	}
	
	
	private void addEmployer() {
		final JFrame employerFrame = new JFrame("Add Employer");
		JButton addBtn = new JButton("Add Employer");
		JButton backBtn = new JButton("Back");
		JLabel lblFName = new JLabel("First Name:");
		JLabel lblLName = new JLabel("Last Name:");
		JLabel lblId = new JLabel("Employer ID:");
		JTextField tfFName = new JTextField();
		JTextField tfLName = new JTextField();
		JTextField tfId = new JTextField();
		employerFrame.dispatchEvent(new WindowEvent(employerFrame, WindowEvent.WINDOW_CLOSING));
		employerFrame.setLocation(dim.width/2-employerFrame.getSize().width/2, dim.height/2-employerFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		System.out.println("Employer added");
		    		employerFrame.setVisible(false);
		    		new GUI();
		    }  
		    });  
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
	    		employerFrame.setVisible(false);
	    		new GUI();
	    }  
	    });  
		
		employerFrame.setLayout(new GridLayout(4,2));
		employerFrame.add(lblFName);
		employerFrame.add(tfFName);
		employerFrame.add(lblLName);
		employerFrame.add(tfLName);
		employerFrame.add(lblId);
		employerFrame.add(tfId);
		employerFrame.add(addBtn);
		employerFrame.add(backBtn);
		
		employerFrame.setSize(400, 300);
		employerFrame.setVisible(true);
	}
	
	private void addLocation() {
		final JFrame locationFrame = new JFrame("Add Location");
		JButton addBtn = new JButton("Add Location");
		JButton backBtn = new JButton("Back");
		JLabel lblCountry = new JLabel("Country:");
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblId = new JLabel("Location ID:");
		JTextField tfCountry = new JTextField();
		JTextField tfAddress = new JTextField();
		JTextField tfId = new JTextField();
		locationFrame.dispatchEvent(new WindowEvent(locationFrame, WindowEvent.WINDOW_CLOSING));
		locationFrame.setLocation(dim.width/2-locationFrame.getSize().width/2, dim.height/2-locationFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		System.out.println("Employee added");
		    		locationFrame.setVisible(false);
		    		new GUI();
		    }  
		    });  
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
	    		locationFrame.setVisible(false);
	    		new GUI();
	    }  
	    });  
		
		
		locationFrame.setLayout(new GridLayout(6,2));
		locationFrame.add(lblCountry);
		locationFrame.add(tfCountry);
		locationFrame.add(lblAddress);
		locationFrame.add(tfAddress);
		locationFrame.add(lblId);
		locationFrame.add(tfId);
		locationFrame.add(addBtn);
		locationFrame.add(backBtn);
		
		locationFrame.setSize(400, 300);
		locationFrame.setVisible(true);
	}
	
	
	
	private void addEmployee() {
		final JFrame employeeFrame = new JFrame("Add Employee");
		JButton backBtn = new JButton("Back");
		JButton addBtn = new JButton("Add employee");
		JLabel lblFName = new JLabel("First Name:");
		JLabel lblLName = new JLabel("Last Name:");
		JLabel lblId = new JLabel("Employee ID:");
		JLabel lblLocation = new JLabel("Location ID:");
		JTextField tfFname = new JTextField();
		JTextField tfLname = new JTextField();
		JTextField tfId = new JTextField();
		JTextField tfLocation = new JTextField();
		employeeFrame.dispatchEvent(new WindowEvent(employeeFrame, WindowEvent.WINDOW_CLOSING));
		employeeFrame.setLocation(dim.width/2-employeeFrame.getSize().width/2, dim.height/2-employeeFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		System.out.println("Employee added");
		    		employeeFrame.setVisible(false);
		    		new GUI();
		    }  
		    });  
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
	    		employeeFrame.setVisible(false);
	    		new GUI();
	    }  
	    });  
		
		
		employeeFrame.setLayout(new GridLayout(6,2));
		employeeFrame.add(lblFName);
		employeeFrame.add(tfFname);
		employeeFrame.add(lblLName);
		employeeFrame.add(tfLname);
		employeeFrame.add(lblId);
		employeeFrame.add(tfId);
		employeeFrame.add(lblLocation);
		employeeFrame.add(tfLocation);
		employeeFrame.add(addBtn);
		employeeFrame.add(backBtn);
		
		employeeFrame.setSize(400, 300);
		employeeFrame.setVisible(true);
	}
	
	
	private void addMember() {
		final JFrame memberFrame = new JFrame("Add member");
		JButton addBtn = new JButton("Add Member");
		JButton backBtn = new JButton("Back");
		JLabel lblFName = new JLabel("First Name:");
		JLabel lblLName = new JLabel("Last Name:");
		JLabel lblId = new JLabel("ID:");
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblOccupation = new JLabel("Occupation:");
		JLabel lblSSN = new JLabel("SSN:");
		JTextField tfFname = new JTextField();
		JTextField tfLname = new JTextField();
		JTextField tfId = new JTextField();
		JTextField tfAddress = new JTextField();
		JTextField tfOccupation = new JTextField();
		JTextField tfSSN = new JTextField();
		memberFrame.dispatchEvent(new WindowEvent(memberFrame, WindowEvent.WINDOW_CLOSING));
		memberFrame.setLocation(dim.width/2-memberFrame.getSize().width/2, dim.height/2-memberFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		System.out.println("Member added");
		    		memberFrame.setVisible(false);
		    		new GUI();
		    }  
		    }); 
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
	    		memberFrame.setVisible(false);
	    		new GUI();
	    }  
	    });  
		
		
		memberFrame.setLayout(new GridLayout(8,2));
		memberFrame.add(lblFName);
		memberFrame.add(tfFname);
		memberFrame.add(lblLName);
		memberFrame.add(tfLname);
		memberFrame.add(lblId);
		memberFrame.add(tfId);
		memberFrame.add(lblAddress);
		memberFrame.add(tfAddress);
		memberFrame.add(lblOccupation);
		memberFrame.add(tfOccupation);
		memberFrame.add(lblSSN);
		memberFrame.add(tfSSN);
		memberFrame.add(addBtn);
		memberFrame.add(backBtn);
		
		memberFrame.setSize(400, 300);
		memberFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//new StartGUI();
		new GUI();
	}

}
