package info.tonyl.pokeapi.models.utility;

import javax.swing.plaf.synth.Region;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Location {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("region")
	@ResourceClass(Region.class)
	private ApiResource<Region> region;

	@SerializedName("names")
	private Name[] names;

	@SerializedName("game_indices")
	private GenerationGameIndex[] gameIndices;

	@SerializedName("areas")
	@ResourceClass(LocationArea.class)
	private ApiResource<LocationArea>[] areas;

}