
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

public class UserNotFoundException extends Exception {

	private String userId;

	/***
	 * Setter function for UserId
	 * @param userId
	 */
	public UserNotFoundException(String id) {
		userId = id;
	}

	/**
	 * Message thrown by exception
	 */
	
	public String getMessage() {
		return "User with userId: " + userId + " not found.";
	}
	

}