package com.projectzero.ui;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.projectzero.controller.CustomerController;
import com.projectzero.model.Customer;

public class CustomerMenu {
	
	private CustomerController cc;
	private CustomerDealershipMenu cdm = new CustomerDealershipMenu(cc);
	static Logger LOGGER = Logger.getLogger(CustomerMenu.class);
	
	public CustomerMenu() {
		this(new CustomerController());
	}
	
	public CustomerMenu(CustomerController cc) {
		super();
		this.cc = cc;
	}
	
	public String customerMenu (Scanner scan) {
		String userId = null;
		String password = null;
		System.out.println("\n======================================================================================\n");
		System.out.println("\nWhat would you like to do?");
		System.out.println("1. Login to existing customer account");
		System.out.println("2. Register new customer account");
		System.out.println("0. Return to Main Menu");
		String selection = scan.next();
		switch(selection) {
		case "1":
			System.out.println("Enter your Username:");
			userId = scan.next();
			System.out.println("Enter your password:");
			password = scan.next();
			try {
				if (cc.findById(cc.findIdByLogin(userId)).getPassword().equalsIgnoreCase(password)){
					LOGGER.info("Employee number "+ cc.findIdByLogin(userId) + " logged into the system.");
					cdm.customerDealershipMenu(cc.findById(cc.findIdByLogin(userId)), scan);
					break;
				}
			}catch (NullPointerException e) {
				System.out.println("Invalid Login Credentials");
				customerMenu(scan);
			}
			break;
		case "2":
			Customer newCustomer = new Customer();
			cc.create(newCustomer);
			customerMenu(scan);
			break;
		case "0":
			return null;
		default:
			System.out.println("Invalid entry");
			customerMenu(scan);
		}
		return null;
	}	
}