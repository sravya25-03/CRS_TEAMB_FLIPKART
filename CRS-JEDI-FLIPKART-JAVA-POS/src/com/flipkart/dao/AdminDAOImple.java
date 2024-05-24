/**
 * DAO implementation class for Admin operations.
 */
package com.flipkart.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.GenderConstant;
import com.flipkart.constant.RoleConstant;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotFoundForApprovalException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotAddedException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.utils.DBUtils;

/**
 * DAO implementation class for Admin operations.
 */
public class AdminDAOImple implements AdminDAOInterface {

    private static volatile AdminDAOImple instance = null;
    private PreparedStatement statement = null;

    private AdminDAOImple() {
    }

    /**
     * Singleton method to get instance of AdminDAOImpl class
     */
    public static AdminDAOImple getInstance() {
        if (instance == null) {
            synchronized (AdminDAOImple.class) {
                instance = new AdminDAOImple();
            }
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();

    // Method to remove a course
    @Override
    public void removeCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException {
        statement = null;
        try {
            String sql = SQLQueriesConstant.DELETE_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, courseCode);
            int row = statement.executeUpdate();
            if (row == 0) {
                throw new CourseNotFoundException(courseCode);
            }
        } catch (SQLException se) {
            throw new CourseNotDeletedException(courseCode);
        }
    }

    // Method to add a course
    @Override
    public void addCourse(Course course) throws CourseExistsAlreadyException {
        statement = null;
        try {
            String sql = SQLQueriesConstant.ADD_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, course.getCourseCode());
            statement.setString(2, course.getCourseName());
            statement.setInt(3, course.getSeats());
            statement.setString(4, course.getInstructorId());
            statement.setInt(5, course.getCourseFee());
            int row = statement.executeUpdate();
            if (row == 0) {
                throw new CourseExistsAlreadyException(course.getCourseCode());
            }
        } catch (SQLException se) {
            throw new CourseExistsAlreadyException(course.getCourseCode());
        }
    }

    // Method to view pending admissions
    @Override
    public List<Student> viewPendingAdmissions() {
        statement = null;
        List<Student> userList = new ArrayList<Student>();
        try {
            String sql = SQLQueriesConstant.VIEW_PENDING_ADMISSION_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student user = new Student();
                user.setUserId(resultSet.getString(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRole(RoleConstant.stringToName(resultSet.getString(4)));
                user.setGender(GenderConstant.stringToGender(resultSet.getString(5)));
                user.setAddress(resultSet.getString(6));
                user.setStudentId(resultSet.getString(7));
                userList.add(user);
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return userList;
    }

    // Method to approve a student
    @Override
    public void approveStudent(String studentId) throws StudentNotFoundForApprovalException {
        statement = null;
        try {
            String sql = SQLQueriesConstant.APPROVE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, studentId);
            int row = statement.executeUpdate();
            if (row == 0) {
                throw new StudentNotFoundForApprovalException(studentId);
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    // Method to add a user
    @Override
    public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException {
        statement = null;
        try {
            String sql = SQLQueriesConstant.ADD_USER_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUserId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().toString());
            statement.setString(5, user.getGender().toString());
            statement.setString(6, user.getAddress());
            int row = statement.executeUpdate();
            if (row == 0) {
                throw new UserNotAddedException(user.getUserId());
            }
        } catch (SQLException se) {
            throw new UserIdAlreadyInUseException(user.getUserId());
        }
    }

    // Method to add a professor
    @Override
    public void addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException {
        try {
            this.addUser(professor);
        } catch (UserNotAddedException e) {
            throw new ProfessorNotAddedException(professor.getUserId());
        } catch (UserIdAlreadyInUseException e) {
            throw e;
        }
        statement = null;
        try {
            String sql = SQLQueriesConstant.ADD_PROFESSOR_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, professor.getUserId());
            statement.setString(2, professor.getDepartment());
            statement.setString(3, professor.getDesignation());
            int row = statement.executeUpdate();
            if (row == 0) {
                throw new ProfessorNotAddedException(professor.getUserId());
            }
        } catch (SQLException se) {
            throw new UserIdAlreadyInUseException(professor.getUserId());
        }
    }

    // Method to assign a course to a professor
    @Override
    public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException, UserNotFoundException {
        statement = null;
        try {
            String sql = SQLQueriesConstant.ASSIGN_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, professorId);
            statement.setString(2, courseCode);
            int row = statement.executeUpdate();
            if (row == 0) {
                throw new CourseNotFoundException(courseCode);
            }
        } catch (SQLException se) {
            throw new UserNotFoundException(professorId);
        }
    }

    // Method to view all courses
    public List<Course> viewCourses() {
        statement = null;
        List<Course> courseList = new ArrayList<>();
        try {
            String sql = SQLQueriesConstant.VIEW_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseCode(resultSet.getString(1));
                course.setCourseName(resultSet.getString(2));
                course.setInstructorId(resultSet.getString(3));
                courseList.add(course);
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return courseList;
    }

    // Method to view all professors
    @Override
    public List<Professor> viewProfessors() {
        statement = null;
        List<Professor> professorList = new ArrayList<Professor>();
        try {
            String sql = SQLQueriesConstant.VIEW_PROFESSOR_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Professor professor = new Professor();
                professor.setUserId(resultSet.getString(1));
                professor.setName(resultSet.getString(2));
                professor.setGender(GenderConstant.stringToGender(resultSet.getString(3)));
                professor.setDepartment(resultSet.getString(4));
                professor.setDesignation(resultSet.getString(5));
                professor.setAddress(resultSet.getString(6));
                professor.setRole(RoleConstant.PROFESSOR);
                professor.setPassword("*********");
                professorList.add(professor);
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return professorList;
    }

    public void setGeneratedReportCardTrue(String Studentid) {
        String sql1 = SQLQueriesConstant.SET_GENERATED_REPORT_CARD_TRUE;
        try {
            statement = connection.prepareStatement(sql1);
            statement.setString(1, Studentid);
            int row = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<RegisteredCourse> generateGradeCard(String Studentid) {
        List<RegisteredCourse> CoursesOfStudent = new ArrayList<RegisteredCourse>();
        try {
            String sql = SQLQueriesConstant.VIEW_REGISTERED_COURSES;
            statement = connection.prepareStatement(sql);
            statement.setString(1, Studentid);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                RegisteredCourse temp = new RegisteredCourse();
                course.setCourseCode(resultSet.getString(1));
                course.setCourseName(resultSet.getString(2));
                course.setInstructorId(resultSet.getString(3));
                course.setSeats(resultSet.getInt(4));
                temp.setCourse(course);
                temp.setstudentId(Studentid);
                temp.setGrade(resultSet.getString(8));
                CoursesOfStudent.add(temp);
            }
            String sql1 = SQLQueriesConstant.SET_GENERATED_REPORT_CARD_TRUE;
            statement = connection.prepareStatement(sql1);
            statement.setString(1, Studentid);
            int row = statement.executeUpdate();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return CoursesOfStudent;
    }
}
