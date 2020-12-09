package com.hrsmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrsmvc.model.Room;
import com.hrsmvc.services.RoomService;

@SpringBootTest
class HotelMvcApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	RoomService rService;
	
	@Test
	public void testAddRoom() {
		Room r1 = new Room("King", 'n', 100.50);
		r1.setOccupant("John");
		
		rService.saveRoom(r1);
	}
}
