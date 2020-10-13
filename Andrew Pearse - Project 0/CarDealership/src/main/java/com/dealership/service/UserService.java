package com.dealership.service;

import com.dealership.models.User;
import com.dealership.repository.UserDAO;

public class UserService {

	private UserDAO ud;
	
	public UserService() {
		this(new UserDAO());
	}
	
	public UserService(UserDAO ud) {
		this.ud = ud;
	}
	
	public User validateUser(User user) {
		User checkedUser = ud.findById(user.getUserName());
		
		if (checkedUser == null) {
			return null;
		}
		
		if (checkedUser.getPassword().equals(user.getPassword())) {
			return checkedUser;
		}
				
		return null;
	}
	
	public boolean createCustomerAccount(User customer) {
		if(ud.create(customer) == null)
			return false;
		
		return true;
	}
	
	public boolean changePassword(User user) {
		User changedUser = ud.update(new User(user.getUserName(), user.getPassword(), null, null, null));
				
		if (changedUser == null)
			return false;
		
		return changedUser.getUserName().equals(user.getUserName());
	}
	
	public User findByID(String username) {
		return ud.findById(username);
	}
}