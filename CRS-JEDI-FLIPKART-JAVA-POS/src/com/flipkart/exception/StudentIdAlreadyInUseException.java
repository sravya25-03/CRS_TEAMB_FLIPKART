/**
 * This class represents a custom exception for the scenario where a student ID is already in use.
 */
package com.flipkart.exception;

/**
 * StudentIdAlreadyInUseException is a custom exception class that extends the Exception class.
 * It is thrown when a student ID is already in use.
 */
public class StudentIdAlreadyInUseException extends Exception {
    
    // The ID of the student that is already in use.
    private String studentId;
    
    /**
     * Constructs a new StudentIdAlreadyInUseException with the specified student ID.
     * @param id The ID of the student that is already in use.
     */
    public StudentIdAlreadyInUseException(String id) {
        this.studentId = id;
    }

    /**
     * Retrieves the student ID that is already in use.
     * @return The student ID.
     */
    public String getUserId() {
        return studentId;
    }
    
    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified student ID is already in use.
     */
    @Override
    public String getMessage() {
        return "userId: " + studentId + " is already in use.";
    }
}
