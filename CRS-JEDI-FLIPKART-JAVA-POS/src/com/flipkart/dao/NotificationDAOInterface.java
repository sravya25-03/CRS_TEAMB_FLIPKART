/**
 * Interface for NotificationDAO.
 * Defines methods related to sending notifications.
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.constant.NotificationTypeConstant;
import com.flipkart.constant.PaymentModeConstant;

public interface NotificationDAOInterface {

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
    public int sendNotification(NotificationTypeConstant type, int studentId, PaymentModeConstant modeOfPayment, double amount) throws SQLException;

}

