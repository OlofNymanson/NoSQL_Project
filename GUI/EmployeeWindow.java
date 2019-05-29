package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class EmployeeWindow extends JFrame{
	public EmployeeWindow() {
//		initialize();
	
	
//	public void initialize() {
		final JFrame frame = new JFrame("ADD MEMBER");
		frame.setSize(600, 400);
		frame.setLayout(new GridLayout(0,1));

		//frame.setLayout(null);
		
		
		JButton customerBtn = new JButton("Add member");
		JButton employeeBtn = new JButton("Add employee");
		JButton locationBtn = new JButton("Add location");
		
		customerBtn.setBounds(150, 160, 100, 30);
		employeeBtn.setBounds(150, 160, 100, 30);
		locationBtn.setBounds(150, 160, 100, 30);
		
		employeeBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
//		    	System.out.println("Employee added");
		    	frame.setVisible(false);
		    	addEmployee();
		    }  
		    }); 
		
		customerBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
//		    	System.out.println("ADD MEMBER");
		    	frame.setVisible(false);
		    	addMember();
		    }  
		    }); 
		
		locationBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
//		    	System.out.println("Employee added");
		    	frame.setVisible(false);
		    //	addLocation();
		    }  
		    }); 
		
		frame.add(customerBtn);
		frame.add(employeeBtn);
		frame.setVisible(true);
		//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
//	//id country address
//	private void addLocation() {
//		final JFrame locationFrame = new JFrame("Add Employee");
//		JButton addBtn = new JButton("Add Location");
//		JLabel lblCountry = new JLabel("Country:");
//		JLabel lblLAddress = new JLabel("Address:");
//		JLabel lblId = new JLabel("Location ID:");
//		JTextField tfFname = new JTextField();
//		JTextField tfLname = new JTextField();
//		JTextField tfId = new JTextField();
//		JTextField tfLocation = new JTextField();
//		locationFrame.dispatchEvent(new WindowEvent(locationFrame, WindowEvent.WINDOW_CLOSING));
//		
//		addBtn.addActionListener(new ActionListener(){  
//		    public void actionPerformed(ActionEvent e){  
//		    		System.out.println("Employee added");
//		    		locationFrame.setVisible(false);
//		    		new EmployeeWindow();
//		    }  
//		    });  
//		
//		
//		locationFrame.setLayout(new GridLayout(6,2));
//		locationFrame.add(lblFName);
//		locationFrame.add(tfFname);
//		locationFrame.add(lblLName);
//		locationFrame.add(tfLname);
//		locationFrame.add(lblId);
//		locationFrame.add(tfId);
//		locationFrame.add(lblLocation);
//		locationFrame.add(tfLocation);
//		locationFrame.add(addBtn);
////		JLabel firstName, lastname, id, address, occupation, ssn
//		
//		locationFrame.setSize(400, 300);
//		locationFrame.setVisible(true);
//	}
//	}
	
	//id,fname,lname,locationId
	private void addEmployee() {
		final JFrame employeeFrame = new JFrame("Add Employee");
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
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		System.out.println("Employee added");
		    		employeeFrame.setVisible(false);
		    		new EmployeeWindow();
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
//		JLabel firstName, lastname, id, address, occupation, ssn
		
		employeeFrame.setSize(400, 300);
		employeeFrame.setVisible(true);
	}
	
	
	private void addMember() {
		final JFrame memberFrame = new JFrame("Add member");
		JButton addBtn = new JButton("Add Member");
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
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		System.out.println("Member added");
		    		memberFrame.setVisible(false);
		    		new EmployeeWindow();
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
//		JLabel firstName, lastname, id, address, occupation, ssn
		
		memberFrame.setSize(400, 300);
		memberFrame.setVisible(true);
	}

}
