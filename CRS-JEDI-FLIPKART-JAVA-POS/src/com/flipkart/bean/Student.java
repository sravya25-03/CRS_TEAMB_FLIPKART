/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.constant.GenderConstant;
import com.flipkart.constant.RoleConstant;



public class Student extends User 
{
	private String department;
	private String studentId;
	private int gradYear;
	boolean isApproved;
	
	//Constructing User of a Student type.
	public Student(String userId, String name, RoleConstant role, String password, GenderConstant gender, String address,String branchName,String studentId,int batch,boolean isApproved) {
		super(userId, name, role, password,gender,address);
		this.department = branchName;
		this.studentId = studentId;
		this.gradYear = batch;
		this.isApproved = isApproved;
	}

	public Student() {
		
	}

	public String getDepartment() 
	{
		return department;
	}

	public void setDepartment(String department) 
	{
		this.department = department;
	}

	public String getStudentId() 
	{
		return studentId;
	}

	public void setStudentId(String studentId) 
	{
		this.studentId = studentId;
	}

	public int getGradYear() 
	{
		return gradYear;
	}

	public void setGradYear(int gradYear) 
	{
		this.gradYear = gradYear;
	}
		
	
}
