package com.projectzero.controller;
import java.util.List;

import com.projectzero.model.Car;
import com.projectzero.model.Customer;
import com.projectzero.service.CarService;

public class CarController {

	/*
	 * 
	 * The controller package acts a communication medium between the UI and the service package. 
	 * 
	 * There is a controller class for each table that exists in the database.
	 * 
	 * The Implementation for each method is described in the Corresponding DAO class.
	 */
	
	private CarService cs;

	public CarController() {
		this(new CarService());
	}

	public CarController(CarService cs) {
		super();
		this.cs = cs;
	}

	public List<Car> findAll(){
		return cs.findAll();
	}
	
	public Car findById(Integer i) {
		return cs.findById(i);
	}
	
	public Car update(Car t) {
		return cs.update(t);
	}
	
	public Car create(Car t) {
		return cs.create(t);
	}
	
	public int delete(Integer i) {
		return cs.delete(i);
	}
	
	public int makeOffer(Integer i, Customer c) {
		return cs.makeOffer(i,c);
	}
}