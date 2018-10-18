package info.tonyl.pokeapi.models.evolution;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.items.Item;
import info.tonyl.pokeapi.models.pokemon.PokemonSpecies;
import info.tonyl.pokeapi.models.pokemon.Type;
import info.tonyl.pokeapi.models.utility.ApiResource;
import info.tonyl.pokeapi.models.utility.Location;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class EvolutionDetail {
	@SerializedName("item")
	@ResourceClass(Item.class)
	private ApiResource<Item> item;

	@SerializedName("trigger")
	@ResourceClass(EvolutionTrigger.class)
	private ApiResource<EvolutionTrigger> trigger;

	@SerializedName("gender")
	private Integer gender;

	@SerializedName("held_item")
	@ResourceClass(Item.class)
	private ApiResource<Item> heldItem;

	@SerializedName("known_move")
	@ResourceClass(Move.class)
	private ApiResource<Move> knownMove;

	@SerializedName("known_move_type")
	@ResourceClass(Type.class)
	private ApiResource<Type> knownMoveType;

	@SerializedName("location")
	@ResourceClass(Location.class)
	private ApiResource<Location> location;

	@SerializedName("min_level")
	private Integer minLevel;

	@SerializedName("min_happiness")
	private Integer minHappiness;

	@SerializedName("min_beauty")
	private Integer minBeauty;

	@SerializedName("min_affection")
	private Integer minAffection;

	@SerializedName("needs_overworld_rain")
	private Boolean needsOverworldRain;

	@SerializedName("party_species")
	@ResourceClass(PokemonSpecies.class)
	private ApiResource<PokemonSpecies> partySpecies;

	@SerializedName("party_type")
	@ResourceClass(Type.class)
	private ApiResource<Type> partyType;

	@SerializedName("relative_physical_stats")
	private Integer relativePhysicalStats;

	@SerializedName("time_of_day")
	private String timeOfDay;

	@SerializedName("trade_species")
	@ResourceClass(PokemonSpecies.class)
	private ApiResource<PokemonSpecies> tradeSpecies;

	@SerializedName("turn_upside_down")
	private Boolean turnUpsideDown;

}