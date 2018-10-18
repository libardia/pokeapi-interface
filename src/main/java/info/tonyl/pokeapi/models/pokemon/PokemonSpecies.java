package info.tonyl.pokeapi.models.pokemon;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.evolution.EvolutionChain;
import info.tonyl.pokeapi.models.utility.ApiResource;
import info.tonyl.pokeapi.models.utility.Description;
import info.tonyl.pokeapi.models.utility.FlavorText;
import info.tonyl.pokeapi.models.utility.Name;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class PokemonSpecies {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("order")
	private Integer order;

	@SerializedName("gender_rate")
	private Integer genderRate;

	@SerializedName("capture_rate")
	private Integer captureRate;

	@SerializedName("base_happiness")
	private Integer baseHappiness;

	@SerializedName("is_baby")
	private Boolean isBaby;

	@SerializedName("hatch_counter")
	private Integer hatchCounter;

	@SerializedName("has_gender_differences")
	private Boolean hasGenderDifferences;

	@SerializedName("forms_switchable")
	private Boolean formsSwitchable;

	@SerializedName("growth_rate")
	@ResourceClass(GrowthRate.class)
	private ApiResource<GrowthRate> growthRate;

	@SerializedName("pokedex_numbers")
	private PokemonSpeciesDexEntry[] pokedexNumbers;

	@SerializedName("egg_groups")
	@ResourceClass(EggGroup.class)
	private ApiResource<EggGroup>[] eggGroups;

	@SerializedName("color")
	@ResourceClass(PokemonColor.class)
	private ApiResource<PokemonColor> color;

	@SerializedName("shape")
	@ResourceClass(PokemonShape.class)
	private ApiResource<PokemonShape> shape;

	@SerializedName("evolves_from_species")
	@ResourceClass(PokemonSpecies.class)
	private ApiResource<PokemonSpecies> evolvesFromSpecies;

	@SerializedName("evolution_chain")
	@ResourceClass(EvolutionChain.class)
	private ApiResource<EvolutionChain> evolutionChain;

	@SerializedName("habitat")
	@ResourceClass(PokemonHabitat.class)
	private ApiResource<PokemonHabitat> habitat;

	@SerializedName("generation")
	@ResourceClass(Generation.class)
	private ApiResource<Generation> generation;

	@SerializedName("names")
	private Name[] names;

	@SerializedName("pal_park_encounters")
	private PalParkEncounterArea[] palParkEncounters;

	@SerializedName("flavor_text_entries")
	private FlavorText[] flavorTextEntries;

	@SerializedName("form_descriptions")
	private Description[] formDescriptions;

	@SerializedName("genera")
	private Genus[] genera;

	@SerializedName("varieties")
	private PokemonSpeciesVariety[] varieties;

}