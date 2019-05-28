package model;

import java.sql.*;
import java.util.ArrayList;

public class Order {
	String id, empID, locID, memID;
	double price;
	Timestamp ts;
	ArrayList<Product> products;
	
	public Order(String id, String empID, String locID, String memID, double price, ArrayList<Product> products) {
		ts = new Timestamp(System.currentTimeMillis());
		this.id = id;
		this.empID = empID;
		this.locID = locID;
		this.memID = memID;
		this.price = price;
		this.products = products;
	}
	
	

}
