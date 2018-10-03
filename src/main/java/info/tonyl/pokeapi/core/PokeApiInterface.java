package info.tonyl.pokeapi.core;

import info.tonyl.pokeapi.models.Berry;
import lombok.Getter;
import lombok.Setter;

public class PokeApiInterface {
	public static final String POKEAPI_BASE_URL = "https://pokeapi.co/api";

	@Getter
	@Setter
	private ApiVersion apiVersion;

	@Getter
	private PokeApiCaller apiCaller;

	public PokeApiInterface(PokeApiCaller apiCaller) {
		this.apiCaller = apiCaller;
	}

	public Berry getBerry(int id) {
		// TODO: getBerry(int)
		return null;
	}

	public Berry getBerry(String name) {
		// TODO: getBerry(string)
		return null;
	}

	public String makeUrl(String baseurl, String endpoint) {
		StringBuilder sb = new StringBuilder();

		sb.append(baseurl);

		if (!baseurl.endsWith("/")) {
			sb.append("/");
		}

		sb.append(apiVersion.toString());
		sb.append("/");
		sb.append(endpoint);

		if (!endpoint.endsWith("/")) {
			sb.append("/");
		}

		return sb.toString();
	}
}
