package com.flipkart.dao;

import java.util.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Student;



public interface ProfessorDAOInterface {

	public List<Course> getCoursesByProfessor(String userId);

	public List<EnrolledStudent> getEnrolledStudents(String courseId);
	
	public Boolean addGrade(String studentId,String courseCode,String grade);

	public String getProfessorById(String profId);
}