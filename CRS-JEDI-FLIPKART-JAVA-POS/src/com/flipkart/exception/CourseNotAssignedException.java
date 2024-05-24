/**
 * This class represents a custom exception for the scenario where a course is not assigned to a user.
 */
package com.flipkart.exception;

/**
 * CourseNotAssignedException is a custom exception class that extends the Exception class.
 * It is thrown when a course is not assigned to a user.
 */
public class CourseNotAssignedException extends Exception {
    
    // The code of the course that couldn't be assigned.
    private String courseCode;
    // The ID of the user to whom the course couldn't be assigned.
    private String userId;
    
    /**
     * Constructs a new CourseNotAssignedException with the specified course code and user ID.
     * @param courseCode The code of the course that couldn't be assigned.
     * @param userId The ID of the user to whom the course couldn't be assigned.
     */
    public CourseNotAssignedException(String courseCode, String userId) {
        this.courseCode = courseCode;
        this.userId = userId;
    }

    /**
     * Retrieves the course code that couldn't be assigned.
     * @return The course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Retrieves the user ID to whom the course couldn't be assigned.
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user ID to whom the course couldn't be assigned.
     * @param userId The user ID.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Sets the course code that couldn't be assigned.
     * @param courseCode The course code.
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Overrides the getMessage() method of the Exception class to provide a custom exception message.
     * @return A message indicating that the specified course couldn't be assigned to the specified user.
     */
    @Override
    public String getMessage() {
        return "Course code: " + courseCode + " couldn't be assigned to UserID: " + userId;
    }
}
