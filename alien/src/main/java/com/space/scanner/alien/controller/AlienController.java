package com.space.scanner.alien.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.space.scanner.alien.domain.Alien;
import com.space.scanner.alien.service.AlienService;

@RestController
@RequestMapping("/aliens")
public class AlienController {
	@Autowired
	AlienService alienService;
	
	/* Only for demonstration purposes. 
	 * Not compliant with REST API style. Use POST instead!
	 */
	@GetMapping("/add") 
	public @ResponseBody String addAlien (
			@RequestParam String name,
			@RequestParam String race) {
		
		alienService.addAlien(name, race);
		return "Saved";
	}
	
	@GetMapping("") 
	public @ResponseBody List<Alien> getAliens (
			@RequestParam Optional<String> race) {
		
		if (race.isPresent())
			return alienService.getAliens(race.get());
		else
			return alienService.getAliens();
	}
	

}
