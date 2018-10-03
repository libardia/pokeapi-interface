package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

public class BerryFirmness {
	@SerializedName("id")
	private Integer id;
	@SerializedName("name")
	private String name;
	@SerializedName("berries")
	private ApiResource<Berry>[] berries;
	@SerializedName("names")
	private Name[] names;
}
