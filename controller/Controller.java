package controller;
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
			if(!dbHelper.init()) {
				System.out.println("Fatal error: starting database");
				System.exit(0);
			}
	}
	
	public static void addMember(Member m) {
		dbHelper.addMember(m);
	}
	
	public static void addEmployee(Employee e) {
		dbHelper.addEmployee(e);
	}
	
	public static void addLocation(Location l) {
		dbHelper.addLocation(l);
	}
	
	public static void addEmployer(Employer e) {
		dbHelper.addEmployer(e);
	}
	
	public static void addComment(Comment c) {
		dbHelper.addComment(c);
	}
	
	public static void addIngredient(Ingredient i, Location l) {
		dbHelper.addToStock(l, i);
	}
	
	public static void addOrder(Order o) {
		dbHelper.createOrder(o);
	}
	
}
