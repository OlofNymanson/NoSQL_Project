package controller;
import java.util.ArrayList;

import model.Comment;
import model.Database;
import model.Employee;
import model.Employer;
import model.Ingredient;
import model.Location;
import model.Member;
import model.Order;
public class Controller {
	public static Database dbHelper = new Database();
	
	public static void main(String[] args) {
		
	}
	
	public static ArrayList<Location> getLocations() {
		return null; //todo
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
	}
	
}
