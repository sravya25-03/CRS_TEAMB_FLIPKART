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

public class ProfessorIdAlreadyInUseException extends Exception{
	private String ProfessorId;
	
	
	/***
	 * Setter function for ProfessorId
	 * @param userId
	 */
	
	public ProfessorIdAlreadyInUseException(String id) {
		ProfessorId = id;
	}
	
	/***
	 * Getter function for ProfessorId
	 * @param userId
	 */
	
	public String getUserId() {
		return ProfessorId;
	}
	
	
	@Override
	public String getMessage() {
		return "userId: " + ProfessorId + " is already in use.";
	}

}