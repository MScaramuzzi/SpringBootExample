package com.space.scanner.alien.bean;

public class Venus implements Planet {

	@Override
	public String getGreetings() {
		return "Yellow Planet!";
	}
	
	@Override
	public String getName() {
		return "venus";
	}

}
