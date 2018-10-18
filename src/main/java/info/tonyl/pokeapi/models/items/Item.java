package info.tonyl.pokeapi.models.items;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.evolution.EvolutionChain;
import info.tonyl.pokeapi.models.utility.ApiResource;
import info.tonyl.pokeapi.models.utility.GenerationGameIndex;
import info.tonyl.pokeapi.models.utility.MachineVersionDetail;
import info.tonyl.pokeapi.models.utility.Name;
import info.tonyl.pokeapi.models.utility.VerboseEffect;
import info.tonyl.pokeapi.models.utility.VersionGroupFlavorText;
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