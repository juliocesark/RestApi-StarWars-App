package com.starwars.api.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.starwars.api.RestApiStarWarsAppApplicationTests;
import com.starwars.api.model.Planeta;

public class ApiControllerTests extends RestApiStarWarsAppApplicationTests {

	@Test
	public void testeInserirDados() {
		final String urlBaseApi = "http://localhost:" + porta + "/api/planetas";
		
		Planeta planeta = new Planeta();
		planeta.setNome("Endor");
		planeta.setClima("temperate");
		planeta.setTerreno("forests, mountains, lakes");
		
		ResponseEntity<Planeta> postPlaneta = restTemplate.postForEntity(urlBaseApi, planeta, Planeta.class);
		
		Assert.assertEquals(HttpStatus.OK, postPlaneta.getStatusCode());
        Assert.assertNotNull(postPlaneta.getBody());
	}
	
	@Test
    public void testeListarTodos() {
		final String urlBaseApi = "http://localhost:" + porta + "/api/planetas";
		
        ResponseEntity<String> getAllPlanetas = restTemplate.exchange(urlBaseApi,
            HttpMethod.GET, null, String.class);

        Assert.assertEquals(HttpStatus.OK, getAllPlanetas.getStatusCode());
        Assert.assertNotNull(getAllPlanetas.getBody());
    }
	
	@Test
    public void testeListarPorNome() {
		UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme("http").host("localhost:" + porta)
			      .path("/api/planetas/").query("nome={nome}").buildAndExpand("Tatooine");
		
		ResponseEntity<Planeta> getPlaneta = restTemplate.getForEntity(
				url.toString(), Planeta.class);

		Assert.assertEquals(HttpStatus.OK, getPlaneta.getStatusCode());
        Assert.assertNotNull(getPlaneta.getBody());
    }
	
	@Test
    public void testeListarPorId() {
		final String urlBaseApi = "http://localhost:" + porta + "/api/planetas";
		UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme("http").host("localhost:" + porta)
			      .path("/api/planetas/").query("nome={nome}").buildAndExpand("Tatooine");
		
        Planeta getPlanetaPorNome = restTemplate.getForObject(url.toString(), Planeta.class);
        
        ResponseEntity<Planeta> getPlanetaPorId = restTemplate.getForEntity(
        		urlBaseApi + "/" + getPlanetaPorNome.getId(), Planeta.class);

        Assert.assertEquals(HttpStatus.OK, getPlanetaPorId.getStatusCode());
        Assert.assertNotNull(getPlanetaPorId.getBody());
    }
	
	@Test
    public void testeAtulizarDados() {
		final String urlBaseApi = "http://localhost:" + porta + "/api/planetas";
		UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme("http").host("localhost:" + porta)
			      .path("/api/planetas/").query("nome={nome}").buildAndExpand("Tatooine");
		
		Planeta planeta = restTemplate.getForObject(url.toString(), Planeta.class);
        planeta.setNome("Dagobah");
        planeta.setClima("murky");
        planeta.setTerreno("swamp, jungles");
        
        restTemplate.put(urlBaseApi + "/" + planeta.getId(), planeta);
		
		ResponseEntity<Planeta> planetaAtualizado = restTemplate.getForEntity(
        		urlBaseApi + "/" + planeta.getId(), Planeta.class);
		
		

		Assert.assertEquals(HttpStatus.OK, planetaAtualizado.getStatusCode());
        Assert.assertNotNull(planetaAtualizado.getBody());
    }
	
	@Test
    public void testeDeletarDados() {
		final String urlBaseApi = "http://localhost:" + porta + "/api/planetas";
		UriComponents url = UriComponentsBuilder.newInstance()
			      .scheme("http").host("localhost:" + porta)
			      .path("/api/planetas/").query("nome={nome}").buildAndExpand("Alderaan");
		
		ResponseEntity<Planeta> getPlaneta = restTemplate.getForEntity(
				url.toString(), Planeta.class);
		
		restTemplate.delete(urlBaseApi + "/" + getPlaneta.getBody().getId());
		
		ResponseEntity<Planeta> planetaDeletado = restTemplate.getForEntity(
        		urlBaseApi + "/" + getPlaneta.getBody().getId(), Planeta.class);

		Assert.assertEquals(HttpStatus.NOT_FOUND, planetaDeletado.getStatusCode());
    }
	
}
