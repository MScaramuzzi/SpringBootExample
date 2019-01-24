package com.space.scanner.alien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.space.scanner.alien.bean.Planet;
import com.space.scanner.alien.domain.Alien;
import com.space.scanner.alien.repository.AlienRepository;


@Service
public class AlienService {
	@Autowired
	private AlienRepository alienRepository;
	
	@Autowired
	Planet planet;
	
	public void addAlien(String name, String race) {
		Alien a = new Alien();
		a.setName(name);
		a.setRace(race);
		a.setPlanet(planet.getName());
		alienRepository.save(a);
	}
	
	public List<Alien> getAliens() {
		return alienRepository.findByPlanet(planet.getName());
	}
	
	public List<Alien> getAliens(String race) {
		return alienRepository.findByPlanetAndRace(planet.getName(), race);
	}
}
