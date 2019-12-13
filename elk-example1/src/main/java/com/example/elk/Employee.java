package com.example.elk;

public class Employee {
	private Long empID;
	private String name;
	private String emailId;
	
	public Employee() {
		
	}
	public Employee(Long empID, String name, String emailId) {
		this.empID = empID;
		this.name = name;
		this.emailId = emailId;
	}
	
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
