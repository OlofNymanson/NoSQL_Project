package model;

import java.util.ArrayList;

public class Product {
	String id, name;
	double price;
	ArrayList<Ingredient> ingredients;
	
	public Product(String id, String name, ArrayList<Ingredient> ingredients) {
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		
		this.price = calculatePrice();
	}
	
	private double calculatePrice() {
		double sum = 0;
		
		if(ingredients != null) {
			for(Ingredient i : ingredients) {
				sum += i.price;
			}
		}else {
			System.out.println("Ingredients is null");
		}
		
		return sum;
	}
}
