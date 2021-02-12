package com.mindtree.entity;

import java.util.Set;

public class Hotel {
	private int id;
	private String  name;
	private String city;
	private Set<Room> rooms;
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Room> getRooms() {
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}
	
	public Hotel(int id, String name, String city, Set<Room> rooms) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.rooms = rooms;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
