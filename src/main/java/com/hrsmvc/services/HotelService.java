package com.hrsmvc.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.hrsmvc.model.*;

@Service
public class HotelService {

	public List<Hotel> listHotel() {
		//  Static way of returning hotel list
		List<Hotel> hList = new ArrayList<Hotel>();
		hList.add(new Hotel("C'Mon Inn", "Fargo"));
		hList.add(new Hotel("Clubhouse Hotel & Suites", "Fargo"));
		hList.add(new Hotel("Holiday Inn", "Fargo"));
	
		return hList;
		//return hRepo.findAll();	// return list of object to contoller
	}
}
