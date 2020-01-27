package com.starwars.api.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

/**
 * 
 * Classe para mapeamento do
 * documento Planeta no mongodb
 * para a api do starwars
 *
**/

@Document
public class Planeta {

	@Id
	private String id;
	
	@NotBlank(message = "{nome.not.blank}")
	private String nome;
	
	@NotBlank(message = "{clima.not.blank}")
	private String clima;
	
	@NotBlank(message = "{terreno.not.blank}")
	private String terreno;
	
	private Integer aparicoesEmFilmes;

	public Planeta() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getAparicoesEmFilmes() {
		return aparicoesEmFilmes;
	}

	public void setAparicoesEmFilmes(Integer aparicoesEmFilmes) {
		this.aparicoesEmFilmes = aparicoesEmFilmes;
	}
	
	
}
