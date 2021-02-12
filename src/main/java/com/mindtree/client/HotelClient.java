package com.mindtree.client;

import java.util.Set;

import com.mindtree.entity.Room;
import com.mindtree.exception.clientException.HotelException;
import com.mindtree.exception.serviceException.HotelServiceException;
import com.mindtree.service.ServiceImplements;

public class HotelClient {
	public static void main(String args[]) throws HotelException {
		ServiceImplements obj = new ServiceImplements();
		boolean quit = true;
		do {
			System.out.println("==============================================");
			System.out.println("1>Add Hotel\n2>Add Room\n3>Display by type\n" + "4>Exit");
			int choice = ScannerValidate.getValidInt();
			try {
				switch (choice) {
				case 1:
					System.out.println("value for hotel inserted " + obj.addHotel());
					break;
				case 2:
					System.out.println("Enter for which hotel id u want to add");
					int id = ScannerValidate.getValidInt();
					System.out.println("value for room inserted " + obj.addRooms(id));
					break;
				case 3:

					try {

						Set<Room> rs = obj.display();
						System.out.println("Rooms for this hotel is");
						for (Room obj1 : rs) {
							System.out.println(
									obj1.getRoomNumber() + "  " + obj1.getType() + "  " + obj1.getCost() + "    "+obj1.getHotelId());
						}
					} catch (HotelServiceException e) {
						System.out.println(e);
					}
					break;
				case 4:
					quit = false;
					break;
				default:
					System.out.println("Invalied choice");

				}
			} catch (HotelException e) {
				System.out.println(e.getMessage());
			}

		} while (quit);

	}
}
