package com.dto;

public class Train {

	private int trainId;
	private String source;
	private String destination;
	private String date;
	private String time;
	private int tickets;
	private int distance;
	
	
	public Train(int trainId, String source, String destination, String date, String time, int tickets,
			int distance) {
		super();
		this.trainId = trainId;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.tickets = tickets;
		this.distance = distance;
	}
	
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}

}
