package model;

public class Member {
	public String id, fName, lName, address, occupation, SSN;
	
	public Member(String id, String fName, String lName, String address, String occupation, String SSN) {
		this.id = id;
		this.lName = lName;
		this.fName = fName;
		this.address = address;
		this.occupation = occupation;
		this.SSN = SSN;
	}
}
