package com.space.scanner.alien.service;

import java.util.List;

import javax.validation.Valid;

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
	
	public Long getPopulation(String race) {
		return alienRepository.countByPlanetAndRace(planet.getName(), race);
	}

	public Long getPopulation() {
		return alienRepository.countByPlanet(planet.getName());
	}

	public Alien createAlien(@Valid Alien newAlien) {
		newAlien.setPlanet(planet.getName());
		return alienRepository.save(newAlien);
		
	}

	public Alien getAlien(String id) {
		return alienRepository.findByPlanetAndIdQuery(planet.getName(), id);
	}

	public Alien updateAlien(String id, @Valid Alien newAlien) {
		return alienRepository.findByPlanetAndId(planet.getName(), id)
				.map(alien -> {
					alien.setName(newAlien.getName());
					alien.setRace(newAlien.getRace());
					return alienRepository.save(alien);
				})
				.orElseGet(() -> {
					System.out.println("put new with specified ID");
					newAlien.setId(id);
					newAlien.setPlanet(planet.getName());
					return alienRepository.save(newAlien);
				});
	}

	public void deleteAlien(String id) {
		alienRepository.deleteById(id);
	}
}
