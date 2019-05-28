package model;

import java.util.ArrayList;

public class Product {
	String id, name;
	double price;
	ArrayList<Ingredient> ingredients;
	
	public Product(String id, String name, double price, ArrayList<Ingredient> ingredients) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.ingredients = ingredients;
	}
}
