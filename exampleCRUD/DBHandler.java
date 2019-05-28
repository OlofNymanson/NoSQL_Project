package exampleCRUD;

import java.net.UnknownHostException;
import java.util.ArrayList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DBHandler {
	private MongoClient client;
	private DB database;

	public DBHandler() {
		try {
			client = new MongoClient();
			database = client.getDB("MyDatabase");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void createPerson(Person p) {
		DBCollection collection = database.getCollection("Person");
		collection.insert(new BasicDBObject("_id", p.id).append("name", p.name).append("age", p.age));
	}

	public void createLocation(Location loc) {
		DBCollection collection = database.getCollection("Location");
		collection.insert(new BasicDBObject("_id", loc.id).append("city", loc.city).append("address", loc.address).append("residents", new ArrayList<BasicDBObject>()));
	}

	public void addPersonToLocation(Location loc, Person p) {
		DBCollection collection = database.getCollection("Location");
		DBObject query = new BasicDBObject("_id", loc.id);

		DBObject update = new BasicDBObject("$push", new BasicDBObject("residents",
				new BasicDBObject("_id", p.id).append("name", p.name).append("age", p.age)));

		collection.findAndModify(query, update);
	}
	
	
	public void findPersonInLocation(Location loc) {
		DBCollection collection = database.getCollection("Location");
		DBObject query = new BasicDBObject("_id", loc.id);
		DBCursor cursor = collection.find(query);
		
		System.out.println(cursor.one().get("resident"));
	}
	

	public static void main(String[] args) {
		DBHandler dbh = new DBHandler();
		Person p1 = new Person("Olof", 23, "p1");
		Person p2 = new Person("Carl", 23, "p2");
		Location l1 = new Location("Fersens väg 3", "Malmö", "l1");
		
		dbh.createPerson(p2);
		
//		dbh.createLocation(l1);

//		dbh.addPersonToLocation(l1, p1);
//		dbh.addPersonToLocation(l1, p2);
		
//		dbh.findPersonInLocation(l1);
		
		//scoobidoo

		System.out.println("DONE");
	}
}
