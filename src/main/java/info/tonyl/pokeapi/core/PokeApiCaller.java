package info.tonyl.pokeapi.core;

public interface PokeApiCaller {
	String getByUrl(String url);

	String getByEndpoint(String endpoint);
}
