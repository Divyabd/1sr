package com.mindtree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.mindtree.client.ScannerValidate;
import com.mindtree.entity.Hotel;
import com.mindtree.entity.Room;
import com.mindtree.exception.daoException.DaoException;
import com.mindtree.exception.daoException.DattaBaseEmptyException;
import com.mindtree.utility.DatabaseConnection;

public class DaoImp implements Dao {

	public boolean addHotel() throws DaoException {
		boolean val = false;
		System.out.println("Enter the hotel id");
		int id = ScannerValidate.getValidInt();
		System.out.println("Enter the hotel name");
		ScannerValidate.scanner.nextLine();
		String name = ScannerValidate.getString();
		System.out.println("Enter the hotel city");
		String city = ScannerValidate.getString();
		Connection con = null;
		PreparedStatement pst = null;
		String sql = null;
		try {
			sql = "insert into hotel values(?,?,?)";
			con = DatabaseConnection.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, city);
			int i = pst.executeUpdate();
			System.out.println(i);
			if (i > 0) {
				System.out.println("How many rooms u want to add for this hotel");
				int n = ScannerValidate.getValidInt();
				for (int j = 0; j < n; j++) {
					System.out.println("room inserted : " + addRooms(id));
				}
				val = true;
			} else {
				val = false;
			}

		} catch (SQLException e) {
			e.getStackTrace();
		} 
		finally {
			DatabaseConnection.close(con, pst);
		}

		return val;
	}

	public boolean addRooms(int hId) throws DaoException {
		boolean val = false;
		System.out.println("Enter the Room id");
		int id = ScannerValidate.getValidInt();
		System.out.println("Enter the Room type");
		ScannerValidate.scanner.nextLine();
		String name = ScannerValidate.getRoomType();
		System.out.println("Enter the room cost");
		double city = ScannerValidate.getDouble();
		Connection con = null;
		PreparedStatement pst = null;
		String sql = null;
		try {
			sql = "insert into room values(?,?,?,?)";
			con = DatabaseConnection.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDouble(3, city);
			pst.setInt(4, hId);
			int i = pst.executeUpdate();
			System.out.println(i);
			if (i > 0) {
				val = true;
			} else {
				val = false;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			DatabaseConnection.close(con, pst);
		}
		return val;
	}

	public Set<Room> display() throws DaoException, DattaBaseEmptyException {
		Set<Room> rm = new LinkedHashSet<Room>();
		Set<Hotel> rm1 = new LinkedHashSet<Hotel>();
		System.out.println("Enter the hotel city");
		ScannerValidate.scanner.nextLine();
		String city = ScannerValidate.getString();
		Connection con = null;
		PreparedStatement pst = null;
		String sql = null;
		try {
			sql = "select * from hotel join room where city=? and room.id=hotel.id";
			con = DatabaseConnection.connect();
			pst = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pst.setString(1, city);
			ResultSet rs = pst.executeQuery();
			if (rs.next() == false) {
				throw new DattaBaseEmptyException("No recards found");
			}
			rs.previous();
			rs.next();
			System.out.println( " city  : " + rs.getString(3) );
			rs.previous();
			while (rs.next()) {

				rm.add((new Room(rs.getInt(4), rs.getString(5), rs.getDouble(6),rs.getInt(7))));
                rm1.add(new Hotel(rs.getInt(1),rs.getString(2), rs.getString(3), rm));
			}
		} catch (SQLException e) {
			e.getStackTrace();
		} finally {
			DatabaseConnection.close(con, pst);
		}
		return rm;
	}

}
