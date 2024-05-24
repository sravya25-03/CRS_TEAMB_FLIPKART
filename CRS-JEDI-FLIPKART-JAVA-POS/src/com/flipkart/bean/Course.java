/**
 * 
 */
package com.flipkart.bean;



public class Course 
{
	private String crsCode;
	private String crsName;
	private String instructorId;
	private int seats = 10;
	private int courseFee = 0;
	
	public Course()
	{
		
	}
	
	public Course(String crsCode,String crsName,String professorId,int seats, int courseFee) {
		this.crsCode=crsCode;
		this.crsName=crsName;
		this.instructorId=professorId;
		this.seats=seats;
		this.courseFee = courseFee;
	}

	public String getCourseCode() {
		return crsCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.crsCode = courseCode;
	}
	

	public String getCourseName() {
		return crsName;
	}
	

	public void setCourseName(String courseName) {
		this.crsName = courseName;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}
	
}
