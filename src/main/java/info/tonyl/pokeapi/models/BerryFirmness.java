package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

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
	private ApiResource[] berries;
	@SerializedName("names")
	private Name[] names;
}
