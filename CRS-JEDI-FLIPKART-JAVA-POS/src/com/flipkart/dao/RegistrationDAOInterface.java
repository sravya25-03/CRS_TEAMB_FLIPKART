package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;

/**
 * The RegistrationDAOInterface provides an interface for operations related to course registration by students.
 */
public interface RegistrationDAOInterface {

    /**
     * Adds a course for a student.
     *
     * @param courseCode Code of the course to be added
     * @param studentId  ID of the student
     * @return true if course added successfully, false otherwise
     * @throws SQLException
     */
    public boolean addCourse(String courseCode, String studentId) throws SQLException;

    /**
     * Drops a course for a student.
     *
     * @param courseCode Code of the course to be dropped
     * @param studentId  ID of the student
     * @return true if course dropped successfully, false otherwise
     * @throws SQLException
     */
    public boolean dropCourse(String courseCode, String studentId) throws SQLException;

    /**
     * Retrieves the list of available courses for a student.
     *
     * @param studentId ID of the student
     * @return List of available courses
     * @throws SQLException
     */
    public List<Course> viewCourses(String studentId) throws SQLException;

    /**
     * Retrieves the list of registered courses for a student.
     *
     * @param studentId ID of the student
     * @return List of registered courses
     * @throws SQLException
     */
    public List<Course> viewRegisteredCourses(String studentId) throws SQLException;

    /**
     * Calculates the total fee for a student.
     *
     * @param studentId ID of the student
     * @return Total fee for the student
     * @throws SQLException
     */
    public double calculateFee(String studentId) throws SQLException;

    /**
     * Checks if seats are available for a course.
     *
     * @param courseCode Code of the course
     * @return true if seats available, false otherwise
     * @throws SQLException
     */
    public boolean seatAvailable(String courseCode) throws SQLException;

    /**
     * Returns the number of courses a student is registered for.
     *
     * @param studentId ID of the student
     * @return Number of registered courses
     * @throws SQLException
     */
    public int numOfRegisteredCourses(String studentId) throws SQLException;

    /**
     * Checks if a student is already registered for a course.
     *
     * @param courseCode Code of the course
     * @param studentId  ID of the student
     * @return true if student is registered for the course, false otherwise
     * @throws SQLException
     */
    public boolean isRegistered(String courseCode, String studentId) throws SQLException;

    /**
     * Checks if the student's registration status is true.
     *
     * @param studentId ID of the student
     * @return true if registration status is true, false otherwise
     * @throws SQLException
     */
    public boolean getRegistrationStatus(String studentId) throws SQLException;

    /**
     * Checks if the student's payment status is true.
     *
     * @param studentId ID of the student
     * @return true if payment status is true, false otherwise
     * @throws SQLException
     */
    public boolean getPaymentStatus(String studentId) throws SQLException;

    /**
     * Sets the student's registration status to true.
     *
     * @param studentId ID of the student
     * @throws SQLException
     */
    public void setRegistrationStatus(String studentId) throws SQLException;

    /**
     * Retrieves the grade card for a student.
     *
     * @param studentId ID of the student
     * @return List of grades for the student
     * @throws SQLException
     */
    public List<Grade> viewGradeCard(String studentId) throws SQLException;

    /**
     * Checks if the student's report card has been generated.
     *
     * @param studentId ID of the student
     * @return true if report card has been generated, false otherwise
     * @throws SQLException
     */
    public boolean isReportGenerated(String studentId) throws SQLException;

    /**
     * Sets the student's payment status to true.
     *
     * @param studentId ID of the student
     * @throws SQLException
     */
    public void setPaymentStatus(String studentId) throws SQLException;
}
