package model;

public class Comment {
	public String employerID;
	public String employeeID;
	public String comment;

	
	public Comment(String employerID, String employeeID, String comment) {
		this.employerID = employerID;
		this.employeeID = employeeID;
		this.comment = comment;
	}
}
