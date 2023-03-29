package com.login;

import java.util.Scanner;

import com.adminmod.AdminView;
import com.usermod.UserView;

public class LoginView {
	private LoginModel loginmodel;
	private Scanner scan=new Scanner(System.in);
	
	public LoginView() {
		loginmodel=new LoginModel(this);
	}

	public static void main(String[] args) {
		LoginView obj=new LoginView();
		obj.login();
	}

	public void login() {
		
		System.out.println("Welcome to unresrved train ticket booking website...!");
		System.out.println("There are two login available");
		System.out.println("\n1.Admin\n2.User\n3.Exit");
		System.out.println("\nEnter the option:");
		int opt=0;
		try {
			opt=Integer.parseInt(scan.nextLine());
		}catch(Exception e) {
			System.out.println("Please enter valid option");
			login();
		}
		if(opt==1) {
			System.out.println("Enter the admin name: ");
			String name=scan.next();
			System.out.println("Enter the admin password: ");
			String pass=scan.next();
			loginmodel.checkAdmin(name,pass);
		}
		else if(opt==2) {
			System.out.println("Enter the user name: ");
			String userName=scan.next();
			System.out.println("Enter the password: ");
			String pass=scan.next();
			
			loginmodel.checkUser(userName, pass);
		}
		else {
			System.out.println("You are exitted from our website...!");
		}
	}

	public void adminFailure() {
		System.out.println("You are enter the invalid password ...!");
		login();
	}

	public void adminSuccess() {
		System.out.println("Admin Loggedin successfully...!");
		AdminView ref=new AdminView();
		ref.adminChoices();
	}

	public void userFailure() {
		System.out.println("Please enter the valid password or username...! ");
		login();
	}

	public void userSuccess(int id) {
		System.out.println("User loggedin successfully...!");
		UserView ref=new UserView();
		ref.userChoices(id);
	}	

}
