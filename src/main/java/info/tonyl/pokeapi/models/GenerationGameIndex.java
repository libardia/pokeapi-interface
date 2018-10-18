package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class GenerationGameIndex {
	@SerializedName("game_index")
	private Integer gameIndex;

	@SerializedName("generation")
	@ResourceClass(Generation.class)
	private ApiResource<Generation> generation;

}