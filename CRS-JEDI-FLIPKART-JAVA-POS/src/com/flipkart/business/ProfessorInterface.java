/**
 * 
 */
package com.flipkart.business;

import java.sql.SQLException;
import java.util.List;


import com.flipkart.bean.*;
import com.flipkart.exception.GradeNotAllotedException;



public interface ProfessorInterface {
	
	public boolean addGrade(String studentID, String courseID, String grade) throws GradeNotAllotedException;
	
	public List<Course> viewCourses(String profID);

	/**
	 * Method to get the professor name with ID
	 * @param profId
	 * @return Professor name 
	 */
	String getProfessorById(String profId);

	/**
	 * Method to view all the enrolled students
	 * @param profId: professor id 
	 * @return List of enrolled students
	 */
	public List<EnrolledStudent> viewEnrolledStudents(String profId) throws SQLException;

	
}
