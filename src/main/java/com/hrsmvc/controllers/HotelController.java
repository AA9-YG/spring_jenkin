package com.hrsmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrsmvc.model.Hotel;
import com.hrsmvc.services.HotelService;

@Controller
public class HotelController {
	@RequestMapping("/")
	public String welcome() {
		// Forward request to model and get some data
		return "index"; // this is a view name
	}
	
	@Autowired
	HotelService hService; 
	
	@RequestMapping("/list_hotel")
	public String listHotel(Model model) {
		List<Hotel> list = hService.listHotel();
		model.addAttribute("hotels", list); // The html page can get details
		
		return "hotel";	// Name of the thymeleaf or html file or jsp under template folder
	}
}
