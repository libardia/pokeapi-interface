package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class VersionGroupFlavorText {
	@SerializedName("text")
	private String text;

	@SerializedName("language")
	@ResourceClass(Language.class)
	private ApiResource<Language> language;

	@SerializedName("version_group")
	@ResourceClass(VersionGroup.class)
	private ApiResource<VersionGroup> versionGroup;

}