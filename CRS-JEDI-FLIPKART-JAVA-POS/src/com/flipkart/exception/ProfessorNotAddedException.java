/**
 * This class represents a custom exception for the scenario where a professor is not added.
 */
package com.flipkart.exception;

/**
 * ProfessorNotAddedException is a custom exception class that extends the Exception class.
 * It is thrown when a professor is not added.
 */
public class ProfessorNotAddedException extends Exception {
    
    // The ID of the professor that was not added.
    private String professorId;
    
    /**
     * Constructs a new ProfessorNotAddedException with the specified professor ID.
     * @param id The ID of the professor that was not added.
     */
    public ProfessorNotAddedException(String id) {
        this.professorId = id;
    }

    /**
     * Retrieves the professor ID that was not added.
     * @return The professor ID.
     */
    public String getUserId() {
        return this.professorId;
    }
    
    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified professor ID was not added.
     */
    @Override
    public String getMessage() {
        return "professorId: " + professorId + " not added!";
    }
}
