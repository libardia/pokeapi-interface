package info.tonyl.pokeapi.core;

import com.google.gson.Gson;

public class GsonFactory {
	private static Gson gson;

	public static Gson get() {
		if (gson == null) {
			gson = new Gson();
		}

		return gson;
	}
}
