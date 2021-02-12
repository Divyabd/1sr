package com.mindtree.dao;

import java.util.Set;

import com.mindtree.entity.Room;
import com.mindtree.exception.daoException.DaoException;
import com.mindtree.exception.daoException.DattaBaseEmptyException;

public interface Dao {
	public boolean addHotel() throws DaoException;
	public boolean addRooms(int id) throws DaoException;
	public Set<Room> display() throws DaoException, DattaBaseEmptyException;
}
