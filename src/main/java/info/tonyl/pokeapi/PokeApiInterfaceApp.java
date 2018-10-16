package info.tonyl.pokeapi;

import info.tonyl.pokeapi.core.PokeApiInterface;
import info.tonyl.pokeapi.core.impl.PokeApiCallerSpring;
import info.tonyl.pokeapi.models.Berry;
import info.tonyl.pokeapi.models.BerryFirmness;

public class PokeApiInterfaceApp {
	public static void main(String args[]) {
		PokeApiInterface api = new PokeApiInterface(new PokeApiCallerSpring());

		Berry b = api.getBerry("cheri");
		BerryFirmness firmness = (BerryFirmness) b.getFirmness().resolve(api, BerryFirmness.class);

		System.out.println(b.toString());
		System.out.println(firmness.toString());
	}
}
