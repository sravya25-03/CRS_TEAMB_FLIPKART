/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Student;
import com.flipkart.exception.StudentNotRegisteredException;


public interface StudentDAOInterface {

	public String addStudent(Student student) throws StudentNotRegisteredException;

	public String getStudentId(String userId);

	public boolean isApproved(String studentId);
}