package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.core.Deserializer;
import info.tonyl.pokeapi.core.PokeApiCaller;
import info.tonyl.pokeapi.core.PokeApiInterface;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ApiResource<T> {
	@Setter
	private transient Class<T> resourceClass;

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
	public T resolve(PokeApiCaller caller) {
		// TODO: Throw exception if resourceClass isn't set
		return Deserializer.fromJson(caller.getByFullUrl(url), resourceClass);
	}

	public T resolve(PokeApiInterface api) {
		return resolve(api.getApiCaller());
	}
}
