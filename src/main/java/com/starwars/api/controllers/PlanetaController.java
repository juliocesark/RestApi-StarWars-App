package com.starwars.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.api.model.Planeta;
import com.starwars.api.services.PlanetaService;

/**
 * 
 * Rest para dados do StarWars
 * 
 **/

@RestController
@RequestMapping(path = "/api/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaService planetaService;
	
	@GetMapping
	public ResponseEntity<List<Planeta>> listarTodos() {
		
		return ResponseEntity.ok(this.planetaService.listarTodos());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Planeta> listarPorId(
			@PathVariable("id") String id) {
		
		return ResponseEntity.ok(this.planetaService.listarPorId(id));
	}
	
	@GetMapping(path = "/")
	public ResponseEntity<Planeta> listarPorNome(
			@RequestParam("nome") String nome) {
		
		return ResponseEntity.ok(this.planetaService.listarPorNome(nome));
	}
	
	@PostMapping
	public ResponseEntity<Planeta> cadastrar(
			@Valid @RequestBody Planeta planeta) {
		
		return ResponseEntity.ok(this.planetaService.cadastrar(planeta));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Planeta> atualizar(
			@PathVariable("id") String id, 
			@Valid @RequestBody Planeta planeta) {
		
		return ResponseEntity.ok(this.planetaService.atualizar(id, planeta));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> remover(
			@PathVariable("id") String id) {
		
		this.planetaService.remover(id);
		
		return ResponseEntity.ok("Deletado com sucesso!");
	}
}
