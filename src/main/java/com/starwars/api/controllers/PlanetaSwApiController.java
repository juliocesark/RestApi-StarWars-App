package com.starwars.api.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.api.services.PlanetaSwApiService;

/**
 * 
 * Rest para consumo da API externa
 * do StarWars -> https://swapi.dev
 *
 **/

@RestController
@RequestMapping("/swapi")
public class PlanetaSwApiController {

	@Autowired
	private PlanetaSwApiService service;
	
	@GetMapping(path = "/planetas/")
	public ResponseEntity<Map<String, Object>> listarPorPagina(
			@RequestParam("pagina") int pagina) {
		
		return ResponseEntity.ok(this.service.listarPorPagina(pagina));
	}
	
	@GetMapping(path = "/planeta/{id}")
	public ResponseEntity<Map<String, Object>> listarPorId(
			@PathVariable("id") int id) {
		
		return ResponseEntity.ok(this.service.listarPorId(id));
	}
}