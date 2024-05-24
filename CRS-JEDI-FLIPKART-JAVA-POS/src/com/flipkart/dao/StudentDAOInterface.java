/**
 * The StudentDAOInterface interface defines methods related to student data access.
 */
package com.flipkart.dao;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;

public interface StudentDAOInterface {

	/**
	 * Method to add a new student to the database.
	 * 
	 * @param student: Student object containing student details
	 * @return studentId of the added student
	 * @throws StudentNotRegisteredException if student registration fails
	 */
	public String addStudent(Student student) throws StudentNotRegisteredException;

	/**
	 * Method to retrieve the student ID based on the user ID.
	 * 
	 * @param userId: User ID of the student
	 * @return studentId corresponding to the userId
	 */
	public String getStudentId(String userId);

	/**
	 * Method to check if a student is approved.
	 * 
	 * @param studentId: ID of the student
	 * @return true if the student is approved, false otherwise
	 */
	public boolean isApproved(String studentId);
}
