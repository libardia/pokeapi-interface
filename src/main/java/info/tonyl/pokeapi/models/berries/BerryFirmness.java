package info.tonyl.pokeapi.models.berries;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.utility.ApiResource;
import info.tonyl.pokeapi.models.utility.Name;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class BerryFirmness {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("berries")
	@ResourceClass(Berry.class)
	private ApiResource<Berry>[] berries;

	@SerializedName("names")
	private Name[] names;
}
