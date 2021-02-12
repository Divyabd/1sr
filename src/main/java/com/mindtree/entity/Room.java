package com.mindtree.entity;

public class Room {
	private int roomNumber;
	private String type;
	private double cost;
	private int hotelId;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(int roomNumber, String type, double cost,int hotelId) {
		super();
		this.roomNumber = roomNumber;
		this.type = type;
		this.cost = cost;
		this.hotelId=hotelId;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	

}
