package info.tonyl.pokeapi.models.berries;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.utility.ApiResource;
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
