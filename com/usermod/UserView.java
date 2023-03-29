package com.usermod;

import java.util.Scanner;

import com.login.LoginView;

public class UserView {
	private UserModel usermodel;
	private Scanner scan=new Scanner(System.in);
	
	public UserView() {
		usermodel=new UserModel(this);
	}

	public void userChoices(int id) {
		System.out.println("Welcome to user  page...!");
		System.out.println("There are 6 options available for users");
		System.out.println("\n1.Book train\n2.Update wallet\n3.Transactions\n4.Show availTicket\n5.Delete account\n6.Logout");
		System.out.println("\nEnter your option: ");
		int opt=scan.nextInt();
		if(opt==1) {
			System.out.println("Enter the train id: ");
			int tid=scan.nextInt();
			System.out.println("Enter the enter the number of tickets: ");
			int n=scan.nextInt();
			usermodel.bookTickets(tid,n,id);
			
		}
		else if(opt==2) {
			System.out.println("Enter the amount to put into the wallet: ");
			int amountw=scan.nextInt();
			usermodel.updateWallet(id,amountw);
		}
		else if(opt==4) {
			System.out.println("Enter the train id: ");
			int tid=scan.nextInt();
			usermodel.getTickets(tid,id);
		}
		else if(opt==5) {
			usermodel.deleteAccount(id);
		}
		else {
			System.out.println("You are exitted from the user page...!");
			LoginView ref=new LoginView();
			ref.login();
		}
	}

	public void updateSuccess(int uid) {
		System.out.println("Your wallet updated successfully");
		userChoices(uid);
	}

	public void showTickets(int tickets, int id) {
		System.out.println("The available tickets for this  train is: "+tickets);
		userChoices(id);
	}

	public void delSuccess() {
		System.out.println("Your account deleted successfully..#");
		LoginView ref=new LoginView();
		ref.login();
	}

	public void bookFailure() {
		System.out.println("You can't book  the train at this time...!");
		LoginView ref=new LoginView();
		ref.login();
	}

	public void bookSuccess(int amount) {
		System.out.println("Ticket booked  successfully");
		System.out.println("Your total ticket amount is: "+amount);
		LoginView ref=new LoginView();
		ref.login();
	}
	
}
