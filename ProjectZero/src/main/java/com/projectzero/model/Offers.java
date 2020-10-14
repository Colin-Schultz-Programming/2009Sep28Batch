package com.projectzero.model;

import java.math.BigDecimal;

public class Offers {
	
	
	/**
	 * 
	 * The Offers class exists as a way of representing the data in the Offers table of our database.
	 * 
	 **/
	
	

	private int tagId;
	private BigDecimal price;
	private BigDecimal offerAmount;
	private String firstName;
	private String lastName;
	
	public Offers(int tagId, BigDecimal price, BigDecimal offerAmount, String firstName, String lastName) {
		super();
		this.tagId = tagId;
		this.price = price;
		this.offerAmount = offerAmount;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(BigDecimal offerAmount) {
		this.offerAmount = offerAmount;
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

	@Override
	public String toString() {
		return "Car ID: " + tagId + ", Listed Price:" + price + ", Offer Amount:" + offerAmount + "\n--------------------------------------------------------";
	}
	
}