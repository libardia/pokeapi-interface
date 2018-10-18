package info.tonyl.pokeapi.models.games;

import javax.swing.plaf.synth.Region;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import info.tonyl.pokeapi.models.utility.ApiResource;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class VersionGroup {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("order")
	private Integer order;

	@SerializedName("generation")
	@ResourceClass(Generation.class)
	private ApiResource<Generation> generation;

	@SerializedName("move_learn_methods")
	@ResourceClass(MoveLearnMethod.class)
	private ApiResource<MoveLearnMethod>[] moveLearnMethods;

	@SerializedName("pokedexes")
	@ResourceClass(Pokedex.class)
	private ApiResource<Pokedex>[] pokedexes;

	@SerializedName("regions")
	@ResourceClass(Region.class)
	private ApiResource<Region>[] regions;

	@SerializedName("versions")
	@ResourceClass(Version.class)
	private ApiResource<Version>[] versions;

}