package info.tonyl.pokeapi;

import java.util.ArrayList;
import java.util.List;

import info.tonyl.pokeapi.core.PokeApiInterface;
import info.tonyl.pokeapi.core.impl.PokeApiCallerSpring;
import info.tonyl.pokeapi.models.ApiResource;
import info.tonyl.pokeapi.models.Berry;
import info.tonyl.pokeapi.models.BerryFirmness;

public class PokeApiInterfaceApp {
	public static void main(String args[]) {
		PokeApiInterface api = new PokeApiInterface(new PokeApiCallerSpring());

		Berry b = api.getBerry("cheri");
		BerryFirmness firmness = b.getFirmness().resolve(api);

		System.out.println(b.toString());
		System.out.println(firmness.toString());

		List<Berry> berries = new ArrayList<>();
		for (ApiResource<Berry> br : firmness.getBerries()) {
			berries.add(br.resolve(api));
		}

		System.out.println("All " + firmness.getName() + " berries:");
		System.out.println(berries.toString());

		// TODO: test new "resolve" strategy on ApiResources
	}
}
