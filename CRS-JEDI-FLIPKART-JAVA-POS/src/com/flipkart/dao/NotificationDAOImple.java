/**
 * Implementation class for NotificationDAOInterface.
 * Handles operations related to sending notifications.
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.flipkart.constant.NotificationTypeConstant;
import com.flipkart.constant.PaymentModeConstant;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBUtils;

public class NotificationDAOImple implements NotificationDAOInterface {

    private static volatile NotificationDAOImple instance = null;

    private NotificationDAOImple() {
        // Private constructor to prevent instantiation.
    }

    /**
     * Singleton instance creation.
     *
     * @return Singleton instance of NotificationDAOImple
     */
    public static NotificationDAOImple getInstance() {
        if (instance == null) {
            synchronized (NotificationDAOImple.class) {
                if (instance == null) {
                    instance = new NotificationDAOImple();
                }
            }
        }
        return instance;
    }

    /**
     * Sends notification to a student.
     *
     * @param type          Type of notification
     * @param studentId     ID of the student
     * @param modeOfPayment Mode of payment for notification type PAYED
     * @param amount        Amount paid for notification type PAYED
     * @return ID of the sent notification
     * @throws SQLException If an SQL exception occurs
     */
    @Override
    public int sendNotification(NotificationTypeConstant type, int studentId, PaymentModeConstant modeOfPayment, double amount) throws SQLException {
        int notificationId = 0;
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(SQLQueriesConstant.INSERT_NOTIFICATION, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, studentId);
            ps.setString(2, type.toString());
            if (type == NotificationTypeConstant.PAYED) {
                UUID referenceId = addPayment(studentId, modeOfPayment, amount);
                ps.setString(3, referenceId.toString());
            } else {
                ps.setString(3, "");
            }
            ps.executeUpdate();
            ResultSet results = ps.getGeneratedKeys();
            if (results.next())
                notificationId = results.getInt(1);

            switch (type) {
                case REGISTRATION:
                    System.out.println("Registration successful. Administration will verify the details and approve it!");
                    break;
                case APPROVED:
                    System.out.println("Student with id " + studentId + " has been approved!");
                    break;
                case PAYED:
                    System.out.println("Student with id " + studentId + " fee has been paid");
            }

        } catch (SQLException ex) {
            throw ex;
        }
        return notificationId;
    }

    /**
     * Adds payment details to the database.
     *
     * @param studentId     ID of the student
     * @param modeOfPayment Mode of payment
     * @param amount        Amount paid
     * @return Reference ID of the payment
     * @throws SQLException If an SQL exception occurs
     */
    public UUID addPayment(int studentId, PaymentModeConstant modeOfPayment, double amount) throws SQLException {
        UUID referenceId;
        Connection connection = DBUtils.getConnection();
        try {
            referenceId = UUID.randomUUID();
            PreparedStatement statement = connection.prepareStatement(SQLQueriesConstant.INSERT_PAYMENT);
            statement.setInt(1, studentId);
            statement.setString(2, modeOfPayment.toString());
            statement.setString(3, referenceId.toString());
            statement.setDouble(4, amount);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }
        return referenceId;
    }

}
