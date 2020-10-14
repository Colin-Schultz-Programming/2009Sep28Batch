package com.example.oop.abstraction;

public abstract class FirstAbstract {
	
	protected int age;
	
	protected abstract void screamInRampage();
	
	protected FirstAbstract() {
		super();
	}
	
	protected void print() {
		System.out.println("print");
	}
	
}