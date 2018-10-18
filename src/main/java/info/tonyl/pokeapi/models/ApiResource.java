package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.core.Deserializer;
import info.tonyl.pokeapi.core.PokeApiCaller;
import info.tonyl.pokeapi.core.PokeApiInterface;
import info.tonyl.pokeapi.exceptions.UndefinedResourceClassException;
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

	public T resolve(PokeApiCaller caller) {
		if (resourceClass == null) {
			throw new UndefinedResourceClassException(this);
		}

		return Deserializer.fromJson(caller.getByFullUrl(url), resourceClass);
	}

	public <U> U resolve(PokeApiCaller caller, Class<U> classOfU) {
		return Deserializer.fromJson(caller.getByFullUrl(url), classOfU);
	}

	public T resolve(PokeApiInterface api) {
		return resolve(api.getApiCaller());
	}
}
