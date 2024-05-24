/**
 * 
 */
package com.flipkart.validator;

import java.util.List;

import com.flipkart.bean.*;


public class AdminValidator {
	
	/**
	 * Validates if a new course is valid by checking if its course code already exists in the provided list of courses.
	 * @param newCourse The new course to be validated.
	 * @param courseList The list of existing courses.
	 * @return True if the new course is valid (i.e., its course code is unique), false otherwise.
	 */
	public static boolean isValidNewCourse(Course newCourse, List<Course> courseList) {
		for(Course course : courseList) {
			if(newCourse.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
				return false; 
			}
		}
		return true;
	}
	/**
	 * Validates if a course can be dropped by checking if the provided course code exists in the list of courses.
	 * @param dropCourseCode The course code to be dropped.
	 * @param courseList The list of existing courses.
	 * @return True if the course can be dropped (i.e., its course code exists in the list), false otherwise.
	 */
	
	public static boolean isValidDropCourse(String dropCourseCode, List<Course> courseList) {
		for(Course course : courseList) {
			if(dropCourseCode.equalsIgnoreCase(course.getCourseCode())) {
				return true; 
			}
		}
		return false;
	}
	/**
	 * Validates if a student is unapproved by checking if the provided student ID exists in the list of students.
	 * @param studentId The student ID to be validated.
	 * @param studentList The list of existing students.
	 * @return True if the student is unapproved (i.e., their ID exists in the list), false otherwise.
	 */

	public static boolean isValidUnapprovedStudent(String studentId, List<Student> studentList) {
		for(Student student : studentList) {
			if(studentId == student.getStudentId()) {
				return true;
			}
		}
		return false;
	}
}
