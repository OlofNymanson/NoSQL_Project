package model;

import java.net.UnknownHostException;
import java.util.ArrayList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

class Database {
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
				.append("address", m.address).append("occupation", m.occupation).append("SSN", m.SSN));
	}

	public Member findMember(String id) {
		DBCollection collection = database.getCollection("Member");
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);

		Member m = new Member((String) cursor.one().get("_id"), (String) cursor.one().get("fName"),
				(String) cursor.one().get("lName"), (String) cursor.one().get("address"),
				(String) cursor.one().get("occupation"), (String) cursor.one().get("SSN"));

		return m;
	}

	public void addEmployee(Employee emp) {
		DBCollection collection = database.getCollection("Employee");
		collection.insert(new BasicDBObject("_id", emp.id).append("fName", emp.fName).append("lName", emp.lName)
				.append("locationID", emp.locationID));
	}

	public Employee findEmployee(String id) {
		DBCollection collection = database.getCollection("Employee");
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);

		Employee emp = new Employee((String) cursor.one().get("_id"), (String) cursor.one().get("fName"),
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

	public Location findLocation(String id) {
		DBCollection collection = database.getCollection("Location");
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);

		Location l = new Location(cursor.one().get("_id").toString(), cursor.one().get("country").toString(),
				cursor.one().get("address").toString());
		return l;
	}

	/*
	 * Adds ingredient to locations stock
	 * If stock already has ingredient, the new quantity is added to the old ingredients quantity
	 */
	public void addToStock(String locationID, Ingredient ingredient) {
		DBCollection collection = database.getCollection("Location");

		DBObject locQuery = null;
		DBObject update = null;
		
		ArrayList<Ingredient> locationStock = getStock(locationID);
		
		if (alreadyInStock(locationStock, ingredient.name)) {

			locQuery = new BasicDBObject("_id", locationID).append("stock", new BasicDBObject("$elemMatch", new BasicDBObject("name", "Milk")));
			
			double currentQuantity = 0;
			
			for(Ingredient i : locationStock) {
				if(i.name.equals(ingredient.name)) {
					currentQuantity = i.quantity;
				}
			}
			
			update = new BasicDBObject("$set", new BasicDBObject("stock.$.quantity", currentQuantity + ingredient.quantity)); //find current ingredient quantity and add
			
		} else {
			locQuery = new BasicDBObject("_id", locationID);
			update = new BasicDBObject("$push",
					new BasicDBObject("stock", new BasicDBObject("name", ingredient.name)
							.append("price", ingredient.price).append("quantity", ingredient.quantity)));
		}

		collection.findAndModify(locQuery, update);
	}

	public ArrayList<Ingredient> getStock(String locationID) {
		ArrayList<Ingredient> stock = new ArrayList<Ingredient>();
		DBCollection collection = database.getCollection("Location");

		DBObject query = new BasicDBObject("_id", locationID);
		DBCursor cursor = collection.find(query);

		ArrayList<DBObject> list = (ArrayList<DBObject>) cursor.one().get("stock");

		for (DBObject dbo : list) {
			stock.add(
					new Ingredient((String) dbo.get("name"), (Double) dbo.get("price"), (Double) dbo.get("quantity")));
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
	
	
	public static void main(String[] args) {
		Database db = new Database();

		// EMPLOYEE
		// db.addEmployee(new Employee("emp_olny95", "Olof", "Nymansson",
		// "loc_malmö1"));
		// System.out.println(db.findEmployee("emp_olny95").fName);

		// MEMBER
		// db.addMember(new Member("osar93", "Oscar", "Arréhn", "Hittepågatan",
		// "Student", "1993-02-11"));
		// Member m = db.findMember("osar93");
		// System.out.println(m.fName + ", " + m.address);

		// LOCATION
		// db.addLocation(new Location("loc_malmö1", "sweden", "banérsgatan 2B"));
		// Location l = db.findLocation("loc_malmö1");
		// System.out.println(l.country);

		db.addToStock("loc_malmö1", new Ingredient("Milk", 2.0, 4.5));

		System.out.println("HELLO");
	}
}
