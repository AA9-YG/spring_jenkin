package com.hrsmvc.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrsmvc.model.Room;
import com.hrsmvc.services.RoomService;

@RestController
public class RoomController {
	
	@Autowired
	private RoomService rService;
	
	@GetMapping("/rooms")
	public List<Room> getRooms() {
		return rService.listRooms();
	}
	
	@GetMapping("/rooms/{id}") 
	public ResponseEntity<Optional<Room>> get(@PathVariable Integer id) {
		try {
			Optional<Room> room1 = rService.getRoom(id);
			return new ResponseEntity<Optional<Room>>(room1, HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<Optional<Room>>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/rooms")
	public void add(@RequestBody Room room) {
		rService.saveRoom(room);
	}
	
	@PutMapping("/rooms/{id}") 
	public ResponseEntity<?> update(@RequestBody Room room, @PathVariable Integer id) {
		try {
			rService.saveRoom(room);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/rooms/{id}")
	public void delete(@PathVariable Integer id) {
		rService.deleteRoom(id);
	}
}
