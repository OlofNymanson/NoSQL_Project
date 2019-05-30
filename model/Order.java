package model;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;

public class Order {
	String id, empID, locID, memID, ts;
	double price;
//	Timestamp ts;
	ArrayList<Product> products;
	
	public Order(String id, String empID, String locID, String memID, ArrayList<Product> products) {
//		ts = new Timestamp(System.currentTimeMillis());
		this.id = id;
		this.empID = empID;
		this.locID = locID;
		this.memID = memID;
		this.products = products;
		
		this.price = calculatePrice();
		
		String timeStr = Instant.now().toString();
		
		try {
			Date date = (Date) new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS ZZZ").parse(timeStr);
			ts = date.toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Order(Timestamp ts, String id, String empID, String locID, String memID, ArrayList<Product> products) {
//		this.ts = ts;
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
