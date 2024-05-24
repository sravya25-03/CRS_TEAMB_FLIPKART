/**
 * This class represents a custom exception for the scenario where a user is not found.
 */
package com.flipkart.exception;

/**
 * UserNotFoundException is a custom exception class that extends the Exception class.
 * It is thrown when a user is not found.
 */
public class UserNotFoundException extends Exception {

    // The ID of the user that was not found.
    private String userId;

    /**
     * Constructs a new UserNotFoundException with the specified user ID.
     * @param id The ID of the user that was not found.
     */
    public UserNotFoundException(String id) {
        userId = id;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified user ID was not found.
     */
    @Override
    public String getMessage() {
        return "User with userId: " + userId + " not found.";
    }
}
