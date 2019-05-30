package model;

import java.sql.*;
import java.util.ArrayList;

public class Order {
	String id, empID, locID, memID;
	double price;
	Timestamp ts;
	ArrayList<Product> products;
	
	public Order(String id, String empID, String locID, String memID, ArrayList<Product> products) {
		ts = new Timestamp(System.currentTimeMillis());
		this.id = id;
		this.empID = empID;
		this.locID = locID;
		this.memID = memID;
		this.products = products;
		
		this.price = calculatePrice();
	}
	
	public Order(Timestamp ts, String id, String empID, String locID, String memID, ArrayList<Product> products) {
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
