/**
 * 
 */
package com.flipkart.bean;


import java.util.Date;

import com.flipkart.constant.GenderConstant;
import com.flipkart.constant.RoleConstant;

public class Professor extends User {
	private String professorID;
	private String department;
	private String designation;
	
	
	public Professor(String userID) {
		super(userID);
	}
	public Professor(String userID, String name, GenderConstant gender, RoleConstant role, String password, String address) {
		super(userID, name, role, password, gender, address);
	}
	public Professor() {
		// TODO Auto-generated constructor stub
	}

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
}
