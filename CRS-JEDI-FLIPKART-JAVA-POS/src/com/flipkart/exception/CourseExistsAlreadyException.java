/**
 * This class represents a custom exception for the scenario where a new course is attempted to be added
 * to a catalog where it already exists.
 */
package com.flipkart.exception;

/**
 * CourseExistsAlreadyException is a custom exception class that extends the Exception class.
 * It is thrown when a new course is attempted to be added to a catalog where it already exists.
 */
public class CourseExistsAlreadyException extends Exception {
    
    // The course code that already exists in the catalog.
    private String courseCode;

    /**
     * Constructs a new CourseExistsAlreadyException with the specified course code.
     * @param courseCode The code of the course that already exists in the catalog.
     */
    public CourseExistsAlreadyException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Retrieves the course code that already exists in the catalog.
     * @return The course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified course already exists in the catalog.
     */
    @Override
    public String getMessage() {
        return "Course: " + courseCode + " already exists in catalog.";
    }
}
