package model;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

		Member m = new Member((String)cursor.one().get("_id"), (String)cursor.one().get("fName"), (String)cursor.one().get("lName"),
				(String)cursor.one().get("address"), (String)cursor.one().get("occupation"), (String)cursor.one().get("SSN"));
		
		return m;
	}
	
	public void addEmployee(Employee emp) {
		DBCollection collection = database.getCollection("Employee");
		collection.insert(new BasicDBObject("_id", emp.id).append("fName", emp.fName)
				.append("lName", emp.lName).append("locationID", emp.locationID));
	}
	
	public Employee findEmployee(String id) {
		DBCollection collection = database.getCollection("Employee");
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);
		
		Employee emp = new Employee((String)cursor.one().get("_id"), (String)cursor.one().get("fName"),
				(String)cursor.one().get("lName"), (String)cursor.one().get("locationID"));
		
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
		
		Employer emp = new Employer((String)cursor.one().get("_id"), (String)cursor.one().get("fName"),
				(String)cursor.one().get("lName"));
		
		return emp;
	}
	
	public void addLocation(Location l) {
		DBCollection collection = database.getCollection("location");
		collection.insert(new BasicDBObject("_id", l.id).append("address", l.address).append("country", l.country).append("stock", new ArrayList<Ingredient>()));
	}
	
	public Location findLocation(String id) {
		DBCollection collection = database.getCollection("location");
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);
		
		Location l = new Location(cursor.one().get("_id").toString(), cursor.one().get("address").toString(), cursor.one().get("country").toString());
		return l;
	}
	
	public void createOrder(Order o) {
		DBCollection collection = database.getCollection("order");
		collection.insert(new BasicDBObject("_id", o.id).append("empID", o.empID).append("locID", o.locID).append("memID", o.memID)
				.append("_ts", o.ts).append("price", o.price).append("products", o.products));
	}
	
	public Order findOrder(String id) {
		DBCollection collection = database.getCollection("order");
		DBObject query = new BasicDBObject("_id", id);
		DBCursor cursor = collection.find(query);
	
		ArrayList<Product> products = new ArrayList<Product>(); //Denna är tom nu och egentligen ska den läsa in från databas, arbetar på det.
		
		Order o = new Order(cursor.one().get("_id").toString(), cursor.one().get("empID").toString(), cursor.one().get("locID").toString(), 
				 cursor.one().get("memID").toString(), products);
		return o;
				
	}
	
	public void addComment(Comment c) {
		DBCollection collection = database.getCollection("Employee");
		DBObject query = new BasicDBObject("id", c.employeeID);
		DBCursor cursor = collection.find(query);
		query.put("comment", c);
	}
	
	public void addProduct(Product p) {
		DBCollection collection = database.getCollection("Products");
		collection.insert(new BasicDBObject("id", p.id).append("name", p.name).append("ingredients", p.ingredients));
		
	}
	
	
	public ArrayList<Product> getProducts() {
		DBCollection collection = database.getCollection("Products");
		DBCursor cursor = collection.find();
		ArrayList<Product> productList = new ArrayList<Product>();
		while(cursor.hasNext()) {
			DBObject product = cursor.next();
			productList.add(new Product((String)product.get("id"), (String)product.get("name"), (ArrayList<Ingredient>)product.get("ingredients")));
		}
		return productList;
	}
	
	
	public static void main(String[] args) {
		Database db = new Database();
//		
//		//ADD EMPLOYEE
//		db.addEmployee(new Employee("emp_olny95", "Olof", "Nymansson", "loc_malmö1"));
//		System.out.println(db.findEmployee("emp_olny95").fName);
//		
//		//ADD MEMBER
//		db.addMember(new Member("osar93", "Oscar", "Arréhn", "Hittepågatan", "Student", "1993-02-11"));
//		Member m = db.findMember("osar93");
//		System.out.println(m.fName + ", " + m.address);
		
//		//Add Location
//		ArrayList<Ingredient> stock = new ArrayList<Ingredient>();
//		Location l = new Location("loc_malmö2", "Storgatan 2", "Skåneland");
//		db.addLocation(l);
	
//		//Find Location
//		Location fl = db.findLocation("loc_malmö2");
//		System.out.println(fl.id);

//		//Add Order
//		ArrayList<Product> products = new ArrayList<Product>();
//		Location fl = db.findLocation("loc_malmö2");
//		Employee fe = db.findEmployee("emp_olny95");
//		Member fm = db.findMember("osar93");
//		Order o = new Order("ord_1", fe.id, fl.id, fm.SSN, products);
//		db.createOrder(o);
//		System.out.println(o.id);
		
		//Find Order
		Order o = db.findOrder("ord_1");
		System.out.println(o.id);
	}
}
