/**
 * This class represents a custom exception for the scenario where a user attempts to register for more courses
 * than the allowed limit.
 */
package com.flipkart.exception;

/**
 * CourseLimitExceededException is a custom exception class that extends the Exception class.
 * It is thrown when a user attempts to register for more courses than the allowed limit.
 */
public class CourseLimitExceededException extends Exception {
    
    // The number of courses for which the user is already registered.
    private int num;

    /**
     * Constructs a new CourseLimitExceededException with the specified number of courses.
     * @param num The number of courses for which the user is already registered.
     */
    public CourseLimitExceededException(int num) {
        this.num = num;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the user has already registered for the specified number of courses.
     */
    @Override
    public String getMessage() {
        return "You have already registered for " + num + " courses";
    }
}
