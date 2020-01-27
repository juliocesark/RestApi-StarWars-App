package com.starwars.api.model;

import java.util.List;

/**
 * 
 * Classe para mapamento de dados
 * especificos da api externa
 * do StarWars
 *
**/

public class PlanetaSwApi {

	private String name;
	private List<String> films;
	
	public PlanetaSwApi() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	
	
}