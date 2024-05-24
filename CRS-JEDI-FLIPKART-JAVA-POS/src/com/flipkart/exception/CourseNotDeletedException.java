/**
 * This class represents a custom exception for the scenario where a course cannot be deleted.
 */
package com.flipkart.exception;

/**
 * CourseNotDeletedException is a custom exception class that extends the Exception class.
 * It is thrown when a course cannot be deleted.
 */
public class CourseNotDeletedException extends Exception {
    
    // The code of the course that cannot be deleted.
    private String courseCode;
    
    /**
     * Constructs a new CourseNotDeletedException with the specified course code.
     * @param courseCode The code of the course that cannot be deleted.
     */
    public CourseNotDeletedException(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Retrieves the course code that cannot be deleted.
     * @return The course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the course with the specified code cannot be deleted.
     */
    @Override
    public String getMessage() {
        return "Course with courseCode: " + courseCode + " can't be deleted.";
    }
}
