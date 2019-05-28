package model;

public class Comment {
	public long employerID;
	public long employeeID;
	public String comment;
	
	public Comment(long employerID, long employeeID, String comment) {
		this.employerID = employerID;
		this.employeeID = employeeID;
		this.comment = comment;
	}
}
