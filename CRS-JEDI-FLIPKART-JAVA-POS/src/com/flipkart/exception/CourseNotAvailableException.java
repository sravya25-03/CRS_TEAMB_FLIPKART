/**
 * This class represents a custom exception for the scenario where seats are not available for a course.
 */
package com.flipkart.exception;

/**
 * CourseNotAvailableException is a custom exception class that extends the Exception class.
 * It is thrown when seats are not available for a course.
 */
public class CourseNotAvailableException extends Exception {
    
    // The code of the course for which seats are not available.
    private String courseCode;

    /**
     * Constructs a new CourseNotAvailableException with the specified course code.
     * @param courseCode The code of the course for which seats are not available.
     */
    public CourseNotAvailableException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that seats are not available for the specified course.
     */
    @Override
    public String getMessage() {
        return "Seats are not available in: " + courseCode;
    }
}
