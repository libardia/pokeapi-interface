package info.tonyl.pokeapi.models.utility;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Effect {
	@SerializedName("effect")
	private String effect;

	@SerializedName("language")
	@ResourceClass(Language.class)
	private ApiResource<Language> language;
}