/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotAddedException;
import com.flipkart.exception.UserNotFoundException;


public interface AdminDAOInterface {
	
	public List<Course> viewCourses();
	public List<Professor> viewProfessors();
	
	
	public void setGeneratedReportCardTrue(String Studentid);
	
	public List<RegisteredCourse> generateGradeCard(String Studentid);

	public List<Student> viewPendingAdmissions();

	public void approveStudent(String studentid) throws StudentNotFoundForApprovalException;

	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

	public void removeCourse(String coursecode) throws CourseNotFoundException, CourseNotDeletedException;

	public void addCourse(Course course) throws CourseExistsAlreadyException;

	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException, UserNotFoundException;
	
	public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;
}
