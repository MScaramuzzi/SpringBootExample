package com.space.scanner.alien.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.space.scanner.alien.domain.Alien;

public interface AlienRepository extends MongoRepository<Alien, String> {
	public List<Alien> findByPlanet(String planet);
	public List<Alien> findByPlanetAndRace(String planet, String race);
}
