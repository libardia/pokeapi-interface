package info.tonyl.pokeapi.models.evolution;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.pokemon.PokemonSpecies;
import info.tonyl.pokeapi.models.utility.ApiResource;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ChainLink {
	@SerializedName("is_baby")
	private Boolean isBaby;

	@SerializedName("species")
	@ResourceClass(PokemonSpecies.class)
	private ApiResource<PokemonSpecies> species;

	@SerializedName("evolution_details")
	private EvolutionDetail[] evolutionDetails;

	@SerializedName("evolves_to")
	private ChainLink[] evolvesTo;

}