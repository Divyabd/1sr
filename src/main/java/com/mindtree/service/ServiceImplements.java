package com.mindtree.service;

import java.util.LinkedHashSet;
import java.util.Set;

import com.mindtree.dao.DaoImp;
import com.mindtree.entity.Room;
import com.mindtree.exception.daoException.DaoException;
import com.mindtree.exception.serviceException.HotelServiceException;

public class ServiceImplements implements Service {
	DaoImp obj = new DaoImp();

	public boolean addHotel() throws HotelServiceException {
		boolean result = false;
		try {
			result = obj.addHotel();
		} catch (DaoException e) {
			e.getStackTrace();
		}
		return result;
	}

	public boolean addRooms(int id) throws HotelServiceException {
		boolean result = false;
		try {
			result = obj.addRooms(id);
		} catch (DaoException e) {

			e.getStackTrace();
		}
		return result;

	}

	public Set<Room> display() throws HotelServiceException {
		Set<Room> ls = new LinkedHashSet<Room>();
		try {
			ls = obj.display();
		} catch (DaoException e) {
			e.getStackTrace();
			throw new HotelServiceException(e);
			//System.out.println(e);
		}
		return ls;
	}

}
