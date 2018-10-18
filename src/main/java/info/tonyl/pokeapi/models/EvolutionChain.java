package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class EvolutionChain {
	@SerializedName("id")
	private Integer id;

	@SerializedName("baby_trigger_item")
	@ResourceClass(Item.class)
	private ApiResource<Item> babyTriggerItem;

	@SerializedName("chain")
	private ChainLink chain;

}