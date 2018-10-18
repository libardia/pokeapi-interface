package info.tonyl.pokeapi.models.games;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.utility.ApiResource;
import info.tonyl.pokeapi.models.utility.Name;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Version {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("names")
	private Name[] names;

	@SerializedName("version_group")
	@ResourceClass(VersionGroup.class)
	private ApiResource<VersionGroup> versionGroup;

}