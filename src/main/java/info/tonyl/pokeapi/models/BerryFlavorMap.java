package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class BerryFlavorMap {
	@SerializedName("potency")
	private Integer potency;

	@SerializedName("flavor")
	@ResourceClass(BerryFlavor.class)
	private ApiResource<BerryFlavor> flavor;
}
