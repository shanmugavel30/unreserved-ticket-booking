package com.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dto.Admin;
import com.dto.Users;
import com.repo.BookingRepository;

public class LoginModel {
	private LoginView loginview;

	public LoginModel(LoginView loginview) {
		this.loginview=loginview;
	}

	public void checkAdmin(String name, String pass) {
		List<Admin>admin1=new ArrayList<>();
		admin1=BookingRepository.getInstance().getAdmin(name,pass);
		if(admin1==null) {
			loginview.adminFailure();
		}
		else {
			loginview.adminSuccess();
		}
	}

	public void checkUser(String userName, String pass) {
		Users user1;
		user1=BookingRepository.getInstance().getUser(userName,pass);
		
		if(user1==null) {
			loginview.userFailure();
		}
		else {
			loginview.userSuccess(user1.getId());
		}
	}
}
