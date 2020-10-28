package com.dealership.service;

import java.util.List;

import com.dealership.models.Car;
import com.dealership.repository.CarDAO;

public class CarService {

	private CarDAO cd;
	
	public CarService() {
		this(new CarDAO());
	}
	
	public CarService(CarDAO cd) {
		this.cd = cd;
	}
	
	public List<Car> findAllCarsOnLot(){
		return cd.findAllOnLot();
	}
	
	public List<Car> findAllOwned(String username){
		return cd.findAllOwned(username);
	}
	
	public boolean addCarToTheLot(Car car) {
		return cd.create(car) != null;
	}
	
	public int removeCarFromLot(int cid) {
		return cd.delete(cid);
	}
}