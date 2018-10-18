package info.tonyl.pokeapi.models.contests;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.models.utility.Effect;
import info.tonyl.pokeapi.models.utility.FlavorText;
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