package info.tonyl.pokeapi.core;

import com.google.gson.Gson;

public class Deserializer {
	private static Gson gson;

	private static Gson makeSingletonGson() {
		if (gson == null) {
			gson = new Gson();
		}

		return gson;
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		T obj = makeSingletonGson().fromJson(json, classOfT);
		ApiResourceScanner.scan(obj);
		return obj;
	}
}
