package com.flipkart.validator;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;


public class StudentValidator {
	/**
	 * Validates if a student is registered for a course by checking if the course code exists in the list of registered courses.
	 * @param courseCode The course code to be checked.
	 * @param studentId The ID of the student.
	 * @param registeredCourseList The list of registered courses.
	 * @return True if the student is registered for the course, false otherwise.
	 * @throws CourseNotFoundException if the course is not found in the list of registered courses.
	 */

	public static boolean isRegistered(String courseCode,String studentId,List<Course>registeredCourseList) throws CourseNotFoundException
	{
		for(Course course : registeredCourseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseCode())) 
			{
				return true; 
			}
		}
		
		return false;
	}
	/**
	 * Validates if a course code is valid by checking if it exists in the list of available courses.
	 * @param courseCode The course code to be checked.
	 * @param availableCourseList The list of available courses.
	 * @return True if the course code is valid, false otherwise.
	 */

	public static boolean isValidCourseCode(String courseCode,List<Course>availableCourseList) 
	{
		for(Course course : availableCourseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseCode())) 
			{
				return true; 
			}
		}
		
		return false;
	
	}
	

}