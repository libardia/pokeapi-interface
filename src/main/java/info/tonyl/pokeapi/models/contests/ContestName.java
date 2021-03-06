package info.tonyl.pokeapi.models.contests;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.utility.ApiResource;
import info.tonyl.pokeapi.models.utility.Language;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ContestName {
	@SerializedName("name")
	private String name;

	@SerializedName("color")
	private String color;

	@SerializedName("language")
	@ResourceClass(Language.class)
	private ApiResource<Language> language;

}