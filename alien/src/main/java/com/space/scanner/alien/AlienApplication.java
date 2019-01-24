package com.space.scanner.alien;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.space.scanner.alien.bean.Mars;
import com.space.scanner.alien.bean.Planet;
import com.space.scanner.alien.bean.Venus;


@SpringBootApplication
public class AlienApplication {

	@Value("${app.planet}")
	private String planet;
	
	public static void main(String[] args) {
		SpringApplication.run(AlienApplication.class, args);
	}
	
	@Bean
	public Planet planet() {
		System.out.println("Landing planet: " + planet);
		
		switch (planet) {	
			case "mars": 	return new Mars(); 
			case "venus": 	return new Venus(); 
			
			default:		return new Mars(); 
		}
	}

}

