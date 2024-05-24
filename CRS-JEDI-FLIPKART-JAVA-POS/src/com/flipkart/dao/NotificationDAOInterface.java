/**
 * 
 */
package com.flipkart.dao;

import java.sql.SQLException;

import com.flipkart.constant.NotificationTypeConstant;
import com.flipkart.constant.PaymentModeConstant;



public interface NotificationDAOInterface {

	public int sendNotification(NotificationTypeConstant type,int studentId,PaymentModeConstant modeOfPayment,double amount) throws SQLException;
	
}
