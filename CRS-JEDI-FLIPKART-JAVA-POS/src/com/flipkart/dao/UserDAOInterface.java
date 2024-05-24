package com.flipkart.dao;

import com.flipkart.exception.UserNotFoundException;



public interface UserDAOInterface {
	

	public boolean verifyCredentials(String userId,String password) throws UserNotFoundException;

	public boolean updatePassword(String userID);

	public String getRole(String userId);

	public String getName(String userId);

	public boolean updatePassword(String userID,String newPassword);
}