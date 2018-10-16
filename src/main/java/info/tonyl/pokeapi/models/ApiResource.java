package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.core.GsonFactory;
import info.tonyl.pokeapi.core.PokeApiCaller;
import info.tonyl.pokeapi.core.PokeApiInterface;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ApiResource {
	@SerializedName("name")
	private String name;
	@SerializedName("url")
	private String url;

	/**
	 * Resolves the object referred to by this ApiResource.
	 * 
	 * @param api
	 *            The PokeApiCaller object to use when resolving.
	 * @return The object referred to by this resource.
	 */
	public <T> T resolve(PokeApiCaller caller, Class<T> resourceClass) {
		return GsonFactory.get().fromJson(resolve(caller), resourceClass);
	}

	public String resolve(PokeApiCaller caller) {
		return caller.getByFullUrl(url);
	}

	public <T> T resolve(PokeApiInterface api, Class<T> resourceClass) {
		return resolve(api.getApiCaller(), resourceClass);
	}

	public String resolve(PokeApiInterface api) {
		return resolve(api.getApiCaller());
	}
}
