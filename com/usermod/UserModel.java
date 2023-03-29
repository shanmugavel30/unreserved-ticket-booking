package com.usermod;

import java.util.Scanner;

import com.repo.BookingRepository;

public class UserModel {
	private UserView userview;
	
	public UserModel(UserView userview) {
		this.userview=userview;
	}

	public void updateWallet(int id, int amountw) {
		int uid=BookingRepository.getInstance().updateWallet(id,amountw);
		userview.updateSuccess(uid);
	}

	public void getTickets(int tid,int id) {
		int tickets=BookingRepository.getInstance().getTickets(tid);
		userview.showTickets(tickets,id);
	}

	public void deleteAccount(int id) {
		boolean flag=BookingRepository.getInstance().deleteAccount(id);
		if(flag) {
			userview.delSuccess();
		}
	}

	public void bookTickets(int tid, int n,int id) {
		int amount=BookingRepository.getInstance().bookTickets(tid,n,id);
		if(amount==0) {
			userview.bookFailure();
			
		}
		else {
			userview.bookSuccess(amount);
		}
	}
	
}
