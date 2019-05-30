package model;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Filter;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import java.sql.*;

public class Database {
	private MongoClient client;
	private DB database;

	public Database() {
		try {
			client = new MongoClient();
			database = client.getDB("BeaverCoffee");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void addMember(Member m) {
		DBCollection collection = database.getCollection("Member");
		collection.insert(new BasicDBObject("_id", m.id).append("fName", m.fName).append("lName", m.lName)
				.append("address", m.address).append("occupation", m.occupation).append("SSN", m.SSN)
				.append("coffeeCount", 0));
	}

	public Member findMember(String SSN) {
		DBCollection collection = database.getCollection("Member");
		DBObject query = new BasicDBObject("SSN", SSN);
		DBCursor cursor = collection.find(query);

		Member m = new Member(cursor.one().get("_id").toString(), (String) cursor.one().get("fName"),
				(String) cursor.one().get("lName"), (String) cursor.one().get("address"),
				(String) cursor.one().get("occupation"), (String) cursor.one().get("SSN"));

		return m;
	}

	public void addEmployee(Employee emp) {
		DBCollection collection = database.getCollection("Employee");
		collection.insert(new BasicDBObject("_id", emp.id).append("fName", emp.fName).append("lName", emp.lName)
				.append("location", emp.locationID));
	}

	public Employee findEmployee(String fName, String lName, String location) {
		DBCollection collection = database.getCollection("Employee");
		DBObject query = new BasicDBObject("fName", fName).append("lName", lName).append("location", location);
		DBCursor cursor = collection.find(query);

		Employee emp = new Employee(cursor.one().get("_id").toString(), (String) cursor.one().get("fName"),
				(String) cursor.one().get("lName"), (String) cursor.one().get("locationID"));

		return emp;
	}

	public void addEmployer(Employer emp) {
		DBCollection collection = database.getCollection("Employer");
		collection.insert(new BasicDBObject("_id", emp.id).append("fName", emp.fName).append("lName", emp.lName));
	}

	public Employer findEmployer(String id) {
		DBCollection collection = database.getCollection("Employer");
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);

		Employer emp = new Employer((String) cursor.one().get("_id"), (String) cursor.one().get("fName"),
				(String) cursor.one().get("lName"));

		return emp;
	}

	public void addLocation(Location l) {
		DBCollection collection = database.getCollection("Location");
		collection.insert(new BasicDBObject("_id", l.id).append("address", l.address).append("country", l.country)
				.append("stock", new ArrayList<Ingredient>()));
	}

	public Location findLocation(String locationAddress) {
		DBCollection collection = database.getCollection("Location");
		DBObject query = new BasicDBObject("address", locationAddress);
		DBCursor cursor = collection.find(query);

		Location l = new Location(cursor.one().get("_id").toString(), cursor.one().get("country").toString(),
				cursor.one().get("address").toString());
		
		return l;
	}

	/*
	 * Adds ingredient to locations stock If stock already has ingredient, the new
	 * quantity is added to the old ingredients quantity
	 */
	public void addToStock(Location l, Ingredient ingredient) {
		DBCollection collection = database.getCollection("Location");

		DBObject locQuery = null;
		DBObject update = null;

		ArrayList<Ingredient> locationStock = getStock(l);

		if (alreadyInStock(locationStock, ingredient.name)) {

			locQuery = new BasicDBObject("_id", l.id).append("stock",
					new BasicDBObject("$elemMatch", new BasicDBObject("name", ingredient.name)));

			double currentQuantity = 0;

			for (Ingredient i : locationStock) {
				if (i.name.equals(ingredient.name)) {
					currentQuantity = i.quantity;
					break;
				}
			}

			update = new BasicDBObject("$set",
					new BasicDBObject("stock.$.quantity", currentQuantity + ingredient.quantity)); // find current ingredient quantity and add

		} else {
			locQuery = new BasicDBObject("_id", l);
			update = new BasicDBObject("$push", new BasicDBObject("stock", new BasicDBObject("name", ingredient.name)
					.append("price", ingredient.price).append("quantity", ingredient.quantity)));
		}

		collection.findAndModify(locQuery, update);
	}

	public ArrayList<Ingredient> getStock(Location location) {
		ArrayList<Ingredient> stock = new ArrayList<Ingredient>();
		DBCollection collection = database.getCollection("Location");

		DBObject query = new BasicDBObject("address", location.address);
		DBCursor cursor = collection.find(query);
		
		ArrayList<DBObject> list = (ArrayList<DBObject>) cursor.one().get("stock");

		for (DBObject dbo : list) {
			stock.add(
					new Ingredient((String) dbo.get("name"), Double.parseDouble(dbo.get("price").toString()), Double.parseDouble(dbo.get("quantity").toString())));
		}

		return stock;
	}

	private boolean alreadyInStock(ArrayList<Ingredient> stock, String ingredientName) {
		for (Ingredient i : stock) {
			if (i.name.equals(ingredientName)) {
				return true;
			}
		}

		return false;
	}

	public void takeFromStock(Order order) throws Exception {
		DBCollection collection = database.getCollection("Location");

		if (!enoughIngredientsInStock(order)) {
			throw new Exception("Not enough ingredients!");
		}

		double currentQuantity;
		ArrayList<Ingredient> locationStock = getStock(findLocation(order.locID));

		for (Product p : order.products) {
			for (Ingredient ip : p.ingredients) {
				currentQuantity = 0;

				for (Ingredient is : locationStock) {
					if (ip.name.equals(is.name)) {
						currentQuantity = is.quantity;
						break;
					}
				}

				DBObject query = new BasicDBObject("address", order.locID).append("stock",
						new BasicDBObject("$elemMatch", new BasicDBObject("name", ip.name)));
				DBObject update = new BasicDBObject("$set",
						new BasicDBObject("stock.$.quantity", currentQuantity - ip.quantity));
				collection.findAndModify(query, update);
			}
		}
	}

	private boolean enoughIngredientsInStock(Order order) {
		System.out.println(order.locID);
		
		ArrayList<Ingredient> locationStock = getStock(findLocation(order.locID));
		

		// förlåt
		for (Ingredient ingredientInStock : locationStock) {
			for (Product p : order.products) {
				for (Ingredient ingredientInProduct : p.ingredients) {
					if (ingredientInProduct.name.equals(ingredientInStock.name)) {
						if ((ingredientInStock.quantity - ingredientInProduct.quantity) < 0) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public void createOrder(Order o) {
		DBCollection collection = database.getCollection("order");

		ArrayList<DBObject> products = new ArrayList<DBObject>();

		for (Product p : o.products) {
			ArrayList<DBObject> ingredients = new ArrayList<DBObject>();

			for (Ingredient i : p.ingredients) {
				ingredients
						.add(new BasicDBObject("name", i.name).append("price", i.price).append("quantity", i.quantity));
			}

			products.add(new BasicDBObject("_id", p.id).append("name", p.name).append("ingredients", ingredients));
		}

		collection.insert(new BasicDBObject("_id", o.id).append("empID", o.empID).append("locID", o.locID)
				.append("memID", o.memID).append("_ts", o.ts).append("price", o.price).append("products", products));

		addCoffeeCount(findMember(o.memID));
	}

	public Order findOrder(String id) {
		DBCollection collection = database.getCollection("order");
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);

		ArrayList<Product> products = new ArrayList<Product>();
		
		DBObject order = cursor.one();
		
		ArrayList<DBObject> productsInOrder = (ArrayList)order.get(("products"));
		
		for(DBObject dbo : productsInOrder) {
			ArrayList<DBObject> DBIngredients = (ArrayList)dbo.get("ingredients");
			ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
			
			for(DBObject dbo2 : DBIngredients) {
				ingredients.add(new Ingredient((String)dbo2.get("name"), Double.parseDouble(dbo2.get("price").toString()), Double.parseDouble(dbo2.get("quantity").toString())));
			}
			
			products.add(new Product(dbo.get("_id").toString(), dbo.get("name").toString(), ingredients));
		}
		
		
		Order o = new Order(cursor.one().get("_id").toString(), cursor.one().get("empID").toString(),
				cursor.one().get("locID").toString(), cursor.one().get("memID").toString(), products);
		
		return o;

	}

	// is added for every order
	private void addCoffeeCount(Member member) {
		DBCollection collection = database.getCollection("Member");
		DBObject query = new BasicDBObject("_id", member.id);
		DBCursor cursor = collection.find(query);
		int currentCoffeeCount = (Integer) cursor.one().get("coffeeCount");
		DBObject update = new BasicDBObject("$set", new BasicDBObject("coffeeCount", ++currentCoffeeCount));

		collection.findAndModify(query, update);
	}

	public boolean freeCoffee(Member member) {
		int coffeeCount = getCoffeeCount(member);

		if (coffeeCount % 10 == 0) {
			return true;
		}

		return false;
	}

	private int getCoffeeCount(Member member) {
		DBCollection collection = database.getCollection("Member");
		DBObject query = new BasicDBObject("_id", member.id);
		DBCursor cursor = collection.find(query);
		return (Integer) cursor.one().get("coffeeCount");
	}

	public void addComment(Comment c) {
		DBCollection collection = database.getCollection("Employee");
		DBObject query = new BasicDBObject("_id", c.employeeID);
		DBObject update = new BasicDBObject("$set", new BasicDBObject("comment", c.comment));
		collection.findAndModify(query, update);
	}

	public void addProduct(Product p) {
		DBCollection collection = database.getCollection("Products");
		collection.insert(new BasicDBObject("id", p.id).append("name", p.name).append("ingredients", p.ingredients));
	}

	public ArrayList<Product> getProducts() {
		DBCollection collection = database.getCollection("Products");
		DBCursor cursor = collection.find();
		ArrayList<Product> productList = new ArrayList<Product>();

		while (cursor.hasNext()) {
			DBObject product = cursor.next();

			ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

			ArrayList<DBObject> list = (ArrayList) product.get("ingredients");

			for (DBObject dbo : list) {
				ingredientList
						.add(new Ingredient((String) dbo.get("name"), Double.parseDouble(dbo.get("price").toString()),
								Double.parseDouble(dbo.get("quantity").toString())));
			}

			productList.add(new Product(product.get("_id").toString(), (String) product.get("name"), ingredientList));
		}

		return productList;
	}

	public void init() {
		Initializer i = new Initializer(database);
		i.initProducts();
		i.initLocationsAndStock();
		i.initEmployees();
		i.initMembers();
	}

	public boolean checkDiscount(String ID) {
		DBCollection collection = database.getCollection("Employee");
		DBObject query = new BasicDBObject("_id", ID);
		DBCursor cursor = collection.find(query);

		if (cursor.hasNext()) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Location> getAllLocations() {
		ArrayList<Location> locList = new ArrayList<Location>();
		DBCollection collection = database.getCollection("Location");
		DBCursor cursor = collection.find();

		while (cursor.hasNext()) {
			DBObject location = cursor.next();
			locList.add(new Location((String) location.get("_id"), (String) location.get("adress"),
					(String) location.get("country")));
		}

		return locList;

	}

	public ArrayList<Order> getOrdersTimePeriod(Timestamp from, Timestamp to) {
		ArrayList<Order> orderList = new ArrayList<Order>();
		DBCollection collection = database.getCollection("order");
		
		System.out.println(from.toString());
		
		BasicDBObject query = new BasicDBObject("_ts",
				new BasicDBObject("$gt", from.toString()).append("$lte", to.toString()));
		DBCursor cursor = collection.find(query);
		
		System.out.println(query);
		
		System.out.println("XXX");
		
		System.out.println(cursor.one());

		while (cursor.hasNext()) {
			DBObject DBOrder = cursor.next();
			
			ArrayList<Product> products = new ArrayList<Product>();
			
			Order order = findOrder(DBOrder.get("_id").toString());
			
			System.out.println(order);
			
			orderList.add(new Order((Timestamp) DBOrder.get("dateAndTime"), (String) DBOrder.get("id"),
					(String) DBOrder.get("employeeId"), (String) DBOrder.get("locationId"), (String) DBOrder.get("memberId"),
					products));
		}

		return orderList;

	}

	public static void main(String[] args) {
		Database db = new Database();
		
//		db.init(); //Kommer att dubbla allt i databas om körs flera gånger. 
		
//		//ADD EMPLOYEE - FUNKAR
//		db.addEmployee(new Employee("emp_olny95", "Olof", "Nymansson", "loc_malmö1"));
//		System.out.println(db.findEmployee("Gustav", "von Flemming", "London").fName);
//		
//		//ADD MEMBER - FUNKAR
//		db.addMember(new Member("osar93", "Oscar", "Arréhn", "Hittepågatan", "Student", "1993-02-11"));
//		Member m = db.findMember("19980901");
//		System.out.println(m.fName + ", " + m.address);
		
//		//Add Location - FUNKAR
//		Location l = new Location("loc_malmö2", "Storgatan 2", "Skåneland");
//		db.addLocation(l);
	
//		//Find Location - FUNKAR
//		Location fl = db.findLocation("Malmö"); //adress
//		System.out.println(fl.country);

//		//Add Order - FUNKAR
//		ArrayList<Product> products = new ArrayList<Product>();
//		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
//		ingredients.add(new Ingredient("milk", 2.5, 3));
//		ingredients.add(new Ingredient("beans", 2.5, 3));
//		products.add(new Product("p1", "coffee", ingredients));
//		Location fl = db.findLocation("Malmö");
//		Employee fe = db.findEmployee("emp_olny95");
//		Member fm = db.findMember("osar93");
//		Order o = new Order("ord_208", fe.id, fl.id, fm.id, products);
//		db.createOrder(o);
//		System.out.println(o.id);
		
		//Find Order - FUNKAR
//		Order o = db.findOrder("ord_99");
//		System.out.println(o.memID + ", " + o.price);
		
		//Take from stock: - FUNKAR
//		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
//		ArrayList<Product> products = new ArrayList<Product>();
//		
//		ingredients.add(new Ingredient("Cream", 2.5, 100));
//		ingredients.add(new Ingredient("Caramel", 2.5, 100));
//		
//		products.add(new Product("1", "Coffee", ingredients));
//		
//		try {
//			db.takeFromStock(new Order("1", "1", "Malmö", "1", products));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//Comment - FUNKAR
//		db.addComment(new Comment("The employer", "emp_olny95", "Good job!"));
		
		System.out.println("X");
	}
}