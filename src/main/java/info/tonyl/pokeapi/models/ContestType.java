package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class ContestType {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("berry_flavor")
	@ResourceClass(BerryFlavor.class)
	private ApiResource<BerryFlavor> berryFlavor;

	@SerializedName("names")
	private ContestName[] names;
}