package com.starwars.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * Classe para erro de exceção
 * caso o planeta já exista
 *
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PlanetaJaExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlanetaJaExisteException(String msg) {
		super(msg);
	}
	
}
