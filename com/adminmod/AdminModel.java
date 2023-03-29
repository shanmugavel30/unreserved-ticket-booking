package com.adminmod;

import java.util.ArrayList;
import java.util.List;

import com.dto.Train;
import com.repo.BookingRepository;

public class AdminModel {
	private AdminView adminview;
	
	public AdminModel( AdminView adminview) {
		this.adminview=adminview;
	}

	public void addTrain(int id, String source, String destination, String date, String time, int ticket,
			int distance) {
		BookingRepository.getInstance().addTrain(id,source,destination,date,time,ticket,distance);
		adminview.addTrainSuccess();
	}

	public void getTrains() {
		List<Train>trains=new ArrayList<>();
		trains=BookingRepository.getInstance().getTrains();
		adminview.showTrains(trains);
	}

	public void getRevenue() {
		int revenue=BookingRepository.getInstance().getRevenue();
		adminview.showRevenue(revenue);
	}
}
