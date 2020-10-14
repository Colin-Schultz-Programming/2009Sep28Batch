package com.projectzero.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.projectzero.config.EnvironmentConnectionUtil;
import com.projectzero.model.Customer;
import com.projectzero.model.SellingHistory;

public class SellingHistoryDao implements DaoContract<SellingHistory, Integer> {
	
	/**
	 * 
	 * The CarDao class implements the DaoContract, and allows us to implement methods between the tables within our database and the Objects in our application.
	 **/
	
	public SellingHistoryDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SellingHistory> findAll() {
		List<SellingHistory> soldCars = new LinkedList<>();
		String sqlQuery = "select * from sold_cars";
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
			//ps.setString(1, "sold_cars");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				soldCars.add(new SellingHistory(rs.getInt(1), rs.getBigDecimal(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getString(7), rs.getString(8), rs.getBigDecimal(9), rs.getBigDecimal(10), rs.getBigDecimal(11)));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return soldCars;
	}

	@Override
	public SellingHistory findById(Integer i) {
		SellingHistory findSoldCar = null;
		String sqlQuery = "select * from sold_cars where tag_id = ?";
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				findSoldCar = new SellingHistory(rs.getInt(1), rs.getBigDecimal(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getString(7), rs.getString(8), rs.getBigDecimal(9), rs.getBigDecimal(10), rs.getBigDecimal(11));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return findSoldCar;
	}

	@Override
	public SellingHistory update(SellingHistory t) {
		String updatingValue = null;
		BigDecimal updateValueTo = null;
		Scanner whatToUpdate = new Scanner(System.in) ;
		System.out.println("What would you like to update?\n");
		System.out.println("1. Monthly Payment");
		System.out.println("2. Remaining Balance");
		System.out.println("0: Exit");
		switch(whatToUpdate.nextLine()) {
		case "1":
			updatingValue = "monthly_payment";
			System.out.println("Set new monthly payment: ");
			updateValueTo = whatToUpdate.nextBigDecimal();
		case "2":
			updatingValue = "remaining_balance";
			System.out.println("Set new remaining balance: ");
			updateValueTo = whatToUpdate.nextBigDecimal();
		case "0":
			break;
		default:
			System.out.println("Invalid response. Try again.");
			update(t);
		}
		String sqlQuery = "update sold_cars set ? = ? where tag_id = ?";
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
			ps.setString(1, updatingValue);
			ps.setBigDecimal(2, updateValueTo);
			ps.setInt(3, t.getTagId());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//whatToUpdate.close();
		System.out.println("\nPayment information updated.");
		return t;
	}

	@Override
	public SellingHistory create(SellingHistory t) {
		Scanner carSold = new Scanner(System.in);
		String sqlQuery = "call sell_car(?,?,?,?,?,?,?)";
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){	
			
			try {
			
			System.out.println("\nEnter car's tag ID: ");
			ps.setInt(1, carSold.nextInt());
			System.out.println("\nEnter Sell Price: ");
			ps.setBigDecimal(2, carSold.nextBigDecimal());
			System.out.println("\nEnter first name of customer: ");
			ps.setString(3, carSold.nextLine());
			System.out.println("\nEnter last name of customer: ");
			ps.setString(4, carSold.nextLine());
			System.out.println("\nEnter down Payment: ");
			ps.setBigDecimal(5, carSold.nextBigDecimal());
			System.out.println("\nEnter monthly payment: ");
			ps.setBigDecimal(6, carSold.nextBigDecimal());
			System.out.println("\nEnter Remaining balance: ");
			ps.setBigDecimal(7, carSold.nextBigDecimal());
			
			}catch (InputMismatchException e) {
				System.out.println("Invalid format Entered. Please try again.\n");
				create(t);
			}
			ps.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		//carSold.close();
		System.out.println("\nSuccessfully sold car from the lot\n");
		return t;
	}

	@Override
	public int delete(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<String> getCustomerCars(Customer cust){
		ArrayList<String> customerCars = new ArrayList<String>();
		String sqlQuery = "select pull_a_customers_cars(?,?)";
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
			ps.setString(1, cust.getFirstName());
			ps.setString(2, cust.getLastName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customerCars.add(rs.getString(1)+"\n     ---------------------------\n");     //rs.getInt(1), rs.getBigDecimal(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBigDecimal(6), rs.getString(7), rs.getString(8), rs.getBigDecimal(9), rs.getBigDecimal(10), rs.getBigDecimal(11)));
			}
			rs.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return customerCars;	
	}
	
	public SellingHistory makePayment(SellingHistory t) {
		String sqlQuery = "update sold_cars set remaining_balance = (remaining_balance - monthly_payment) where tag_id = ?";
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection(); PreparedStatement ps = conn.prepareStatement(sqlQuery)){
			ps.setInt(1, t.getTagId());
			ps.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\nPayment information updated.");
		return t;
	}

}