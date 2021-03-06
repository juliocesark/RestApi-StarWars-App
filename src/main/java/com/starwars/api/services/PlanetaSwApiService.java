package com.starwars.api.services;

import java.util.Arrays;
import java.util.Map;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.starwars.api.model.PlanetaSwApiFilms;

/**
 * 
 * Serviço para API externa
 * do StarWars -> https://swapi.dev
 * 
 **/

@Service
public class PlanetaSwApiService {
	
	private CloseableHttpClient httpClient = HttpClients.custom()
            .setSSLHostnameVerifier(new NoopHostnameVerifier())
            .build();
	private HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	private RestTemplate restTemplate;
	private HttpHeaders headers = new HttpHeaders();
	private HttpEntity<String> entity;
	
	
	public PlanetaSwApiService() {
		this.requestFactory.setHttpClient(httpClient);
		this.restTemplate = new RestTemplate(requestFactory);
		this.headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		this.entity = new HttpEntity<String>(headers);
		
	}
	
	@Cacheable("planetasPorPagina")
	public Map<String, Object> listarPorPagina(int pagina) {
		 UriComponents swApiUrl = UriComponentsBuilder.newInstance()
			      .scheme("https").host("swapi.dev")
			      .path("/api/planets/").query("page={pagina}").buildAndExpand(pagina);
		 
		ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
				swApiUrl.toString(), HttpMethod.GET, entity, 
				new ParameterizedTypeReference<Map<String, Object>>() {});
		
		return response.getBody();
	}
	
	@Cacheable("planetasPorId")
	public Map<String, Object> listarPorId(int id) {
		 UriComponents swApiUrl = UriComponentsBuilder.newInstance()
			      .scheme("https").host("swapi.dev")
			      .path("/api/planets/{id}").buildAndExpand(id);
		 
		ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
				swApiUrl.toString(), HttpMethod.GET, entity, 
				new ParameterizedTypeReference<Map<String, Object>>() {});
		
		return response.getBody();
	}
	
	public PlanetaSwApiFilms listarPorNome(String nome) {
		UriComponents swApiUrl = UriComponentsBuilder.newInstance()
			      .scheme("https").host("swapi.dev")
			      .path("/api/planets/").query("search={nome}").buildAndExpand(nome);
	
		PlanetaSwApiFilms response = restTemplate.getForObject(swApiUrl.toString(), PlanetaSwApiFilms.class);
		return response;
	}
}
