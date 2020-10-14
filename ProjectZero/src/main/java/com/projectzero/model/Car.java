package com.projectzero.model;

import java.math.BigDecimal;

public class Car {
	
	/**
	 * 
	 * The car class exists as a way of representing the data in the cars table of our database.
	 * 
	 **/

	private int tagId;
	private BigDecimal year;
	private String make;
	private String model;
	private String color;
	private BigDecimal defaultPrice;
	private boolean existingOffer;
	
	/*
	 * GETTERS AND SETTERS
	 */
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public BigDecimal getYear() {
		return year;
	}
	public void setYear(BigDecimal year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public BigDecimal getDefaultPrice() {
		return defaultPrice;
	}
	public void setDefaultPrice(BigDecimal defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
	public boolean isExistingOffer() {
		return existingOffer;
	}
	public void setExistingOffer(boolean existingOffer) {
		this.existingOffer = existingOffer;
	}
	
	/*
	 * 
	 * TOSTRING() METHOD
	 */
	@Override
	public String toString() {
		return "\nTag ID: " + tagId + " Car: "+ color + " " + year  + " " + make +" "+ model + ", Listed Price: " + defaultPrice + "\n--------------------------------------------------------";
	}
	
	/*
	 * 
	 * CONSTRUCTORS
	 */
	public Car(int tagId, BigDecimal year, String make, String model, String color, BigDecimal defaultPrice, boolean existingOffer) {
		super();
		this.tagId = tagId;
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
		this.defaultPrice = defaultPrice;
		this.existingOffer = existingOffer;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}	
}