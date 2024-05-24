/**
 * 
 */
package com.flipkart.bean;



import com.flipkart.constant.GradeConstant;

public class RegisteredCourse 
{
	Course course;
	String studentId;
	GradeConstant grade;
	
	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = new Course(course.getCourseCode(), course.getCourseName(), course.getInstructorId() ,course.getSeats(), course.getCourseFee());
	}
	

	public String getstudentId() {
		return studentId;
	}

	public void setstudentId(String studentId) {
		this.studentId = studentId;
	}

	public GradeConstant getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = GradeConstant.valueOf(grade);
	}
	
	
	
	

}
