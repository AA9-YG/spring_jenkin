package com.hrsmvc.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
	
	int hotelID;
	String name;
	String location;
	int occupiedCnt = 0;
	int numOfRoom = 0;
	
	List<Room> rooms = new ArrayList<Room>();

	private final int NOT_FOUND = -1;
	
	public Hotel() {
		
	}
	
	public Hotel(String n, String l) {
		name = n;
		location = l;
	}
	
	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getOccupiedCnt() {
		return occupiedCnt;
	}

	public void setOccupiedCnt(int occupiedCnt) {
		this.occupiedCnt = occupiedCnt;
	}

	public List<Room> getRooms() {
		return rooms;
	}
	public void addRoom(String b, char s, double r) {
		Room r1 = new Room(b,s,r);
		rooms.add(r1);
		numOfRoom++;
	}
	
	public void addReservation(String oName, char s, String b) {
		String printOutput = "Reservation was unsuccessful";
		for(Room room: rooms) {
			if(!room.isOccupied() && room.getSmoking() == s 
					&& room.getBedType().equals(b)) {
				room.setOccupant(oName);
				room.setOccupied(true);
				occupiedCnt++;
				printOutput = "Reservation was successful";
			}
		}
		System.out.println(printOutput);
	}
	
	public int findReservation(String oName) {
		for(int i = 0; i < rooms.size(); i++) {
			if(rooms.get(i).getOccupant().equals(oName) && rooms.get(i).isOccupied()) {
				return i;
			}
		}
		return NOT_FOUND;
	}
	
	public void cancelReservation(String oName) {
		String printOutput = "Cancellation was unsuccessful";
		
		int index = findReservation(oName);
		if(index == -1)
			System.out.println(printOutput);
		else {
			rooms.get(index).occupied = false;
			occupiedCnt--;
			System.out.println("Reservation cancelled. Occupied count: " + occupiedCnt);
		}
	}
	
	public double getDailySales() {
		double total = 0;
		for(Room room: rooms) {
			if(room.isOccupied()) {
				total += room.rate;
			}
		}
		return total;
	}
	
	public String occupancyPercentage() {
		DecimalFormat percentPattern = new DecimalFormat("#00%");
		
		double percentage = occupiedCnt / numOfRoom;
		return percentPattern.format(percentage);
	}

	public boolean isFull() {
		return occupiedCnt == numOfRoom;
	}
	
	public boolean isEmpty() {
		return occupiedCnt == 0;
	}
	
	public void printReservationList() {
		for (Room room : rooms) {
			if(room.isOccupied()) {
				System.out.println("Room number: " + room.getRoomNum() 
						+ "\nOccupant name: " + room.getOccupant() 
						+ "\nSmoking room: " + room.getSmoking() 
						+ "\nBed Type: " + room.getBedType() 
						+ "\nRate: " + room.getRate());
			}
		}
	}
	@Override
	public String toString() {
		return hotelID + ":" + name + ":" + location + ":" + 
				occupiedCnt + ":" + numOfRoom;
	}
}
