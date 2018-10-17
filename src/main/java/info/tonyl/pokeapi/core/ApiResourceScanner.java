package info.tonyl.pokeapi.core;

import java.lang.reflect.Field;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.exceptions.ApiResourceScannerException;
import info.tonyl.pokeapi.exceptions.ResourceClassDoesNotMatchException;
import info.tonyl.pokeapi.exceptions.ResourceClassOnWrongTypeException;
import info.tonyl.pokeapi.models.ApiResource;

public class ApiResourceScanner {
	// Shut up Eclipse, I'm catching ClassCastExceptions.
	@SuppressWarnings("unchecked")
	public static <T> void scan(T obj) {
		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field f : fields) {
			ResourceClass rc = f.getAnnotation(ResourceClass.class);
			Object value = null;

			if (rc != null) {
				// Get the value in the field
				try {
					value = f.get(obj);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new ApiResourceScannerException(f, e);
				}

				// Make an ApiResource out of it (throw ClassCastException if it isn't, and
				// we'll throw our own in response)
				ApiResource<T> ar = null;
				try {
					ar = (ApiResource<T>) value;
				} catch (ClassCastException e) {
					throw new ResourceClassOnWrongTypeException(f, e);
				}

				// Try to set the class, throw an exception if T doesn't match
				try {
					ar.setResourceClass((Class<T>) rc.value());
				} catch (ClassCastException e) {
					throw new ResourceClassDoesNotMatchException(f, e);
				}
			}
		}
	}
}
