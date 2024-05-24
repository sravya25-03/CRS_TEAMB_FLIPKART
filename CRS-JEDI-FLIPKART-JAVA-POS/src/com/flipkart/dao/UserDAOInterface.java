/**
 * The UserDAOInterface interface provides methods to interact with user data in the database.
 */
package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;

public interface UserDAOInterface {

	/**
	 * Verifies the credentials of a user based on the provided user ID and password.
	 * 
	 * @param userId The ID of the user to be verified
	 * @param password The password to be verified
	 * @return true if the credentials are valid, false otherwise
	 * @throws UserNotFoundException If the user is not found
	 */
	public boolean verifyCredentials(String userId, String password) throws UserNotFoundException;

	/**
	 * Retrieves the role of a user based on the provided user ID.
	 * 
	 * @param userId The ID of the user
	 * @return The role of the user
	 */
	public String getRole(String userId);

	/**
	 * Retrieves the name of a user based on the provided user ID.
	 * 
	 * @param userId The ID of the user
	 * @return The name of the user
	 */
	public String getName(String userId);

	/**
	 * Updates the password for a given user in the database.
	 * 
	 * @param userId The ID of the user whose password needs to be updated
	 * @param newPassword The new password to be set
	 * @return true if the password is updated successfully, false otherwise
	 */
	public boolean updatePassword(String userId, String newPassword);
}
