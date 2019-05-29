package model;

public class Comment {
	public String comment, employeeID, employerID;
	
	public Comment(String employerID, String employeeID, String comment) {
		this.employerID = employerID;
		this.employeeID = employeeID;
		this.comment = comment;
	}
}
