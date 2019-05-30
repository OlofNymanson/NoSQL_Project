package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import model.*;

//import controller.Controller;


public class GUI extends JFrame{
	
	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private Controller controller = new Controller();
	private Timestamp ts;
	
	public GUI() {
		final JFrame frame = new JFrame("BEAVERCOFFEE");
		frame.setSize(600, 400);
		frame.setLayout(new GridLayout(0,1));
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		
//		JLabel beaver = new JLabel("BEAVERCOFFEE");
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
		JButton makeReportBtn = new JButton("Create report");
		
		
		makeReportBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	frame.setVisible(false);
		    	makeReport();
		    }  
		    }); 
		
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
		    	String id = JOptionPane.showInputDialog("Enter a member's SSN");
		    	Member member = controller.findMember(id);
		    	String res = "First Name: " + member.fName + "\n Last Name: " + member.lName + "\n ID: " + member.id + "\n Adress: " + member.address +
		    			"\n Occupation: " + member.occupation + "\n SSN: " + member.SSN;
		    	JOptionPane.showMessageDialog(null, res);
		    }  
		    });
		
		findLocationBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String adress = JOptionPane.showInputDialog("Enter a location's adress");
		    	String res = controller.findLocation(adress);
		    	JOptionPane.showMessageDialog(null, res);
		    }  
		    });
		
		findEmployeeBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String id = JOptionPane.showInputDialog("Enter a employee's ID");
		    	
		    	String empInfo = controller.findEmployee(id);
		    	System.out.println("Hej");
		    	JOptionPane.showMessageDialog(null, empInfo);
		    }  
		    });
		
		findEmployerBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	String id = JOptionPane.showInputDialog("Enter a employer's ID");
		    	Employer emp = controller.findEmployer(id);
		    	String res = "Employer ID: " + emp.id + "\n First Name: " + emp.fName + "\n Last Name:" + emp.lName;
		    	JOptionPane.showMessageDialog(null, res);
		    	
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
		frame.add(makeReportBtn);
		frame.setVisible(true);
		//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	//väntar med punkt 2 & 4
	private void makeReport() {
		final JFrame reportFrame = new JFrame("Make a report");
		JButton backBtn = new JButton("Back");
		JButton salesTimeBtn = new JButton("Sales for specific time period");
		JButton salesProdBtn = new JButton("Sales for a product over a time period");
		JButton salesCustBtn = new JButton("Sales per customer by occupation");
		JButton stockQuanBtn = new JButton("Stock quantities");
		JButton ordersEmpBtn = new JButton("Orders by a employee over time");
		JButton emplTimeBtn = new JButton("Employees listing over time");
		JButton custTimeBtn = new JButton("Customers listing over time");
		JLabel hahaa = new JLabel("Products");
//		final ButtonGroup bg = new ButtonGroup();
		
		reportFrame.dispatchEvent(new WindowEvent(reportFrame, WindowEvent.WINDOW_CLOSING));
		reportFrame.setLocation(dim.width/2-reportFrame.getSize().width/2, dim.height/2-reportFrame.getSize().height/2);
		
		
		
		salesCustBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    		String occupation = JOptionPane.showInputDialog("Write an occupation");
	    }  
	    }); 
		
		stockQuanBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
//		    		ArrayList<Product> products = controller.getProducts();
		    	final ArrayList<JRadioButton> buttons = new ArrayList<JRadioButton>();
		    	final String[] products = {"Latte", "cappuccino", "Milk", "Choklad"};
		    	ButtonGroup bg = new ButtonGroup();
		    		final JFrame frame = new JFrame("Stock quantity time period");
		    		JButton backBtn = new JButton("Back");
		    		JLabel lblSDate = new JLabel("Start date(yyyymmdd");
		    		final JTextField tfSDate = new JTextField();
		    		final JTextField tfEDate = new JTextField();		    		
		    		JLabel lblEDate = new JLabel("End date(yyyymmdd");
		    		JButton checkBtn = new JButton("Check");
		    		frame.setSize(400,300);
		    		frame.setVisible(true);
//		    		frame.add(bg);
		    		frame.setLayout(new GridLayout(10,2));
		    		
		    		for(int i = 0; i < products.length; i++) {
		    			JRadioButton prod = new JRadioButton(products[i]);	
		    			buttons.add(prod);
		    			frame.add(prod);
		    		}
		    		frame.add(lblSDate);
		    		frame.add(tfSDate);
		    		frame.add(lblEDate);
		    		frame.add(tfEDate);		    		
		    		frame.add(checkBtn);
		    		frame.add(backBtn);
		    		
		    		backBtn.addActionListener(new ActionListener(){  
		    		    public void actionPerformed(ActionEvent e){ 
		    	    		frame.setVisible(false);
		    	    }  
		    	    });  
		    		
		    		checkBtn.addActionListener(new ActionListener(){  
		    		    public void actionPerformed(ActionEvent e){ 
		    	    		frame.setVisible(false);
		    	    		checkStock(products, buttons, tfSDate.getText(), tfEDate.getText());
		    	    }  
		    	    });  
		    	
    }  
    }); 
		
		salesProdBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
//		    		ArrayList<Product> products = controller.getProducts();
		    	final ArrayList<JRadioButton> buttons = new ArrayList<JRadioButton>();
		    	final String[] products = {"Latte", "cappuccino", "Milk", "Choklad"};
		    	ButtonGroup bg = new ButtonGroup();
		    		final JFrame frame = new JFrame("Product sales time period");
		    		JButton backBtn = new JButton("Back");
		    		JLabel lblSDate = new JLabel("Start date(yyyymmdd");
		    		final JTextField tfSDate = new JTextField();
		    		final JTextField tfEDate = new JTextField();		    		
		    		JLabel lblEDate = new JLabel("End date(yyyymmdd");
		    		JButton checkBtn = new JButton("Check");
		    		frame.setSize(400,300);
		    		frame.setVisible(true);
//		    		frame.add(bg);
		    		frame.setLayout(new GridLayout(10,2));
		    		
		    		for(int i = 0; i < products.length; i++) {
		    			JRadioButton prod = new JRadioButton(products[i]);	
		    			buttons.add(prod);
		    			frame.add(prod);
		    		}
		    		frame.add(lblSDate);
		    		frame.add(tfSDate);
		    		frame.add(lblEDate);
		    		frame.add(tfEDate);		    		
		    		frame.add(checkBtn);
		    		frame.add(backBtn);
		    		
		    		backBtn.addActionListener(new ActionListener(){  
		    		    public void actionPerformed(ActionEvent e){ 
		    	    		frame.setVisible(false);
		    	    }  
		    	    });  
		    		
		    		checkBtn.addActionListener(new ActionListener(){  
		    		    public void actionPerformed(ActionEvent e){ 
		    	    		frame.setVisible(false);
		    	    		checkProduct(products, buttons, tfSDate.getText(), tfEDate.getText());
		    	    }  
		    	    });  
		    		
	    }  
	    });  
		
		ordersEmpBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
	    		String empID = JOptionPane.showInputDialog("Enter the employee's ID");
	    		
    }  
    }); 
		
		salesTimeBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    		String startDate = JOptionPane.showInputDialog("Enter start date (YYYYMMDD)");
		    		int startYear = Integer.valueOf(startDate.substring(0, 4));
		    		int startYonth = Integer.valueOf(startDate.substring(4, 6));
		    		int startDay = Integer.valueOf(startDate.substring(6, 8));
		    		String endDate = JOptionPane.showInputDialog("Enter end date (YYYMMDD)");
		    		
	    }  
	    });  
		
		reportFrame.setLayout(new GridLayout(8,1));
		reportFrame.add(salesTimeBtn);
		reportFrame.add(salesProdBtn);
		reportFrame.add(salesCustBtn);
		reportFrame.add(stockQuanBtn);
		reportFrame.add(ordersEmpBtn);
		reportFrame.add(emplTimeBtn);
		reportFrame.add(custTimeBtn);
		reportFrame.add(backBtn);
		
		
		reportFrame.setSize(600, 450);
		reportFrame.setVisible(true);
		
		reportFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void checkStock(String[] prod, ArrayList<JRadioButton> b, String sDate, String eDate) {
		String[] products = prod;
		ArrayList<JRadioButton> buttons = b;
		for (int i = 0; i < buttons.size(); i++) {
			if(buttons.get(i).isSelected()) {
				System.out.println("Selected: " + products[i]);
			}
		}
		System.out.println("Start date: " + sDate + " End Date: " + eDate);
	}
	
	private void checkProduct(String[] prod, ArrayList<JRadioButton> b, String sDate, String eDate) {
		String[] products = prod;
		ArrayList<JRadioButton> buttons = b;
		for (int i = 0; i < buttons.size(); i++) {
			if(buttons.get(i).isSelected()) {
				System.out.println("Selected: " + products[i]);
			}
		}
		System.out.println("Start date: " + sDate + " End Date: " + eDate);
	}
	
	private void makeOrder() {
		final JFrame orderFrame = new JFrame("Make an order");
		JButton addBtn = new JButton("Make order");
		final Frame oFrame = new Frame("Order");
		oFrame.setVisible(false);
		JButton backBtn = new JButton("Back");
		JLabel lblId = new JLabel("Order ID:");
		JLabel lblEmpId = new JLabel("Employee ID:");
		JLabel lblLocId = new JLabel("Location ID:");
		JLabel lblMemId = new JLabel("Member ID");
		JButton oBack = new JButton("Done");
		JButton addProdBtn = new JButton("Add products");
		String[] names = new String[100];
//		String[] products = controller.getProducts();
		final ArrayList<Product> products = controller.getProducts();
		final ArrayList<Product> orderedProducts = new ArrayList<Product>();
		for(int i = 0; i < products.size(); i++) {
			names[i] = products.get(i).name;
		}
		final JComboBox cbProducts = new JComboBox(names);
		final JTextArea taProducts = new JTextArea("Products: \n");
		final JTextField tfId = new JTextField();
		final JTextField tfEmpId = new JTextField();
		final JTextField tfLocId = new JTextField();
		final JTextField tfMemId = new JTextField();
	
		orderFrame.dispatchEvent(new WindowEvent(orderFrame, WindowEvent.WINDOW_CLOSING));
		orderFrame.setLocation(dim.width/2-orderFrame.getSize().width/2, dim.height/2-orderFrame.getSize().height/2);
		oFrame.setSize(400, 300);
		oFrame.add(taProducts);
		oFrame.add(oBack, BorderLayout.SOUTH);
		oFrame.add(cbProducts,BorderLayout.NORTH);
		
		
		
		
//		cbProducts.addMouseListener(new MouseAdapter() {
//	        @Override
//	        public void mouseClicked(MouseEvent e) {
//	            System.out.println(cbProducts.getSelectedItem());
//	        }
//	    });
		
		addProdBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	oFrame.setVisible(true);
	    }  
	    });  
		
		oBack.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    		oFrame.setVisible(false);
		    		taProducts.setText("Products: \n");
		    }  
		    });  
		
		cbProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
//                Object selected = comboBox.getSelectedItem().toString();
              
//                taProducts.append(selected + "\n");
                for (int i = 0; i < products.size(); i++) {
                	String selected = comboBox.getSelectedItem().toString();
                	if (selected.equals(products.get(i).name)) {
                		orderedProducts.add(products.get(i));
                		taProducts.append(selected + "\n");
                	}
                }
//                orderedProducts.add((Product) selected);
                
            }
		});
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	ts = new Timestamp(System.currentTimeMillis());
		    		orderFrame.setVisible(false);
		    		System.out.println(ts.toString());
		    		new GUI();
		    		for(int i = 0; i < orderedProducts.size();i++) {
		    			System.out.println(orderedProducts.get(i).name);
		    		}
		    			Order order = new Order(tfId.getText(), tfEmpId.getText(), tfLocId.getText(), tfMemId.getText(), orderedProducts);
		    			controller.addOrder(order);
//	                controller.addOrder( tfId.getText(), tfEmpId.getText(), tfLocId.getText(), tfMemId.getText(), orderedProducts);
		    }  
		    });  
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
	    		orderFrame.setVisible(false);
	    		new GUI();
	    }  
	    });  
		
		orderFrame.setLayout(new GridLayout(8,2));
		orderFrame.add(lblId);
		orderFrame.add(tfId);
		orderFrame.add(lblEmpId);
		orderFrame.add(tfEmpId);
		orderFrame.add(lblLocId);
		orderFrame.add(tfLocId);
		orderFrame.add(lblMemId);
		orderFrame.add(tfMemId);
		orderFrame.add(addProdBtn);
//		locationFrame.add(cbProducts);
//		locationFrame.add(taProducts);
		orderFrame.add(addBtn);
		orderFrame.add(backBtn);
		
		orderFrame.setSize(400, 300);
		orderFrame.setVisible(true);
		orderFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void addIngredient() {
		final JFrame ingredientFrame = new JFrame("Add Ingredient");
		ArrayList<Location> locations = controller.getLocations();
//		String[] loco = {locations.get(0).id};
//		for(int i = 1; i <= locations.size();i++) {
//			loco[i] = locations.get(i).id;
//		}
		
		JComboBox cbLocation = new JComboBox();
		JButton addBtn = new JButton("Add Ingredient");
		JButton backBtn = new JButton("Back");
		JLabel lblName = new JLabel("Ingredient name:");
		JLabel lblPrice = new JLabel("Price:");
		JLabel lblQuantity = new JLabel("Quantity:");
		JLabel lblLocations = new JLabel("Locations");
		final JTextField tfName = new JTextField();
		final JTextField tfPrice = new JTextField();
		final JTextField tfQuan = new JTextField();
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
		
		ingredientFrame.setLayout(new GridLayout(6,2));
		ingredientFrame.add(lblName);
		ingredientFrame.add(tfName);
		ingredientFrame.add(lblPrice);
		ingredientFrame.add(tfPrice);
		ingredientFrame.add(lblQuantity);
		ingredientFrame.add(tfQuan);
		ingredientFrame.add(lblLocations);
		ingredientFrame.add(cbLocation);
		
		ingredientFrame.add(addBtn);
		ingredientFrame.add(backBtn);
		
		ingredientFrame.setSize(400, 300);
		ingredientFrame.setVisible(true);
		ingredientFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		
		
		
	private void makeComment() {
		final JFrame commentFrame = new JFrame("Make Comment");
		JButton addBtn = new JButton("Add Comment");
		JButton backBtn = new JButton("Back");
		JLabel lblId = new JLabel("Employee id:");
		JLabel lblEmployer = new JLabel("Comment by:");
		final JTextField tfId = new JTextField();
		final JTextField tfBy = new JTextField();
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
		    		Controller.addComment(tfBy.getText(), tfId.getText(), text);
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
		commentFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void addEmployer() {
		final JFrame employerFrame = new JFrame("Add Employer");
		JButton addBtn = new JButton("Add Employer");
		JButton backBtn = new JButton("Back");
		JLabel lblFName = new JLabel("First Name:");
		JLabel lblLName = new JLabel("Last Name:");
//		JLabel lblId = new JLabel("Employer ID:");
		final JTextField tfFName = new JTextField();
		final JTextField tfLName = new JTextField();
//		final JTextField tfId = new JTextField();
		employerFrame.dispatchEvent(new WindowEvent(employerFrame, WindowEvent.WINDOW_CLOSING));
		employerFrame.setLocation(dim.width/2-employerFrame.getSize().width/2, dim.height/2-employerFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		Controller.addEmployer(tfFName.getText(), tfLName.getText());
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
//		employerFrame.add(lblId);
//		employerFrame.add(tfId);
		employerFrame.add(addBtn);
		employerFrame.add(backBtn);
		
		employerFrame.setSize(400, 300);
		employerFrame.setVisible(true);
		employerFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void addLocation() {
		final JFrame locationFrame = new JFrame("Add Location");
		JButton addBtn = new JButton("Add Location");
		JButton backBtn = new JButton("Back");
		JLabel lblCountry = new JLabel("Country:");
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblId = new JLabel("Location ID:");
		final JTextField tfCountry = new JTextField();
		final JTextField tfAddress = new JTextField();
		final JTextField tfId = new JTextField();
		locationFrame.dispatchEvent(new WindowEvent(locationFrame, WindowEvent.WINDOW_CLOSING));
		locationFrame.setLocation(dim.width/2-locationFrame.getSize().width/2, dim.height/2-locationFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		Controller.addLocation(tfCountry.getText(), tfAddress.getText());
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
		locationFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	private void addEmployee() {
		final JFrame employeeFrame = new JFrame("Add Employee");
		JButton backBtn = new JButton("Back");
		JButton addBtn = new JButton("Add employee");
		JLabel lblFName = new JLabel("First Name:");
		JLabel lblLName = new JLabel("Last Name:");
		JLabel lblId = new JLabel("Employee ID:");
		JLabel lblLocation = new JLabel("Location ID:");
		final JTextField tfFname = new JTextField();
		final JTextField tfLname = new JTextField();
		final JTextField tfId = new JTextField();
		final JTextField tfLocation = new JTextField();
		employeeFrame.dispatchEvent(new WindowEvent(employeeFrame, WindowEvent.WINDOW_CLOSING));
		employeeFrame.setLocation(dim.width/2-employeeFrame.getSize().width/2, dim.height/2-employeeFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	controller.addEmployee(tfFname.getText(), tfLname.getText(), tfLocation.getText());
		    		System.out.println("Employee added");
		    		employeeFrame.setVisible(false);
		    		new GUI();
		    }  
		    });  
		
		backBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
//		    	Controller.addEmployee(tfFname.getText(), tfLname.getText(), tfLocation.getText());
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
		employeeFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	    final JTextField tfFname = new JTextField();
		final JTextField tfLname = new JTextField();
		final JTextField tfId = new JTextField();
		final JTextField tfAddress = new JTextField();
		final JTextField tfOccupation = new JTextField();
		final JTextField tfSSN = new JTextField();
		memberFrame.dispatchEvent(new WindowEvent(memberFrame, WindowEvent.WINDOW_CLOSING));
		memberFrame.setLocation(dim.width/2-memberFrame.getSize().width/2, dim.height/2-memberFrame.getSize().height/2);
		
		addBtn.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    		System.out.println("Member added");
		    		Controller.addMember(tfFname.getText(), tfLname.getText(), tfAddress.getText(), tfOccupation.getText(), tfSSN.getText());
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
		memberFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		//new StartGUI();
		new GUI();
	}

}
