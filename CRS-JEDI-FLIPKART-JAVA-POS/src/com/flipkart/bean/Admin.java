package com.flipkart.bean;

import java.util.Date;

import com.flipkart.constant.GenderConstant;
import com.flipkart.constant.RoleConstant;

/**
 * @author Group-A
 * Aaryan Pawar
 * Harsh Garg
 * Pulkit Bhargava
 * Rudra Tiwari
 * Shruti Sharma
 * Vedant Patel
 *
 */

public class Admin extends User
{
		
		private String adminID;
	
		public Admin(String userID, String name, GenderConstant gender, RoleConstant role, String password, String address) 
		{
			super(userID, name, role, password, gender, address);
		}	

		
		
}
