package info.tonyl.pokeapi.models.evolution;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.items.Item;
import info.tonyl.pokeapi.models.utility.ApiResource;
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