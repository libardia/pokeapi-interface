package info.tonyl.pokeapi.core.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import info.tonyl.pokeapi.core.PokeApiCaller;

public class PokeApiCallerSpring extends PokeApiCaller {
	private RestTemplate rest = new RestTemplate();

	@Override
	public String getByFullUrl(String url) {
		// Make the request and set headers (PokeApi requires "User-Agent" header)
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Agent", "PokeApiCallerSpring");
		HttpEntity<String> req = new HttpEntity<>(headers);

		// Make the call
		ResponseEntity<String> resp = rest.exchange(url, HttpMethod.GET, req, String.class);

		// Get the body from the response
		return resp.getBody();
	}
}
