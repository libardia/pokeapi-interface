package info.tonyl.pokeapi.models.pokemon;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.utility.ApiResource;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Pokemon {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("base_experience")
	private Integer baseExperience;

	@SerializedName("height")
	private Integer height;

	@SerializedName("is_default")
	private Boolean isDefault;

	@SerializedName("order")
	private Integer order;

	@SerializedName("weight")
	private Integer weight;

	@SerializedName("abilities")
	private PokemonAbility[] abilities;

	@SerializedName("forms")
	@ResourceClass(PokemonForm.class)
	private ApiResource<PokemonForm>[] forms;

	@SerializedName("game_indices")
	private VersionGameIndex[] gameIndices;

	@SerializedName("held_items")
	private PokemonHeldItem[] heldItems;

	@SerializedName("location_area_encounters")
	private String locationAreaEncounters;

	@SerializedName("moves")
	private PokemonMove[] moves;

	@SerializedName("sprites")
	private PokemonSprites sprites;

	@SerializedName("species")
	@ResourceClass(PokemonSpecies.class)
	private ApiResource<PokemonSpecies> species;

	@SerializedName("stats")
	private PokemonStat[] stats;

	@SerializedName("types")
	private PokemonType[] types;
}