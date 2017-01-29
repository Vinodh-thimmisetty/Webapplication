package com.mvc.service;

import java.util.HashMap;

import com.mvc.model.User;

public class LoginService {

	HashMap<String, String> loginInfo = new HashMap<>();
	 // it is for testing instead of fetching data from Database
	public LoginService() {
		loginInfo.put("vinodh", "Vinodh Kumar Thimmisetty");
		loginInfo.put("pavan", "Pavan Kumar Ventrapati");
		loginInfo.put("vadan", "Priyavadan Reddy");
	}

	public boolean authenticateUser(String userName, String password) {
		// connect to Data base and connect the details for this user
		if (password != null && password != "") {
			return true;
		}
		return false;

	}

	public User getUserDetails(String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setUserName(loginInfo.get(userId));
		return user;
	}
	
	public boolean validatePassword(String userId){
	return false;	
	}

}
