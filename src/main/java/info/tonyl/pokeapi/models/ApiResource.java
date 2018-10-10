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
public class ApiResource<T> {
	// CONSTRUCTOR -- We must have the class for gson to read it in resolve().
	public ApiResource(Class<T> resourceType) {
		this.resourceClass = resourceType;
	}

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
		String json = caller.getByFullUrl(url);
		return GsonFactory.get().fromJson(json, resourceClass);
	}

	public T resolve(PokeApiInterface api) {
		return resolve(api.getApiCaller());
	}
}
