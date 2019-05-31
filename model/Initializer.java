package model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class Initializer {
	private DB database;
	
	BasicDBObject coffeeBeans = new BasicDBObject("name","Coffee Beans").append("price", 8).append("quantity", 10);
	BasicDBObject espressoRoast = new BasicDBObject("name", "Espresso roast").append("price", 15).append("quantity", 33);
	BasicDBObject wholeBeanFrenchRoast = new BasicDBObject("name", "Whole Bean French Roast").append("price", 15).append("quantity", 33);
	BasicDBObject wholeBeanLigtRoast = new BasicDBObject("name", "Whole Bean Light Roast").append("price", 10).append("quantity", 156);
	BasicDBObject soyMilk = new BasicDBObject("name", "Soy Milk").append("price", 40).append("quantity", 20);
	BasicDBObject wholeMilk = new BasicDBObject("name","Whole Milk").append("price", 40).append("quantity", 22);
	BasicDBObject twoPercentMilk = new BasicDBObject("name","2% Milk").append("price", 40).append("quantity", 20);
	BasicDBObject steamedMilk = new BasicDBObject("name","Steamed Milk").append("price", 40).append("quantity", 20);
	BasicDBObject cacaoMix = new BasicDBObject("name","Cocoa Mix").append("price", 8).append("quantity", 10);
	BasicDBObject cream = new BasicDBObject("name", "Cream").append("price", 55).append("quantity", 11);
	BasicDBObject vanilla = new BasicDBObject("name","Vanilla").append("price", 10).append("quantity", 11);
	
	public Initializer(DB database) {
		this.database = database;
	}
	
	public void initProducts() {		
		DBCollection collection = database.getCollection("Products");

		{
		
		BasicDBObject[] ingredients = {espressoRoast, wholeBeanFrenchRoast, wholeBeanLigtRoast};
		collection.insert(new BasicDBObject("name", "Whole bean coffee").append("ingredients", ingredients));

		}
		
		{
			
			BasicDBObject[] ingredients = {coffeeBeans};
			collection.insert(new BasicDBObject("name", "Brewed Coffee").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {coffeeBeans};
			collection.insert(new BasicDBObject("name", "Espresso").append("ingredients", ingredients));
		}
		
		{
			
			
			BasicDBObject[] ingredients = {coffeeBeans, steamedMilk};
			collection.insert(new BasicDBObject("name", "Latte Steamed").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject[] ingredients = {coffeeBeans, soyMilk};
			collection.insert(new BasicDBObject("name", "Latte Soy").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {wholeMilk, coffeeBeans};
			collection.insert(new BasicDBObject("name", "Latte Whole").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {twoPercentMilk, coffeeBeans};
			collection.insert(new BasicDBObject("name", "Latte 2%").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {coffeeBeans, steamedMilk};
			collection.insert(new BasicDBObject("name", "Capuccino Steamed").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {coffeeBeans, soyMilk};
			collection.insert(new BasicDBObject("name", "Capuccino Soy").append("ingredients", ingredients));
		}
		
		{
			BasicDBObject[] ingredients = {coffeeBeans, wholeMilk};
			collection.insert(new BasicDBObject("name", "Capuccino Whole").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {coffeeBeans, twoPercentMilk};
			collection.insert(new BasicDBObject("name", "Capuccino 2%").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {wholeMilk, cacaoMix};
			collection.insert(new BasicDBObject("name", "Hot Chocolate Whole").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {steamedMilk, cacaoMix};
			collection.insert(new BasicDBObject("name", "Hot Chocolate Steamed").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {soyMilk, cacaoMix};
			collection.insert(new BasicDBObject("name", "Hot Chocolate Soy").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {twoPercentMilk, cacaoMix};
			collection.insert(new BasicDBObject("name", "Hot Chocolate 2%").append("ingredients", ingredients));
		}
		
		{
			
			BasicDBObject[] ingredients = {cream};
			collection.insert(new BasicDBObject("name", "Whipped Cream").append("ingredients", ingredients));
		}
		
		{			
			
			BasicDBObject[] ingredients = {vanilla};
			collection.insert(new BasicDBObject("name", "Vanilla Flavour").append("ingredients", ingredients));
		}
		
		{	
			BasicDBObject[] ingredients = {cream};
			collection.insert(new BasicDBObject("name", "Irish Cream").append("ingredients", ingredients));
		}
	}
	
	public void initLocationsAndStock() {
		DBCollection collection = database.getCollection("Location");
		
		BasicDBObject i2 = new BasicDBObject("name","Espresso roast").append("price", 15).append("quantity", 1000);
		
		BasicDBObject i3 = new BasicDBObject("name","Whole Bean French Roast").append("price", 12).append("quantity", 1000);
		
		BasicDBObject i4 = new BasicDBObject("name","Whole Bean Light Roast").append("price", 10).append("quantity", 1000);
		
		BasicDBObject i5 = new BasicDBObject("name","Coffee Beans").append("price", 5).append("quantity", 1000);
		
		BasicDBObject i6 = new BasicDBObject("name","Cocoa Mix").append("price", 8).append("quantity", 1000);
		
		BasicDBObject i7 = new BasicDBObject("name","Steamed Milk").append("price", 4).append("quantity", 1000);
		
		BasicDBObject i8 = new BasicDBObject("name","Soy Milk").append("price", 1).append("quantity", 1000);
		
		BasicDBObject i9 = new BasicDBObject("name","2% Milk").append("price", 1).append("quantity", 1000);
		
		BasicDBObject i10 = new BasicDBObject("name","Whole Milk").append("price", 40).append("quantity", 1000);
		
		BasicDBObject i11 = new BasicDBObject("name","Vanilla").append("price", 10).append("quantity", 1000);
		
		BasicDBObject i12 = new BasicDBObject("name","Cream").append("price", 55).append("quantity", 1000);
		
		BasicDBObject i13 = new BasicDBObject("name","Caramel").append("price", 105).append("quantity", 1000);

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
		collection.insert(new BasicDBObject("fName", "Jakup").append("lName", "Guven").append("location", "London"));
		collection.insert(new BasicDBObject("fName", "Börje").append("lName", "Salming").append("location", "Stockholm"));
		collection.insert(new BasicDBObject("fName", "Sid").append("lName", "Sidung").append("location", "Stockholm"));
		collection.insert(new BasicDBObject("fName", "Thomas").append("lName", "Turin").append("location", "Amsterdam"));
		collection.insert(new BasicDBObject("fName", "James").append("lName", "Grenblom").append("location", "London"));
		collection.insert(new BasicDBObject("fName", "Gustav").append("lName", "von Flemming").append("location", "London"))	;

	}
	
	public void initMembers() {
		DBCollection collection = database.getCollection("Member");
		
		collection.insert(new BasicDBObject("fName", "Oscar").append("lName", "Ågren").append("address", "London").append("SSN", "19930909").append("occupation", "Systemutvecklare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Göran").append("lName", "Åkesson").append("address", "Malmö").append("SSN", "19931009").append("occupation", "Systemutvecklare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Nils").append("lName", "Malmgren").append("address", "Malmö").append("SSN", "19940909").append("occupation", "Systemutvecklare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Max").append("lName", "Hermansson").append("address", "Amsterdam").append("SSN", "19900129").append("occupation", "Snickare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Jonatan").append("lName", "Viro").append("address", "Örebro").append("SSN", "19911231").append("occupation", "Systemutvecklare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Olof").append("lName", "Nymanson").append("address", "Pisa").append("SSN", "19991212").append("occupation", "Systemutvecklare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Börje").append("lName", "Salming").append("address", "Stockholm").append("SSN", "19950909").append("occupation", "Barista").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Sid").append("lName", "Sidung").append("address", "Stockholm").append("SSN", "19920909").append("occupation", "Systemutvecklare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Thomas").append("lName", "Turin").append("address", "Amsterdam").append("SSN", "19910109").append("occupation", "DJ").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Jakup").append("lName", "Guven").append("address", "London").append("SSN", "19910109").append("occupation", "Systemutvecklare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "James").append("lName", "Grenblom").append("address", "London").append("SSN", "19940901").append("occupation", "Systemutvecklare").append("coffeeCount", 0));
		collection.insert(new BasicDBObject("fName", "Gustav").append("lName", "von Flemming").append("address", "London").append("SSN", "19980901").append("occupation", "Operasångare").append("coffeeCount", 0));

	}
}
