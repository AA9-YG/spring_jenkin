package com.hrsmvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsmvc.model.Room;
import com.hrsmvc.repos.RoomRepo;

@Service
public class RoomService {

	@Autowired
	RoomRepo rRepo;
	
	public List<Room> listRooms() {
		return rRepo.findAll(); 
	}
	
	public void saveRoom(Room r) {
		rRepo.save(r);
	}
	
	public Optional<Room> getRoom(int id) {
		return rRepo.findById(id);
	}
	
	public void deleteRoom(int id) {
		rRepo.deleteById(id);
	}
}
