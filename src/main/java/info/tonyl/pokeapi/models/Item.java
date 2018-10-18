package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Item {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("cost")
	private Integer cost;

	@SerializedName("fling_power")
	private Integer flingPower;

	@SerializedName("fling_effect")
	@ResourceClass(ItemFlingEffect.class)
	private ApiResource<ItemFlingEffect> flingEffect;

	@SerializedName("attributes")
	@ResourceClass(ItemAttribute.class)
	private ApiResource<ItemAttribute>[] attributes;

	@SerializedName("category")
	private ItemCategory category;

	@SerializedName("effect_entries")
	private VerboseEffect[] effectEntries;

	@SerializedName("flavor_text_entries")
	private VersionGroupFlavorText[] flavorTextEntries;

	@SerializedName("game_indices")
	private GenerationGameIndex[] gameIndices;

	@SerializedName("names")
	private Name[] names;

	@SerializedName("sprites")
	private ItemSprites sprites;

	@SerializedName("held_by_pokemon")
	private ItemHolderPokemon[] heldByPokemon;

	@SerializedName("baby_trigger_for")
	@ResourceClass(EvolutionChain.class)
	private ApiResource<EvolutionChain> babyTriggerFor;

	@SerializedName("machines")
	private MachineVersionDetail[] machines;

}