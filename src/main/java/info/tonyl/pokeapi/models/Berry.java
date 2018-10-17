package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Berry {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("growth_time")
	private Integer growthTime;

	@SerializedName("max_harvest")
	private Integer maxHarvest;

	@SerializedName("natural_gift_power")
	private Integer naturalGiftPower;

	@SerializedName("size")
	private Integer size;

	@SerializedName("smoothness")
	private Integer smoothness;

	@SerializedName("soil_dryness")
	private Integer soilDryness;

	@SerializedName("firmness")
	@ResourceClass(BerryFirmness.class)
	private ApiResource<BerryFirmness> firmness;

	@SerializedName("flavors")
	private BerryFlavorMap[] flavors;

	@SerializedName("item")
	@ResourceClass(Item.class)
	private ApiResource<Item> item;

	@SerializedName("natural_gift_type")
	@ResourceClass(Type.class)
	private ApiResource<Type> naturalGiftType;
}
