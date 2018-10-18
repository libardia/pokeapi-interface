package info.tonyl.pokeapi.core;

import java.lang.reflect.Field;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.exceptions.ApiResourceScannerException;
import info.tonyl.pokeapi.exceptions.ResourceClassOnWrongTypeException;
import info.tonyl.pokeapi.models.ApiResource;

public class ApiResourceScanner {
	// Shut up Eclipse, I'm catching ClassCastExceptions.
	@SuppressWarnings("unchecked")
	public static <T> void scan(T obj) {
		// Loop through fields on the model
		for (Field f : obj.getClass().getDeclaredFields()) {
			// Get the ResourceClass annotation, and skip the following if there isn't one
			ResourceClass resourceClass = f.getAnnotation(ResourceClass.class);
			if (resourceClass != null) {
				try {
					// Get the value in the field
					f.setAccessible(true);
					Object value = f.get(obj);

					if (value instanceof ApiResource<?>) {
						// If it's a single resource, just set it based on the annotation. Also, don't
						// worry about exceptions, the catch will handle it.
						ApiResource<T> apiResource = (ApiResource<T>) value;
						apiResource.setResourceClass((Class<T>) resourceClass.value());
					} else if (value instanceof ApiResource<?>[]) {
						// If it's a resource array, set them one at a time. Who even cares about
						// exceptions?
						ApiResource<T>[] resourceArray = (ApiResource<T>[]) value;
						for (ApiResource<T> apiResource : resourceArray) {
							apiResource.setResourceClass((Class<T>) resourceClass.value());
						}
					} else {
						// If it isn't an ApiResource or an array of them, throw an exception explaining
						// it.
						throw new ResourceClassOnWrongTypeException(f);
					}
				} catch (ClassCastException | IllegalArgumentException | IllegalAccessException e) {
					// Here's where we care about exceptions.
					throw new ApiResourceScannerException(f, e);
				}
			}
		}
	}
}
