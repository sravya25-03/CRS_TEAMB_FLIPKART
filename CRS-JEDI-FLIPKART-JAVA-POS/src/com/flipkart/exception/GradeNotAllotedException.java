/**
 * This class represents a custom exception for the scenario where a grade has not been allotted to a student.
 */
package com.flipkart.exception;

/**
 * GradeNotAllotedException is a custom exception class that extends the Exception class.
 * It is thrown when a grade has not been allotted to a student.
 */
public class GradeNotAllotedException extends Exception {
    
    // The ID of the student for whom a grade has not been allotted.
    private String studentId;
    
    /**
     * Constructs a new GradeNotAllotedException with the specified student ID.
     * @param studentId The ID of the student for whom a grade has not been allotted.
     */
    public GradeNotAllotedException(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Retrieves the student ID for whom a grade has not been allotted.
     * @return The student ID.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the student with the specified ID hasn't been allotted a grade yet.
     */
    @Override
    public String getMessage() {
        return "Student with id: " + studentId + " hasn't been allotted a grade yet";
    }
}
