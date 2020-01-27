package com.starwars.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starwars.api.model.Planeta;

/**
 * 
 * Classe para gerar o crud
 * do documento Planeta
 * no mondodb
 *
 */

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

	Planeta findByNome(String nome);
}
