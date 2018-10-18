package info.tonyl.pokeapi.models.items;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.utility.ApiResource;
import info.tonyl.pokeapi.models.utility.Name;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ItemPocket {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("categories")
	@ResourceClass(ItemCategory.class)
	private ApiResource<ItemCategory>[] categories;

	@SerializedName("names")
	private Name[] names;

}