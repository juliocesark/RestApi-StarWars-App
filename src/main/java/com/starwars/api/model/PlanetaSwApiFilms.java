package com.starwars.api.model;

import java.util.List;

/**
 * 
 * Classe para mapeamento
 * de dado especifico da
 * api externa do starwars
 *
 */

public class PlanetaSwApiFilms {

	private List<PlanetaSwApi> results;
	
	public PlanetaSwApiFilms() {}

	public List<PlanetaSwApi> getResults() {
		return results;
	}

	public void setResults(List<PlanetaSwApi> results) {
		this.results = results;
	}
	
}
