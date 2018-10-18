package info.tonyl.pokeapi.models;

import com.google.gson.annotations.SerializedName;

import info.tonyl.pokeapi.annotations.ResourceClass;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Type {
	@SerializedName("id")
	private Integer id;

	@SerializedName("name")
	private String name;

	@SerializedName("damage_relations")
	private TypeRelations damageRelations;

	@SerializedName("game_indices")
	private GenerationGameIndex[] gameIndices;

	@SerializedName("generation")
	@ResourceClass(Generation.class)
	private ApiResource<Generation> generation;

	@SerializedName("move_damage_class")
	@ResourceClass(MoveDamageClass.class)
	private ApiResource<MoveDamageClass> moveDamageClass;

	@SerializedName("names")
	private Name[] names;

	@SerializedName("pokemon")
	private TypePokemon[] pokemon;

	@SerializedName("moves")
	@ResourceClass(Move.class)
	private ApiResource<Move>[] moves;

}