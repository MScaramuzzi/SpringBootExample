package com.space.scanner.alien.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.space.scanner.alien.domain.Alien;

public interface AlienRepository extends MongoRepository<Alien, String> {
	public List<Alien> findByPlanet(String planet);
	public List<Alien> findByPlanetAndRace(String planet, String race);
	
	public Long countByPlanet(String planet);
	public Long countByPlanetAndRace(String planet, String race);
	
	@Query("{planet: ?0, id: ?1}")
	public Alien findByPlanetAndIdQuery(String planet, String id);
	public Optional<Alien> findByPlanetAndId(String planet, String id);
}
