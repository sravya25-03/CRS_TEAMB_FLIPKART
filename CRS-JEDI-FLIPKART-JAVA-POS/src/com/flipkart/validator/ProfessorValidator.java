package com.flipkart.validator;

import java.util.List;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.RegisteredCourse;



public class ProfessorValidator {

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