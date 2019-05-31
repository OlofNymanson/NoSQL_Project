package model;

public class Employee {
	public String id;
	public String fName;
	public String lName;
	public String locationID;
	public String comment = "";
	
	public Employee(String id, String fName, String lName, String locationID) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.locationID = locationID;
	}
}
