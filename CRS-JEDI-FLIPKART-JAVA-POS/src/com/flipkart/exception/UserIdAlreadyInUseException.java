/**
 * This class represents a custom exception for the scenario where a user ID is already in use.
 */
package com.flipkart.exception;

/**
 * UserIdAlreadyInUseException is a custom exception class that extends the Exception class.
 * It is thrown when a user ID is already in use.
 */
public class UserIdAlreadyInUseException extends Exception {
    
    // The ID that is already in use.
    private String userId;
    
    /**
     * Constructs a new UserIdAlreadyInUseException with the specified user ID.
     * @param id The user ID that is already in use.
     */
    public UserIdAlreadyInUseException(String id) {
        userId = id;
    }

    /**
     * Retrieves the user ID that is already in use.
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified user ID is already in use.
     */
    @Override
    public String getMessage() {
        return "userId: " + userId + " is already in use.";
    }
}
