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

		Member m = new Member((String)cursor.one().get("_id"), (String)cursor.one().get("fName"), (String)cursor.one().get("lName"),
				(String)cursor.one().get("address"), (String)cursor.one().get("occupation"), (String)cursor.one().get("SSN"));
		
		return m;
	}
	
	
	public static void main(String[] args) {
		Database db = new Database();
		
		db.addMember(new Member("osar93", "Oscar", "Arréhn", "Hittepågatan", "Student", "1993-02-11"));
		Member m = db.findMember("osar93");
		System.out.println(m.fName);
		
	}
}
