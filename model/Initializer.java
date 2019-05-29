package model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class Initializer {
	private DB database;
	
	public Initializer(DB database) {
		this.database = database;
	}
	
	public void initProducts() {		
		DBCollection collection = database.getCollection("Products");

		{
		BasicDBObject espressoRoast = new BasicDBObject("Espresso roast",
				new BasicDBObject("price", 15).append("quantity", 33));
		BasicDBObject wholeBeanFrenchRoast = new BasicDBObject("Whole Bean French Roast",
				new BasicDBObject("price", 12).append("quantity", 123));
		BasicDBObject wholeBeanLigtRoast = new BasicDBObject("Whole Bean Light Roast",
				new BasicDBObject("price", 10).append("quantity", 156));
		
		BasicDBObject[] ingredients = {espressoRoast, wholeBeanFrenchRoast, wholeBeanLigtRoast};
		collection.insert(new BasicDBObject("name", "Whole bean coffee").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {coffeeBeans};
			collection.insert(new BasicDBObject("name", "Brewed Coffee").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {coffeeBeans};
			collection.insert(new BasicDBObject("name", "Espresso").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject steamedMilk = new BasicDBObject("Steamed Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {coffeeBeans, steamedMilk};
			collection.insert(new BasicDBObject("name", "Latte Steamed").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject soyMilk = new BasicDBObject("Soy Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {coffeeBeans, soyMilk};
			collection.insert(new BasicDBObject("name", "Latte Soy").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject wholeMilk = new BasicDBObject("Whole Milk",
					new BasicDBObject("price", 40).append("quantity", 22));
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {wholeMilk, coffeeBeans};
			collection.insert(new BasicDBObject("name", "Latte Whole").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject twoPercentMilk = new BasicDBObject("2% Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {twoPercentMilk, coffeeBeans};
			collection.insert(new BasicDBObject("name", "Latte 2%").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject steamedMilk = new BasicDBObject("Steamed Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {coffeeBeans, steamedMilk};
			collection.insert(new BasicDBObject("name", "Capuccino Steamed").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			BasicDBObject soyMilk = new BasicDBObject("Soy Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			
			BasicDBObject[] ingredients = {coffeeBeans, soyMilk};
			collection.insert(new BasicDBObject("name", "Capuccino Soy").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			BasicDBObject wholeMilk = new BasicDBObject("Whole Milk",
					new BasicDBObject("price", 40).append("quantity", 22));
			
			BasicDBObject[] ingredients = {coffeeBeans, wholeMilk};
			collection.insert(new BasicDBObject("name", "Capuccino Whole").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject twoPercentMilk = new BasicDBObject("2% Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			BasicDBObject coffeeBeans = new BasicDBObject("Coffee Beans",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {coffeeBeans, twoPercentMilk};
			collection.insert(new BasicDBObject("name", "Capuccino 2%").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject WholeMilk = new BasicDBObject("Whole Milk",
					new BasicDBObject("price", 40).append("quantity", 22));
			BasicDBObject CacaoMix = new BasicDBObject("Cocoa Mix",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {WholeMilk, CacaoMix};
			collection.insert(new BasicDBObject("name", "Hot Chocolate Whole").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject SteamedMilk = new BasicDBObject("Steamed Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			BasicDBObject CacaoMix = new BasicDBObject("Cocoa Mix",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {SteamedMilk, CacaoMix};
			collection.insert(new BasicDBObject("name", "Hot Chocolate Steamed").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject SoyMilk = new BasicDBObject("Soy Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			BasicDBObject CacaoMix = new BasicDBObject("Cocoa Mix",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {SoyMilk, CacaoMix};
			collection.insert(new BasicDBObject("name", "Hot Chocolate Soy").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject twoPercentMilk = new BasicDBObject("2% Milk",
					new BasicDBObject("price", 40).append("quantity", 20));
			BasicDBObject CacaoMix = new BasicDBObject("Cocoa Mix",
					new BasicDBObject("price", 8).append("quantity", 10));
			
			BasicDBObject[] ingredients = {twoPercentMilk, CacaoMix};
			collection.insert(new BasicDBObject("name", "Hot Chocolate 2%").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject cream = new BasicDBObject("Cream",
					new BasicDBObject("price", 55).append("quantity", 11));
			
			BasicDBObject[] ingredients = {cream};
			collection.insert(new BasicDBObject("name", "Whipped Cream").append("ingredients", ingredients));
		}
		
		{			
			BasicDBObject vanilla = new BasicDBObject("Vanilla",
					new BasicDBObject("price", 10).append("quantity", 11));
			
			BasicDBObject[] ingredients = {vanilla};
			collection.insert(new BasicDBObject("name", "Vanilla Flavour").append("ingredients", ingredients));
		}
		
		{	
			BasicDBObject cream = new BasicDBObject("Cream",
				new BasicDBObject("price", 55).append("quantity", 12));
		
			BasicDBObject[] ingredients = {cream};
			collection.insert(new BasicDBObject("name", "Irish Cream").append("ingredients", ingredients));
		}
	}
	
	public void initLocationsAndStock() {
		DBCollection collection = database.getCollection("Location");
		
		BasicDBObject i2 = new BasicDBObject("Espresso roast",
				new BasicDBObject("price", 15).append("quantity", 1000));
		BasicDBObject i3 = new BasicDBObject("Whole Bean French Roast",
				new BasicDBObject("price", 12).append("quantity", 1000));
		BasicDBObject i4 = new BasicDBObject("Whole Bean Light Roast",
				new BasicDBObject("price", 10).append("quantity", 1000));
		BasicDBObject i5 = new BasicDBObject("Coffee Beans",
				new BasicDBObject("price", 5).append("quantity", 1000));
		BasicDBObject i6 = new BasicDBObject("Cocoa Mix",
				new BasicDBObject("price", 8).append("quantity", 1000));
		BasicDBObject i7 = new BasicDBObject("Steamed Milk",
				new BasicDBObject("price", 4).append("quantity", 1000));
		BasicDBObject i8 = new BasicDBObject("Soy Milk",
				new BasicDBObject("price", 1).append("quantity", 1000));
		BasicDBObject i9 = new BasicDBObject("2% Milk",
				new BasicDBObject("price", 1).append("quantity", 1000));
		BasicDBObject i10 = new BasicDBObject("Whole Milk",
				new BasicDBObject("price", 40).append("quantity", 1000));
		BasicDBObject i11 = new BasicDBObject("Vanilla",
				new BasicDBObject("price", 10).append("quantity", 1000));
		BasicDBObject i12 = new BasicDBObject("Cream",
				new BasicDBObject("price", 55).append("quantity", 1000));
		BasicDBObject i13 = new BasicDBObject("Caramel",
				new BasicDBObject("price", 105).append("quantity", 1000));

		BasicDBObject[] stock = {i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13};
		
		collection.insert(new BasicDBObject("address", "Malmö").append("country", "Sweden").append("stock", stock));

		collection.insert(new BasicDBObject("address", "Stockholm").append("country", "Sweden").append("stock", stock));

		collection.insert(new BasicDBObject("address", "London").append("country", "Great Britain").append("stock", stock));

		collection.insert(new BasicDBObject("address", "Örebro").append("country", "Sweden").append("stock", stock));

		collection.insert(new BasicDBObject("address", "Amsterdam").append("country", "Netherlands").append("stock", stock));

		collection.insert(new BasicDBObject("address", "Pisa").append("country", "Italy").append("stock", stock));
	}
	
	public void initEmployees() {
		DBCollection collection = database.getCollection("Employee");
		
		collection.insert(new BasicDBObject("fName", "Oscar").append("lName", "Ågren").append("location", "London"));
		collection.insert(new BasicDBObject("fName", "Göran").append("lName", "Åkesson").append("location", "Malmö"));
		collection.insert(new BasicDBObject("fName", "Nils").append("lName", "Malmgren").append("location", "Malmö"));
		collection.insert(new BasicDBObject("fName", "Max").append("lName", "Hermansson").append("location", "Amsterdam"));
		collection.insert(new BasicDBObject("fName", "Jonatan").append("lName", "Viro").append("location", "Örebro"));
		collection.insert(new BasicDBObject("fName", "Olof").append("lName", "Nymanson").append("location", "Pisa"));
		collection.insert(new BasicDBObject("fName", "Börje").append("lName", "Salming").append("location", "Stockholm"));
		collection.insert(new BasicDBObject("fName", "Sid").append("lName", "Sidung").append("location", "Stockholm"));
		collection.insert(new BasicDBObject("fName", "Thomas").append("lName", "Turin").append("location", "Amsterdam"));
		collection.insert(new BasicDBObject("fName", "James").append("lName", "Grenblom").append("location", "London"));
		collection.insert(new BasicDBObject("fName", "Gustav").append("lName", "von Flemming").append("location", "London"))	;

	}
	
	public void initMembers() {
		DBCollection collection = database.getCollection("Member");
		
		collection.insert(new BasicDBObject("fName", "Oscar").append("lName", "Ågren").append("address", "London").append("SSN", "19930909").append("Ocupation", "Systemutvecklare"));
		collection.insert(new BasicDBObject("fName", "Göran").append("lName", "Åkesson").append("address", "Malmö").append("SSN", "19931009").append("Ocupation", "Systemutvecklare"));
		collection.insert(new BasicDBObject("fName", "Nils").append("lName", "Malmgren").append("address", "Malmö").append("SSN", "19940909").append("Ocupation", "Systemutvecklare"));
		collection.insert(new BasicDBObject("fName", "Max").append("lName", "Hermansson").append("address", "Amsterdam").append("SSN", "19900129").append("Ocupation", "Snickare"));
		collection.insert(new BasicDBObject("fName", "Jonatan").append("lName", "Viro").append("address", "Örebro").append("SSN", "19911231").append("Ocupation", "Systemutvecklare"));
		collection.insert(new BasicDBObject("fName", "Olof").append("lName", "Nymanson").append("address", "Pisa").append("SSN", "19991212").append("Ocupation", "Systemutvecklare"));
		collection.insert(new BasicDBObject("fName", "Börje").append("lName", "Salming").append("address", "Stockholm").append("SSN", "19950909").append("Ocupation", "Barista"));
		collection.insert(new BasicDBObject("fName", "Sid").append("lName", "Sidung").append("address", "Stockholm").append("SSN", "19920909").append("Ocupation", "Systemutvecklare"));
		collection.insert(new BasicDBObject("fName", "Thomas").append("lName", "Turin").append("address", "Amsterdam").append("SSN", "19910109").append("Ocupation", "DJ"));
		collection.insert(new BasicDBObject("fName", "James").append("lName", "Grenblom").append("address", "London").append("SSN", "19940901").append("Ocupation", "Systemutvecklare"));
		collection.insert(new BasicDBObject("fName", "Gustav").append("lName", "von Flemming").append("address", "London").append("SSN", "19980901").append("Ocupation", "Operasångare"));

	}
}
