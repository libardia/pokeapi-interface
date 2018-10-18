package info.tonyl.pokeapi.models.utility;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class MachineVersionDetail {
	@SerializedName("machine")
	@ResourceClass(Machine.class)
	private ApiResource<Machine> machine;

	@SerializedName("version_group")
	@ResourceClass(VersionGroup.class)
	private ApiResource<VersionGroup> versionGroup;

}