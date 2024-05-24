/**
 * This class represents a custom exception for the scenario where a professor ID is already in use.
 */
package com.flipkart.exception;

/**
 * ProfessorIdAlreadyInUseException is a custom exception class that extends the Exception class.
 * It is thrown when a professor ID is already in use.
 */
public class ProfessorIdAlreadyInUseException extends Exception {
    
    // The ID of the professor that is already in use.
    private String professorId;
    
    /**
     * Constructs a new ProfessorIdAlreadyInUseException with the specified professor ID.
     * @param id The ID of the professor that is already in use.
     */
    public ProfessorIdAlreadyInUseException(String id) {
        this.professorId = id;
    }

    /**
     * Retrieves the professor ID that is already in use.
     * @return The professor ID.
     */
    public String getUserId() {
        return professorId;
    }
    
    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified professor ID is already in use.
     */
    @Override
    public String getMessage() {
        return "userId: " + professorId + " is already in use.";
    }
}
