/**
 * This class represents a custom exception for the scenario where a user attempts to register for a course 
 * that they are already registered for.
 */
package com.flipkart.exception;

/**
 * CourseAlreadyRegisteredException is a custom exception class that extends the Exception class.
 * It is thrown when a user tries to register for a course that they are already registered for.
 */
public class CourseAlreadyRegisteredException extends Exception {
    
    // The course code for which the user is already registered.
    private String courseCode;

    /**
     * Constructs a new CourseAlreadyRegisteredException with the specified course code.
     * @param courseCode The code of the course for which the user is already registered.
     */
    public CourseAlreadyRegisteredException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Retrieves the course code for which the user is already registered.
     * @return The course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the user has already registered for the specified course.
     */
    @Override
    public String getMessage() {
        return "You have already registered for " + courseCode;
    }
}
