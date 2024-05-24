package com.flipkart.validator;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;


public class StudentValidator {


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