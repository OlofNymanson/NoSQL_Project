package model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;

public class Order {
	public String id;
	public String empID;
	public String locID;
	public String memID;
	public double price;
	Instant ts;
	public ArrayList<Product> products;
	
	public Order(String id, String empID, String locID, String memID, ArrayList<Product> products) {
		ts = Instant.now();
		this.id = id;
		this.empID = empID;
		this.locID = locID;
		this.memID = memID;
		this.products = products;
		
		this.price = calculatePrice();
		
	}
	
	public Order(Instant ts, String id, String empID, String locID, String memID, ArrayList<Product> products) {
		this.ts = ts;
		this.id = id;
		this.empID = empID;
		this.locID = locID;
		this.memID = memID;
		this.products = products;
		
		this.price = calculatePrice();
	}
	
	private double calculatePrice() {
		double sum = 0;
		
		for(Product p : products){
			sum += p.price;
		}
		
		return sum;
	}
}
