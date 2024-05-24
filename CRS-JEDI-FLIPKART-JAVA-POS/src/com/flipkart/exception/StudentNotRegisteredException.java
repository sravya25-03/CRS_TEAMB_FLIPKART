/**
 * This class represents a custom exception for the scenario where a student is not registered.
 */
package com.flipkart.exception;

/**
 * StudentNotRegisteredException is a custom exception class that extends the Exception class.
 * It is thrown when a student is not registered.
 */
public class StudentNotRegisteredException extends Exception {
    
    // The name of the student who is not registered.
    private String studentName;
    
    /**
     * Constructs a new StudentNotRegisteredException with the specified student name.
     * @param studentName The name of the student who is not registered.
     */
    public StudentNotRegisteredException(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Retrieves the name of the student who is not registered.
     * @return The student name.
     */
    public String getStudentName() {
        return studentName;
    }
}
