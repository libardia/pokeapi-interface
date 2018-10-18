package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ContestEffect {
	@SerializedName("id")
	private Integer id;

	@SerializedName("appeal")
	private Integer appeal;

	@SerializedName("jam")
	private Integer jam;

	@SerializedName("effect_entries")
	private Effect[] effectEntries;

	@SerializedName("flavor_text_entries")
	private FlavorText[] flavorTextEntries;
}