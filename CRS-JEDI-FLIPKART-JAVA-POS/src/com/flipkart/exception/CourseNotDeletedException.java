/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Group-A
 * Aaryan Pawar
 * Harsh Garg
 * Pulkit Bhargava
 * Rudra Tiwari
 * Shruti Sharma
 * Vedant Patel
 *
 */

public class CourseNotDeletedException extends Exception {
	
	private String courseCode;
	
	public CourseNotDeletedException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	/**
	 * Getter function for course code
	 * @return
	 */
	public String getCourseCode()
	{
		return courseCode;
	}
	
	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseCode + " can't be deleted.";
	}
}
