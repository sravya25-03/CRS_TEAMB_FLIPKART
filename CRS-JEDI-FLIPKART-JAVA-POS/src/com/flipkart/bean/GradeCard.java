package com.flipkart.bean;

import java.util.List;

public class GradeCard 
{
	Student stud;
	int sem;
	float cgpa;
	List<RegisteredCourse> reg_list ;
	
	/*public float calCGPA()
	{
		return 0;
	}*/


	public Student getStud() {
		return stud;
	}

	public void setStud(Student stud) {
		this.stud = stud;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	public List<RegisteredCourse> getReg_list() {
		return reg_list;
	}

	public void setReg_list(List<RegisteredCourse> reg_list) {
		this.reg_list = reg_list;
	}
	
	
}
