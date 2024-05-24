/**
 * This class represents a custom exception for the scenario where a student is not found for approval.
 */
package com.flipkart.exception;

/**
 * StudentNotFoundForApprovalException is a custom exception class that extends the Exception class.
 * It is thrown when a student is not found for approval.
 */
public class StudentNotFoundForApprovalException extends Exception {
    
    // The ID of the student that was not found for approval.
    private String studentId;
    
    /**
     * Constructs a new StudentNotFoundForApprovalException with the specified student ID.
     * @param id The ID of the student that was not found for approval.
     */
    public StudentNotFoundForApprovalException(String id) {
        this.studentId = id;
    }

    /**
     * Retrieves the student ID that was not found for approval.
     * @return The student ID.
     */
    public String getUserId() {
        return studentId;
    }
    
    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified student ID was not found for approval.
     */
    @Override
    public String getMessage() {
        return "StudentId: " + studentId + " not registered!";
    }
}
