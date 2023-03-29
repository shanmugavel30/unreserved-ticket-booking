package com.adminmod;

import java.util.List;
import java.util.Scanner;

import com.dto.Train;
import com.login.LoginView;

public class AdminView {
	private AdminModel adminmodel;
	private Scanner scan=new Scanner(System.in);
	
	public AdminView() {
		adminmodel=new AdminModel(this);
	}

	public void adminChoices() {
		System.out.println("Thera are 4 choices for admin...!");
		System.out.println("\n1.add train\n2.Train schedule\n3.check revenue\n4.logout");
		LoginView ref=new LoginView();
		int opt=0;
		try {
			opt=Integer.parseInt(scan.nextLine());
		}catch(Exception e) {
			System.out.println("Please enter valid option");
			adminChoices();
		}
		
		if(opt==1) {
			System.out.println("Enter the train id: ");
			int id=scan.nextInt();
			System.out.println("Enter the source: ");
			String source=scan.next();
			System.out.println("Enter the destination: ");
			String destination=scan.next();
			System.out.println("Enter the date: ");
			String date =scan.next();
			System.out.println("Enter the time: ");
			String time =scan.next();
			System.out.println("Enter the tickets:");
			int ticket=scan.nextInt();
			System.out.println("Enter the distance:");
			int distance=scan.nextInt();
			adminmodel.addTrain(id,source,destination,date,time,ticket,distance);
		}
		else if(opt==2) {
			adminmodel.getTrains();
		}
		else if(opt==3) {
			adminmodel.getRevenue();
		}
		else if(opt==4) {
			System.out.println("Logged out successfully...!");
			System.out.println("You are navigated to the home page...!");			
			ref.login();
		}
		else {
			System.out.println("You are navigated to the home page...!");
			ref.login();
		}
	}

	public void addTrainSuccess() {
		System.out.println("Train added successfully...!");
		adminChoices();
	}

	public void showTrains(List<Train> trains) {
		System.out.printf("%10s %20s %20s %20s %20s %20s","Train id","Source","Destination","Date","Time","Distance");
		System.out.println();
		for(int i=0;i<trains.size();i++) {
			System.out.printf("%10s %20s %20s %20s %20s %20s",trains.get(i).getTrainId(),trains.get(i).getSource(),trains.get(i).getDestination(),trains.get(i).getDate(),trains.get(i).getTime(),trains.get(i).getTickets(),trains.get(i).getDistance());
			System.out.println();
		}
	}

	public void showRevenue(int revenue) {
		System.out.println("Total revenue for admin is  "+revenue);
	}
	
	
}
