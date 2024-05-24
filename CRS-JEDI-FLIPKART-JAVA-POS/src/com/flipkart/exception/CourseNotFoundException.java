/**
 * This class represents a custom exception for the scenario where a course is not found.
 */
package com.flipkart.exception;

/**
 * CourseNotFoundException is a custom exception class that extends the Exception class.
 * It is thrown when a course is not found.
 */
public class CourseNotFoundException extends Exception {
    
    // The code of the course that was not found.
    private String courseCode;
    
    /**
     * Constructs a new CourseNotFoundException with the specified course code.
     * @param courseCode The code of the course that was not found.
     */
    public CourseNotFoundException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Retrieves the course code that was not found.
     * @return The course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the course with the specified code was not found.
     */
    @Override
    public String getMessage() {
        return "Course with courseCode: " + courseCode + " not found.";
    }
}
