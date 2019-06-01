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

public class GUI extends JFrame {

	private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private Controller controller = new Controller();
	private Timestamp ts;

	public GUI() {
		final JFrame frame = new JFrame("BEAVERCOFFEE");
		frame.setSize(600, 400);
		frame.setLayout(new GridLayout(0, 1));
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

		// JLabel beaver = new JLabel("BEAVERCOFFEE");
		JButton addMemberBtn = new JButton("Add member");
		JButton employeeBtn = new JButton("Add employee");
		JButton locationBtn = new JButton("Add location");
		JButton addEmployerBtn = new JButton("Add employer");
		JButton findEmployerBtn = new JButton("Find employer");
		JButton findEmployeeBtn = new JButton("Find employee");
		JButton findLocationBtn = new JButton("Find location");
		JButton findMemberBtn = new JButton("Find member");
		JButton addIngredientBtn = new JButton("Add ingredient");
		JButton findStockBtn = new JButton("Find stock");
		JButton commentBtn = new JButton("Make a comment");
		JButton makeOrderBtn = new JButton("Make an order");
		JButton makeReportBtn = new JButton("Create report");

		makeReportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				makeReport();
			}
		});

		makeOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				makeOrder();
			}
		});

		commentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				makeComment();
			}
		});

		findMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Enter a member's SSN");
				Member member = controller.findMember(id);
				String res = "First Name: " + member.fName + "\n Last Name: " + member.lName + "\n Adress: "
						+ member.address + "\n Occupation: " + member.occupation + "\n SSN: " + member.SSN
						+ "\nCoffee Count: " + member.coffeeCount + "\n ID: " + member.id;
				JOptionPane.showMessageDialog(null, res);
			}
		});

		findLocationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adress = JOptionPane.showInputDialog("Enter a location's adress");
				Location loco = controller.findLocation(adress);
				String res = "ID: " + loco.id + "\n Adress: " + loco.address + "\n Country: " + loco.country;
				JOptionPane.showMessageDialog(null, res);
			}
		});

		findEmployeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = JOptionPane.showInputDialog("Enter the employee's fname");
				String lName = JOptionPane.showInputDialog("Enter the employee's lname");
				String loc = JOptionPane.showInputDialog("Enter the location of shop");

				Employee emp = controller.findEmployee(fName, lName, loc);

				String empInfo = new String(
						"First name: " + emp.fName + "\nLast name: " + emp.lName + "\nLocation address: "
								+ emp.locationID + "\nComment: " + emp.comment + "\nEmployee ID: " + emp.id);

				JOptionPane.showMessageDialog(null, empInfo);
			}
		});

		findEmployerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String location = JOptionPane.showInputDialog("Enter a employer's location");
				Employer emp = controller.findEmployer(location);
				String res = "\n First Name: " + emp.fName + "\n Last Name:" + emp.lName + "\nLocation: "
						+ emp.location.address;
				JOptionPane.showMessageDialog(null, res);

			}
		});

		findStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String location = JOptionPane.showInputDialog("Location address");
				ArrayList<Ingredient> stock = controller.getStock(location);
				StringBuilder sb = new StringBuilder();

				for (Ingredient i : stock) {
					sb.append(i.name + ": " + i.quantity + "\n");
				}

				String fullStock = location + ": \n" + sb.toString();

				JOptionPane.showMessageDialog(null, fullStock);
			}
		});

		employeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addEmployee();
			}
		});

		addEmployerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addEmployer();
			}
		});

		addMemberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addMember();
			}
		});

		locationBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addLocation();
			}
		});

		addIngredientBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addIngredient();
			}
		});

		// frame.add(beaver);
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
		frame.add(findStockBtn);
		frame.add(commentBtn);
		frame.add(makeReportBtn);
		frame.setVisible(true);
		// frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// väntar med punkt 2 & 4
	private void makeReport() {
		final JFrame reportFrame = new JFrame("Make a report");
		JButton backBtn = new JButton("Back");
		JButton salesTimeBtn = new JButton("Sales for specific time period");
		JButton salesProdBtn = new JButton("Sales for a product over a time period");
		JButton salesCustSSN = new JButton("Sales per member by SSN");
		JButton salesCustBtn = new JButton("Sales per member by occupation");
		JButton stockQuanBtn = new JButton("Stock quantities");
		JButton ordersEmpBtn = new JButton("Orders by a employee over time");
		JButton emplAtLocation = new JButton("All employees in location");
		JButton custTimeBtn = new JButton("Customers listing over time");
		JLabel hahaa = new JLabel("Products");
		// final ButtonGroup bg = new ButtonGroup();

		reportFrame.dispatchEvent(new WindowEvent(reportFrame, WindowEvent.WINDOW_CLOSING));
		reportFrame.setLocation(dim.width / 2 - reportFrame.getSize().width / 2,
				dim.height / 2 - reportFrame.getSize().height / 2);

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportFrame.setVisible(false);
				new GUI();
			}
		});

		salesCustSSN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SSN = JOptionPane.showInputDialog("Enter a member's SSN");
				String location = JOptionPane.showInputDialog("At specific location (optional");
				int sales = controller.salesPerSSN(SSN, location);
				JOptionPane.showMessageDialog(null, "Member " + SSN + " Has done " + sales + " purchases");
			}
		});

		salesCustBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String occupation = JOptionPane.showInputDialog("Enter a member's occupation");
				String location = JOptionPane.showInputDialog("At specific location (optional");
				int sales = controller.salesPerOccupation(occupation, location);
				JOptionPane.showMessageDialog(null,
						"Members with " + occupation + " as occupation has done " + sales + " purchases");
			}
		});

		stockQuanBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = JOptionPane.showInputDialog(null, "Item");
				String location = JOptionPane.showInputDialog(null, "Location");
				JOptionPane.showMessageDialog(null, controller.getItemInLocation(item, location));
			}
		});

		salesProdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String product = JOptionPane.showInputDialog("Product");
				String location = JOptionPane.showInputDialog("Enter Location (optional)");
				String strFrom = JOptionPane.showInputDialog("Date from (YYYY-MM-DD)");
				String strTo = JOptionPane.showInputDialog("Date to (YYYY-MM-DD)");
				String message = product + " has been sold " + controller.checkProdSales(product, location, strFrom, strTo) + " times between during the time period";
				JOptionPane.showMessageDialog(null, message);
			}
		});

		ordersEmpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String empID = JOptionPane.showInputDialog("Enter the employee's ID");
				String location = JOptionPane.showInputDialog("Enter Location");
				String strFrom = JOptionPane.showInputDialog("Date from (YYYY-MM-DD)");
				String strTo = JOptionPane.showInputDialog("Date to (YYYY-MM-DD)");
				
				ArrayList<Order> orders = controller.getOrdersByEmployeeOverTime(empID, location, strFrom, strTo);
				
				StringBuilder sb = new StringBuilder();
				sb.append("Orders:\n");
				
				for(Order o : orders) {
					sb.append("Order at " + o.locID + ", Cost: " + o.price + "\n");
				}
				
				JOptionPane.showMessageDialog(null, sb.toString());
			}
		});

		salesTimeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strFrom = JOptionPane.showInputDialog("Date from (YYYY-MM-DD)");
				String strTo = JOptionPane.showInputDialog("Date to (YYYY-MM-DD)");
				String location = JOptionPane.showInputDialog("Location");
				
				ArrayList<Order> orders = controller.getOrdersTimePeriod(strFrom, strTo, location);
				
				StringBuilder sb = new StringBuilder();
				sb.append("Orders:\n");
				
				for(Order o : orders) {
					sb.append("Order at " + o.locID + ", Cost: " + o.price + "\n");
				}
				
				JOptionPane.showMessageDialog(null, sb.toString());
			}
		});

		emplAtLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String location = JOptionPane.showInputDialog(null, "Location:");
				ArrayList<Employee> emps = controller.getAllEmployeesInLocation(location);
				StringBuilder sb = new StringBuilder();

				if (emps.size() < 1) {
					sb.append("No employees in " + location);
				} else {
					sb.append("Employees in " + location + ":\n");

					for (Employee emp : emps) {
						sb.append(emp.fName + " " + emp.lName + "\n");
					}

					JOptionPane.showMessageDialog(null, sb.toString());
				}
			}
		});

		reportFrame.setLayout(new GridLayout(8, 1));
		reportFrame.add(salesTimeBtn);
		reportFrame.add(salesProdBtn);
		reportFrame.add(salesCustSSN);
		reportFrame.add(salesCustBtn);
		reportFrame.add(stockQuanBtn);
		reportFrame.add(ordersEmpBtn);
		reportFrame.add(emplAtLocation);
		reportFrame.add(custTimeBtn);
		reportFrame.add(backBtn);

		reportFrame.setSize(600, 450);
		reportFrame.setVisible(true);

		reportFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

//	private void checkProdSales(ArrayList<Product> prod, ArrayList<JRadioButton> b, String sDate, String eDate) {
//		ArrayList<JRadioButton> buttons = b;
//		ArrayList<Product> products = new ArrayList<Product>();
//		for (int i = 0; i < buttons.size(); i++) {
//			if (buttons.get(i).isSelected()) {
//				products.add(prod.get(i));
//
//			}
//		}
//		controller.checkProdSales(products, sDate, eDate);
//	}

	// private String checkStock(ArrayList<Product> prod, ArrayList<JRadioButton> b,
	// String location) {
	// ArrayList<JRadioButton> buttons = b;
	// for (int i = 0; i < buttons.size(); i++) {
	// if (buttons.get(i).isSelected()) {
	// Product p = prod.get(i);
	//// controller.checkStock(p, sDate, eDate);
	//
	// break;
	// }
	// }
	// }

	private void checkProduct(String[] prod, ArrayList<JRadioButton> b, String sDate, String eDate) {
		String[] products = prod;
		ArrayList<JRadioButton> buttons = b;
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).isSelected()) {
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
		JLabel lblEmpId = new JLabel("Employee Full Name:");
		JLabel lblLocId = new JLabel("Location Address:");
		JLabel lblMemId = new JLabel("Member SSN");
		JButton oBack = new JButton("Done");
		JButton addProdBtn = new JButton("Add products");
		String[] names = new String[100];
		final ArrayList<Product> products = controller.getProducts();
		final ArrayList<Product> orderedProducts = new ArrayList<Product>();
		for (int i = 0; i < products.size(); i++) {
			names[i] = products.get(i).name;
		}
		final JComboBox cbProducts = new JComboBox(names);
		final JTextArea taProducts = new JTextArea("Products: \n");
		final JTextField tfEmpId = new JTextField();
		final JTextField tfLocId = new JTextField();
		final JTextField tfMemId = new JTextField();

		orderFrame.dispatchEvent(new WindowEvent(orderFrame, WindowEvent.WINDOW_CLOSING));
		orderFrame.setLocation(dim.width / 2 - orderFrame.getSize().width / 2,
				dim.height / 2 - orderFrame.getSize().height / 2);
		oFrame.setSize(400, 300);
		oFrame.add(taProducts);
		oFrame.add(oBack, BorderLayout.SOUTH);
		oFrame.add(cbProducts, BorderLayout.NORTH);

		addProdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oFrame.setVisible(true);
			}
		});

		oBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oFrame.setVisible(false);
				taProducts.setText("Products: \n");
			}
		});

		cbProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JComboBox comboBox = (JComboBox) event.getSource();

				for (int i = 0; i < products.size(); i++) {
					String selected = comboBox.getSelectedItem().toString();
					if (selected.equals(products.get(i).name)) {
						orderedProducts.add(products.get(i));
						taProducts.append(selected + "\n");
					}
				}
			}
		});

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ts = new Timestamp(System.currentTimeMillis());
				orderFrame.setVisible(false);
				System.out.println(ts.toString());
				new GUI();
				for (int i = 0; i < orderedProducts.size(); i++) {
					System.out.println(orderedProducts.get(i).name);
				}

				String[] fullName = tfEmpId.getText().split(" ");

				Employee emp = controller.findEmployee(fullName[0], fullName[1], tfLocId.getText());

				Order order = new Order(null, emp.id, tfLocId.getText(), tfMemId.getText(), orderedProducts);

				controller.addOrder(order);

			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderFrame.setVisible(false);
				new GUI();
			}
		});

		orderFrame.setLayout(new GridLayout(8, 2));
		// orderFrame.add(lblId);
		// orderFrame.add(tfId);
		orderFrame.add(lblEmpId);
		orderFrame.add(tfEmpId);
		orderFrame.add(lblLocId);
		orderFrame.add(tfLocId);
		orderFrame.add(lblMemId);
		orderFrame.add(tfMemId);
		orderFrame.add(addProdBtn);
		// locationFrame.add(cbProducts);
		// locationFrame.add(taProducts);
		orderFrame.add(addBtn);
		orderFrame.add(backBtn);

		orderFrame.setSize(400, 300);
		orderFrame.setVisible(true);
		orderFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void addIngredient() {
		final JFrame ingredientFrame = new JFrame("Add Ingredient");
		final ArrayList<Location> locations = controller.getLocations();
		String[] loco = new String[locations.size()];
		for (int i = 0; i < locations.size(); i++) {
			loco[i] = locations.get(i).address;
			System.out.println(locations.get(i).address);
			// System.out.println(locations.get(i).country);
		}

		final JComboBox cbLocation = new JComboBox(loco);
		JButton addBtn = new JButton("Add Ingredient");
		JButton backBtn = new JButton("Back");
		JLabel lblName = new JLabel("Ingredient name:");
		JLabel lblPrice = new JLabel("Price:");
		JLabel lblQuantity = new JLabel("Quantity:");
		JLabel lblLocations = new JLabel("Location");
		final JTextField tfName = new JTextField();
		final JTextField tfPrice = new JTextField();
		final JTextField tfQuan = new JTextField();
		ingredientFrame.dispatchEvent(new WindowEvent(ingredientFrame, WindowEvent.WINDOW_CLOSING));
		ingredientFrame.setLocation(dim.width / 2 - ingredientFrame.getSize().width / 2,
				dim.height / 2 - ingredientFrame.getSize().height / 2);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String country = cbLocation.getSelectedItem().toString();
				Location location = new Location("", "", "");
				for (int i = 0; i < locations.size(); i++) {
					if (country == locations.get(i).address) {
						location = locations.get(i);
					}
				}
				// add to db
				controller.addIngredient(tfName.getText(), Double.valueOf(tfPrice.getText()),
						Double.valueOf(tfQuan.getText()), location);
				ingredientFrame.setVisible(false);
				new GUI();
			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingredientFrame.setVisible(false);
				new GUI();
			}
		});

		ingredientFrame.setLayout(new GridLayout(6, 2));
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
		JLabel lblEmpName = new JLabel("Employee full name: ");
		JLabel lblEmployer = new JLabel("Comment by:");
		JLabel lblLocation = new JLabel("Shop location");
		final JTextField employeeName = new JTextField();
		final JTextField tfBy = new JTextField();
		final JTextField tfLocation = new JTextField();
		final JTextArea comment = new JTextArea("Comment here");
		commentFrame.dispatchEvent(new WindowEvent(commentFrame, WindowEvent.WINDOW_CLOSING));
		commentFrame.setLocation(dim.width / 2 - commentFrame.getSize().width / 2,
				dim.height / 2 - commentFrame.getSize().height / 2);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = comment.getText();
				if (text.length() > 300) {
					JOptionPane.showMessageDialog(null, "Comment cannot be longer than 300 chars");
				} else {
					String[] fullName = employeeName.getText().split(" ");

					controller.addComment(tfBy.getText(), fullName[0], fullName[1], tfLocation.getText(),
							comment.getText());

					commentFrame.setVisible(false);
					new GUI();
				}
			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commentFrame.setVisible(false);
				new GUI();
			}
		});

		commentFrame.setLayout(new GridLayout(6, 2));
		commentFrame.add(lblEmpName);
		commentFrame.add(employeeName);
		commentFrame.add(lblLocation);
		commentFrame.add(tfLocation);
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
		JLabel lblLocation = new JLabel("Employer Location:");
		final JTextField tfFName = new JTextField();
		final JTextField tfLName = new JTextField();
		final JTextField tfLocation = new JTextField();
		employerFrame.dispatchEvent(new WindowEvent(employerFrame, WindowEvent.WINDOW_CLOSING));
		employerFrame.setLocation(dim.width / 2 - employerFrame.getSize().width / 2,
				dim.height / 2 - employerFrame.getSize().height / 2);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Controller.addEmployer(tfFName.getText(), tfLName.getText());
				controller.addEmployer(tfFName.getText(), tfLName.getText(),
						Controller.findLocation(tfLocation.getText()));
				employerFrame.setVisible(false);
				new GUI();
			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employerFrame.setVisible(false);
				new GUI();
			}
		});

		employerFrame.setLayout(new GridLayout(4, 2));
		employerFrame.add(lblFName);
		employerFrame.add(tfFName);
		employerFrame.add(lblLName);
		employerFrame.add(tfLName);
		employerFrame.add(lblLocation);
		employerFrame.add(tfLocation);
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
		final JTextField tfCountry = new JTextField();
		final JTextField tfAddress = new JTextField();
		locationFrame.dispatchEvent(new WindowEvent(locationFrame, WindowEvent.WINDOW_CLOSING));
		locationFrame.setLocation(dim.width / 2 - locationFrame.getSize().width / 2,
				dim.height / 2 - locationFrame.getSize().height / 2);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controller.addLocation(tfCountry.getText(), tfAddress.getText());
				locationFrame.setVisible(false);
				new GUI();
			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locationFrame.setVisible(false);
				new GUI();
			}
		});

		locationFrame.setLayout(new GridLayout(4, 2));
		locationFrame.add(lblCountry);
		locationFrame.add(tfCountry);
		locationFrame.add(lblAddress);
		locationFrame.add(tfAddress);
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
		JLabel lblLocation = new JLabel("Location Address:");
		final JTextField tfFname = new JTextField();
		final JTextField tfLname = new JTextField();
		final JTextField tfLocation = new JTextField();
		employeeFrame.dispatchEvent(new WindowEvent(employeeFrame, WindowEvent.WINDOW_CLOSING));
		employeeFrame.setLocation(dim.width / 2 - employeeFrame.getSize().width / 2,
				dim.height / 2 - employeeFrame.getSize().height / 2);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.addEmployee(tfFname.getText(), tfLname.getText(), tfLocation.getText());
				employeeFrame.setVisible(false);
				new GUI();
			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeFrame.setVisible(false);
				new GUI();
			}
		});

		employeeFrame.setLayout(new GridLayout(6, 2));
		employeeFrame.add(lblFName);
		employeeFrame.add(tfFname);
		employeeFrame.add(lblLName);
		employeeFrame.add(tfLname);
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
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblOccupation = new JLabel("Occupation:");
		JLabel lblSSN = new JLabel("SSN:");
		final JTextField tfFname = new JTextField();
		final JTextField tfLname = new JTextField();
		final JTextField tfAddress = new JTextField();
		final JTextField tfOccupation = new JTextField();
		final JTextField tfSSN = new JTextField();
		memberFrame.dispatchEvent(new WindowEvent(memberFrame, WindowEvent.WINDOW_CLOSING));
		memberFrame.setLocation(dim.width / 2 - memberFrame.getSize().width / 2,
				dim.height / 2 - memberFrame.getSize().height / 2);

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Member added");
				Controller.addMember(tfFname.getText(), tfLname.getText(), tfAddress.getText(), tfOccupation.getText(),
						tfSSN.getText());
				memberFrame.setVisible(false);
				new GUI();
			}
		});

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memberFrame.setVisible(false);
				new GUI();
			}
		});

		memberFrame.setLayout(new GridLayout(8, 2));
		memberFrame.add(lblFName);
		memberFrame.add(tfFname);
		memberFrame.add(lblLName);
		memberFrame.add(tfLname);
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
		// new StartGUI();
		new GUI();
	}

}
