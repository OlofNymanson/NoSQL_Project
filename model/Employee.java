package model;

public class Employee {
	String id;
	public String fName;
	public String lName;
	public String locationID;
	
	public Employee(String id, String fName, String lName, String locationID) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.locationID = locationID;
	}
}
