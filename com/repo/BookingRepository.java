package com.repo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.dto.Admin;
import com.dto.Train;
import com.dto.Users;

public class BookingRepository {
	private static BookingRepository repInstance;
	private Map<Integer,Users>userList=new HashMap<>();
	private List<Admin>admin=new ArrayList<>();
	private Map<Integer,Train>train=new HashMap<>();
	public List<Integer>transactions=new LinkedList<>();
	public List<String>type=new LinkedList<>();
	public List<Integer>currAmount=new LinkedList<>();
	Train trainref;
	Users user;
	Admin adminref;
	
	private BookingRepository() {
		
	}
	
	public static BookingRepository getInstance() {
		if(repInstance==null) {
			repInstance=new BookingRepository();
			repInstance.setUsers();
	        repInstance.setAdmin();
	        repInstance.setTrains();
		}
		return repInstance;
	}

	private void setTrains() {
	    trainref=new Train(1, "chennaibeach", "besantnagar","29/03/23", "08:00:00",50,20);
	    train.put(1, trainref);
	    trainref=new Train(2, "chennaibeach", "rknagar","27/03/23", "09:00:00",50,30);
	    train.put(2, trainref);
	    
	}

	private void setAdmin() {
		adminref=new Admin("Admin", 00, "admin@gmail.com", "9876543200", "admin@00",100);
		admin.add(adminref);
	}

	private void setUsers() {
		user=new Users("kailash", 11, "kailash@gmail.com", "9876543210", 100,"kailash@11", "jzhkzrg34");
		userList.put(11, user);
		user=new Users("karthiga", 12, "karthiga@gmail.com", "9876543211", 90,"karthiga@12", "jsgsghfz53");
		userList.put(12, user);

	}

	public List<Admin> getAdmin(String name, String pass) {
		if(admin.get(0).getName().equalsIgnoreCase(name) && admin.get(0).getPassword().equalsIgnoreCase(pass)) {
			return admin;
		}
		return null;
	}

	public Users getUser(String userName, String pass) {
		System.out.println();
		for(Map.Entry<Integer, Users> entry:userList.entrySet()) {
			if(((entry.getValue().getUserName()).equalsIgnoreCase(userName)) && (entry.getValue().getPassword()).equalsIgnoreCase(pass)) {
				return entry.getValue();
			}
		}
		return null;
	}

	public void addTrain(int id, String source, String destination, String date, String time, int ticket,
			int distance) {
		trainref=new Train(id, source, destination,date, time,ticket,distance);
	    train.put(id, trainref);
	}

	public List<Train> getTrains() {
		List<Train> trainList=new ArrayList<>();
		for(Map.Entry<Integer,Train> entry:train.entrySet()) {
			trainList.add(entry.getValue());
		}
		return trainList;
	}

	public int getRevenue() {
		int revenue=admin.get(0).getRevenue();
		return revenue;
	}

	public int updateWallet(int id, int amountw) {
		if(userList.containsKey(id)) {
			userList.get(id).setWallet(userList.get(id).getWallet()+amountw);	
			type.add("wallet update");
			transactions.add(amountw);
			currAmount.add(userList.get(id).getWallet());
			return id;
		}
		return  0;
	}

	public int getTickets(int tid) {
		if(train.containsKey(tid)) {
			return train.get(tid).getTickets();
		}
		return 0;
	}

	public boolean deleteAccount(int id) {
		if(userList.containsKey(id)) {
			userList.remove(id);
			return true;
		}
		return false;
	}

	public int bookTickets(int tid, int n, int id) {
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/YY");
		DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("hh:mm:ss");
		String currdate=LocalDateTime.now().format(formatter);
		String currtime=LocalDateTime.now().format(formatter1);
		String tdate=train.get(tid).getDate();
		String ttime=train.get(tid).getTime();
		
		int date=Integer.parseInt(currdate.substring(0, 2));
		int ch=Integer.parseInt(currtime.substring(0, 2));
		int cm=Integer.parseInt(currtime.substring(3,5));
		
		int td=Integer.parseInt(tdate.substring(0, 2));
		int th=Integer.parseInt(ttime.substring(0, 2));
		int tm=Integer.parseInt(ttime.substring(3,5));
		
		//System.out.println(date+" "+h);
		
		if(date==td && (ch==(th-1) || (ch==th)) ){
			if((cm>tm && (ch==(th-1))) || ((cm<=tm) && (ch==th))) {
				if(train.containsKey(tid)) {
					int d=train.get(tid).getDistance();
					if(d>50) {
						int trate=25;
						int tamount=trate*n;
						userList.get(id).setWallet(userList.get(id).getWallet()-tamount);
						return tamount;
					}
					else if(d<5) {
						int trate=5;
						int tamount=trate*n;
						userList.get(id).setWallet(userList.get(id).getWallet()-tamount);
						return tamount;
					}
					
					else {
						int trate=d/2;
						int tamount=trate*n;
						userList.get(id).setWallet(userList.get(id).getWallet()-tamount);
						return tamount;
					}
				}
				
			}
		}
		
		return 0;
	}
}
