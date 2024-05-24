/**
 * This class represents a custom exception for the scenario where a user is not added.
 */
package com.flipkart.exception;

/**
 * UserNotAddedException is a custom exception class that extends the Exception class.
 * It is thrown when a user is not added.
 */
public class UserNotAddedException extends Exception {
    
    // The ID of the user that was not added.
    private String userId;
    
    /**
     * Constructs a new UserNotAddedException with the specified user ID.
     * @param id The ID of the user that was not added.
     */
    public UserNotAddedException(String id) {
        userId = id;
    }

    /**
     * Retrieves the user ID that was not added.
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified user ID was not added.
     */
    @Override
    public String getMessage() {
        return "UserId: " + userId + " not added!";
    }
}
