/**
 * Interface for Admin Data Access Object (DAO) operations.
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

/**
 * Interface for Admin Data Access Object (DAO) operations.
 */
public interface AdminDAOInterface {

    /**
     * Method to view all courses.
     *
     * @return List of courses
     */
    public List<Course> viewCourses();

    /**
     * Method to view all professors.
     *
     * @return List of professors
     */
    public List<Professor> viewProfessors();

    /**
     * Method to set the generated report card flag to true for a student.
     *
     * @param studentId The ID of the student
     */
    public void setGeneratedReportCardTrue(String studentId);

    /**
     * Method to generate the grade card for a student.
     *
     * @param studentId The ID of the student
     * @return List of registered courses with grades
     */
    public List<RegisteredCourse> generateGradeCard(String studentId);

    /**
     * Method to view pending admissions.
     *
     * @return List of pending admissions
     */
    public List<Student> viewPendingAdmissions();

    /**
     * Method to approve a student.
     *
     * @param studentId The ID of the student
     * @throws StudentNotFoundForApprovalException If student is not found for approval
     */
    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException;

    /**
     * Method to add a professor.
     *
     * @param professor The professor object to add
     * @throws ProfessorNotAddedException     If professor is not added
     * @throws UserIdAlreadyInUseException    If user ID is already in use
     */
    public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;

    /**
     * Method to remove a course.
     *
     * @param courseCode The code of the course to remove
     * @throws CourseNotFoundException    If course is not found
     * @throws CourseNotDeletedException  If course is not deleted
     */
    public void removeCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException;

    /**
     * Method to add a course.
     *
     * @param course The course object to add
     * @throws CourseExistsAlreadyException If course already exists
     */
    public void addCourse(Course course) throws CourseExistsAlreadyException;

    /**
     * Method to assign a course to a professor.
     *
     * @param courseCode  The code of the course to assign
     * @param professorId The ID of the professor to assign the course to
     * @throws CourseNotFoundException If course is not found
     * @throws UserNotFoundException   If user is not found
     */
    public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException, UserNotFoundException;

    /**
     * Method to add a user.
     *
     * @param user The user object to add
     * @throws UserNotAddedException      If user is not added
     * @throws UserIdAlreadyInUseException If user ID is already in use
     */
    public void addUser(User user) throws UserNotA
