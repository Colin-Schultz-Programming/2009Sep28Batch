package com.projectzero.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.projectzero.controller.CarController;
import com.projectzero.controller.EmployeeController;
import com.projectzero.controller.OffersController;
import com.projectzero.controller.SellingHistoryController;
import com.projectzero.model.Employee;

public class EmployeeDealershipMenu {

	private SellingHistoryController shc = new SellingHistoryController();
	private CarController carCont = new CarController();
	private EmployeeController ec = new EmployeeController();
	private OffersController oc = new OffersController();
	static Logger LOGGER = Logger.getLogger(EmployeeDealershipMenu.class);
	
	public EmployeeDealershipMenu() {
		this(new EmployeeController());
	}
	
	public EmployeeDealershipMenu(EmployeeController ec) {
		super();
		this.ec = ec;
	}
	
	public void employeeDealershipMenu(Employee t, Scanner scan) {
		System.out.println("\n======================================================================================\n");
		System.out.println("\nWelcome to the Dealership, "+ t.getFirstName() + "!");
		System.out.println("What would you like to do?\n");
		System.out.println("1. View cars in the lot");
		System.out.println("2. View/Manage active car offers");
		System.out.println("3. Manage Staff");
		System.out.println("4. View Sold Cars");
		System.out.println("5. Register a car sale");
		System.out.println("6. Change a car's listed price");
		System.out.println("0. Logout");
		String select = scan.next();
		switch (select) {
		case "1":
			System.out.println(carCont.findAll().toString());
			employeeDealershipMenu(t, scan);
			break;
		case "2":
			if (t.getAccessLevel()!=10) {
				System.out.println("Access Denied");
				employeeDealershipMenu(t, scan);
				break;
			}else {
				System.out.println("What would you like to do?");
				System.out.println("1. View all offers");
				System.out.println("2. Accept an offer");
				System.out.println("3. Reject an offer");
				System.out.println("4. Return");
				String offerOption = scan.next();
				switch (offerOption) {
				case "1":
					System.out.println(oc.findAll().toString());
					employeeDealershipMenu(t,scan);
					break;
				case "2":
					System.out.println("Enter the ID of the car to sell");
					int chosenCar = scan.nextInt();
					carCont.delete(chosenCar);
					employeeDealershipMenu(t,scan);
					break;
				case "3":
					System.out.println("Enter the ID of the car offer to delete");
					int deleteCar = scan.nextInt();
					oc.delete(deleteCar);
					employeeDealershipMenu(t,scan);
					break;
				case "4":
					employeeDealershipMenu(t,scan);
					break;
				}
			}
			break;
		case "3":
			if (t.getAccessLevel()!=10) {
				System.out.println("Access Denied");
				employeeDealershipMenu(t, scan);
				break;
			}else {
				EmployeeController whynot = new EmployeeController();
				System.out.println("\nStaff Management Menu");
				System.out.println("1. View all staff");
				System.out.println("2. Fire a staff member");
				System.out.println("3. Register new staff member");
				System.out.println("4. Return");
				String staffScreenOption = scan.next();
				switch (staffScreenOption) {
				case "1":
					System.out.println(whynot.findAll().toString());
					employeeDealershipMenu(t, scan);
					break;
				case "2":
					System.out.println("input the employee number to delete from the system:");
					whynot.delete(scan.nextInt());
					employeeDealershipMenu(t,scan);
					break;
				case "3":
					whynot.create(t);
					employeeDealershipMenu(t,scan);
					break;
				case "4":
					employeeDealershipMenu(t,scan);
					break;
				}
		
			}	
			break;
		case "4":
			System.out.println("Displaying list of sold cars...");
			System.out.println(shc.findAll().toString());
			employeeDealershipMenu(t,scan);
			break;
		case "5":
			System.out.println("Enter the ID of the car to sell");
			carCont.delete(scan.nextInt());
			employeeDealershipMenu(t,scan);
			break;
		case "6":
			System.out.println("Enter the ID of the car to update");
			carCont.update(carCont.findById(scan.nextInt()));
			employeeDealershipMenu(t,scan);
			break;
		case "0":
			break;
		default:
			System.out.println("Invalid input format");
			employeeDealershipMenu(t,scan);
			break;
	}

}
}