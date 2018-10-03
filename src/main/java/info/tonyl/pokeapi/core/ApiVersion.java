package info.tonyl.pokeapi.core;

public enum ApiVersion {
	V1, V2;

	public String toString() {
		switch (this) {
		case V1:
			return "v1";
		case V2:
			return "v2";
		default:
			return "v2";
		}
	}
}
