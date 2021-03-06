package info.tonyl.pokeapi;

import java.util.ArrayList;
import java.util.List;

import info.tonyl.pokeapi.core.PokeApiInterface;
import info.tonyl.pokeapi.core.impl.PokeApiCallerSpring;
import info.tonyl.pokeapi.models.berries.Berry;
import info.tonyl.pokeapi.models.berries.BerryFirmness;
import info.tonyl.pokeapi.models.utility.ApiResource;

public class PokeApiInterfaceApp {
	public static void main(String args[]) {
		PokeApiInterface api = new PokeApiInterface(new PokeApiCallerSpring());

		Berry b = api.getBerry(10);
		BerryFirmness firmness = b.getFirmness().resolve(api);

		System.out.println(b.toString());
		System.out.println(firmness.toString());

		List<Berry> berries = new ArrayList<>();
		for (ApiResource<Berry> br : firmness.getBerries()) {
			berries.add(br.resolve(api));
		}

		System.out.println("All " + firmness.getName() + " berries:");
		for (Berry berry : berries) {
			System.out.println(berry.toString());
		}
	}
}
