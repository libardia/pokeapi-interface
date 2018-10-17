package info.tonyl.pokeapi.core;

import info.tonyl.pokeapi.constants.PokeApiEndpoint;
import info.tonyl.pokeapi.models.Berry;
import lombok.Getter;
import lombok.Setter;

public class PokeApiInterface {
	@Getter
	@Setter
	private PokeApiCaller apiCaller;

	public PokeApiInterface() {
		// Empty
	}

	public PokeApiInterface(PokeApiCaller apiCaller) {
		this.apiCaller = apiCaller;
	}

	public <T> T get(Class<T> resourceType, String endpoint, int id) {
		return get(resourceType, endpoint, Integer.toString(id));
	}

	public <T> T get(Class<T> resourceType, String endpoint, String name) {
		String json = apiCaller.get(endpoint, name);
		return Deserializer.fromJson(json, resourceType);
	}

	public Berry getBerry(String name) {
		return get(Berry.class, PokeApiEndpoint.BERRY, name);
	}

	public Berry getBerry(int id) {
		return get(Berry.class, PokeApiEndpoint.BERRY, id);
	}
}
