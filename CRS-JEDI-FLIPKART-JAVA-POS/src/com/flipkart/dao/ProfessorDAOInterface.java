package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;

/**
 * ProfessorDAOInterface interface provides the method declarations for operations related to professors in the system.
 */
public interface ProfessorDAOInterface {

    /**
     * Method to get courses taught by a professor
     *
     * @param userId ID of the professor
     * @return List of courses taught by the professor
     */
    public List<Course> getCoursesByProfessor(String userId);

    /**
     * Method to get enrolled students for a course
     *
     * @param courseId ID of the course
     * @return List of enrolled students for the course
     */
    public List<EnrolledStudent> getEnrolledStudents(String courseId);

    /**
     * Method to add grade for a student in a course
     *
     * @param studentId ID of the student
     * @param courseCode Code of the course
     * @param grade      Grade to be added
     * @return True if grade added successfully, false otherwise
     */
    public Boolean addGrade(String studentId, String courseCode, String grade);

    /**
     * Method to get professor's name by ID
     *
     * @param profId ID of the professor
     * @return Name of the professor
     */
    public String getProfessorById(String profId);
}
