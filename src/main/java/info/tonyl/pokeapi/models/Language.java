package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Language {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("official")
	private Boolean official;

	@SerializedName("iso639")
	private String iso639;

	@SerializedName("iso3166")
	private String iso3166;

	@SerializedName("names")
	private Name[] names;
}
