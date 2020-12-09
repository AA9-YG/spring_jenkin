package com.hrsmvc.model;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	int roomNum;
	String bedType;
	double rate;
	String occupantName;
	char smoking;
	boolean occupied;
	
	public Room() {
		
	}
	
	public Room(String b, char s, double rr) {
		bedType = b;
		smoking = s;
		rate = rr;
		occupied = false;
	}
	
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String b) {
		bedType = b;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public char getSmoking() {
		return smoking;
	}
	public void setSmoking(char smoking) {
		this.smoking = smoking;
	}
	public String getOccupant() {
		return occupantName;
	}
	public void setOccupant(String o) {
		occupantName = o;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	@Override
	public String toString() {
		return roomNum + ":" + occupantName + ":" + bedType +
				":" + smoking + ":" + rate;
	}
}
