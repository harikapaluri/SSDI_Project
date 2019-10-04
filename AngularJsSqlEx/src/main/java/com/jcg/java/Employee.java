package com.jcg.java;

public class Employee {

	public int emp_id;
	public String emp_name, emp_email, emp_gender;

	public Employee() {}

	public Employee(int id, String name, String email, String gender) {
		this.emp_id = id;
		this.emp_name = name;
		this.emp_gender = gender;
		this.emp_email = email;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}
}