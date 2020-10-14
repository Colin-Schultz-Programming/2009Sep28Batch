package com.projectzero.model;

public class Employee {
	
	
	/**
	 * 
	 * The Employee class exists as a way of representing the data in the Employees table of our database.
	 * 
	 **/
	
	
	
	private int employeeId;
	private String firstName;
	private String lastName;
	private String username;
	private String pass;
	private int accessLevel;
	
	
	public Employee(int employeeId, String firstName, String lastName, String username, String pass, int accessLevel) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.pass = pass;
		this.accessLevel = accessLevel;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "Employee ID: " + employeeId + ", Name: " + firstName + lastName+ ", Login Username: " + username + ", Password: " + pass + "\n--------------------------------------------------------";
	}
	
}