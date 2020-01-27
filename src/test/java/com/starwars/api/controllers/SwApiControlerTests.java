package com.starwars.api.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.starwars.api.RestApiStarWarsAppApplicationTests;

public class SwApiControlerTests extends RestApiStarWarsAppApplicationTests {

	@Test
    public void testeListarPlanetasPorPagina() {
		UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme("http").host("localhost:" + porta)
			      .path("/swapi/planetas/").query("pagina={pagina}").buildAndExpand(2);
		
        ResponseEntity<String> getAllPlanetas = restTemplate.exchange(url.toString(),
            HttpMethod.GET, null, String.class);

        Assert.assertEquals(HttpStatus.OK, getAllPlanetas.getStatusCode());
        Assert.assertNotNull(getAllPlanetas.getBody());
    }
	
	@Test
    public void testeListarPlanetaPorId() {
		final String url = "http://localhost:" + porta + "/swapi/planeta/2";
		
        ResponseEntity<String> getAllPlanetas = restTemplate.exchange(url,
            HttpMethod.GET, null, String.class);

        Assert.assertEquals(HttpStatus.OK, getAllPlanetas.getStatusCode());
        Assert.assertNotNull(getAllPlanetas.getBody());
    }
	
	
}
