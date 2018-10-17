package info.tonyl.pokeapi.exceptions;

import java.lang.reflect.Field;

public class ResourceClassOnWrongTypeException extends RuntimeException {
	private static final long serialVersionUID = 6100928359856545038L;

	public ResourceClassOnWrongTypeException(Field f, Throwable t) {
		super(makeMsg(f), t);
	}

	private static String makeMsg(Field f) {
		StringBuilder sb = new StringBuilder();

		sb.append("The @ResourceClass annotation was present on a field that was not an ApiResource, ");
		sb.append("and as a consequence the ApiResourceScanner failed. ");
		sb.append("The field that caused the problem is ");
		sb.append(f.getName());
		sb.append(" on the class ");
		sb.append(f.getDeclaringClass().getName());
		sb.append(" and its actual type was ");
		sb.append(f.getClass().getSimpleName());

		return sb.toString();
	}
}
