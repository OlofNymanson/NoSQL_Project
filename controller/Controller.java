package controller;

import java.time.Instant;
import java.util.ArrayList;

import model.*;


public class Controller {
	public static Database dbHelper = new Database();
	
	public static ArrayList<Product> getProducts() {
		ArrayList<Product> products = dbHelper.getProducts();
		return products;
	}
	
	public static ArrayList<Location> getLocations() {
		ArrayList<Location> locations = dbHelper.getAllLocations();
		return locations;		
	}
	
	public static void addMember(String firstName, String lastName, String address, String occupation, String SSN) {
		Member m = new Member(null, firstName, lastName, address, occupation, SSN);
		dbHelper.addMember(m);
	}
	
	public static void addEmployee(String firstName, String lastName, String location) {
		Employee e = new Employee(null, firstName, lastName, location);
		dbHelper.addEmployee(e);
	}
	
	public static void addLocation(String country, String address) {
		Location l = new Location(null, country, address);
		dbHelper.addLocation(l);
	}
	
	public static void addEmployer(String firstName, String lastName, Location location) {
//		Employer e = new Employer(null, firstName, lastName);
		Employer e = new Employer(firstName, lastName, location);
		dbHelper.addEmployer(e);
	}
	
	public static void addComment(String employer, String employeeFName, String employeeLName, String location, String comment) {
		Employee employee = dbHelper.findEmployee(employeeFName, employeeLName, location);
		
		System.out.println(employee.fName + " " + employee.id);
		
		Comment c = new Comment(employer, employee.id, comment);
		
		dbHelper.addComment(c);
	}
	
	public static void addIngredient(String name, double price, double quantity, Location l) {
		Ingredient i = new Ingredient(name, price, quantity);
		dbHelper.addToStock(l, i);
	}
	
	public static ArrayList<Ingredient> getStock(String locationAddress) {
		Location loc = dbHelper.findLocation(locationAddress);
		return dbHelper.getStock(loc);
	}
	
	public static void addOrder(Order o) {
		dbHelper.createOrder(o);
		for (int i = 0; i < o.products.size();i++) {
			System.out.println("Product " + i + o.products.get(i));
		}
	}
	
//	public static String findEmployee(String fName, String lName, String location) {
//		Employee emp = dbHelper.findEmployee(fName, lName, location);
//		String res = "Fname: " + emp.fName + "\nLname: " + emp.lName + "\n Location ID: " + emp.locationID;
//		return res;
//	}
	
	public static Employee findEmployee(String fName, String lName, String location) {
		Employee emp = dbHelper.findEmployee(fName, lName, location);
		return emp;
	}
	
	public static Location findLocation(String adress) {
		Location loco = dbHelper.findLocation(adress);
		return loco;
	}
	
	public static Employer findEmployer(String id) {
		Employer emp = dbHelper.findEmployer(id);
		return emp;
	}
	
	public static Member findMember(String ssn) {
		Member member = dbHelper.findMember(ssn);
		return member;
	}
	
	public static int salesPerOccupation(String occ, String location) {
		return dbHelper.getNumberOfSalesOccupation(occ, location);
	}
	
	public static void checkProdSales(ArrayList<Product> p, String sDate, String eDate) {
		for (int i = 0; i < p.size(); i++) {
			System.out.println("Product selected: " + p.get(i).name);
		}
		System.out.println(sDate + ", " + eDate);
	}
	
	public static int salesPerSSN(String ssn, String location) {
		int sales = dbHelper.getNumberOfSalesCustomer(ssn, location);
		return sales;
	}
	
	public static ArrayList<Employee> getAllEmployeesInLocation(String location){
		return dbHelper.getAllEmployees(location);
	}
	
	public static void checkStock(Product p, String sDate, String eDate) {
		System.out.println("Product selected: " + p.name + " Start date: " + sDate + " End date: " + eDate);
	}
	
	public static String getItemInLocation(String item, String location) {
		int numOfItem = dbHelper.getStockForItem(item, location);
		return numOfItem + " " + item + " in " + location;
	}
	
	public static ArrayList<Order> getOrdersByEmployeeOverTime(String employeeID, String location, String timeFrom, String timeTo){
		return dbHelper.getOrdersByEmployee(Instant.parse(timeFrom + "T00:00:00.000Z"), Instant.parse(timeTo + "T00:00:00.000Z"), location, employeeID);
	}
}