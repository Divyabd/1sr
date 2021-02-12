package com.mindtree.service;

import java.util.Set;

import com.mindtree.entity.Room;
import com.mindtree.exception.serviceException.HotelServiceException;

public interface Service {
	public boolean addHotel() throws HotelServiceException;
	public boolean addRooms(int id) throws HotelServiceException;
	public Set<Room> display() throws HotelServiceException;

}
