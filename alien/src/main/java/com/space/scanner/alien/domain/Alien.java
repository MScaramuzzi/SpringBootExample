package com.space.scanner.alien.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Alien {
	@Id
	private String id;
	
	@NotNull
	@Size(min=3, message="Name should have at least 2 characters")
	private String name;
	
	@NotNull
	@Size(max=10, message="Race should have no more than 10 characters")
	private String race;
	
	// Set by Service with setter
	@Null
	private String planet;
	
	public Alien() {
	}
	
	@Override
	public String toString() {
		return String.format(
				"Alien[id=%s, name='%s', race='%s', planet='s']",
				id, name, race, planet);
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getPlanet() {
		return planet;
	}

	public void setPlanet(String planet) {
		this.planet = planet;
	}

}
