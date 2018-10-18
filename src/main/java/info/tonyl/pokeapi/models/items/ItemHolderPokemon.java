package info.tonyl.pokeapi.models.items;

import com.google.gson.annotations.SerializedName;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ItemHolderPokemon {
	@SerializedName("pokemon")
	private String pokemon;

	@SerializedName("version_details")
	private ItemHolderPokemonVersionDetail[] versionDetails;

}