package info.tonyl.pokeapi.core;

import lombok.Getter;
import lombok.Setter;

public abstract class PokeApiCaller {
	// Default base URL
	public static final String DEFAULT_POKEAPI_BASE_URL = "https://pokeapi.co/api";

	@Getter
	@Setter
	private ApiVersion apiVersion = ApiVersion.v2;

	@Getter
	@Setter
	private String pokeApiBaseUrl = DEFAULT_POKEAPI_BASE_URL;

	public String get(String endpoint, String id) {
		return getByFullUrl(PokeApiCaller.makeFullUrl(pokeApiBaseUrl, apiVersion, endpoint, id));
	}

	public String get(String endpoint) {
		return getByFullUrl(PokeApiCaller.makeFullUrl(pokeApiBaseUrl, apiVersion, endpoint, ""));
	}

	public abstract String getByFullUrl(String url);

	public static String makeFullUrl(String baseUrl, ApiVersion apiVersion, String endpoint, String id) {
		baseUrl = cutSlashes(baseUrl);
		endpoint = cutSlashes(endpoint);
		id = cutSlashes(id);

		StringBuilder sb = new StringBuilder();

		sb.append(baseUrl);
		sb.append("/");
		sb.append(apiVersion);
		sb.append("/");
		sb.append(endpoint);
		sb.append("/");
		sb.append(id);

		if (!"".equals(id)) {
			sb.append("/");
		}

		return sb.toString();
	}

	private static String cutSlashes(String s) {
		if (s.startsWith("/")) {
			s = s.substring(1, s.length());
		}

		if (s.endsWith("/")) {
			s = s.substring(0, s.length() - 1);
		}

		return s;
	}
}
