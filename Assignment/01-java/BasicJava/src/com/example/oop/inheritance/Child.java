package com.example.oop.inheritance;

public class Child extends Parent{
	
	
	//static block
	static {
		System.out.println("in the child static block");
	}
	
	//instance block
	{
		System.out.println("in the child instance block");
	}
	
	
	public int age = 12;
	private String firstName;
	private double height;
	
	public Child() {
		super();
		System.out.println("Child Constructor");

	}




	public Child(int age, String firstName, String lastName, double height) {
		super(age, firstName, lastName, height);
	}




	public int getAge() {
		return age;
	}
	public String getFirstName() {
		return firstName;
	}
	public double getHeight() {
		return height;
	}
	private void setAge(int age) {
		this.age = age;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private void setHeight(double height) {
		this.height = height;
	}
	
	

}