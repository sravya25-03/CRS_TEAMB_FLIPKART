package com.flipkart.exception;

/**
 * @author Group-A
 * Aaryan Pawar
 * Harsh Garg
 * Pulkit Bhargava
 * Rudra Tiwari
 * Shruti Sharma
 * Vedant Patel
 *
 */

public class StudentIdAlreadyInUseException extends Exception{
	private String StudentId;
	
	
	/***
	 * Setter function for ProfessorId
	 * @param userId
	 */
	
	public StudentIdAlreadyInUseException(String id) {
		StudentId = id;
	}
	
	/***
	 * Getter function for ProfessorId
	 * @param userId
	 */
	
	public String getUserId() {
		return StudentId;
	}
	
	
	@Override
	public String getMessage() {
		return "userId: " + StudentId + " is already in use.";
	}

}