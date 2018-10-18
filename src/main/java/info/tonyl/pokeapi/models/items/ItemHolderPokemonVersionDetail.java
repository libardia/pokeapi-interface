package info.tonyl.pokeapi.models.items;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.games.Version;
import info.tonyl.pokeapi.models.utility.ApiResource;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ItemHolderPokemonVersionDetail {
	@SerializedName("rarity")
	private String rarity;

	@SerializedName("version")
	@ResourceClass(Version.class)
	private ApiResource<Version> version;

}