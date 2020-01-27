package com.starwars.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.api.exception.PlanetaJaExisteException;
import com.starwars.api.exception.PlanetaNaoEncontradoException;
import com.starwars.api.model.Planeta;
import com.starwars.api.model.PlanetaSwApiFilms;
import com.starwars.api.repositories.PlanetaRepository;

/**
 * 
 * Serviço para dados do StarWars
 * 
 **/

@Service
public class PlanetaService {
	
	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Autowired
	private PlanetaSwApiService planetaSwApiService;

	public List<Planeta> listarTodos() {
		return this.planetaRepository.findAll();
	}

	public Planeta listarPorId(String id) throws PlanetaNaoEncontradoException {
		return this.planetaRepository.findById(id).orElseThrow(
				() -> new PlanetaNaoEncontradoException("Não existe planeta com esse id."));
	}
	
	public Planeta listarPorNome(String nome) {
		Planeta buscarPlaneta = this.planetaRepository.findByNome(nome);
		if (buscarPlaneta == null) {
			throw new PlanetaNaoEncontradoException("Não existe planeta com esse nome.");
		}
		
		return this.planetaRepository.findByNome(nome);
	}

	public Planeta cadastrar(Planeta planeta) {
		Planeta buscarPlaneta = this.planetaRepository.findByNome(planeta.getNome());
		if (buscarPlaneta != null) {
			throw new PlanetaJaExisteException("Já existe um planeta com esse nome.");
		}
		
		PlanetaSwApiFilms planetaSwApiFilms = this.planetaSwApiService.listarPorNome(planeta.getNome());
		if (planetaSwApiFilms.getResults().isEmpty()) {
			planeta.setAparicoesEmFilmes(0);
		} else {
			planeta.setAparicoesEmFilmes(planetaSwApiFilms.getResults()
					.get(0).getFilms().size());
		}
		
		return this.planetaRepository.save(planeta);
	}

	public Planeta atualizar(String id, Planeta planeta) {
		Planeta buscarPlanetaPorId = this.planetaRepository.findById(id).get();
		Planeta buscarPlanetaPorNome = this.planetaRepository.findByNome(planeta.getNome());
		if (buscarPlanetaPorNome != null) {
			if (!(buscarPlanetaPorNome.getNome().equals(buscarPlanetaPorId.getNome()))) {
				throw new PlanetaJaExisteException("Já existe um planeta com esse nome.");
			}
		}
		
		planeta.setId(id);
		PlanetaSwApiFilms planetaSwApiFilms = this.planetaSwApiService.listarPorNome(planeta.getNome());
		if (planetaSwApiFilms.getResults().isEmpty()) {
			planeta.setAparicoesEmFilmes(0);
		} else {
			planeta.setAparicoesEmFilmes(planetaSwApiFilms.getResults()
					.get(0).getFilms().size());
		}
		
		return this.planetaRepository.save(planeta);
	}

	public void remover(String id) {
		this.planetaRepository.deleteById(id);
	}

}
