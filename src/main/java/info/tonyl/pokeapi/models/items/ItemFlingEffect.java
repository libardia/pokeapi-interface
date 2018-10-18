package info.tonyl.pokeapi.models.items;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.utility.ApiResource;
import info.tonyl.pokeapi.models.utility.Effect;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ItemFlingEffect {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("effect_entries")
	private Effect[] effectEntries;

	@SerializedName("items")
	@ResourceClass(Item.class)
	private ApiResource<Item> items;

}