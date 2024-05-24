package com.flipkart.validator;

import java.util.List;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.RegisteredCourse;



public class ProfessorValidator {

	/**
	 * Validates if a student is enrolled in a course by checking if the student ID exists in the list of enrolled students.
	 * @param enrolledStudents The list of enrolled students.
	 * @param studentId The student ID to be validated.
	 * @return True if the student is enrolled (i.e., their ID exists in the list), false otherwise.
	 */
	public static boolean isValidStudent(List<EnrolledStudent> enrolledStudents,String studentId)
	{
		boolean result=false;
		//check if student exist in the students list
		for(int i=0;i<enrolledStudents.size();i++)
		{
			//role.equalsIgnoreCase("ADMIN")
			if(enrolledStudents.get(i).getStudentId()==studentId)
				result=true;
				
		}
		return result;
	}
	/**
	 * Validates if a course is assigned to a professor by checking if the course code exists in the list of assigned courses.
	 * @param assignedCourses The list of assigned courses.
	 * @param courseCode The course code to be validated.
	 * @return True if the course is assigned (i.e., its code exists in the list), false otherwise.
	 */

	public static boolean isValidCourse(List<Course> assignedCourses,String courseCode)
	{
		//check if course is valid
		boolean result=false;
		for(int i=0;i<assignedCourses.size();i++)
		{
			if(assignedCourses.get(i).getCourseCode().equalsIgnoreCase(courseCode))
				result= true;
		}
		return result;
	}

}