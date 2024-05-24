package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBUtils;

/**
 * ProfessorDAOImple class provides the implementation for ProfessorDAOInterface
 */
public class ProfessorDAOImple implements ProfessorDAOInterface {

    private static volatile ProfessorDAOImple instance = null;

    private ProfessorDAOImple() {
    }

    /**
     * Method to get instance of ProfessorDAOImple
     *
     * @return ProfessorDAOImple instance
     */
    public static ProfessorDAOImple getInstance() {
        if (instance == null) {
            synchronized (ProfessorDAOImple.class) {
                instance = new ProfessorDAOImple();
            }
        }
        return instance;
    }

    /**
     * Method to get courses taught by a professor
     *
     * @param profId ID of the professor
     * @return List of courses taught by the professor
     */
    @Override
    public List<Course> getCoursesByProfessor(String profId) {
        Connection connection = DBUtils.getConnection();
        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_COURSES);
            statement.setString(1, profId);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                courseList.add(new Course(results.getString("courseCode"), results.getString("courseName"), results.getString("professorId"), results.getInt("seats"), results.getInt("courseFee")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(connection);
        }
        return courseList;
    }

    /**
     * Method to get enrolled students for a course
     *
     * @param courseId ID of the course
     * @return List of enrolled students for the course
     */
    @Override
    public List<EnrolledStudent> getEnrolledStudents(String courseId) {
        Connection connection = DBUtils.getConnection();
        List<EnrolledStudent> enrolledStudents = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_ENROLLED_STUDENTS);
            statement.setString(1, courseId);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                enrolledStudents.add(new EnrolledStudent(results.getString("courseCode"), results.getString("courseName"), results.getString("studentId")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(connection);
        }
        return enrolledStudents;
    }

    /**
     * Method to add grade for a student in a course
     *
     * @param studentId ID of the student
     * @param courseCode Code of the course
     * @param grade      Grade to be added
     * @return True if grade added successfully, false otherwise
     */
    @Override
    public Boolean addGrade(String studentId, String courseCode, String grade) {
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.ADD_GRADE);
            statement.setString(1, grade);
            statement.setString(2, courseCode);
            statement.setString(3, studentId);
            int row = statement.executeUpdate();
            return row == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(connection);
        }
        return false;
    }

    /**
     * Method to get professor's name by ID
     *
     * @param profId ID of the professor
     * @return Name of the professor
     */
    @Override
    public String getProfessorById(String profId) {
        String profName = null;
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.GET_PROF_NAME);
            statement.setString(1, profId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                profName = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.closeConnection(connection);
        }
        return profName;
    }
}
