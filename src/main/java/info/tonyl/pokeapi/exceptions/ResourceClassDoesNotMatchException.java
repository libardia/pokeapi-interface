package info.tonyl.pokeapi.exceptions;

import java.lang.reflect.Field;

public class ResourceClassDoesNotMatchException extends RuntimeException {
	private static final long serialVersionUID = -2514173502741336972L;

	public ResourceClassDoesNotMatchException(Field f, Throwable t) {
		super(makeMsg(f), t);
	}

	private static String makeMsg(Field f) {
		StringBuilder sb = new StringBuilder();

		// TODO: Message for ResourceClassDoesNotMatchException

		return sb.toString();
	}
}
