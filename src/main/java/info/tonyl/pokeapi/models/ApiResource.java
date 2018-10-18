package info.tonyl.pokeapi.models;

import com.google.gson.JsonSyntaxException;
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

	/**
	 * Resolves this object by contacting PokeAPI, returning the deserialized object
	 * of the given class.<br/>
	 * In most cases, <code>resolve(caller)</code> should be used instead, but if
	 * PokeAPI has returned an unnamed API resource or if the type of the resource
	 * is unknown, this method can be used to resolve the reference.
	 * 
	 * @param caller
	 *            The PokeApiCaller object to use to contact PokeAPI.
	 * @param classOfU
	 *            The class U to attempt deserialization into.
	 * @return The deserialized object of type U returned by PokeAPI.
	 * @throws JsonSyntaxException
	 *             if the JSON returned by PokeAPI is not a valid representation of
	 *             an object of type U.
	 */
	public <U> U resolve(PokeApiCaller caller, Class<U> classOfU) {
		return Deserializer.fromJson(caller.getByFullUrl(url), classOfU);
	}

	/**
	 * Resolves this object by contacting PokeAPI, returning the deserialized object
	 * of the given class. Calling this method is equivalent to calling
	 * <code>resolve(api.getApiCaller(), classOfU)</code>.<br/>
	 * In most cases, <code>resolve(api)</code> should be used instead, but if
	 * PokeAPI has returned an unnamed API resource or if the type of the resource
	 * is unknown, this method can be used to resolve the reference.
	 * 
	 * @param api
	 *            The PokeApiInteface object to use to contact PokeAPI.
	 * @param The
	 *            class to attempt deserialization into (U).
	 * @return The deserialized object of type U returned by PokeAPI.
	 * @throws JsonSyntaxException
	 *             if the JSON returned by PokeAPI is not a valid representation of
	 *             an object of type U.
	 */
	public <U> U resolve(PokeApiInterface api, Class<U> classOfU) {
		return resolve(api.getApiCaller(), classOfU);
	}

	/**
	 * Resolves this object by contacting PokeAPI, returning the deserialized object
	 * of the type specified by this object's type parameter T.
	 * 
	 * @param caller
	 *            The PokeApiCaller object to use to contact PokeAPI.
	 * @return The deserialized object of type T (this object's type parameter)
	 *         returned by PokeAPI.
	 * @throws UndefinedResourceClassException
	 *             if the resourceClass of this object is set to <code>null</code>.
	 * @throws JsonSyntaxException
	 *             if the JSON returned by PokeAPI is not a valid representation of
	 *             an object of type T.
	 */
	public T resolve(PokeApiCaller caller) {
		if (resourceClass == null) {
			throw new UndefinedResourceClassException(this);
		}

		return resolve(caller, resourceClass);
	}

	/**
	 * Resolves this object by contacting PokeAPI, returning the deserialized object
	 * of the type specified by this object's type parameter T. Calling this method
	 * is equivalent to calling <code>resolve(api.getApiCaller())</code>.
	 * 
	 * @param api
	 *            The PokeApiCaller object to use to contact PokeAPI.
	 * @return The deserialized object of type T (this object's type parameter)
	 *         returned by PokeAPI.
	 * @throws UndefinedResourceClassException
	 *             if the resourceClass of this object is set to <code>null</code>.
	 * @throws JsonSyntaxException
	 *             if the JSON returned by PokeAPI is not a valid representation of
	 *             an object of type T.
	 */
	public T resolve(PokeApiInterface api) {
		return resolve(api.getApiCaller());
	}
}
