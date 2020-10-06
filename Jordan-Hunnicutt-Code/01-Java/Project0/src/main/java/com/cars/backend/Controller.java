package com.cars.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cars.model.Car;
/*
 * 		layers of project 0
 * 			UI
 * 				Gather input from the user
 * 				Display information to the user
 * 				Get actions from the user (I want to put an offer on a car)
 * 			Controller
 * 				Gather information from the UI
 * 				Use the data to communicate with service layer
 * 				Send information back to the UI
 * 				Send information to the Service layer
 * 			Service
 * 				Gather information from the Repository
 * 				Use the data to perform logic with the controller
 * 				Send information to the controller
 * 				Send information to the repository layer
 * 			Repository
 * 				Gather information from the service layer
 * 				Communicate with the database
 * 				send and gather information to/from the db
 * 
 * 			Model (accessible throughout) (what does the data look like? the other layers are about dataflow, this is about the actual data)
 * 				Provide classes meant to represent real world objects
 */
public class Controller {

	public static List<String> lotController() { //calls to the service class, puts car values into strings for ui
		
		List<String> carStrings = new ArrayList<>();
		
		System.out.println("I am the lot controller");
		
		Service.lotService();
		
		return carStrings;
	}
	
	
}