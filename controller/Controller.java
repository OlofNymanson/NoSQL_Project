package controller;
import java.util.ArrayList;

import model.*;


public class Controller {
	public static Database dbHelper = new Database();
	
	public static void main(String[] args) {
		
	}
	
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
		System.out.println("Member added");
	}
	
	public static void addEmployee(String firstName, String lastName, String location) {
		Employee e = new Employee(null, firstName, lastName, location);
		dbHelper.addEmployee(e);
	}
	
	public static void addLocation(String country, String address) {
		Location l = new Location(null, country, address);
		dbHelper.addLocation(l);
	}
	
	public static void addEmployer(String firstName, String lastName) {
		Employer e = new Employer(null, firstName, lastName);
		dbHelper.addEmployer(e);
	}
	
	public static void addComment(String employer, String employee, String comment) {
		Comment c = new Comment(employer, employee, comment);
		dbHelper.addComment(c);
	}
	
	public static void addIngredient(String name, double price, double quantity, Location l) {
		Ingredient i = new Ingredient(name, price, quantity);
		dbHelper.addToStock(l, i);
	}
	
	public static void addOrder(Order o) {
		dbHelper.createOrder(o);
		System.out.println("Order added: id:" + o.id + "empId: "+ o.empID+ "locationID: " + o.locID + "memID: " + o.memID +"price: "+ o.price + "Timestamp: " + o.ts);
		for (int i = 0; i < o.products.size();i++) {
			System.out.println("Product " + i + o.products.get(i));
		}
	}
	
	public static String findEmployee(String fName, String lName, String locAddress) {
		Employee emp = dbHelper.findEmployee(fName, lName, locAddress);
		String res = "Fname: " + emp.fName + "\nLname: " + emp.lName + "\n Location ID: " + emp.locationID;
		return res;
	}
	
	public static String findLocation(String adress) {
		Location loco = dbHelper.findLocation(adress);
		String res = "ID: " + loco.id + "\n Adress: " + loco.address + "\n Country: " + loco.country ;
		return res;
	}
	
	public static Employer findEmployer(String id) {
		Employer emp = dbHelper.findEmployer(id);
		return emp;
	}
	
	public static Member findMember(String ssn) {
		Member member = dbHelper.findMember(ssn);
		return member;
	}
	
}