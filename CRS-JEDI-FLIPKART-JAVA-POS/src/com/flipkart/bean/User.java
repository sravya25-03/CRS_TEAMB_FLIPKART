/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.constant.GenderConstant;
import com.flipkart.constant.RoleConstant;


public abstract class User {
	private String userId;
	private String name;
	private GenderConstant gender;
	protected RoleConstant role;
	private String password;
	private String address;
	
	public User(String userId) {
		this.userId = userId;
	}
	public User(String userId, String name,RoleConstant role,String password ,GenderConstant gender, String address) {
		this.userId = userId;
		this.name = name;
		this.gender = gender;
		this.role = role;
		this.password = password;
		this.address = address;
	}

	public User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GenderConstant getGender() {
		return gender;
	}

	public void setGender(GenderConstant gender) {
		this.gender = gender;
	}

	public RoleConstant getRole() {
		return role;
	}

	public void setRole(RoleConstant role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	
	
}
