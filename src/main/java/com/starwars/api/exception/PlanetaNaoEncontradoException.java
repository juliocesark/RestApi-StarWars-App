package com.starwars.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * Classe para erro de exceção
 * caso o planeta não seja encontrado
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlanetaNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PlanetaNaoEncontradoException(String msg) {
		super(msg);
	}
	
}
